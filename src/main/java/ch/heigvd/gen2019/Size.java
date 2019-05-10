package ch.heigvd.gen2019;

abstract public class Size {
    public abstract String getSize();
}

class XS extends Size {

    public String getSize() {
        return "XS";
    }
}

class S extends Size {
    public String getSize() {
        return "S";
    }
}
class M extends Size {
    public String getSize() {
        return "M";
    }
}

class L extends Size {
    public String getSize() {
        return "L";
    }
}

class XL extends Size {
    public String getSize() {
        return "XL";
    }
}

class XXL extends Size {
    public String getSize() {
        return "XXL";
    }
}

class InvalidSize extends Size {
    public String getSize() {
        return "Invalid Size";
    }
}
