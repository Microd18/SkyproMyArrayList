package Module;

import Exceptions.ElementNotFoundException;
import Exceptions.InvalidIndexException;
import Exceptions.NullItemException;
import Interfaces.StringList;
import java.util.Arrays;

public class MyArrayList implements StringList {
    public int SIZE = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private String[] array;


    public MyArrayList() {
        array = new String[DEFAULT_CAPACITY];
    }

    MyArrayList(int size) {
        array = new String[size];
    }

    @Override
    public String add(String item) {
        validateItem(item);

        if (array.length == SIZE) {
            grow();
        }

        return array[SIZE++] = item;
    }

    @Override
    public String add(int index, String item) {
        validateIndex(index);
        validateItem(item);
        if (array.length - 1 == SIZE) {
            grow();
        }
        if (index == SIZE) {
            array[SIZE++] = item;
            return item;
        }

        System.arraycopy(array, index, array, index + 1, SIZE - index);

        SIZE++;

        return array[index] = item;

    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        return array[index] = item;
    }

    @Override
    public String remove(String item) {

        validateItem(item);

        int index = indexOf(item);

        if (index == -1) {
            throw new ElementNotFoundException();
        }

        System.arraycopy(array, index + 1, array, index, SIZE - index);

        SIZE--;

        return item;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);

        String result = array[index];

        System.arraycopy(array, index + 1, array, index, SIZE - index);

        SIZE--;

        return result;
    }

    @Override
    public boolean contains(String item) {
        for (String str : array) {
            if (str == null) {
                continue;
            }
            if (str.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < SIZE; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = SIZE - 1; i > 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return SIZE;
    }

    @Override
    public boolean isEmpty() {
        return SIZE == 0;
    }

    @Override
    public void clear() {
        SIZE = 0;
        Arrays.fill(array, null);
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, SIZE);
    }

    private Object[] grow() {
        return array = Arrays.copyOf(array, (array.length * 2));
    }

    @Override
    public String toString() {
        return "MyArrayList{" + Arrays.toString(array) +
                '}';
    }

    public void validateIndex(int index) {
        if (index < 0 || index > SIZE)
            throw new InvalidIndexException();
    }

    public void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

}
