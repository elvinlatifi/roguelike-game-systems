import java.util.HashMap;

public class MonsterWithLowHPSlowAttack extends Monster{
    private HashMap<String, Action> availableActions;

    public MonsterWithLowHPSlowAttack(int level) {
        super(level);
    }

    @Override
    public Element getElement(){
        return null;
    }

    void initializeAvailableActions() {
        availableActions = new HashMap<>();
        availableActions.put("Heavy attack", new HeavyAttack(getLevel()));
    }

    @Override
    int getExpReward(){
        return 0;
    }

    Action getAction(double playerHealthRatio){
        return availableActions.get("Heavy attack");
    }
}
