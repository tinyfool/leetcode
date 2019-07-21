package p0385;

import java.util.List;
//暂时跳过
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

public class Solution {

    public NestedInteger deserialize(String s) {

        return null;
    }

}
