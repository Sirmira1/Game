public class Boss {
    double health;
    double armour;
    double damage;
    public Boss (double damagePassed, double healthPassed, double armourPassed) {
        health = healthPassed;
        armour = armourPassed;
        damage = damagePassed;
    }

    public double getHealth () {
        return health;
    }

    public double getArmour () {
        return armour;
    }

    public double getDamage () {
        return damage;
    }
}
