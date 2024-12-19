package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 3, 1, 2, 1);
        int min = Collections.min(list);
        System.out.println(min);

        int max = Collections.max(list);
        System.out.println(max);

        int freqOf1 = Collections.frequency(list, 1);
        System.out.println(freqOf1);

        List<Integer> list1 = Arrays.asList(-100, 10, -3, 8);
        int minAbs = Collections.min(list1, Comparator.comparingInt(Math::abs)); // (a -> Math.abs(a))
        System.out.println(minAbs);

    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        List<Integer> synchronizedList = Collections.synchronizedList(list);

        synchronized (synchronizedList) {
            synchronizedList.add(4);
            System.out.println("Adding 4: " + synchronizedList);
        }

        Runnable task = () -> {
            synchronized (synchronizedList) {
                synchronizedList.add((int) (Math.random() * 100));
                System.out.println(Thread.currentThread().getName() + " updated list: " + synchronizedList);
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (synchronizedList) {
            System.out.println("Final Synchronized List: " + synchronizedList);
        }
    }

}
