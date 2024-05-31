public class StockItem {
    private String description;
    private int id;
    private static int idCount = 0;
    private double price;
    private int quantity;

    StockItem(){
         description = null;
         price = 0.00;
         quantity = 0;
         id = idCount;
         idCount++;
    }

    StockItem(double p, int q, String d){
        id = idCount;
        price = p;
        quantity = q;
        description = d;

        idCount++;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double p){
        if(p < 0){
            System.out.println("Error! Price cannot be below 0! Please try again");
        }else{
            price = p;
        }
    }

    public void lowerQuantity(){
        quantity--;
    }

    public void raiseQuantity(int i){
        quantity = quantity + i;
    }

    public String toString() {
        return "Item Number: " + id + " is " + description + " has price $" +
                price + " we currently have " + quantity;
    }
}
