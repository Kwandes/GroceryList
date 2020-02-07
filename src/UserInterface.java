import javax.swing.*;
import javax.swing.plaf.synth.Region;
import java.util.Scanner;

public class UserInterface
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    int screenWidth = 50;
    char symbol = '-';
    String shopName = "Black Market";
    GroceryList basket;
    Wallet wallet;

    // Menu navigation
    private int screenNumber = 1;

    public UserInterface(GroceryList shoppingList, Wallet wallet)
    {
        this.basket = shoppingList;
        this.wallet = wallet;
    }

    public void display()
    {
        while(true)
        {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            switch (this.screenNumber)
            {
                case 1:
                    mainMenu();
                    break;
                case 2:
                    buyMenu();
                    break;
                case 3:
                    basketMenu();
                    break;
                case 4:
                    walletMenu();
                    break;
                case 5:
                    supportMenu();
                    break;
                case 99:
                    quitMenu();
                    break;
                default:
                    mainMenu();
                    break;
            }
        }
    }
    //region Menus and stuff
    private void mainMenu()
    {
        headline(this.shopName, "What is thy query?");

        System.out.println("1> Buy Stuff");
        System.out.println("2> Check my Basket");
        System.out.println("3> Check my Wallet");
        System.out.println("4> Contact Support");
        System.out.println("5> End my Misery");
        System.out.print(">");

        switch (input())
        {
            case "1":
                this.screenNumber = 2;
                break;
            case "2":
                this.screenNumber = 3;
                break;
            case "3":
                this.screenNumber = 4;
                break;
            case "4":
                this.screenNumber = 5;
                break;
            case "5":
                this.screenNumber = 99;
                break;
        }
    }

    private void buyMenu()
    {
        headline(this.shopName, "Basket time");

        System.out.println("1> What is in the Basket");
        System.out.println("2> Remove an Item");
        System.out.println("3> Check Out");
        System.out.println("4> Check my Wallet");
        System.out.println("5> Contact Support");
        System.out.println("6> End my Misery");
        System.out.print(">");

        switch (input())
        {
            case "1":
                basket.checkBasket();
                System.out.print("press enter to continue");
                input();
                break;
            case "2":
                basket.remove(input());
                break;
            case "3":
                wallet.addFunds(basket.getTotalCost() * -1);
                //basket.clearBasket();
                break;
            case "4":
                this.screenNumber = 4;
                break;
            case "5":
                this.screenNumber = 5;
                break;
            case "6":
                this.screenNumber = 99;
                break;
        }

    }

    private void basketMenu()
    {
        headline(this.shopName, "What is thy query?");

        System.out.println("1> Buy Stuff");
        System.out.println("2> Check my Basket");
        System.out.println("3> Check my Wallet");
        System.out.println("4> Contact Support");
        System.out.println("5> End my Misery");
        System.out.print(">");

        switch (input())
        {
            case "1":
                this.screenNumber = 2;
                break;
            case "2":
                basket.checkBasket();
                System.out.print("press enter to continue");
                input();
                break;
            case "3":
                this.screenNumber = 4;
                break;
            case "4":
                this.screenNumber = 5;
                break;
            case "5":
                this.screenNumber = 99;
                break;
        }

    }

    private void walletMenu()
    {
        headline(this.shopName, "What is thy query?");

        System.out.println("You have " + wallet.getAmount() + wallet.getCurrency() + " in your wallet");
        System.out.println("What would you like to do next?");

        System.out.println("1> Add Money");
        System.out.println("2> Convert currency");
        System.out.println("3> Contact Support");
        System.out.println("4> End my Misery");
        System.out.print(">");

        switch (input())
        {
            case "1":
                System.out.print("How many munies would you like to add: ");
                boolean checkSuccessful = false;
                int rupieAmount = 0;
                while (!checkSuccessful)
                {
                    try
                    {
                        rupieAmount = Integer.parseInt(input());

                        if (rupieAmount < 0)
                        {
                            System.out.println("You can only add positive amount of rupies");
                        }
                        else checkSuccessful = true;

                    } catch (NumberFormatException e)
                    {
                        System.out.println("Wrong input, it has to be an integer");
                    }

                }
                wallet.addFunds(rupieAmount);
                break;
            case "2":
                System.out.println("Currently not implemented, contact support");
                System.out.print("press enter to continue");
                input();
                break;
            case "3":
                this.screenNumber = 5;
                break;
            case "4":
                this.screenNumber = 99;
                break;
        }

    }

    private void supportMenu()
    {
        headline(this.shopName, "Hi this is Prajit talking. How can I help you today sir?");

        System.out.println("Actually I am currently unable to help you for I do now know how to help you sir I am so sorry I will return you to the main menu soon");
        System.out.print("press enter to continue");
        input();
        this.screenNumber = 1;

    }

    private void quitMenu()
    {
        System.out.println(ANSI_RED + "Bye Loser" + ANSI_RESET);
        System.exit(0);
    }
    //endregion

    //region Nonimportant methods (prints etc)
    void print()
    {
        for(int  i = 0; i < screenWidth; i++)
        {
            System.out.print(this.symbol);
        }
        System.out.println();
    }

    void print(Character symbol)
    {
        for(int  i = 0; i < screenWidth; i++)
        {
            System.out.print(symbol);
        }
        System.out.println();
    }

    void print(String text)
    {
        for(int  i = 0; i < (screenWidth-text.length())/2; i++)
        {
            System.out.print(this.symbol);
        }
        System.out.print(text);
        for(int  i = 0; i < (screenWidth-text.length())/2; i++)
        {
            System.out.print(this.symbol);
        }
        System.out.println();
    }

    private void headline(String headline, String subtext)
    {
        System.out.print(ANSI_PURPLE);
        print();
        print(headline);
        if (!subtext.isBlank()) print(subtext);
        print();
        System.out.print(ANSI_RESET);
    }

    private String input()
    {
        Scanner console = new Scanner(System.in);
        return console.nextLine();
    }

    //endregion
}
