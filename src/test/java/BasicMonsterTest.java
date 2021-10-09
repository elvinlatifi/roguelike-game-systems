import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicMonsterTest {

    @Test
    void testLevelSetCorrectly() {
        Monster monster = new BasicMonster(10);
        assertEquals(10, monster.getLevel());
    }

    @Test
    void testExceptionThrownIfLevelBelowZero() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new BasicMonster(-1));
        assertEquals("Level can not be negative!", e.getMessage());
    }

    @Test
    void testMaxHPSetCorrectly() {
        Monster monster = new BasicMonster(10);
        assertEquals(100, monster.getMaxHP());
    }

    @Test
    void testMaxManaSetCorrectly() {
        Monster monster = new BasicMonster(10);
        assertEquals(100, monster.getMaxMana());
    }

    @Test
    void testExpRewardCalculatedCorrectly() {
        Monster monster = new BasicMonster(10);
        assertEquals(100, monster.getExpReward());
    }

    @Test
    void testDecreaseHealth() {
        Monster monster = new BasicMonster(10);
        monster.decreaseHP(10);
        assertEquals(90, monster.getHPValue());
    }

    @Test
    void testIncreaseHealth() {
        Monster monster = new BasicMonster(10);
        monster.setHP(80);
        monster.increaseHP(10);
        assertEquals(90, monster.getHPValue());
    }

    @Test
    void testHPSetToMaxHPIfMaxExceeded() {
        Monster monster = new BasicMonster(10);
        monster.setHP(80);
        monster.increaseHP(30);
        assertEquals(100, monster.getHPValue());
    }

    @Test
    void testDecreaseMana() {
        Monster monster = new BasicMonster(10);
        monster.decreaseMana(10);
        assertEquals(90, monster.getManaValue());
    }

    @Test
    void testManaSetToZeroIfNegative() {
        Monster monster = new BasicMonster(10);
        monster.decreaseMana(110);
        assertEquals(0, monster.getManaValue());
    }

    @Test
    void testIncreaseMana() {
        Monster monster = new BasicMonster(10);
        monster.setMana(80);
        monster.increaseMana(10);
        assertEquals(90, monster.getManaValue());
    }

    @Test
    void testManaSetToMaxManaIfMaxExceeded() {
        Monster monster = new BasicMonster(10);
        monster.setMana(80);
        monster.increaseMana(30);
        assertEquals(100, monster.getManaValue());
    }

}