public class Potion {
    String name;
    int health;
    int cost;
    public Potion (String namePassed, int healthPassed, int costPassed) {
        name = namePassed;
        health = healthPassed;
        cost = costPassed;
    }
    public String getName () {
        return name;
    }
    public int getHealth () { return health; }
    public int getCost () { return cost; }
}
