import CustomList.CustomList;

public class QuickSorter  {

    public CustomList<Comparable> sort(CustomList<Comparable> list) {
        Comparable pivot = list.remove(list.size()-1);
        CustomList<Comparable> left = new CustomList<Comparable>();
        CustomList<Comparable> right = new CustomList<Comparable>();
        for (Comparable c : list) {
            if (c.compareTo(pivot) < 0) {
                left.add(c);
            } else {
                right.add(c);
            }
        }
        if (left.size()>0) {
            left = sort(left);
        }
        if (right.size()>0) {
            right = sort(right);
        }
        CustomList<Comparable> sorted = new CustomList<Comparable>();
        //sorted.addAll(left);
        for (Comparable c : left) {
            sorted.add(c);
        }
        sorted.add(pivot);
        //sorted.addAll(right);
        for (Comparable c : right) {
            sorted.add(c);
        }
        return sorted;
    }
}