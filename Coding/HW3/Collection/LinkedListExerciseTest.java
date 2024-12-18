package Collection;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExerciseTest {

    @Test
    public void learn_Inserting_And_Retrieving() {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.addLast(20);
        list.addFirst(5);
        list.add(1, 15);

        LinkedList<Integer> anotherList = new LinkedList<>();
        anotherList.add(25);
        anotherList.add(30);
        list.addAll(anotherList);

        list.addAll(2, anotherList);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(3));
        System.out.println(list);
    }

    @Test
    public void learn_Remove_Sort() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(30);

        list.removeFirst();
        list.removeLast();
        list.remove(1);
        list.remove((Integer) 30);
        list.removeLastOccurrence(30);

        Collections.sort(list);
        System.out.println(list);
    }
}

