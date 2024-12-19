package collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 * <p>
 * CopyOnWriteArrayList 类的最大优点在于读取时无需加锁，非常适合读多写少的并发场景，
 * 由于其写操作通过复制底层数据来实现，从而保证了读取数据的一致性和高效性，
 * 此外，它简单易用，是快速实现线程安全列表的不错选择，
 * CopyOnWriteArrayList在读操作占主导的场景下，能够提供出色的性能和稳定性。
 *
 * 线程安全：在多线程环境下，普通的 ArrayList 不是线程安全的，
 * 如果有多个线程同时修改 ArrayList，可能会导致数据不一致的问题，
 * CopyOnWriteArrayList 通过内部的复制机制保证了线程安全，
 * 即当有线程对列表进行修改时（如添加、删除元素），它会先复制一份当前列表的副本，
 * 然后在副本上进行修改，修改完成后再将内部引用指向新的副本，
 * 这样读取操作就可以继续在原列表上进行，而不会被修改操作所阻塞。
 *
 * 读写分离：由于 CopyOnWriteArrayList 的写操作（修改操作）是在新的数组上进行的，
 * 而读操作则是在未修改的原始数组上进行，因此读写操作之间不会相互干扰，
 * 这种读写分离的设计使得 CopyOnWriteArrayList 在高并发读取的场景下表现良好。
 *
 * 数据一致性：通过复制整个底层数组来确保修改操作的原子性，
 * CopyOnWriteArrayList 提供了强一致性保证，
 * 因此，读取操作要么看到的是修改之前的列表状态，要么看到的是修改之后的列表状态，
 * 而不会是中间状态。
 * </p>
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Item 10");
        list.add("Item 11");
        list.add("Item 12");

        Thread adder = new Thread(new AddRunnable(list));
        adder.start();

        Thread moder1 = new Thread(new ReadRunnable(list));
        moder1.setName("ModifierThread1");
        moder1.start();
        Thread moder2 = new Thread(new ReadRunnable(list));
        moder2.setName("ModifierThread2");
        moder2.start();
        Thread moder3 = new Thread(new ReadRunnable(list));
        moder3.setName("ModifierThread3");
        moder3.start();

        try {
            adder.join();
            moder1.join();
            moder2.join();
            moder3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     *
     * CopyOnWriteArrayList 的 iterator() 方法返回一个基于快照的迭代器，迭代期间的修改操作不会影响正在进行的迭代过程
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String cur = itr.next();
            System.out.println(cur);
        }
    }

    public class AddRunnable implements Runnable {
        List<String> list;

        public AddRunnable(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                int idx = (int) (Math.random() * 10);
                list.add("Item " + idx);
                try {
                    // 模拟耗时操作，让其他线程有机会读取数据
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class ReadRunnable implements Runnable {
        List<String> list;

        public ReadRunnable(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; i < list.size(); i++) {
                System.out.println("Reader Thread: " + Thread.currentThread().getName() + " is reading: " + list.toString());
                try {
                    // 模拟耗时操作，让其他线程有机会读取数据
                    Thread.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
