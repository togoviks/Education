import java.util.LinkedList;

public class MyHashMap<K, V> {
    private LinkedList<Entry<K, V>>[] table = new LinkedList[16];
    private int size = 0;
    private final float loadFactor = 0.75f;

    public void put(K key, V value) {
        Entry<K, V> newEntry = new Entry<>(key, value);
        int index = (table.length - 1) & key.hashCode();
        if (table[index] != null) {
            table[index].add(newEntry);
        } else {
            LinkedList<Entry<K, V>> bucket = new LinkedList<>();
            bucket.add(newEntry);
            table[index] = bucket;
        }
        size++;
        if (size > table.length * loadFactor) {
            resize();
        }
    }

    public V get(K key) {
        int index = (table.length - 1) & key.hashCode();
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (key.hashCode() == entry.getHash() && entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int rehash(int oldHash, int capacity) {
        int prime1 = 13;
        return (oldHash + prime1) % capacity;
    }

    private void resize() {
        int newCapacity = table.length * 2;
        LinkedList<Entry<K, V>>[] newTable = new LinkedList[newCapacity];
        for (LinkedList<Entry<K, V>> entries : table) {
            if (entries != null) {
                for (Entry<K, V> entry : entries) {
                    int newIndex = rehash(entry.getKey().hashCode(), newCapacity);
                    if (newTable[newIndex] == null) {
                        newTable[newIndex] = new LinkedList<>();
                    }
                    newTable[newIndex].add(entry);
                }
            }
        }
        table = newTable;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (LinkedList<Entry<K, V>> entries : table) {
            if (entries != null) {
                for (Entry<K, V> entry : entries) {
                    StringBuilder entryData = new StringBuilder()
                            .append(entry)
                            .append(", ");
                    stringBuilder.append(entryData);
                }
            }
        }
        if (stringBuilder.length() > 1) {
            stringBuilder.setLength(stringBuilder.length() - 2);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}