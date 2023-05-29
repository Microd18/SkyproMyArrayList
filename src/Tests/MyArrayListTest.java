package Tests;

import Exceptions.InvalidIndexException;
import Exceptions.NullItemException;
import Module.MyArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


class MyArrayListTest {

    ArrayList<String> test = new ArrayList<>();
    MyArrayList list = new MyArrayList();
    MyArrayList list2 = new MyArrayList();
    String one = "one";
    String two = "two";
    String three = "three";
    String four = "four";

    @Test
    public void addTest() {
        String expected = one;
        String actual = list.add(one);

        Assertions.assertEquals(expected, actual);

        expected = two;
        actual = list.add(two);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addWithIndexTest() {
        list.add(one);
        list.add(two);
        list.add(three);

        String expected = four;
        String actual = list.add(1, four);

        ArrayList<String> test = new ArrayList<>();

        test.add(one);
        test.add(four);
        test.add(two);
        test.add(three);

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(Arrays.toString(test.toArray()), Arrays.toString(list.toArray()));

    }

    @Test
    public void removeTest() {
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);

        String expected = four;
        String actual = list.remove(four);

        test.add(one);
        test.add(two);
        test.add(three);

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(Arrays.toString(test.toArray()), Arrays.toString(list.toArray()));
    }

    @Test
    public void removeWithIndexTest() {
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);

        String expected = four;
        String actual = list.remove(3);

        test.add(one);
        test.add(two);
        test.add(three);

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(Arrays.toString(test.toArray()), Arrays.toString(list.toArray()));
    }

    @Test
    public void containsTest() {
        list.add(one);
        list.add(two);

        boolean expected = true;
        boolean actual = list.contains(one);

        Assertions.assertEquals(expected, actual);

        expected = false;
        actual = list.contains(four);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void indexOfTest() {
        list.add(one);
        list.add(two);

        int expected = 0;
        int actual = list.indexOf(one);

        Assertions.assertEquals(expected, actual);

        expected = -1;
        actual = list.indexOf(four);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void lastIndexOfTest() {
        list.add(one);
        list.add(two);
        list.add(one);

        int expected = 2;
        int actual = list.lastIndexOf(one);

        Assertions.assertEquals(expected, actual);

        expected = -1;
        actual = list.indexOf(four);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getTest() {
        list.add(one);
        list.add(two);

        String expected = one;
        String actual = list.get(0);

        Assertions.assertEquals(expected, actual);

        expected = two;
        actual = list.get(1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equalsTest() {
        list.add(one);
        list.add(two);
        list.add(three);

        list2.add(one);
        list2.add(two);
        list2.add(three);

        boolean expected = true;
        boolean actual = list.equals(list2);

        Assertions.assertEquals(expected, actual);

        list2.add(four);

        expected = false;
        actual = list.equals(list2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sizeTest() {
        int expected = 0;
        int actual = list.size();

        Assertions.assertEquals(expected, actual);

        list.add(one);
        list.add(two);
        list.add(three);


        expected = 3;
        actual = list.size();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isEmptyTest() {
        boolean expected = true;
        boolean actual = list.isEmpty();

        Assertions.assertEquals(expected, actual);

        list.add(one);
        list.add(two);
        list.add(three);


        expected = false;
        actual = list.isEmpty();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void clearTest() {
        list.add(one);
        list.add(two);
        list.add(three);

        list.clear();

        int expected = 0;
        int actual = list.size();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void toArrayTest() {
        String[] expected = {"one", "two", "three"};

        list.add(one);
        list.add(two);
        list.add(three);

        String[] actual = list.toArray();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void growTest() {

        list.add(one);
        list.add(two);
        list.add(three);

        int expected = 3;
        int actual = list.size();

        Assertions.assertEquals(expected, actual);

        list.add(one);
        list.add(two);
        list.add(three);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(one);
        list.add(two);
        list.add(three);

        expected = 12;
        actual = list.size();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {

        list.add(one);
        list.add(two);
        list.add(three);

        String expected = "MyArrayList{[one, two, three, null, null, null, null, null, null, null]}";
        String actual = list.toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void validateIndexTest() {

        list.add(one);
        list.add(two);
        list.add(three);

        Assertions.assertThrows(InvalidIndexException.class,() -> list.validateIndex(5));

    }

    @Test
    public void validateItemTest() {

        list.add(one);
        list.add(two);
        list.add(three);

        Assertions.assertThrows(NullItemException.class,() -> list.validateItem(null));

    }


}