package hillel.entry_test.first_task;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestDistinctWordsService {

    private DistinctWordsService distinctWordsService;
    private String FILE_PATH;

    @Before
    public void setUp() {
        FILE_PATH = "E:\\IntelliJ IDEA 2016.3.5\\mini_projects\\src\\test\\java\\hillel\\entry_test\\first_task\\test.txt";
        distinctWordsService = new DistinctWordsService(FILE_PATH);
    }

    @After
    public void tearDown() {
        distinctWordsService = null;
    }

    @Test
    public void distinctWords() {
        assertEquals("test, point, word, final, java, distinct, tt, ttt, txt",
                distinctWordsService.collectDistinctWords());

    }

    @Test(expected = AssertionError.class)
    public void nullPathArgument() {
        assertEquals(null, distinctWordsService.collectDistinctWords());
    }

}
