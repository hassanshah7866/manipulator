import CustomList.*;
import Manipulator.*;


public class ManipulatorApplication {

    private static CustomList getSortedList (CustomList list) {

     Manipulator quickSorter = new QuickSorter();
     return quickSorter.perform(list);
    }

    private static CustomList<Integer> getCustomListWithIntegers (String[] args) {

        CustomList<Integer> list = new CustomList<Integer>();

        for (String s : args) {
            list.add(Integer.getInteger(s));
        }

        return list;
    }

    private static CustomList<Integer> removeOddIntegers (CustomList<Integer> list) {

        CustomList<Integer> evenList = new CustomList<Integer>();

        for (Integer number : list) {

            if (number%2 == 0) {
                evenList.add(number);
            }
        }

        return evenList;
    }

    private static CustomList<Integer> randomizeList (CustomList<Integer> list) {

        Manipulator randomizer = new Randomizer();
        return randomizer.perform(list);
    }

    private static String selectManipulation (Manipulators manipulators, CustomList<Integer> list) {

        switch (manipulators) {

            case EVEN:
                return removeOddIntegers(list).toString();

            case SORT:
                return getSortedList(list).toString();

            case RANDOMIZE:
                return randomizeList(list).toString();

            default:
                throw new RuntimeException("Invalid manipulation");
        }
    }


    public static void main (String[] args) {

        try {
            for (int i = 0; i < Manipulators.values().length; i++) {
                Manipulators m = Manipulators.values()[i];
                CustomList<Integer> list = getCustomListWithIntegers(args);
                System.out.print(selectManipulation(m, list));

                if (i < Manipulators.values().length - 1) {
                    System.out.print(", ");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
