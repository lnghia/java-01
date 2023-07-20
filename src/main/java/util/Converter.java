package util;

public class Converter {
    private static final Converter instance;

    static {
        instance = new Converter();
    }

    public static Converter getInstance() {
        return instance;
    }

    public boolean binaryInStringToBoolean(String data) {
        return !data.isEmpty() && !data.equals("0");
    }
}
