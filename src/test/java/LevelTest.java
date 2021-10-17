import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LevelTest {

    @Test
    void currentLevelIsSetCorrectly(){
        Level levelOne = new Level(1);
        assertEquals(1, levelOne.getCurrentLevel());
    }
    @Test
    void levelIsNotIncreasedWhenAddingInsufficientXP(){
        Level levelOne = new Level(1);
        levelOne.addXP(99);
        assertEquals(1, levelOne.getCurrentLevel());
    }

    @Test
    void levelIsIncreasedWhenAddingSufficientXP(){
        Level levelOne = new Level(1);
        levelOne.addXP(101);
        assertEquals(2, levelOne.getCurrentLevel());
    }

    @Test
    void levelIsIncreasedWhenAddingSufficientXPForLevelTwo(){
        Level levelOne = new Level(2);
        levelOne.addXP(200);
        assertEquals(3, levelOne.getCurrentLevel());
    }

    @Test
    void levelIsIncreasedCorrectlyWhenAddingSufficientXPForMoreThanOneLevelIncrease(){
        Level levelOne = new Level(1);
        levelOne.addXP(300);
        assertEquals(3, levelOne.getCurrentLevel());
    }

    @Test
    void levelIsNotIncreaseWhenAddingXPAtLevel100(){
        Level levelHundred = new Level(100);
        levelHundred.addXP(999999);
        assertEquals(100, levelHundred.getCurrentLevel());
    }

    @Test
    void entityGetsCorrectLevel(){
        Orc orc = new Orc(10);
        assertEquals(10, orc.getLevel().getCurrentLevel());
    }

    @Test
    void playerGetsCorrectLevelWhenAwardedXP(){
        Player player = new Player(1) {
            @Override
            Action getAction(){
                return null;
            }

            @Override
            public Element getElement(){
                return null;
            }
        };
        player.increaseXP(200);
        assertEquals(2, player.getLevel().getCurrentLevel());
    }

     @Test
    void playerHasCorrectHPWhenLevelledUp(){
         Player player = new Player(1) {
             @Override
             Action getAction(){
                 return null;
             }

             @Override
             public Element getElement(){
                 return null;
             }
         };
         player.increaseXP(200);
         assertEquals(20 , player.getMaxHP());
     }

    @Test
    void playerHasCorrectManaWhenLevelledUp(){
        Player player = new Player(1) {
            @Override
            Action getAction(){
                return null;
            }

            @Override
            public Element getElement(){
                return null;
            }
        };
        player.increaseXP(200);
        assertEquals(20 , player.getMaxHP());
    }

}
