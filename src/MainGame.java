import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.*;
public class MainGame {
    Node beginnersShop;
    Node intermediateShop;
    Node advancedShop;
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
                addItems();
                mainGame();
            }
            case "M", "m" -> {
                System.out.println("Game started");
                System.out.println("Difficulty: Medium");
                mediumDifficulty();
                addItems();
                mainGame();
            }
            case "H", "h" -> {
                System.out.println("Game started");
                System.out.println("For the worthy");
                hardDifficulty();
                addItems();
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
    public void makeBeginnersShop (String s) {
        //initiate beginners shop
        if (beginnersShop == null) {
            beginnersShop = new Node (null, s, null);
        } else {
            Node p = beginnersShop;
            while (p.next != null) {
                p = p.next;
            }
            p.next = new Node (p, s, null);
        }
    }
    public void makeIntermediateShop (String s) {
        //initiate intermediate shop
        if (intermediateShop == null) {
            intermediateShop = new Node (null, s, null);
        } else {
            Node p = intermediateShop;
            while (p.next != null) {
                p = p.next;
            }
            p.next = new Node (p, s, null);
        }
    }
    public void makeAdvancedShop (String s) {
        //initiate advanced shop
        if (advancedShop == null) {
            advancedShop = new Node (null, s, null);
        } else {
            Node p = advancedShop;
            while (p.next != null) {
                p = p.next;
            }
            p.next = new Node (p, s, null);
        }
    }
    public void addItems () {
        makeBeginnersShop("1 Blade of the jungle");
        makeBeginnersShop("2 Sword of the night");
        makeBeginnersShop("3 Scythe of the undead");
        makeBeginnersShop("4 Sword of fire");
        makeBeginnersShop("5 Armour of the jungle");
        makeBeginnersShop("6 Breastplate of the fallen");
        makeBeginnersShop("7 Helmet of sparta");
        makeBeginnersShop("8 Potion by the house recipe");
        makeBeginnersShop("9 Potion from the nature");
        makeBeginnersShop("10 Stinky brew");
        makeIntermediateShop("1 Shadowsteel plate");
        makeIntermediateShop("2 Dragonhide vestments");
        makeIntermediateShop("3 Celestial aegis");
        makeIntermediateShop("4 Stormbreaker blade");
        makeIntermediateShop("5 Frostbite edge");
        makeIntermediateShop("6 Flameforged saber");
        makeIntermediateShop("7 Voidslayer longsword");
        makeIntermediateShop("8 Vitality draught");
        makeIntermediateShop("9 Renewal elixir");
        makeIntermediateShop("10 Healing tonic");
        makeAdvancedShop("1 Shadowstrike katana");
        makeAdvancedShop("2 Frostfang scimitar");
        makeAdvancedShop("3 Legends blade");
        makeAdvancedShop("4 Royal guardian plate");
        makeAdvancedShop("5 Elemental warderobe");
        makeAdvancedShop("6 Runebound mail");
        makeAdvancedShop("7 Legends armour");
        makeAdvancedShop("8 Phoenix elixir");
        makeAdvancedShop("9 Serenety potion");
        makeAdvancedShop("10 Radiant remedy");
    }
    public void openedShopFirstDimension () {
        System.out.println("Press 1 for beginners shop");
        System.out.println("Press q to go back");
        String oS = input.nextLine();
        switch (oS) {
            case "1" -> {
                Node p = beginnersShop;
                while (p != null) {
                    System.out.println(p.item);
                    p = p.next;
                }
                System.out.println("");
                System.out.println("Press the corresponding number with the " +
                        "item to see more info or press Q to go back");
                String b = input.nextLine();
                switch (b) {
                    case "1" -> {
                        System.out.println("A lost blade found in the jungle");
                    }
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
