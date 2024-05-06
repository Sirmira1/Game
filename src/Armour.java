public class Armour {
    String name;
    int armour;
    int cost;
    public Armour (String namePassed, int armourPassed, int costPassed) {
        name =  namePassed;
        armour = armourPassed;
        cost = costPassed;
    }
    public String getName() {
        return name;
    }
    public int getArmour () {
        return armour;
    }
    public int getCost () {
        return cost;
    }
}
