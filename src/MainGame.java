import java.sql.SQLOutput;
import java.util.*;
public class MainGame {
//    Node beginnersShop;
//    Node intermediateShop;
//    Node advancedShop;
    Object[] inventory = new Object[6];
    Object[] beginnersShop = new Object[10];
    Object[] intermediateShop = new Object[10];
    Object[] advancedShop = new Object[10];
    Scanner input = new Scanner(System.in);
    Random rand;
    Player player;
    Boss bossOne;
    Enemy npc;
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
            //case "L", "l" ->
        }


    }
    public void makeShops () {
        //initiate shops
        //swords
        beginnersShop[0] = new Sword ("Sword of the jungle", 7, 50);
        beginnersShop[1] = new Sword ("Night's blade", 12, 67);
        beginnersShop[2] = new Sword("Scythe of the undead", 17, 81);
        beginnersShop[3] = new Sword("Fire blade", 24, 103);
        //armours
        beginnersShop[4] = new Armour("Armour of the jungle", 4, 50);
        beginnersShop[5] = new Armour("Breastplate of the fallen", 8, 64);
        beginnersShop[6] = new Armour("Spartan helmet", 14, 91);
        //potions
        beginnersShop[7] = new Potion("Potion by the house recipe", 50, 50);
        beginnersShop[8] = new Potion("Potion of the nature", 50, 50);
        beginnersShop[9] = new Potion("Stinky brew", 50, 50);
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
                        } else {
                            Object item = beginnersShop[0];
                            if (item instanceof Sword) {
                                Sword sword = (Sword) item;
                                player.addDamage(sword.getDamage());
                                System.out.println("Thanks for your purchase");
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
                        } else {
                            Object item = beginnersShop[1];
                            if (item instanceof Sword) {
                                Sword sword = (Sword) item;
                                player.addDamage(sword.getDamage());
                                System.out.println("Thanks for your purchase");
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
                        } else {
                            Object item = beginnersShop[2];
                            if (item instanceof Sword) {
                                Sword sword = (Sword) item;
                                player.addDamage(sword.getDamage());
                                System.out.println("Thanks for your purchase");
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
                        if (player.getCoins() < 120) {
                            System.out.println("You do not have enough coins to purchase this item");
                        } else {
                            Object item = beginnersShop[0];
                            if (item instanceof Sword) {
                                Sword sword = (Sword) item;
                                player.addDamage(sword.getDamage());
                                System.out.println("Thanks for your purchase");
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
                        } else {
                            Object item = beginnersShop[0];
                            if (item instanceof Sword) {
                                Sword sword = (Sword) item;
                                player.addDamage(sword.getDamage());
                                System.out.println("Thanks for your purchase");
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
                        if (player.getCoins() < 50) {
                            System.out.println("You do not have enough coins to purchase this item");
                        } else {
                            Object item = beginnersShop[0];
                            if (item instanceof Sword) {
                                Sword sword = (Sword) item;
                                player.addDamage(sword.getDamage());
                                System.out.println("Thanks for your purchase");
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
                        if (player.getCoins() < 50) {
                            System.out.println("You do not have enough coins to purchase this item");
                        } else {
                            Object item = beginnersShop[0];
                            if (item instanceof Sword) {
                                Sword sword = (Sword) item;
                                player.addDamage(sword.getDamage());
                                System.out.println("Thanks for your purchase");
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
                        } else {
                            Object item = beginnersShop[0];
                            if (item instanceof Sword) {
                                Sword sword = (Sword) item;
                                player.addDamage(sword.getDamage());
                                System.out.println("Thanks for your purchase");
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
                        } else {
                            Object item = beginnersShop[0];
                            if (item instanceof Sword) {
                                Sword sword = (Sword) item;
                                player.addDamage(sword.getDamage());
                                System.out.println("Thanks for your purchase");
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
                        } else {
                            Object item = beginnersShop[0];
                            if (item instanceof Sword) {
                                Sword sword = (Sword) item;
                                player.addDamage(sword.getDamage());
                                System.out.println("Thanks for your purchase");
                                openedShopFirstDimension();
                            }
                        }

                    }

                    case null, default -> openedShopFirstDimension();
                }
            }

        }
    }
    public void printShopItems() {
        // Iterate over the beginnersShop array and print the details of each item
        for (Object item : beginnersShop) {
            if (item instanceof Sword) {
                Sword sword = (Sword) item;
                System.out.println("Sword: " + sword.getName() + ", Price: " + sword.getCost() + ", Damage: " + sword.getDamage());
            } else if (item instanceof Armour) {
                Armour armour = (Armour) item;
                System.out.println("Armour: " + armour.getName() + ", Price: " + armour.getCost() + ", Armour: " + armour.getArmour());
            } else if (item instanceof Potion) {
                Potion potion = (Potion) item;
                System.out.println("Potion: " + potion.getName() + ", Price: " + potion.getCost() + ", Health: " + potion.getHealth());
            }
        }
    }


    public void easyDifficulty () {
        bossOne = new Boss (15, 500, 30);
        player = new Player(15, 200, 6, 50);
        //npc = new Enemy(rand.nextInt(7) + 1, rand.nextInt(51) + 30, rand.nextInt(9));
    }
    public void mediumDifficulty () {
        bossOne = new Boss (25, 2400, 50);
        player = new Player(10, 150, 3, 25);
        npc = new Enemy(rand.nextInt(16) + 4, rand.nextInt(51) + 30, rand.nextInt(14) + 1);
    }
    public void hardDifficulty () {
        bossOne = new Boss(100, 12000, 90);
        player = new Player (6, 100, 0, 0);
        npc = new Enemy(rand.nextInt(10) + 17, rand.nextInt(61) + 80, rand.nextInt(10) + 10);
    }
    public static void main(String[] args) {
        MainGame m1 = new MainGame();
    }
}
