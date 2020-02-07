public class Wallet {
    //region Fields/Attributes
    private int amount;
    private String currency;
    //endregion

    //region Constructors
    public Wallet () {}

    public Wallet ( int amount ) {
        this.amount = amount;
        this.currency = "DKK";
    }

    public Wallet ( int amount, String currency ) {
        this.amount = amount;
        this.currency = currency;
    }
    //endregion

    //region Methods
    public void addFunds ( int amount ) {
        this.amount += amount;
    }

    public void withdrawFunds ( int amount ) {
        this.amount -= amount;
    }
    //endregion

    //region Getters
    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
    //endregion

    //region Setters
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    //endregion

    //region toString

    @Override
    public String toString() {
        return "Currency : " + currency + ", Amount : " + amount;
    }
    //endregion
}
