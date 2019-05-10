package ch.heigvd.gen2019;

import java.util.ArrayList;
import java.util.List;

public class Orders implements JSonTab {
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
}
