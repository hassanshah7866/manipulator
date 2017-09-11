package IntegerList;

import java.util.Iterator;
import java.util.ListIterator;

public class CustomList<Type> implements Iterable<Type> {

    private Type[] array;
    private int currentSize;


    public CustomList () {
        currentSize = 0;
    }

    public CustomList (Type[] array) {

        this.array = array;
    }

    public Iterator<Type> iterator() {
        ListIterator<Type> listIterator = new ListIterator<Type>() {

            int currentIndex = 0;

            @Override
            public boolean hasNext() {

                return currentIndex >= currentSize && array[currentIndex] != null;
            }

            @Override
            public Type next() {

                return array[currentIndex++];
            }

            @Override
            public boolean hasPrevious() {

                return currentIndex > 0;
            }

            @Override
            public Type previous() {

                return currentIndex > 0 ? array[currentIndex--] : null;
            }

            @Override
            public int nextIndex() {
                return currentIndex < currentIndex-1 && array[currentIndex+1] != null ? currentIndex+1 : -1;
            }

            @Override
            public int previousIndex() {

                return currentIndex > 0 ? currentIndex-1 : -1;
            }

            @Override
            public void set(Type t) {

            }

            /**
            @Override
            public void remove() {

            }


            @Override
            public void add(Type t) {

            }
            */
        };

        return listIterator;
    }
}
