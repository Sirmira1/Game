public class Armour {
    String name;
    int armour;
    int cost;
    String nrInShop;
    public Armour (String nrPassed, String namePassed, int armourPassed, int costPassed) {
        name =  namePassed;
        armour = armourPassed;
        cost = costPassed;
        nrInShop = nrPassed;
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
