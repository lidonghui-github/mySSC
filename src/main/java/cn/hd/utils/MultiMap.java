package cn.hd.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ${李仕超} on 2016/8/19.
 */
public class MultiMap<K, V> extends HashMap<K, V> {
    public MultiMap() {

    }

    @Override
    public V put(K key, V value) {
        Object o = this.get(key);
        if (o == null) {
            return super.put(key, value);
        } else {
            if (o instanceof MyList) {
                MyList vs = (MyList) o;
                vs.add(value);
                return value;
            } else {
                List<V> vs = new MyList<V>();
                vs.add((V) o);
                super.put(key, (V) vs);
                vs.add(value);
                return value;
            }

        }
    }
}

class MyList<T> extends ArrayList<T> {

}