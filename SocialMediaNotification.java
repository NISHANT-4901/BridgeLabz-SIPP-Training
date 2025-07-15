import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.50f, true);
        this.capacity = capacity;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public void putEntry(K key, V value) {
        put(key, value);
    }

    public V getEntry(K key) {
        return getOrDefault(key, null);
    }
}

public class SocialMediaNotification {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.putEntry(1, "A");
        cache.putEntry(2, "B");
        cache.putEntry(3, "C");
        cache.getEntry(1);
        cache.putEntry(4, "D");

        for (Map.Entry<Integer, String> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

}
