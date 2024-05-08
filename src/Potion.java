public class Potion {
    String name;
    int health;
    int cost;
    String nrInShop;
    public Potion (String nrPassed, String namePassed, int healthPassed, int costPassed) {
        name = namePassed;
        health = healthPassed;
        cost = costPassed;
        nrInShop = nrPassed;
    }
    public String getName () {
        return name;
    }
    public int getHealth () { return health; }
    public int getCost () { return cost; }
}
