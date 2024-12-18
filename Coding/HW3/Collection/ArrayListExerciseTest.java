package HW3.Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import static org.junit.Assert.assertTrue;

public class ArrayListExerciseTest {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        ArrayList<String> list = new ArrayList<>();

        list.add("chuwa1");
        list.add("chuwa2");
        list.add("chuwa3");
        System.out.println(list.size());
        System.out.println(list.get(0));

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("chuwa4");
        list2.add("chuwa5");
        list.addAll(list2);

        System.out.println(list.size());
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     *
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        ArrayList<String> list = new ArrayList<>();

        //list.add("chuwa1");
        list.add("chuwa2");
        list.add("chuwa3");
        list.add("chuwa4");
        //list.add("chuwa5");

        list.remove(2);
        System.out.println(list.size());

        list.remove("chuwa3");
        System.out.println(list.size());

        ArrayList<String> toRemove = new ArrayList<>();
        toRemove.add("chuwa2");
        list.removeAll(toRemove);
        System.out.println(list.isEmpty());

        list.add("chuwa1");
        list.clear();
        System.out.println(list.isEmpty());

        list.add("chuwa1");
        list.set(0, "chuwa2");
        System.out.println(list.get(0));

        list.replaceAll(e -> e + " chuwa3");
        System.out.println(list.get(0));

        System.out.println(list.contains("chuwa2"));

        list.add("chuwa2");
        System.out.println(list.indexOf("chuwa2"));
        System.out.println(list.lastIndexOf("chuwa2 chuwa3"));
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    @Test
    public void learn_Iterator() {
        ArrayList<String> list = new ArrayList<>();

        list.add("chuwa1");
        list.add("chuwa2");
        list.add("chuwa3");
        list.add("chuwa4");
        list.add("chuwa5");

        Iterator<String> iterator = list.iterator();
        System.out.println(iterator.hasNext());

        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(list.contains("chuwa1"));

        list.forEach(System.out::println);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<String> list = new ArrayList<>();

        list.add("chuwa1");
        list.add("chuwa3");
        list.add("chuwa2");
        list.add("chuwa5");
        list.add("chuwa4");

        Collections.sort(list);
        list.forEach(System.out::println);

        list.sort(Comparator.reverseOrder());
        list.forEach(System.out::println);


    }
}