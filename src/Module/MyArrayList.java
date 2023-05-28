package Module;

import Interfaces.StringList;

import javax.management.AttributeNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList implements StringList {
    public static int SIZE = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private String[] array;


    MyArrayList() {
        array = new String[DEFAULT_CAPACITY];
    }

    MyArrayList(int size) {
        array = new String[size];
    }

    @Override
    public String add(String item) {
        if (array.length == SIZE) {
            grow();
        }

        return array[SIZE++] = item;
    }

    @Override
    public String add(int index, String item) {

        if (index < 0 || index > SIZE)
            throw new IndexOutOfBoundsException("Выход за пределы массива!");
        if (array.length - 1 == SIZE) {
            grow();
        }
        System.arraycopy(array, index,array, index + 1, SIZE - index );

        SIZE++;

        return array[index] = item;

    }

    @Override
    public String set(int index, String item) {
        if (index < 0 || index > SIZE)
            throw new IndexOutOfBoundsException("Выход за пределы массива!");
        return array[index] = item;
    }

    @Override
    public String remove(String item) {
        int i = 0;
        String result;

        for (; i < SIZE; i++) {
            if (array[i].equals(item)) {
                result = array[i];
                System.arraycopy(array, i + 1 ,array, i, SIZE - i);
                SIZE--;
                return result;
            }
        }

        throw new RuntimeException("Элемент не найден");

    }

    @Override
    public String remove(int index) {
        if (index < 0 || index > SIZE)
            throw new IndexOutOfBoundsException("Выход за пределы массива!");
        String result = array[index];
        System.arraycopy(array, index + 1 ,array, index, SIZE - index);
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
        if (index < 0 || index > SIZE)
            throw new IndexOutOfBoundsException("Выход за пределы массива!");
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
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
        Arrays.fill(array, null);
    }

    @Override
    public String[] toArray() {
        return array;
    }

    private Object[] grow() {
        return array = Arrays.copyOf(array, (array.length * 2));
    }

    @Override
    public String toString() {
        return "MyArrayList{" + Arrays.toString(array) +
                '}';
    }

}
