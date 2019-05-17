package ch.heigvd.gen2019;

public class OrdersWriter {
    private Orders orders;
    private StringBuffer sb = new StringBuffer();

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getOrder() {
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
               sb.append(((Product) tmp).getJson());
            }
        }
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