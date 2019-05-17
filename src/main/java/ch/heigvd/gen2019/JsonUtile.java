package ch.heigvd.gen2019;

public abstract class JsonUtile {
    StringBuffer sb = new StringBuffer();
    public abstract String getJson();

    public void addChamp(String nomChamp, Object valeur) {
        sb.append("\"" + nomChamp + "\": ");
        stringTreatment(valeur);
        sb.append(valeur);
        if (!nomChamp.equals("currency")) {
            stringTreatment(valeur);
            sb.append(", ");
        }
    }
    private void stringTreatment(Object valeur) {
        if (valeur instanceof String) {
            sb.append("\"");
        }
    }

    void addTableau(String name, Object obj) {
        int max;

        max = ((JSonTab) obj).getElementCount();
        sb.append("\"" + name + "\": [");

        for (int j = 0; j < max; j++) {
            Object tmp = ((JSonTab) obj).getElement(j);
            sb.append(((JsonUtile) tmp).getJson());
        }

        if (((JSonTab) obj).getElementCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
    }

}
