package collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int idx = (int) (Math.random() * 10);
            list.add(new int[]{i, idx});
        }
        int min = Integer.MAX_VALUE, idx = -1;
        for (int i = 0; i < 4; i++) {
            if (list.get(i)[1] < min) {
                idx = i;
                min = list.get(i)[1];
            }
        }

        int[] mins = Collections.min(list, (a, b) -> {return a[1] - b[1];});
        Assert.assertArrayEquals(list.get(idx), mins);

        list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            idx = (int) (Math.random() * 10);
            list.add(new int[]{i, idx});
        }
        int max = Integer.MIN_VALUE;
        idx = -1;
        for (int i = 0; i < 4; i++) {
            if (list.get(i)[1] > max) {
                idx = i;
                max = list.get(i)[1];
            }
        }

        int[] maxs = Collections.max(list, (a, b) -> {return a[1] - b[1];});
        Assert.assertArrayEquals(list.get(idx), maxs);

        int freq = Collections.frequency(list, new int[]{0, 0});
        System.out.println(freq);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 10; i++) {
            syncList.add(i);
        }

        Thread t1 = new ListThreadAdd(syncList);
        t1.setName("t1");
        Thread t2 = new ListThreadMod(syncList);
        t2.setName("t2");
        t1.start();
        t2.start();

        List<Integer> list = new ArrayList<>();
        Thread t3 = new ListThreadAdd(list);
        Thread t4 = new ListThreadMod(list);
        t3.start();
        t4.start();

        try {
            t1.join(); // Wait for the thread to finish
            t2.join();
            if (!t1.isAlive() && !t2.isAlive()) System.out.println(syncList.toString());
            Assert.assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), syncList);
            System.out.println("Thread has completed");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        try {
            t3.join(); // Wait for the thread to finish
            t4.join();
            if (!t3.isAlive() && !t4.isAlive()) System.out.println(list.toString());
            Assert.assertNotEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), list);
            System.out.println("Thread has completed");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        synchronized (syncList) {
            Iterator<Integer> i = syncList.iterator(); // Must be in synchronized block
            while (i.hasNext()) {
                System.out.print(i.next() + ", ");
            }
        }
    }

    class ListThreadAdd extends Thread {
        private List<Integer> list;

        public ListThreadAdd(List<Integer> list) {
            this.list = list;
        }

        public void run() {
            for (int i = 10; i < 15; i++) {
                list.add(i);
            }
        }
    }

    static class ListThreadMod extends Thread {
        private List<Integer> list;

        public ListThreadMod(List<Integer> list) {
            this.list = list;
        }

        public void run() {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, i + 1);
            }
        }
    }
}
