public class GroceryListExercise {
    public static void main(String[] args){
        GroceryList list = new GroceryList();

        ItemOrder milk = new ItemOrder("milk", list);
        ItemOrder bread = new ItemOrder("bread", list);
        ItemOrder beer = new ItemOrder("beer", list);

        list.printList();
    }
}
