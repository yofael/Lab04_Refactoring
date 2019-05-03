package ch.heigvd.gen2019;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");

        for (int i = 0; i < orders.getOrdersCount(); i++) {
            addOrder(sb, orders.getOrder(i));
        }

        if (orders.getOrdersCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}").toString();
    }

    private void addOrder(StringBuffer sb, Order order) {
        sb.append("{");
        addChamp(sb, "id", order.getOrderId());

        sb.append("\"products\": [");
        for (int j = 0; j < order.getProductsCount(); j++) {
            addProduct(sb, order.getProduct(j));
        }

        if (order.getProductsCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("]");
        sb.append("}, ");
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
        if (valeur instanceof String) {
            sb.append("\"");
        }
        sb.append(valeur);
        if (!nomChamp.equals("currency")) {
            if (valeur instanceof String) {
                sb.append("\"");
            }
            sb.append(", ");
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