import java.sql.SQLOutput;
import java.util.*;
public class MainGame {
//    Node beginnersShop;
//    Node intermediateShop;
//    Node advancedShop;
    Object[] inventory = new Object[21];
    Object[] equipped = new Object[6];
    //inventory and equipped items to be added in further updates
    Object[] beginnersShop = new Object[10];
    Object[] intermediateShop = new Object[10];
    Object[] advancedShop = new Object[10];
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    Player player;
    Boss bossOne;
    Enemy npc;
    double hP;
    double hN;
    public MainGame () {
        System.out.println("WELCOME");
        mainMenu();
    }
    public void mainMenu () {
        System.out.println("MAIN MENU");
        System.out.println("Press P to play");
        System.out.println("Press H for help");
        System.out.println("Press Q to quit");
        String mM = input.nextLine();
        switch (mM) {
            case "P", "p" -> pressedPlay();
            case "H", "h" -> pressedHelp();
            case "Q", "q" -> System.out.println("Thanks for playing");
            case null, default -> {
                System.out.println("Invalid input, please press P, H or Q");
                mainMenu();
            }
        }
    }
    public void pressedPlay () {
        System.out.println("Select difficulty: ");
        System.out.println("E for easy");
        System.out.println("M for medium");
        System.out.println("H for hard");
        System.out.println("Q to go back");
        String pP = input.nextLine();
        switch (pP) {
            case "E", "e" -> {
                System.out.println("Game started");
                System.out.println("Difficulty: Easy");
                easyDifficulty();
                makeShops();
                mainGame();
            }
            case "M", "m" -> {
                System.out.println("Game started");
                System.out.println("Difficulty: Medium");
                mediumDifficulty();
                makeShops();
                mainGame();
            }
            case "H", "h" -> {
                System.out.println("Game started");
                System.out.println("For the worthy");
                hardDifficulty();
                makeShops();
                mainGame();
            }
            case "Q", "q" -> mainMenu();
            case null, default -> {
                System.out.println("Invalid input, please press E, M, H or Q");
                pressedPlay();
            }
        }
    }
    public void pressedHelp () {
        System.out.println("This is a mini game where you as a player are trying to ");
        System.out.println("defeat different enemies and bosses, and you keep improving");
        System.out.println("with all the money you get from killing these enemies, as they");
        System.out.println("allow you to buy new upgrades to your damage, health and armour.");
        System.out.println("If you die, you may restart the fight you were on, leave the fight or restart the whole game.");
        System.out.println("You start on planet earth, but as you play you may travel to different planets and dimensions.");
        System.out.println("You start at the first dimension, different dimensions and planets give greater rewards, but");
        System.out.println("watch your guard because they also come with more difficult enemies. ");
        System.out.println("Enjoy!");
        System.out.println("Press any button to go back");
        input.nextLine();
        mainMenu();
    }
    public void mainGame () {
        System.out.println("Hey there, welcome to your base");
        System.out.println("You are currently in the normal world in the first dimension");
        System.out.println("Your starting stats: ");
        System.out.println("Health: " + player.getHealth());
        System.out.println("Armour: " + player.getArmour());
        System.out.println("Damage: " + player.getDamage());
        System.out.println("You have " + player.getCoins() + " coins");
        System.out.println("Press P to see the item shop of the dimension");
        System.out.println("Press L to see the world map");
        System.out.println("Press I to see your inventory");
        System.out.println("Press F to look for a random fight with smaller enemies");
        System.out.println("Press B to look at the next boss fight");
        String mG = input.nextLine();
        switch (mG) {
            case "P", "p" -> openedShopFirstDimension();
            case "L", "l" -> worldMap();
            case "I", "i" -> openInventory();
            case "F", "f" -> miniFight();
            case "B", "b" -> peekAtBoss();
        }


    }
    public void miniFight () {
        System.out.println("Are you sure you want to look for a fight? " +
                "Press Y for yes or any other button to go back");
        switch (input.nextLine()) {
            case "Y", "y" -> startFight();
            case null, default -> mainGame();
        }
    }
    public void startFight () {
        fightStats();
        attackHappening();
    }
    public void attackHappening () {
        System.out.println("Select your attack:");
        System.out.println("A for basic attack");
        System.out.println("E for a spin attack");
        System.out.println("X for a critical attack");
        System.out.println("Press H for more info");
        System.out.println("Choose your attack:");
       switch (input.nextLine()) {
           case "A", "a" -> baseAttack();
           case "E", "e" -> spinAttack();
           case "X", "x" -> criticalAttack();
           case "H", "h" -> moreInfo();
           default -> attackHappening();
       }
    }
    private void baseAttack () {
        npc.health -= player.damage;
        System.out.println("You dealt " + player.getDamage() + " damage.");
        if (npc.getHealth() <= 0) {
            npc.health = 0.0;
            System.out.println("Your enemy now has " +  npc.getHealth() + " health");
        }else {
            System.out.println("Your enemy now has " + npc.getHealth() + " health.");
        }
        System.out.println("Press any button to continue");
        switch (input.nextLine()) {
            default -> checkIfOverP();
        }
    }
    private void spinAttack () {
        double spinDmg = rand.nextDouble() * (player.getDamage() * 0.4) + (player.getDamage() * 0.8);
        spinDmg = Math.round(spinDmg * 10.0) / 10.0;
        npc.health -= spinDmg;
        System.out.println("You dealt " + spinDmg + " damage.");
        if (npc.getHealth() <= 0) {
            npc.health = 0.0;
            System.out.println("Your enemy now has " +  npc.getHealth() + " health");
        }else {
            System.out.println("Your enemy now has " + npc.getHealth() + " health.");
        }
        System.out.println("Press any button to continue");
        switch (input.nextLine()) {
            default -> checkIfOverP();
        }
    }
    private void criticalAttack () {
        double critDamage = rand.nextDouble() * (player.getDamage() * 1.0) + (player.getDamage() * 0.5);
        critDamage = Math.round(critDamage * 10.0) / 10.0;
        npc.health -= critDamage;
        System.out.println("You dealt " + critDamage + " damage.");
        if (npc.getHealth() <= 0) {
            npc.health = 0.0;
            System.out.println("Your enemy now has " +  npc.getHealth() + " health");
        }else {
            System.out.println("Your enemy now has " + npc.getHealth() + " health.");
        }
        System.out.println("Press any button to continue");
        switch (input.nextLine()) {
            default -> checkIfOverP();
        }
    }
    public void enemyAttack () {
        double npcDmg  = npc.getDamage();
        double attack = 0.15 * npcDmg;
        double rndDmg = rand.nextDouble() * 2 * attack - attack;
        double actualDmg = npcDmg + rndDmg;
        actualDmg = Math.round(actualDmg * 10.0) / 10.0;
        player.health -= actualDmg;
        System.out.println("The enemy has dealt " + actualDmg + " damage.");
        if (player.getHealth() <= 0) {
            player.health = 0.0;
            System.out.println("You now have " + player.getHealth() + " health");
        }else {
            System.out.println("You now have " + player.getHealth() + " health.");
        }
        System.out.println("Press any button to continue");
        switch (input.nextLine()) {
            default -> checkIfOverE();
        }
    }
    public void checkIfOverP () {
        if (player.getHealth() <= 0) {
            resetHealth();
            System.out.println("You lost");
            System.out.println("Press any button to continue");
            switch (input.nextLine()) {
                default -> mainGame();
            }
        } else if (npc.getHealth() <= 0) {
            resetHealth();
            System.out.println("Congratulations, you won!");
            int randCoins = rand.nextInt(16) + 10;
            System.out.println("You got " + randCoins + " coins!");
            player.coins += randCoins;
            System.out.println("Press any button to go back");
            switch (input.nextLine()) {
                default -> mainGame();
            }
        } else enemyAttack();
    }
    public void checkIfOverE () {
            if (player.getHealth() <= 0) {
                resetHealth();
                System.out.println("You lost");
                System.out.println("Press any button to continue");
                switch (input.nextLine()) {
                    default -> mainGame();
                }
            } else if (npc.getHealth() <= 0) {
                resetHealth();
                System.out.println("Congratulations, you won!");
                int randCoins = rand.nextInt(16) + 10;
                System.out.println("You got " + randCoins + " coins!");
                player.coins += randCoins;
                System.out.println("Press any button to go back");
                switch (input.nextLine()) {
                    default -> mainGame();
                }
            } else attackHappening();
    }
    public void fightStats () {
        System.out.println("Your stats: ");
        System.out.println("Damage: " + player.getDamage());
        System.out.println("Armour: " + player.getArmour());
        System.out.println("Health: " + player.getHealth());
        System.out.println("Enemy stat: ");
        System.out.println("Damage: " + npc.getDamage());
        System.out.println("Armour: " + npc.getArmour());
        System.out.println("Health: " + npc.getHealth());
    }
    public void moreInfo () {
        System.out.println("A is your basic attack, it deals flat damage, which is " + player.getDamage());
        System.out.println("E is a spin attack, that deals anywhere from " + (player.damage - (player.damage * 0.2)) + " to " + player.getDamage() + (player.getDamage() * 0.2) + " damage.");
        System.out.println("X is your riskiest attack, it deals anywhere from " + (player.damage - (player.damage * 0.5)) + " to " + player.damage + (player.damage *0.5) + " damage.");
        System.out.println("Press any button to go back");
        switch (input.nextLine()) {
            default -> startFight();
        }
    }
    private void resetHealth() {
        player.setHealth(hP);
        npc.setHealth(hN);
    }
    public void openInventory () {
        System.out.println("To be added in future updates");
        System.out.println("Please stick around :)");
        System.out.println("Press any button to go back");
        switch (input.nextLine()) {
            default -> mainGame();
        }
    }
    public void worldMap () {
        System.out.println("To be added in future updates");
        System.out.println("Please stick around :)");
        System.out.println("Press any button to go back");
        switch (input.nextLine()) {
            default -> mainGame();
        }
    }
    public void peekAtBoss () {
        System.out.println("To be added in future updates");
        System.out.println("Please stick around :)");
        System.out.println("Press any button to go back");
        switch (input.nextLine()) {
            default -> mainGame();
        }
    }
    public void makeShops () {
        //initiate shops
        //swords
        //to experiment with nr passed to make shop simpler
        beginnersShop[0] = new Sword ("1", "Sword of the jungle", 7, 50);
        beginnersShop[1] = new Sword ("2", "Night's blade", 12, 67);
        beginnersShop[2] = new Sword("3", "Scythe of the undead", 17, 81);
        beginnersShop[3] = new Sword("4", "Fire blade", 24, 103);
        //armours
        beginnersShop[4] = new Armour("5", "Armour of the jungle", 4, 50);
        beginnersShop[5] = new Armour("6", "Breastplate of the fallen", 8, 64);
        beginnersShop[6] = new Armour("7", "Spartan helmet", 14, 91);
        //potions
        beginnersShop[7] = new Potion("8", "Potion by the house recipe", 50, 50);
        beginnersShop[8] = new Potion("9", "Potion of the nature", 50, 50);
        beginnersShop[9] = new Potion("10", "Stinky brew", 50, 50);
    }

