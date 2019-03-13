public class ItemToPurchase {

    private String itemDescription;

    private String name;

    private double itemPrie;

    private int itemQuantity;

    public ItemToPurchase() {

        itemDescription = "none";

        itemQuantity = 0;

        itemPrie = 0;

        name = "";

    }

    public ItemToPurchase(String name, String description, double price, int itemQuantity) {

        this.itemDescription = description;

        this.name = name;

        this.itemPrie = price;

        this.itemQuantity = itemQuantity;

    }

    public String getItemDescription() {

        return itemDescription;

    }

    public void setItemDescription(String itemDescription) {

        this.itemDescription = itemDescription;

    }

    public void printItemCost() {

        System.out.println(name+" "+itemQuantity+" @ "+itemPrie+" = $"+(itemQuantity * itemPrie) );

    }

    public void printItemDescription() {

        System.out.println(name+" "+itemDescription);

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public double getItemPrie() {

        return itemPrie;

    }

    public void setItemPrie(double itemPrie) {

        this.itemPrie = itemPrie;

    }

    public int getItemQuantity() {

        return itemQuantity;

    }

    public void setItemQuantity(int itemQuantity) {

        this.itemQuantity = itemQuantity;

    }

}