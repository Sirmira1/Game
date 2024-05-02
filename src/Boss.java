public class Boss {
    int health;
    int armour;
    int damage;
    public Boss (int damagePassed, int healthPassed, int armourPassed) {
        health = healthPassed;
        armour = armourPassed;
        damage = damagePassed;
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
}
