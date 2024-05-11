public class Player {
    int level = 1;
    int experience = 0;
    Double health;
    Double armour;
    Double damage;
    int coins;
    public Player (Double damagePassed, Double healthPassed, Double armourPassed, int coinsPassed) {
        health = healthPassed;
        armour = armourPassed;
        damage = damagePassed;
        coins = coinsPassed;
    }
    public Double getHealth () {
        return health;
    }

    public Double getArmour () {
        return armour;
    }

    public Double getDamage () {
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
    public void addArmour(int additionalArmour) {
        this.armour += additionalArmour;
    }
    public void addHealth(int additionalHealth) {
        this.health += additionalHealth;
    }
    public void setHealth (double healthPassed) {
        health = healthPassed;
    }
}
