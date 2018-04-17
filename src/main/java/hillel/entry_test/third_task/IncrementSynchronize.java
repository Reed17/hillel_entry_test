package hillel.entry_test.third_task;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;


public class IncrementSynchronize {

    /*
    * @param value to increment.
    * */
    private int value = 0;

    /*
    * @param atomicInteger.
    * */
    private AtomicInteger atomicInteger = new AtomicInteger(value);

    /*
    * @param lock. Object lock for synchronization.
    * */
    private final Object lock = new Object();

    /*
    * @param reentrantLock. Reentrant lock for synchronization.
    * */
    private final ReentrantLock reentrantLock = new ReentrantLock();

    /*
    *  Synchronized method.
    * */
    public synchronized void getNextValueSynchronizedMethod() {
        value++;
    }

    /*
    * Synchronized statement.
    * */
    public void getNextValueSynchronizedStatement() {
        synchronized (lock) {
            value++;
        }
    }

    /*
    *  Reentrant lock.
    * */
    public void getNextValueReentrantLock() {
        reentrantLock.lock();
        try {
            value++;
        } finally {
            reentrantLock.unlock();
        }
    }

    /*
    * Atomic access.
    * */
    public int getNextValueAtomicAccess() {
        return atomicInteger.incrementAndGet();
    }

    /*
     * @return atomicInteger value.
     * */
    public int getAtomicInteger() {
        return atomicInteger.get();
    }

    /*
    * @return value.
    * */
    public int getValue() {
        return value;
    }
}
