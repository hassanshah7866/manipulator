package Manipulator;

import java.lang.Comparable;
import CustomList.*;


public class QuickSorter implements Manipulator {

    public <T extends Comparable<T>> CustomList<T> perform(CustomList<T> list) {

        T pivot = list.remove(list.size()-1);
        CustomList<T> left = new CustomList<T>();
        CustomList<T> right = new CustomList<T>();

        for (T t : list) {

            if (t.compareTo(pivot) < 0) {

                left.add(t);
            } else {

                right.add(t);
            }
        }

        if (left.size()>0) {
            left = perform(left);
        }

        if (right.size()>0) {
            right = perform(right);
        }
        CustomList<T> sorted = new CustomList<T>();

        for (T t : left) {
            sorted.add(t);
        }
        sorted.add(pivot);

        for (T t : right) {
            sorted.add(t);
        }
        return sorted;
    }
}