package Manipulator;

import java.lang.Comparable;
import CustomList.CustomList;


public class Randomizer implements Manipulator {

    @Override
    public <T extends Comparable<T>> CustomList<T> perform(CustomList<T> list) {


        CustomList<T> randomizedList = new CustomList<T>();

        while (!list.isEmpty()) {

            int random = (int) (Math.random()*list.size());
            randomizedList.add(list.remove(random));
        }

        return randomizedList;
    }
}