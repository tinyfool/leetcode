package p0341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


//Runtime: 2 ms, faster than 100.00% of Java online submissions for Flatten Nested List Iterator.
//        Memory Usage: 36.7 MB, less than 99.91% of Java online submissions for Flatten Nested List Iterator.

interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
}

class NestedIntegerClass implements NestedInteger {

    boolean isInteger;
    int number = 0;

    List<NestedInteger> list = null;

    NestedIntegerClass(int num) {
        isInteger = true;
        number = num;
    }

    NestedIntegerClass(List<NestedInteger> aList) {
        isInteger = false;
        list = aList;
    }
    @Override
    public boolean isInteger() {
        return isInteger;
    }

    @Override
    public Integer getInteger() {
        return number;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}

public class NestedIterator implements Iterator<Integer> {

    List<Integer> numList = new ArrayList<>();

    int i=0;
    public NestedIterator(List<NestedInteger> nestedList) {

        flatten(nestedList);
    }

    void flatten(List<NestedInteger> nestedList) {

        if (nestedList==null)
            return;
        for (NestedInteger ni:nestedList) {
            if(ni.isInteger())
                numList.add(ni.getInteger());
            else
                flatten(ni.getList());
        }
    }

    @Override
    public Integer next() {
        Integer num =  numList.get(i);
        i++;
        return num;
    }

    @Override
    public boolean hasNext() {

        if(i<numList.size())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        ArrayList<NestedInteger> rootList = new ArrayList<>();

        ArrayList<NestedInteger> list1 = new ArrayList<>();
        list1.add(new NestedIntegerClass(1));
        list1.add(new NestedIntegerClass(1));

        NestedIntegerClass n1 = new NestedIntegerClass(2);

        ArrayList<NestedInteger> list2 = new ArrayList<>();
        list2.add(new NestedIntegerClass(1));
        list2.add(new NestedIntegerClass(1));

        rootList.add(new NestedIntegerClass(list1));
        rootList.add(n1);
        rootList.add(new NestedIntegerClass(list2));

        NestedIterator iterator = new NestedIterator(rootList);
        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }

        rootList = new ArrayList<>();
        n1 = new NestedIntegerClass(1);
        NestedIntegerClass n2 = new NestedIntegerClass(4);
        NestedIntegerClass n3 = new NestedIntegerClass(6);
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list1.add(n3);
        list2.add(n2);
        list2.add(new NestedIntegerClass(list1));
        rootList.add(n1);
        rootList.add(new NestedIntegerClass(list2));

        iterator = new NestedIterator(rootList);
        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }
    }
}
