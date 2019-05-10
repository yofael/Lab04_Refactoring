package ch.heigvd.gen2019;

public class Product {
    private Amount amount;
    private String code;
    private Color color;
    private Size size;

    public Product(String code, Color color, Size size, Amount amount) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public String getColor() {
        return color.getColor();
    }

    public String getSize() {
        return size.getSize();
    }

    public double getPrice() {
        return amount.getPrice();
    }

    public String getCurrency() {
        return amount.getCurrency();
    }
}