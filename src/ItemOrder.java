public class ItemOrder {
    public String name;

    public ItemOrder(String name, GroceryList list){
        this.name = name;

        list.addItemOrder(this);
    }
    public String toString(){
        return name;
    }
}
