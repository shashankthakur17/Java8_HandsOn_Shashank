package collection.map;

public class HashMapCustomImpl<K, V> {

	private int capacity = 16;
	private Entry[] bucket;

	public HashMapCustomImpl() {
		this.bucket = new Entry[capacity];
	}

	public HashMapCustomImpl(int initCapacity) {
		this.capacity = initCapacity;
		this.bucket = new Entry[capacity];
	}
	
	// Methods of Custom HashMap
	// put(K key, V value)
	// get(K key)
	// remove(K key)
	// Calculate Hash
	
	// put(K key, V value)
	public void put(K key, V value) {
		// if key == null than it will be stored in bucketIndex 0 always, hence only one null key is allowed
		// And if key != null and if(bucket[bucketIndex] == null), that means no Entry is present there. Insert a new entry rightAway 
		int bucketIndex = calculateHash(key);
		if(bucket[bucketIndex] == null) {
			bucket[bucketIndex] = new Entry<>(key, value, null);
		}else {
			// Now, This scope means that we have a collision 
			// A Entry should be added at the end or existing Entry should be override
			
			Entry<K, V> newEntry = new Entry<>(key, value, null);
			Entry<K, V> currentNode = bucket[bucketIndex];		// get Hold of currentNode
			Entry<K, V> previousNode = currentNode;
			
			while(currentNode != null) {
				// if there exist a collision
				if(currentNode.getKey().equals(key)) {
					// if the key value is already present in the bucket, we override its Value
					currentNode.value = value;	// New value Overridden, also true for Null Key and Value
					return; // Value updated, break and don't proceed with addition of K and V
				}
				previousNode = currentNode;
				currentNode = currentNode.next;
			}
			
			// When while loop breaks we would be at
			// currentNode = null and previousNode = last node of bucket
			// Add new Entry/Node at the last
			previousNode.next = newEntry;
		}
	}
	
	// get(K key)
	public V get(K key) {
		
		int bucketIndex = calculateHash(key);
		Entry<K, V> currentNode = bucket[bucketIndex];		// get Hold of currentNode
		
		// if key is null, its value will be null. Hence return null
		if(currentNode == null) {
			return null;
		}
		//	else get the bucket Entry, traverse to the matching key and return it
		while(currentNode != null) {
			// if there exist a matching key in the bucket, we return its value
			if(currentNode.getKey().equals(key)) {
				return currentNode.value; // Value returned, break and don't proceed with loop
			}
			currentNode = currentNode.next;
		}
		
		return null; //	we couldn't find any matching key in the HashMap
	}
	
	// remove(K key)
	public boolean remove(K key){
		
		boolean flag = false;
		int bucketIndex = calculateHash(key);
		Entry<K, V> currentNode = bucket[bucketIndex];		// get Hold of currentNode
		
		// if key is null, its value will be null. Hence return null
		if(currentNode == null) {
			return false;
		}
		
		Entry<K, V> previousNode = currentNode;
		while(currentNode != null) {
			// if there exist a collision
			if(currentNode.getKey().equals(key)) {
				// 1. if previous is null, it means we have got a match at first Entry and need
				// to remove first entry itself
				if (previousNode == null) { 	// remove first entry
					bucket[bucketIndex] = currentNode.next;
					flag = true;
				}else {
					// 2. else set previous.nextNode to current.nextNode, this will unlink the
					// currentNode
					previousNode.next = currentNode.next;
					flag = true;
				}
					
			}
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		return flag;
	}
	
	public boolean contains(K key) {

		
		int bucketIndex = calculateHash(key);
		Entry<K, V> currentNode = bucket[bucketIndex];		// get Hold of currentNode
		
		// if key is null, its value will be null. Hence return null
		if(currentNode == null) {
			return false;
		}
		//	else get the bucket Entry, traverse to the matching key and return it
		while(currentNode != null) {
			// if there exist a matching key in the bucket, we return its value
			if(currentNode.getKey().equals(key)) {
				return true; // Value returned, break and don't proceed with loop
			}
			currentNode = currentNode.next;
		}
		
		return false; //	we couldn't find any matching key in the HashMap
	
	}
	
	public void display() {

		for (int i = 0; i < capacity; i++) {
			if (bucket[i] != null) {
				Entry<K, V> entry = bucket[i];
				while (entry != null) {
					System.out.print("{" + entry.key + "=" + entry.value + "}" + " ");
					entry = entry.next;
				}
			}
		}
	}
	
	public void displaySet(){
		for (int i = 0; i < capacity; i++) {
			if (bucket[i] != null) {
				Entry<K, V> entry = bucket[i];
				while (entry != null) {
					System.out.println(entry.key);
					entry = entry.next;
				}
			}
		}
	}
	
	private int calculateHash(K key) {
		
		if(key == null) {
			return 0;
		}
		return Math.abs(key.hashCode()) % capacity;
	}

	private class Entry<K, V>{
		private K key;
		private V value;
		private Entry<K, V> next;
		
		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		public K getKey() {
			return key;
		}
		public V getValue() {
			return value;
		}
		public Entry<K, V> getNext() {
			return next;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Entry other = (Entry) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			return true;
		}

		private HashMapCustomImpl getEnclosingInstance() {
			return HashMapCustomImpl.this;
		}
		
	}
}
