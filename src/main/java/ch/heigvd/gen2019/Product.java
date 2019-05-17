package ch.heigvd.gen2019;

public class Product  extends JsonUtile {
    private Amount amount;
    private String code;
    private Color color;
    private Size size;

    public Product(String code, Color color, Size size, Amount amount)  {
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

    public String getJson(){
        sb.append("{");
        addChamp("code", this.getCode());
        addChamp("color", this.getColor());

        if (!this.getSize().equals("Invalid Size")) {
            addChamp("size", this.getSize());
        }

        addChamp("price", this.getPrice());
        addChamp("currency", this.getCurrency());
        sb.append("\"}, ");
        return sb.toString();
    }
}