package CLRS;

public class pair {
    int key;
    String value;

    pair(int k, String v) {

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
