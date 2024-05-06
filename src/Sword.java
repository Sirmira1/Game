public class Sword {
    int damage;
    int cost;
    String name;
    String nrInShop;
    public Sword(String nrPassed, String namePassed, int damagePassed, int pricePassed) {
        damage = damagePassed;
        cost = pricePassed;
        name = namePassed;
        nrInShop = nrPassed;
    }
    public int getDamage () {
        return damage;
    }
    public int getCost () {
        return cost;
    }
    public String getName() {
        return name;
    }
    public String getNrInShop () {return nrInShop;}
}
