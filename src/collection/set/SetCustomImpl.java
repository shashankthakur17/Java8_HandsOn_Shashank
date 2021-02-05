package collection.set;

import collection.map.HashMapCustomImpl;

public class SetCustomImpl<K> {

	private int capacity = 12;
	HashMapCustomImpl<K, Object> hashMapCustom;

	public SetCustomImpl() {
		hashMapCustom = new HashMapCustomImpl<>(12);
	}

	// Add
	public void add(K valueAsKey) {
		hashMapCustom.put(valueAsKey, null);
	}

	// Remove
	public boolean remove(K valueAsKey) {
		return hashMapCustom.remove(valueAsKey);
	}

	// contains
	public boolean contains(K valueAsKey) {
		return hashMapCustom.contains(valueAsKey);
	}

	// Display
	public void display() {
		hashMapCustom.displaySet();
	}
}
