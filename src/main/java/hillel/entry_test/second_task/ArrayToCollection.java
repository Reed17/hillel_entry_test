package hillel.entry_test.second_task;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class ArrayToCollection {

    /*
    * @param arrayData. Array with data to copy into collection.
    * @param collection. Container which will store array values.
    *
    * @return collection. Return collection filled with array values.
    * */
    public <T> Collection<T> fillCollectionWithArrayData(T[] arrayData, Collection<T> collection) {
        Objects.requireNonNull(arrayData);
        Objects.requireNonNull(collection);
        Collections.addAll(collection, arrayData);
        return collection;
    }

}
