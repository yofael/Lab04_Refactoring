package ch.heigvd.gen2019;

import java.util.Collections;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer sb = new StringBuffer("{");
        deleteSB(sb, "orders", orders);
        return sb.append("]}").toString();
    }

    private void addOrder(StringBuffer sb, Order order) {
        sb.append("{");
        addChamp(sb, "id", order.getOrderId());
        deleteSB(sb, "products", order);
        sb.append("]}, ");
    }

    private void deleteSB(StringBuffer sb, String s, Object obj) {
        addTableau(sb, s, obj);
        if (((JSonTab)obj).getElementCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
    }
    private void addTableau(StringBuffer sb, String name, Object obj) {
        int max;

        max =((JSonTab) obj).getElementCount();
        sb.append("\"" + name + "\": [");
        for (int j = 0; j < max; j++) {
            Object tmp = ((JSonTab)obj).getElement(j);
            if (tmp instanceof Order) {
                addOrder(sb, (Order) tmp);
            } else {
                addProduct(sb, (Product) tmp);
            }
        }
    }

    private void addProduct(StringBuffer sb, Product product) {
        sb.append("{");
        addChamp(sb, "code", product.getCode());
        addChamp(sb, "color", getColorFor(product));

        if (product.getSize() != Product.SIZE_NOT_APPLICABLE) {
            addChamp(sb, "size", getSizeFor(product));
        }

        addChamp(sb, "price", product.getPrice());
        addChamp(sb, "currency", product.getCurrency());
        sb.append("\"}, ");
    }

    private void addChamp(StringBuffer sb, String nomChamp, Object valeur) {
        sb.append("\"" + nomChamp + "\": ");
        stringTreatment(sb, valeur);
        sb.append(valeur);
        if (!nomChamp.equals("currency")) {
            stringTreatment(sb, valeur);
            sb.append(", ");
        }
    }

    private void stringTreatment(StringBuffer sb, Object valeur) {
        if (valeur instanceof String) {
            sb.append("\"");
        }
    }

    private String getSizeFor(Product product) {
        switch (product.getSize()) {
            case 1:
                return "XS";
            case 2:
                return "S";
            case 3:
                return "M";
            case 4:
                return "L";
            case 5:
                return "XL";
            case 6:
                return "XXL";
            default:
                return "Invalid Size";
        }
    }

    private String getColorFor(Product product) {
        switch (product.getColor()) {
            case 1:
                return "blue";
            case 2:
                return "red";
            case 3:
                return "yellow";
            default:
                return "no color";
        }
    }

}