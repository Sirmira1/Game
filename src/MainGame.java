import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.*;
public class MainGame {
    String[] beginnersShop = new String[10];
    String[] intermediateShop = new String[10];
    String[] advancedShop = new String[10];
    boolean gameOn = true;
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
                mainGame();
            }
            case "M", "m" -> {
                System.out.println("Game started");
                System.out.println("Difficulty: Medium");
                mediumDifficulty();
                mainGame();
            }
            case "H", "h" -> {
                System.out.println("Game started");
                System.out.println("For the worthy");
                hardDifficulty();
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
        System.out.println("Press P to see the item shop");
        System.out.println("Press L to see the world map");
        System.out.println("Press I to see your inventory");
        System.out.println("Press F to look for a random fight with smaller enemies");
        System.out.println("Press B to look at the next boss fight");
        String mG = input.nextLine();
        switch (mG) {
            case "P", "p" -> openedShop();
            //case "L", "l" ->
        }


    }
    public void makeShops () {
        beginnersShop[0] = "0: Jungle sword";
        beginnersShop[1] = "1: Blade of the night";
        beginnersShop[2] = "2: Sword of the undead";
        beginnersShop[3] = "3: Fire blade";
        beginnersShop[4] = "4: Helmet from the woods";
        beginnersShop[5] = "5: The great breastplate";
        beginnersShop[6] = "6: Armour covered in stones";
        beginnersShop[7] = "7: Potion by the house recipe";
        beginnersShop[8] = "8: Potion of health";
        beginnersShop[9] = "9: Nature's gift";

    }
    public void openedShop () {
        makeShops();
        System.out.println("Press 1 for beginners shop");
        System.out.println("Press 2 for intermediate shop");
        System.out.println("Press 3 for advanced shop");
        System.out.println("Press q to go back");
        String oS = input.nextLine();
        switch (oS) {
            case "1" -> {
                for (String s : beginnersShop) {
                    System.out.println(s);
                    System.out.println("Press the corresponding number with the item to see more information");
                    String c = input.nextLine();
                    switch (c) {
                        case "0" -> {
                            System.out.println(beginnersShop[0]);
                            System.out.println("An old blade picked up from the jungle");
                            System.out.println("+ 7 damage");
                            System.out.println("Price: 50 coins");
                            System.out.println("Press P to purchase of Q to go back");
                            String a = input.nextLine();
                            switch (a) {
                                case "P", "p" -> {
                                    player.coins = player.coins - 50;
                                    player.damage = player.damage + 7;
                                    beginnersShop[0] = "Sold";
                                }
                            }
                        }
                        case "1" -> {
                            System.out.println(beginnersShop[1]);
                            System.out.println("An old warrior's blade that fought in the night");
                        }
                    }
                    System.out.println("Press Q to go back");
                }
            }
            case "2" -> {
                for (String s : intermediateShop) {
                    System.out.println(s);
                }
            }
            case "3" -> {

                for (String s : advancedShop) {
                    System.out.println(s);
                }
            }
            case "Q", "q" -> mainGame();
            case null, default -> System.out.println("Invalid input, please press 1, 2, 3 or Q");
        }
    }
    //public void beginnersShopStatistics;
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
