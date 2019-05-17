package ch.heigvd.gen2019;

import java.util.ArrayList;
import java.util.List;

public class Orders extends JsonUtile implements JSonTab {
    private List<Order> orders = new ArrayList<>();

    public void AddOrder(Order order) {
        orders.add(order);
    }

    @Override
    public int getElementCount() {
        return orders.size();
    }

    @Override
    public Object getElement(int j) {
        return orders.get(j);
    }

    @Override
    public String getJson() {
        sb.append("{");
        addTableau("orders", this);
        return sb.append("}").toString();
    }
}
