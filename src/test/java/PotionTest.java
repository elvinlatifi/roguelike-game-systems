import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PotionTest {
    Player player = new Player(10) {
        @Override
        Action getAction() {
            return null;
        }

        @Override
        public Element getElement() {
            return null;
        }
    };
    SmallHealthPotion smallPOT = new SmallHealthPotion();
    LargeHealthPotion largePOT = new LargeHealthPotion();
    SmallManaPotion smallMana = new SmallManaPotion();
    PotionInventory potionInventory = player.getPotionInventory();


    @Test
    void testPlayerFullHP(){
        potionInventory.add(smallPOT);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> smallPOT.usePotion(player));
        assertEquals("Player HP already full", e.getMessage());
    }

    @Test
    void potionNotInInventory(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> smallPOT.usePotion(player));
        assertEquals("Potion not in potion inventory", e.getMessage());
    }

    @Test
    void testPotionValue(){
        assertEquals(smallMana.getValue(), 40);
        assertEquals(smallPOT.getValue(), 50);
        assertEquals(largePOT.getValue(), 100);
    }

    @Test
    void testPOTHealing(){
        int startHP = player.getCurrentHP();
        player.decreaseHP(60);
        potionInventory.add(smallPOT);
        smallPOT.usePotion(player);
        assertEquals(player.getCurrentHP(), startHP - 10);
    }

    @Test
    void healingGreaterThanDamage(){
        player.decreaseHP(10);
        potionInventory.add(smallPOT);
        smallPOT.usePotion(player);
        assertEquals(player.getMaxHP(), player.getCurrentHP());
    }

    @Test
    void testPlayerFullMana(){
        potionInventory.add(smallMana);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> smallMana.usePotion(player));
        assertEquals("Player mana already full", e.getMessage());
    }

    @Test
    void testManaRegen(){
        int startMana = player.getCurrentMana();
        player.decreaseMana(50);
        potionInventory.add(smallMana);
        smallMana.usePotion(player);
        assertEquals(player.getCurrentMana(), startMana - 10);
    }

    @Test
    void manaRegenGreaterThanMissingMana(){
        player.decreaseMana(10);
        potionInventory.add(smallMana);
        smallMana.usePotion(player);
        assertEquals(player.getMaxMana(), player.getCurrentMana());
    }
}
