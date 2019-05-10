package ch.heigvd.gen2019;

import java.util.ArrayList;
import java.util.List;

public class Order implements JSonTab {
    private List<Product> products = new ArrayList<>();
    private int id;

    public Order(int id) {
            this.id = id;
    }

    public int getOrderId() {
        return id;
    }

    public void AddProduct(Product product) {
        products.add(product);
    }

    @Override
    public int getElementCount() {
        return products.size();
    }

    @Override
    public Object getElement(int j) {
        return products.get(j);
    }
}
