import java.util.ArrayList;
import java.util.Arrays;

public class GroceryList {

    //region Fields/Attributes
    private ArrayList<GroceryItemOrder> list = new ArrayList<GroceryItemOrder>();
    private String currency;
    //private GroceryItemOrder[]  list = new GroceryItemOrder[10];
    //endregion

    //region Constructors
    public GroceryList () {
        this.currency = "DKK";
    }

    public GroceryList ( String currency ) {
        this.currency = currency;
    }
    //endregion

    //region Methods
    public void add ( GroceryItemOrder item ) {
        if (list.size() < 10) {
            list.add (item);
        }
    }

    public void remove ( String name ) {
        int index = searchList(name);

        if ( index < 0 || index >= list.size() ) {
            System.out.println("Item not currently in the Basket.");
        }
        else {
            System.out.println(list.get(index) + " has been removed");
            list.remove(index);
        }
    }

    public int searchList ( String name ) {
        for ( int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    public void checkBasket () {
        if(list.isEmpty()) System.out.println("The Basket is empty");
        else
        {
            System.out.println("The Basket currently contains : ");
            for ( int i = 0; i < list.size(); i++ ) {
                System.out.println("\t" + (i+1) + ". " + list.get(i).toString() + ";");
            }
        }
    }

    public void clearBasket () {list.clear();}

    public void printReceipt () {
        if(list.isEmpty()) System.out.println("The Basket is empty");
        else
        {
            for ( int i = 0; i < list.size(); i++ ) {
                System.out.printf("\n %1d x %3s %3s %4d %5s %6d",
                        list.get(i).getQuantity(), list.get(i).getName(), "for", list.get(i).getPrice(),
                        this.currency, (list.get(i)).getQuantity()*list.get(i).getPrice());
            }
            System.out.println();
        }
    }

    public int  getTotalCost () {
        int totalCost = 0;
        for ( int i = 0; i < list.size(); i ++ ) {
            totalCost += list.get(i).getPrice() * list.get(i).getQuantity();
        }
        // Please don't print stuff yourself
        //System.out.println("Total Cost of the Grocery List : " + totalCost + "DKK.");
        return totalCost;
    }
    //endregion

    //region Setters
    public void setList(ArrayList<GroceryItemOrder> list) {
        this.list = list;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    //endregion

    //region Getters
    public ArrayList<GroceryItemOrder> getList() {
        return list;
    }

    public String getCurrency() {
        return currency;
    }
    //endregion

    //region toString
    @Override
    public String toString() {
        return "The List Contains : " + list.toString();
    }
    //endregion
}
