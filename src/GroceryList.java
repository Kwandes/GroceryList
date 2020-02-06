public class GroceryList {

    private GroceryItemOrder[]  list = new GroceryItemOrder[10];

    public GroceryList () {}

    public void add ( GroceryItemOrder item ) {
        if (list.length < 10) {
            list[list.length-1] = item;
        }
    }

    public int  getTotalCost () {
        int totalCost = 0;
        for ( int i = 0; i < 10; i ++ ) {
            totalCost += list[i].getPrice() * list[i].getQuantity();
        }
        System.out.println("Total Cost of the Grocery List : " + totalCost + "DKK.");
        return totalCost;
    }

    public void setList(GroceryItemOrder[] list) {
        this.list = list;
    }

    public GroceryItemOrder[] getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Grocery Item Order : " + list.toString();
    }
}
