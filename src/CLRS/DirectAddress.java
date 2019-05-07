package CLRS;

public class DirectAddress {

    pair[] data;
    DirectAddress(int n) {

        data = new pair[n];
    }

    pair search(int key) {

        return data[key];
    }

    void insert(pair x) {
        data[x.key] = x;
    }

    void delete(pair x) {

        data[x.key] = null;
    }

    public static void main(String[] args) {

        DirectAddress da = new DirectAddress(100);

        da.insert(new pair(20,"Beijing"));
        da.insert(new pair(22,"Shanghai"));
        da.insert(new pair(30,"Test"));
        da.insert(new pair(10,"Book"));

        System.out.println(da.search(20));
        System.out.println(da.search(22));
        System.out.println(da.search(30));
        System.out.println(da.search(10));

        da.delete(new pair(20,""));
        System.out.println(da.search(20));

        System.out.println(da.search(15));

    }
}
