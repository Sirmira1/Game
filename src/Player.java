public class Player {
    int level = 1;
    int experience = 0;
    int health;
    int armour;
    int damage;
    int coins;
    public Player (int damagePassed, int healthPassed, int armourPassed,int coinsPassed) {
        health = healthPassed;
        armour = armourPassed;
        damage = damagePassed;
        coins = coinsPassed;
    }
    public int getHealth () {
        return health;
    }

    public int getArmour () {
        return armour;
    }

    public int getDamage () {
        return damage;
    }
    public int getCoins () {
        return coins;
    }
    public int getLevel () {
        return level;
    }
    public void addDamage(int additionalDamage) {
        this.damage += additionalDamage;
    }
}
