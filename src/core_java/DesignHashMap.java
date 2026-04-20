package core_java;

class MyHashMap<K, V> {
    
	private static final int INITIAL_CAPACITY = 1 << 4;
	private static final int MAX_CAPACITY = 1 << 30;
	HashNode<K, V>[] hashTable;
	
	public MyHashMap() {
		hashTable = new HashNode[INITIAL_CAPACITY];
	}
	
	public MyHashMap(int capacity) {
		int tableSize = tableSizeFor(capacity);
		hashTable = new HashNode[tableSize];
	}
	
	public int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
	    n |= n >>> 2;
	    n |= n >>> 4;
	    n |= n >>> 8;
	    n |= n >>> 16;
	    
	    return (n < 0) ? 1 : ((n >= MAX_CAPACITY) ? MAX_CAPACITY : n + 1);
	    
	}
	
	static class HashNode<K, V> {
		K key;
		V value;
		HashNode<K, V> next;
		
		public HashNode(K key, V value) {
			this.key = key;
			this.value = value;
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
		
		
	}
	
	public void put(K key, V value) {
		int hashCode = key.hashCode() % (hashTable.length);
		HashNode entryNode = hashTable[hashCode];
		if(entryNode == null) {
			entryNode = new HashNode(key, value);
			hashTable[hashCode] = entryNode;
		}
		else {
			HashNode prevHashNode = entryNode;
			while(entryNode != null) {
				if(entryNode.getKey().equals(key)) {
					entryNode.setValue(value);
					return;
				}
				prevHashNode = entryNode;
				entryNode = entryNode.next;
			}
			
			entryNode = new HashNode(key, value);
			prevHashNode.next = entryNode;
		}
	}
		
	
	public V get(K key) {
		int hashCode = key.hashCode() % (hashTable.length);
		HashNode entryNode = hashTable[hashCode];
		while(entryNode != null) {
			if(entryNode.getKey().equals(key)) {
				return (V) entryNode.getValue();
			}
			entryNode = entryNode.next;
		}
		return null;
	}
	
}
public class DesignHashMap {
	public static void main(String[] args) {
		
		MyHashMap<Integer, String> mp = new MyHashMap();
	     mp.put(1, "fhgh");
	     mp.put(2, "sfgsf");
	     mp.put(3, "dgd");
	     mp.put(4, "ghddf");
	     mp.put(5, "gasfg");
	     mp.put(6, "safgsafg");
	     mp.put(7, "sfg");
	     mp.put(8, "fgh");
	     mp.put(9, "olkl");
	     mp.put(10, "dafA");
	     
	     String value = mp.get(8);
	     System.out.println(value);

	}
     
}
