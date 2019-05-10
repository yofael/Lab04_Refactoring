package ch.heigvd.gen2019;

import java.util.HashMap;
import java.util.Map;

public class OrdersWriter {
    private Orders orders;
    private StringBuffer sb = new StringBuffer();
    private Map<Integer, String> getColor = new HashMap<>();
    private Map<Integer, String> getSize = new HashMap<>();


    public OrdersWriter(Orders orders) {
        this.orders = orders;
        getColor.put(1, "blue");
        getColor.put(2, "red");
        getColor.put(3, "yellow");

        getSize.put(1, "XS");
        getSize.put(2, "S");
        getSize.put(3, "M");
        getSize.put(4, "L");
        getSize.put(5, "XL");
        getSize.put(6, "XXL");
    }

    public String getContents() {
        sb.append("{");
        deleteSB("orders", orders);
        return sb.append("]}").toString();
    }

    private void addOrder(Order order) {
        sb.append("{");
        addChamp("id", order.getOrderId());
        deleteSB("products", order);
        sb.append("]}, ");
    }

    private void addTableau(String name, Object obj) {
        int max;

        max = ((JSonTab) obj).getElementCount();
        sb.append("\"" + name + "\": [");
        for (int j = 0; j < max; j++) {
            Object tmp = ((JSonTab) obj).getElement(j);
            if (tmp instanceof Order) {
                addOrder((Order) tmp);
            } else {
                addProduct((Product) tmp);
            }
        }
    }

    private void addProduct(Product product) {
        sb.append("{");
        addChamp("code", product.getCode());
        addChamp("color", getColor.getOrDefault(product.getColor(), "no color"));

        if (product.getSize() != Product.SIZE_NOT_APPLICABLE) {
            addChamp("size", getSize.getOrDefault(product.getSize(), "Invalid Size"));
        }

        addChamp("price", product.getPrice());
        addChamp("currency", product.getCurrency());
        sb.append("\"}, ");
    }

    private void addChamp(String nomChamp, Object valeur) {
        sb.append("\"" + nomChamp + "\": ");
        stringTreatment(valeur);
        sb.append(valeur);
        if (!nomChamp.equals("currency")) {
            stringTreatment(valeur);
            sb.append(", ");
        }
    }

    private void deleteSB(String s, Object obj) {
        addTableau(s, obj);
        if (((JSonTab) obj).getElementCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
    }

    private void stringTreatment(Object valeur) {
        if (valeur instanceof String) {
            sb.append("\"");
        }
    }
}