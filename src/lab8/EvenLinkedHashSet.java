package lab8;

import java.util.LinkedHashSet;

public class EvenLinkedHashSet extends LinkedHashSet<Integer> {
    @Override
    public boolean add(Integer integer) {
        if (integer % 2 == 0) {
            return super.add(integer);
        }
        return false;
    }
}
