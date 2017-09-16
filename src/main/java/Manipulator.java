import CustomList.CustomList;

public class Manipulator {

    public static void main (String[] args) {


        CustomList list = new CustomList();
        for (String s : args) {
            list.add(Integer.getInteger(s));
        }

    }
}
