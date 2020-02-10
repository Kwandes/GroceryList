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

    int screenWidth = 200;
    char symbol = '-';
    String shopName = "Black Market";
    GroceryList basket;
    Wallet wallet;
    Products products;

    // Menu navigation
    private int screenNumber = 1;

    public UserInterface(GroceryList shoppingList, Wallet wallet, Products products)
    {
        this.basket = shoppingList;
        this.wallet = wallet;
        this.products = products;
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
                    browseMenu(); //why is this not default?? i thought this was a shopping terminal? or is it an ATM + shopping terminal?
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
                    mainMenu();//consider removing the loser part, kay isnt gonna like that
                    break;
            }
        }
    }
    //region Menus and stuff
    private void mainMenu()
    {
        headline(this.shopName, "Welcome to Hell");

        promptSelection();
        System.out.print(ANSI_GREEN);
        System.out.println("1: Browse Stuff");
        System.out.println("2: Check my Basket");
        System.out.println("3: Check my Wallet");
        System.out.println("4: Contact Support");
        System.out.println("5: End my Misery");
        System.out.print(ANSI_RESET);
        System.out.print(">");

        switch (input())
        {
            case "1":
                this.screenNumber = 2;
                break;
            case "2":
                System.out.println(ANSI_YELLOW + "Your Basket: " + ANSI_RESET);
                System.out.print(ANSI_GREEN);
                basket.checkBasket();
                System.out.print(ANSI_RESET);
                promptEnter();
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

    private void browseMenu()
    {
        headline(this.shopName, "Shopping Time");

        promptSelection();
        System.out.print(ANSI_GREEN);
        System.out.println("1> Browse Goods");
        System.out.println("2> Remove an Item");
        System.out.println("3> Check Out");
        System.out.println("4> What is in the Basket");
        System.out.println("5> Check my Wallet");
        System.out.println("6> Contact Support");
        System.out.println("7> Return to Main Menu");
        System.out.println("8> End my Misery");
        System.out.print(ANSI_RESET);
        System.out.print(">");

        switch (input())
        {
            case "1":
                // Print out available Items
                System.out.println(ANSI_YELLOW + "Available Items: " + ANSI_RESET);
                System.out.print(ANSI_GREEN);
                System.out.println(this.products);
                System.out.print(ANSI_RESET);
                System.out.println();

                // Item selection
                System.out.print(ANSI_YELLOW + "To add an item, write it's name (type return to cancel): " + ANSI_RESET);
                boolean checkSuccessfull = false;
                // Loop for adding items to the basket
                while (!checkSuccessfull)
                {
                    String item = input();
                    if (item.toLowerCase().equals("return") || item.isEmpty())
                    {
                        checkSuccessfull = true;
                    }
                    else if (products.getProduct(item) == null)
                    {
                        System.out.println(ANSI_RED + "No such item, try again" + ANSI_RESET);
                        System.out.print(">");
                    }
                    else
                    {
                        System.out.println(ANSI_YELLOW + "You've picked up " + ANSI_GREEN + products.getProduct(item).getName() + ANSI_RESET);
                        int quantity;
                        try
                        {
                            System.out.println(ANSI_YELLOW + "How many do you want: " + ANSI_RESET);
                            System.out.print(">");
                            quantity = Integer.parseInt(input());
                            if (quantity <= 0)
                            {
                                System.out.println(ANSI_RED + "You can only add positive amount of items" + ANSI_RESET);
                            }
                            else
                            {
                                basket.add(new GroceryItemOrder( products.getProduct(item).getName(), products.getProduct(item).getPrice(), quantity));
                                System.out.println(ANSI_GREEN + quantity + " " + products.getProduct(item).getName() + " added to the basket" + ANSI_RESET);
                                promptEnter();
                                input();
                                checkSuccessfull = true;
                            }

                        } catch (NumberFormatException e)
                        {
                            System.out.println(ANSI_RED + "Wrong input, it has to be an integer" + ANSI_RESET);
                            System.out.print(">");
                        }
                    }
                }
                break;
            case "2":
                System.out.print(ANSI_YELLOW + "What product would you like to remove: " + ANSI_RESET);
                System.out.println(ANSI_GREEN);
                basket.checkBasket();
                System.out.print(ANSI_RESET);
                System.out.print(">");
                System.out.print(ANSI_YELLOW);
                basket.remove(input());
                System.out.print(ANSI_RESET);;
                promptEnter();
                input();
                break;
            case "3":
                if (wallet.getAmount() < basket.getTotalCost())
                {
                    System.out.println(ANSI_RED + "You're too poor to afford this. Remove some items or acquire more currency" + ANSI_RESET);
                }
                else
                {
                    wallet.addFunds(basket.getTotalCost() * -1);
                    System.out.print(ANSI_YELLOW + "Receipt: " + ANSI_RESET);
                    System.out.print(ANSI_GREEN);
                    basket.printReceipt();
                    System.out.print(ANSI_RESET);
                    basket.clearBasket();
                }
                promptEnter();
                input();
                break;
            case "4":
                System.out.println(ANSI_YELLOW + "Your Basket: " + ANSI_RESET);
                System.out.print(ANSI_GREEN);
                basket.checkBasket();
                System.out.print(ANSI_RESET);
                promptEnter();
                input();
                break;
            case "5":
                this.screenNumber = 4;
                break;
            case "6":
                this.screenNumber = 5;
                break;
            case "7":
                this.screenNumber = 1;
                break;
            case "8":
                this.screenNumber = 99;
                break;
        }

    }

    private void basketMenu()
    {
        headline(this.shopName, "What is thy query?");

        promptSelection();
        System.out.print(ANSI_GREEN);
        System.out.println("1> Browse Items");
        System.out.println("2> Check my Basket");
        System.out.println("3> Check my Wallet");
        System.out.println("4> Contact Support");
        System.out.println("5> Return to Main Menu");
        System.out.println("6> End my Misery");
        System.out.print(ANSI_RESET);
        System.out.print(">");

        switch (input())
        {
            case "1":
                this.screenNumber = 2;
                break;
            case "2":
                System.out.println(ANSI_YELLOW + "Your Basket: " + ANSI_RESET);
                System.out.print(ANSI_GREEN);
                basket.checkBasket();
                System.out.print(ANSI_RESET);
                promptEnter();
                input();
                break;
            case "3":
                this.screenNumber = 4;
                break;
            case "4":
                this.screenNumber = 5;
                break;
            case "5":
                this.screenNumber = 1;
                break;
            case "6":
                this.screenNumber = 99;
                break;
        }

    }

    private void walletMenu()
    {
        headline(this.shopName, "What is thy query?");

        System.out.println(ANSI_YELLOW + "You have " + ANSI_GREEN + wallet.getAmount() + wallet.getCurrency() + ANSI_YELLOW + " in your wallet" + ANSI_RESET);

        promptSelection();
        System.out.print(ANSI_GREEN);
        System.out.println("1> Add Money");
        System.out.println("2> Convert currency");
        System.out.println("3> Contact Support");
        System.out.println("4> Return to Main Menu");
        System.out.println("5> End my Misery");
        System.out.print(ANSI_RESET);

        System.out.print(">");

        switch (input())
        {
            case "1":
                System.out.print(ANSI_YELLOW + "How many munies would you like to add: " + ANSI_RESET);
                boolean checkSuccessful = false;
                int rupieAmount = 0;
                while (!checkSuccessful)
                {
                    try
                    {
                        rupieAmount = Integer.parseInt(input());

                        if (rupieAmount < 0)
                        {
                            System.out.println(ANSI_RED + "You can only add positive amount of rupies" + ANSI_RESET);
                        }
                        else checkSuccessful = true;

                    } catch (NumberFormatException e)
                    {
                        System.out.println(ANSI_RED + "Wrong input, it has to be an integer" + ANSI_RESET);
                    }

                }
                wallet.addFunds(rupieAmount);
                break;
            case "2":
                System.out.println(ANSI_RED + "Currently not implemented, contact support" + ANSI_RESET);
                promptEnter();
                input();
                break;
            case "3":
                this.screenNumber = 5;
                break;
            case "4":
                this.screenNumber = 1;
                break;
            case "5":
                this.screenNumber = 99;
                break;
        }

    }

    private void supportMenu()
    {
        headline(this.shopName, "Hi this is Prajit talking. How can I help you today sir?");

        System.out.println(ANSI_RED +  "Actually I am currently unable to help you for I do now know how to help you sir I am so sorry I will return you to the main menu soon" + ANSI_RESET);

        promptEnter();

        System.out.print(ANSI_RESET);
        input();
        this.screenNumber = 1;

    }

    private void quitMenu()
    {
        headline("Black Market Exit", "Remember to CLose the Door");
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
        print('_');
        print(headline);
        if (!subtext.isBlank()) print(subtext);
        print('_');
        System.out.print(ANSI_RESET);
    }

    private void promptSelection()
    {
        System.out.println(ANSI_YELLOW +  "What would you like to do?" + ANSI_RESET);
    }

    private void promptEnter()
    {
        System.out.println(ANSI_YELLOW +  "press enter to continue" + ANSI_RESET);
    }

    private String input()
    {
        Scanner console = new Scanner(System.in);
        return console.nextLine();
    }

    //endregion
}
