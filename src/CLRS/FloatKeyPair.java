package CLRS;

public class FloatKeyPair {
    float key;
    String value;

    FloatKeyPair(float k, String v) {

        key = k;
        value = v;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(key).append(":").append(value);
        return sb.toString();
    }
}
