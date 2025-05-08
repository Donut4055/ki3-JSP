package Model;

public class Order {
    private String productName;
    private int quantity;
    private double pricePerUnit;

    public Order(String productName, int quantity, double pricePerUnit) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public double calculateTotal() {
        return quantity * pricePerUnit;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }
}