    public void openedShopFirstDimension () {
        printShopItems();
        System.out.println("You have " + player.coins + " coins");
        System.out.println("Press the corresponding number with the " +
                "item to see more info or press any other button to go back");
        String b = input.nextLine();
        switch (b) {
            case "1" -> {
                System.out.println("Are you sure? Y for yes or any other button to return");
                String p = input.nextLine();
                switch (p) {
                    case "Y", "y" -> {
                        if (player.getCoins() < 50) {
                            System.out.println("You do not have enough coins to purchase this item");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else if (beginnersShop[0] == null){
                            System.out.println("Item sold");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        }else {
                            Object item = beginnersShop[0];
                            if (item instanceof Sword) {
                                Sword sword = (Sword) item;
                                player.addDamage(sword.getDamage());
                                System.out.println("Thanks for your purchase");
                                beginnersShop[0] = null;
                                player.coins -= sword.cost;
                                openedShopFirstDimension();
                            }
                        }

                    }

                    case null, default -> openedShopFirstDimension();
                }
            }
            case "2" -> {
                System.out.println("Are you sure? Y for yes or any other button to return");
                String p = input.nextLine();
                switch (p) {
                    case "Y", "y" -> {
                        if (player.getCoins() < 67) {
                            System.out.println("You do not have enough coins to purchase this item");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else if (beginnersShop[1] == null){
                            System.out.println("Item sold");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else {
                            Object item = beginnersShop[1];
                            if (item instanceof Sword) {
                                Sword sword = (Sword) item;
                                player.addDamage(sword.getDamage());
                                System.out.println("Thanks for your purchase");
                                beginnersShop[1] = null;
                                player.coins -= sword.cost;
                                openedShopFirstDimension();
                            }
                        }

                    }

                    case null, default -> openedShopFirstDimension();
                }
            }
            case "3" -> {
                System.out.println("Are you sure? Y for yes or any other button to return");
                String p = input.nextLine();
                switch (p) {
                    case "Y", "y" -> {
                        if (player.getCoins() < 81) {
                            System.out.println("You do not have enough coins to purchase this item");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else if (beginnersShop[2] == null){
                            System.out.println("Item sold");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else {
                            Object item = beginnersShop[2];
                            if (item instanceof Sword) {
                                Sword sword = (Sword) item;
                                player.addDamage(sword.getDamage());
                                System.out.println("Thanks for your purchase");
                                beginnersShop[2] = null;
                                player.coins -= sword.cost;
                                openedShopFirstDimension();
                            }
                        }

                    }

                    case null, default -> openedShopFirstDimension();
                }
            }
            case "4" -> {System.out.println("Are you sure? Y for yes or any other button to return");
                String p = input.nextLine();
                switch (p) {
                    case "Y", "y" -> {
                        if (player.getCoins() < 103) {
                            System.out.println("You do not have enough coins to purchase this item");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else if (beginnersShop[3] == null){
                            System.out.println("Item sold");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else {
                            Object item = beginnersShop[3];
                            if (item instanceof Sword) {
                                Sword sword = (Sword) item;
                                player.addDamage(sword.getDamage());
                                System.out.println("Thanks for your purchase");
                                beginnersShop[3] = null;
                                player.coins -= sword.cost;
                                openedShopFirstDimension();
                            }
                        }

                    }

                    case null, default -> openedShopFirstDimension();
                }
            }
            case "5" -> {System.out.println("Are you sure? Y for yes or any other button to return");
                String p = input.nextLine();
                switch (p) {
                    case "Y", "y" -> {
                        if (player.getCoins() < 50) {
                            System.out.println("You do not have enough coins to purchase this item");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else if (beginnersShop[4] == null){
                            System.out.println("Item sold");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else {
                            Object item = beginnersShop[4];
                            if (item instanceof Armour) {
                                Armour armour = (Armour) item;
                                player.addArmour(armour.getArmour());
                                System.out.println("Thanks for your purchase");
                                beginnersShop[4] = null;
                                player.coins -= armour.cost;
                                openedShopFirstDimension();
                            }
                        }

                    }

                    case null, default -> openedShopFirstDimension();
                }
            }
            case "6" -> {System.out.println("Are you sure? Y for yes or any other button to return");
                String p = input.nextLine();
                switch (p) {
                    case "Y", "y" -> {
                        if (player.getCoins() < 64) {
                            System.out.println("You do not have enough coins to purchase this item");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else if (beginnersShop[5] == null){
                            System.out.println("Item sold");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else {
                            Object item = beginnersShop[5];
                            if (item instanceof Armour) {
                                Armour armour = (Armour) item;
                                player.addArmour(armour.getArmour());
                                System.out.println("Thanks for your purchase");
                                beginnersShop[5] = null;
                                player.coins -= armour.cost;
                                openedShopFirstDimension();
                            }
                        }

                    }

                    case null, default -> openedShopFirstDimension();
                }
            }
            case "7" -> {System.out.println("Are you sure? Y for yes or any other button to return");
                String p = input.nextLine();
                switch (p) {
                    case "Y", "y" -> {
                        if (player.getCoins() < 91) {
                            System.out.println("You do not have enough coins to purchase this item");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else if (beginnersShop[6] == null){
                            System.out.println("Item sold");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else {
                            Object item = beginnersShop[6];
                            if (item instanceof Armour) {
                                Armour armour = (Armour) item;
                                player.addArmour(armour.getArmour());
                                System.out.println("Thanks for your purchase");
                                beginnersShop[6] = null;
                                player.coins -= armour.cost;
                                openedShopFirstDimension();
                            }
                        }

                    }

                    case null, default -> openedShopFirstDimension();
                }
            }
            case "8" -> {System.out.println("Are you sure? Y for yes or any other button to return");
                String p = input.nextLine();
                switch (p) {
                    case "Y", "y" -> {
                        if (player.getCoins() < 50) {
                            System.out.println("You do not have enough coins to purchase this item");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else if (beginnersShop[7] == null){
                            System.out.println("Item sold");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else {
                            Object item = beginnersShop[7];
                            if (item instanceof Potion) {
                                Potion potion = (Potion) item;
                                player.addHealth(potion.getHealth());
                                System.out.println("Thanks for your purchase");
                                beginnersShop[7] = null;
                                player.coins -= potion.cost;
                                openedShopFirstDimension();
                            }
                        }

                    }

                    case null, default -> openedShopFirstDimension();
                }
            }
            case "9" -> {
                System.out.println("Are you sure? Y for yes or any other button to return");
                String p = input.nextLine();
                switch (p) {
                    case "Y", "y" -> {
                        if (player.getCoins() < 50) {
                            System.out.println("You do not have enough coins to purchase this item");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else if (beginnersShop[8] == null){
                            System.out.println("Item sold");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else {
                            Object item = beginnersShop[8];
                            if (item instanceof Potion) {
                                Potion potion = (Potion) item;
                                player.addHealth(potion.getHealth());
                                System.out.println("Thanks for your purchase");
                                beginnersShop[8] = null;
                                player.coins -= potion.cost;
                                openedShopFirstDimension();
                            }
                        }

                    }

                    case null, default -> openedShopFirstDimension();
                }
            }
            case "10" -> {
                System.out.println("Are you sure? Y for yes or any other button to return");
                String p = input.nextLine();
                switch (p) {
                    case "Y", "y" -> {
                        if (player.getCoins() < 50) {
                            System.out.println("You do not have enough coins to purchase this item");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else if (beginnersShop[9] == null){
                            System.out.println("Item sold");
                            System.out.println("Press any button to go back");
                            switch (input.nextLine()) {
                                default -> openedShopFirstDimension();
                            }
                        } else {
                            Object item = beginnersShop[0];
                            if (item instanceof Potion) {
                                Potion potion = (Potion) item;
                                player.addHealth(potion.getHealth());
                                System.out.println("Thanks for your purchase");
                                beginnersShop[9] = null;
                                player.coins -= potion.cost;
                                openedShopFirstDimension();
                            }
                        }

                    }

                    case null, default -> openedShopFirstDimension();
                }
            }
        case null, default -> mainGame();
        }
    }
    public void printShopItems() {
        // Iterate over the beginnersShop array and print the details of each item
        for (Object item : beginnersShop) {
            if (item instanceof Sword) {
                Sword sword = (Sword) item;
                System.out.println(sword.nrInShop + " " + sword.getName() + ", Price: " + sword.getCost() + ", Damage: " + sword.getDamage());
            } else if (item instanceof Armour) {
                Armour armour = (Armour) item;
                System.out.println(armour.nrInShop + " " + armour.getName() + ", Price: " + armour.getCost() + ", Armour: " + armour.getArmour());
            } else if (item instanceof Potion) {
                Potion potion = (Potion) item;
                System.out.println(potion.nrInShop + " " + potion.getName() + ", Price: " + potion.getCost() + ", Health: " + potion.getHealth());
            }
        }
    }

    public void easyDifficulty () {
        double dP = 15.0;
        hP = 200.0;
        double aP = 6.0;
        double dN = 7.0;
        hN = 50;
        double aN = 3.0;
        bossOne = new Boss (15, 500, 30);
        player = new Player(dP, hP, aP, 50);
        npc = new Enemy (dN, hN, aN);
    }
    public void mediumDifficulty () {
        double dP = 10.0;
        hP = 150.0;
        double aP = 3.0;
        double dN = 14.0;
        hN = 75.0;
        double aN = 6.0;
        bossOne = new Boss (25, 2400, 50);
        player = new Player(dP, hP, aP, 25);
        npc = new Enemy (dN, hN, aN);
    }
    public void hardDifficulty () {
        double dP = 6.0;
        hP = 100.0;
        double aP = 0.0;
        double dN = 24.0;
        hN = 100.0;
        double aN = 12.0;
        bossOne = new Boss(100, 12000, 90);
        player = new Player(dP, hP, aP, 50);
        npc = new Enemy (dN, hN, aN);
    }
    public void setHealthToDefault () {

    }
    public static void main(String[] args) {
        MainGame m1 = new MainGame();
    }
}
