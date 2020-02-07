import java.sql.SQLOutput;
import java.util.ArrayList;

public class Store {
    //region Fields/Attributes
    private ArrayList<GroceryItemOrder> stock = new ArrayList<>();
    //endregion

    //region Constructors
    public Store () {}

    public Store ( ArrayList<GroceryItemOrder> stock ) {
        this.stock = stock;
    }
    //endregion

    //region Methods
    public void remove ( String name, int quantity ) {
        int index = searchStock(name);

        if ( index < 0 ) {
            System.out.println("Item not currently in the Store.");
        }
        else {
            GroceryItemOrder item = stock.get(index);
            if (item.getQuantity() >= quantity) {
                item.setQuantity(item.getQuantity()-quantity);
                stock.set(index, item);
            }
            else {
                System.out.println("The store only has " + item.getQuantity() + " " + item.getName() + "s.");
                stock.remove(index);
            }
        }
    }

    public int searchStock ( String name ) {
        for ( int i = 0; i < stock.size(); i++) {
            if (stock.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void checkStock () {
        System.out.println("The Store currently contains : ");
        for ( int i = 0; i < stock.size(); i++ ) {
            System.out.println("\t" + (i+1) + ". " + stock.get(i).toString() + ";");
        }
    }
    //endregion

    //region Getters
    public ArrayList<GroceryItemOrder> getStock() {
        return stock;
    }
    //endregion

    //region Setters
    public void setStock(ArrayList<GroceryItemOrder> stock) {
        this.stock = stock;
    }
    //endregion

    //region toString

    @Override
    public String toString() {
        return "The List Contains : " + stock.toString();
    }
    //endregion
}
