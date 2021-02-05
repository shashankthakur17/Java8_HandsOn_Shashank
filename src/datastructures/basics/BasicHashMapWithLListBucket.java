package datastructures.basics;

public class BasicHashMapWithLListBucket<K, V> {

	private int capacity;
	private HashEntry<K, V>[] hashMap;

	// Constructor
	@SuppressWarnings("unchecked")
	public BasicHashMapWithLListBucket(int capacity) {
		super();
		this.capacity = capacity;
		this.hashMap = new HashEntry[capacity];
	}

	// get
	public V get(K key) {

		// index/bucket
		int bucket = this.calculateHash(key);
		HashEntry<K, V> currentNode = hashMap[bucket]; // get hold of the current Node
		HashEntry<K, V> previousNode = currentNode;

		if (currentNode == null) {
			return null; // if key is provided which was never inserted or it is not currently present in
							// the bucket, return null
		} else {
			do {
				currentNode = currentNode.nextNode; // current node is now the next Node
				if (previousNode.getKey().equals(key)) { // we will check key equality for previous node
					return previousNode.getValue();
				}
				previousNode = currentNode; // move pointer for previous node to current when key mismatch
			} while (currentNode != null);
		}

		return null; // we coundn't find the key-value at all
	}

	// put
	public void put(K key, V value) {
		// index/bucket
		int bucket = this.calculateHash(key);
		HashEntry<K, V> currentNode = hashMap[bucket]; // We get hold of the first Entry Obj of the bucket and traverse
		HashEntry<K, V> newEntry = new HashEntry<K, V>(key, value, null); // create a new Entry object to insert

		if (currentNode == null) { // this means the index contains no HashEntry right now, so no collision, we can add
			hashMap[bucket] = newEntry;
		} else { 			// this means COLLISION, the index value isn't null, i.e it contains a Entry Object of Key, Value already
			HashEntry<K, V> previousNode = currentNode;
			while (currentNode != null) { // This loop will help us reach to the end of the L List where nextNode is null
				if (currentNode.getKey().equals(key)) { // if the key value is already present in the bucket, we override its Value
					currentNode.setValue(value);
					return;
				}
				previousNode = currentNode;
				currentNode = currentNode.nextNode; // else jump to the next node by setting current to nextNode
			}

			previousNode.nextNode = newEntry; // When the loop ends we will be at the last Entry Obj of the List, hence
												// add this
												// new Entry object at the last of the Linked List
		}
	}

	// Remove
	public boolean remove(K key) {
		// index/bucket
		int bucket = this.calculateHash(key);
		HashEntry<K, V> currentNode = hashMap[bucket]; // get hold of the current Node
		HashEntry<K, V> previousNode = null;

		if (currentNode == null) {
			return false; /*
							 * if key is provided which was never inserted or it is not currently present in
							 * the bucket, return false
							 */
		} else {
			while (currentNode != null) { // This loop will help us reach to the end of the L List where nextNode is
											// null
				if (currentNode.getKey().equals(key)) { // if the key value is already present in the bucket, we
														// override its Value
					// 1. if previous is null, it means we have got a match at first Entry and need
					// to remove first entry itself
					if (previousNode == null) { // remove first entry
						hashMap[bucket] = currentNode.nextNode;
						return true;
					} else {
						// 2. else set previous.nextNode to current.nextNode, this will unlink the
						// currentNode
						previousNode.nextNode = currentNode.nextNode;
						return true;
					}
				}
				previousNode = currentNode;
				currentNode = currentNode.nextNode; // else jump to the next node by setting current to nextNode
			}
		}

		return false; // we coundn't find the key-value at all

	}

	public void display() {

		for (int i = 0; i < capacity; i++) {
			if (hashMap[i] != null) {
				HashEntry<K, V> entry = hashMap[i];
				while (entry != null) {
					System.out.print("{" + entry.key + "=" + entry.value + "}" + " ");
					entry = entry.nextNode;
				}
			}
		}
	}

	private int calculateHash(K key) {
		if (key == null) {
			return 0;
		}
		return Math.abs(key.hashCode()) % this.capacity;
	}

	private class HashEntry<K, V> {
		private K key;
		private V value;
		private HashEntry<K, V> nextNode;

		public HashEntry(K key, V value, HashEntry<K, V> nextNode) {
			super();
			this.key = key;
			this.value = value;
			this.nextNode = nextNode;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public HashEntry<K, V> getNextNode() {
			return nextNode;
		}

		public void setNextNode(HashEntry<K, V> nextNode) {
			this.nextNode = nextNode;
		}
	}
}
