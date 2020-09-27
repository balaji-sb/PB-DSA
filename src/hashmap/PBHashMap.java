package hashmap;

public class PBHashMap<K, V> {

    private PBHashItem<K, V>[] data;
    private int INITIAL_SIZE = 8;
    private int size = 0;

    /**
     * LinkedList node declaration
     *
     * @param <K> dynamic key
     * @param <V> dynamic value
     */
    private static class PBHashItem<K, V> {
        PBHashItem<K, V> next;
        K key;
        V value;

        public PBHashItem(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * default constructor with initial size of hashmap
     */
    public PBHashMap() {
        this.data = new PBHashItem[INITIAL_SIZE];
    }

    /**
     * put the key and value pair into the hashmap
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        int index = getIndex(key);
        PBHashItem<K, V> hashItem = new PBHashItem<>(key, value);
        if (data[index] == null) {
            data[index] = hashItem;
        } else {
            PBHashItem<K, V> item = data[index];
            while (item.next != null) {
                item = item.next;
            }
            item.next = hashItem;
        }
        size++;
    }

    /**
     * return the size of the hashmap
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * retrieve the value from hashmap based on key
     *
     * @param key
     */
    public V get(K key) {
        if (key == null)
            return null;
        int index = getIndex(key);
        System.out.println("Index " + index);
        PBHashItem<K, V> item = data[index];
        if (item != null) {
            System.out.println("hashItem " + item.value);
            while (item.next != null && !item.key.equals(key)) {
                item = item.next;
            }
            return item.value;
        }
        return null;
    }


    public void remove(K key) {
        int index = getIndex(key);
        PBHashItem<K, V> item = data[index];

        if (item != null) {
            if (item.next != null) {
                while (item.next != null) {
                    if (item.next.key == key) {
                        item.next = item.next.next;
                        System.out.println("Delete value -> done" + item.next.key);
                        break;
                    }
                    item = item.next;
                }
            } else {
                data[index] = null;

            }
            size--;
        }
    }


    /**
     * get the index of the key using hash function
     *
     * @param key
     * @return
     */
    public int getIndex(K key) {
        int hash = key.hashCode();
        System.out.println("Hash->" + hash);
        int index = Math.abs(hash) % INITIAL_SIZE;
        System.out.println("Index->" + index);
        return index;
    }


}
