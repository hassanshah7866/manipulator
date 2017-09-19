package CustomList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.stream.Stream;

public class CustomList<Type> implements Iterable<Type> {

    private Type[] array;
    private int currentSize;

    public CustomList () {
        array = null;
    }

    public CustomList (Type[] array) {

        this.array = array;
    }

    public Stream stream () {

        return Arrays.stream(array);
    }

    public Iterator<Type> iterator() {

        return new ListIterator<Type>() {

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
                array[currentIndex] = t;
            }

            @Override
            public void remove() {
                Type[] newArray = (Type[]) Arrays.stream(array)
                        .filter(element -> !element.equals(array[currentIndex]))
                        .toArray();

                array = newArray;
                currentSize--;
                if (currentIndex>0) {
                    currentIndex--;
                }
            }


            @Override
            public void add(Type o) { //not yet correct, edit later

                Type[] leftArray = Arrays.copyOfRange(array, 0, currentIndex+1);
                Type[] finalArray = (Type[]) Stream.concat(Arrays.stream(leftArray), Stream.of(o))
                        .toArray();
                if (currentIndex<array.length-1) {
                    Type[] rightArray = Arrays.copyOfRange(array, currentIndex+1, array.length);
                    finalArray = (Type[]) Stream.concat(Arrays.stream(leftArray), Arrays.stream(rightArray))
                    .toArray();
                }else {
                    currentIndex++;
                }
                array = finalArray;
                currentSize++;
            }
        };
    }

    public void add (Type t) {

        if (array == null) {
            array = (Type[]) new Object[1];
            array[0] = t;
        } else {
            Type[] newArray = (Type[]) Stream.concat(Arrays.stream(array), Stream.of(t))
                    .toArray();
            array = newArray;
            currentSize++;
        }
    }

    public Type remove (int index) {

        if (currentSize == 0) {

            throw new RuntimeException("The list is empty");

        } else if (index > currentSize - 1) {

            throw new ArrayIndexOutOfBoundsException();

        } else {

            Type removedObject = array[index];
            Type[] newArray = (Type[]) Arrays.stream(array)
                    .filter(element -> !element.equals(array[index]))
                    .toArray();

            array = newArray;
            currentSize--;
            return removedObject;
        }
    }

    public int size () {

        return currentSize;
    }

    @Override
    public String toString() {

        return Arrays.toString(array);
    }

}
