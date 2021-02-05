package datastructures.basics;

public class BasicHashTable<K, V> {

	private HashEntry[] data;
	private int capacity;
	private int size;

	// initialize HashTable backed by an array of type HashEntry
	public BasicHashTable(int tableSize) {
		this.capacity = tableSize;
		this.data = new HashEntry[capacity];
		size = 0;
	}

	public int size() {
		return this.size;
	}

	public V get(K key) {
		int hash = calculateHash(key);

		if (data[hash] == null) {
			return null;
		} else {
			return (V) data[hash].getValue();
		}
	}

	public void put(K key, V value) {
		int hash = calculateHash(key);

		data[hash] = new HashEntry<K, V>(key, value);
		size++;
	}

	public V delete(K key) {
		int hash = calculateHash(key);

		if (data[hash] == null) {
			return null;
		}

		V deletedValue = (V) data[hash].getValue();
		data[hash] = null; 	// to reduce collision, when a new entry with same hash is inseted 
		return deletedValue;
	}

	public boolean hasKey(K key) {

		int hash = calculateHash(key);
		if (data[hash] == null) {
			return false;
		} else if (data[hash].getKey().equals(key)) {
			return true;
		}
		return false;
	}

	public boolean hasValue(V value) {

		for (int i = 0; i < this.capacity; i++) {
			if (data[i] != null && data[i].getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}

	private int calculateHash(K key) {
		int hash = (key.hashCode() % this.capacity);
		// this is necessary to deal with collisions
		while (data[hash] != null && !data[hash].getKey().equals(key)) {
			hash = (hash + 1) % this.capacity;
		}
		return hash;
	}
	
	private class HashEntry<K, V> {

		private K key;
		private V value;

		public HashEntry(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}
		public V getValue() {
			return value;
		}
	}
}
