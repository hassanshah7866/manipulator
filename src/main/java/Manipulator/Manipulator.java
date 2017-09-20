package Manipulator;

import java.lang.Comparable;
import CustomList.*;


public interface Manipulator {

    // CustomList<Comparable> perform (CustomList<Comparable> list);
    <T extends Comparable<T>> CustomList<T> perform (CustomList<T> list);
}
