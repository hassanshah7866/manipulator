import CustomList.CustomList;

public class Manipulator {

    private static CustomList getSortedList (CustomList list) {

     QuickSorter quickSorter = new QuickSorter();
     return quickSorter.sort(list);
    }

    private static CustomList getCustomListWithIntegers (String[] args) {

        CustomList list = new CustomList();
        for (String s : args) {
            list.add(Integer.getInteger(s));
        }
        return list;
    }

    private static CustomList getCustomListWithEvenIntegers (String[] args) {

        CustomList list = new CustomList();
        for (String s : args) {
            list.add(Integer.getInteger(s));
        }
        return list;
    }


    public static void main (String[] args) {


        CustomList<Integer> sortedList = getSortedList(getCustomListWithIntegers(args));

        CustomList<Integer> evenList = getSortedList(getCustomListWithIntegers(args));

        CustomList<Integer> blabla;






    }
}
