package hillel.entry_test.third_task;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestIncrementSynchronize {

    private IncrementSynchronize incrementSynchronize;
    private ExecutorService executorService;
    private static final int THREADS_NUMBER = 1000;

    @Before
    public void setUp() {
        incrementSynchronize = new IncrementSynchronize();
        executorService = Executors.newFixedThreadPool(THREADS_NUMBER);
    }

    @After
    public void tearDown() {
        incrementSynchronize = null;
        executorService = null;
    }

    @Test
    public void synchronizedMethod() throws InterruptedException {
        for (int j = 0; j < 1000; j++) {
            executorService.execute(() -> incrementSynchronize.getNextValueSynchronizedMethod());
        }
        executorService.shutdown();
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        assertEquals(1000, incrementSynchronize.getValue());
    }

    @Test
    public void synchronizedStatement() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> incrementSynchronize.getNextValueSynchronizedStatement());
        }
        executorService.shutdown();
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        assertEquals(1000, incrementSynchronize.getValue());
    }

    @Test
    public void reentrantLock() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> incrementSynchronize.getNextValueReentrantLock());
        }
        executorService.shutdown();
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        assertEquals(1000, incrementSynchronize.getValue());
    }

    @Test
    public void atomicAccess() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> incrementSynchronize.getNextValueAtomicAccess());
        }
        executorService.shutdown();
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        assertEquals(1000, incrementSynchronize.getAtomicInteger());
    }


}
