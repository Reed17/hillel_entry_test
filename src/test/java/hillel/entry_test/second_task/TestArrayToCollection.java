package hillel.entry_test.second_task;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestArrayToCollection {

    private ArrayToCollection collectionService;
    private List<String> stringList;
    private Set<Object> objectSet;

    @Before
    public void setUp() {
        collectionService = new ArrayToCollection();
        stringList = new LinkedList<>();
        objectSet = new HashSet<>();
    }

    @After
    public void tearDown() {
        collectionService = null;
        stringList = null;
        objectSet = null;
    }

    @Test
    public void fillCollectionWithStrings() {
        stringList.add("first test");
        stringList.add("second test");
        stringList.add("third test");
        assertEquals(stringList,
                collectionService.fillCollectionWithArrayData(
                        new String[]{"first test", "second test", "third test"},
                        new LinkedList<>()));
    }

    @Test
    public void fillCollectionWithObjects() {
        objectSet.add("test");
        objectSet.add('c');
        assertEquals(objectSet,
                collectionService.fillCollectionWithArrayData(
                        new Object[]{"test", 'c'},
                        new HashSet<>()));
    }

    @Test(expected = NullPointerException.class)
    public void sendNullCollectionArgument() {
        stringList.add("test");
        assertNotEquals(stringList, collectionService.fillCollectionWithArrayData(new String[]{"test"}, null));
    }

    @Test(expected = NullPointerException.class)
    public void sendNullArrayArgument() {
        stringList.add("test");
        assertNotEquals(stringList, collectionService.fillCollectionWithArrayData(null, new LinkedList<>()));
    }

    @Test(expected = AssertionError.class)
    public void sendNullArrayValue() {
        objectSet.add(123);
        assertEquals(objectSet, collectionService.fillCollectionWithArrayData(new Object[]{null}, new HashSet<>()));
    }
}
