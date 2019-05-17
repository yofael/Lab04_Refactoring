package ch.heigvd.gen2019;

public class OrdersWriter extends JsonCamp {
    private Orders orders;


    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getOrder() {

        return getJson();
    }

    @Override
    public String getJson() {
        sb.append("{");
        addTableau("orders", orders);
        return sb.append("]}").toString();
    }


}