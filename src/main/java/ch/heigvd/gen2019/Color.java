package ch.heigvd.gen2019;

abstract public class Color {

    public abstract String getColor();
}

class Red extends Color {

    public String getColor() {
        return "red";
    }
}

class Blue extends Color {
    public String getColor() {
        return "blue";
    }
}

class Yellow extends Color {
    public String getColor() {
        return "yellow";
    }
}



