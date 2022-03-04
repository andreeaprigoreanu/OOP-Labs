package lab11.task1;

import java.util.*;

public class MultiMapValue<K, V> {
    private final HashMap<K, ArrayList<V>> map = new HashMap<>();

    public HashMap<K, ArrayList<V>> getMap() {
        return map;
    }

    public void add(K key, V value) {
        // TODO
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            map.put(key, new ArrayList<>());
            map.get(key).add(value);
        }
    }

    public void addAll(K key, List<V> values) {
        // TODO
        for (V value : values) {
            this.add(key, value);
        }
    }

    public void addAll(MultiMapValue<K, V> map) {
        // TODO
        for (Map.Entry<K, ArrayList<V>> entry : map.getMap().entrySet()) {
            this.addAll(entry.getKey(), entry.getValue());
        }
    }

    public V getFirst(K key) {
        // TODO
        if (map.containsKey(key)) {
            return map.get(key).get(0);
        }
        return null;
    }

    public List<V> getValues(K key) {
        // TODO
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return null;
    }

    public boolean containsKey(K key) {
        // TODO
        return map.containsKey(key);
    }

    public boolean isEmpty() {
        // TODO
        return map.isEmpty();
    }

    public List<V> remove(K key) {
        // TODO
        return map.remove(key);
    }

    public int size() {
        // TODO
        return map.size();
    }
}
