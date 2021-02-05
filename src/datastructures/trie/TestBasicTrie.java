package datastructures.trie;

public class TestBasicTrie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicTrie trie = new BasicTrie();
		trie.insert("cats");
		trie.insert("cape");
		trie.insert("capture");
		
		System.out.println(trie.search("cape"));
		System.out.println(trie.search("cote"));
		System.out.println(trie.startsWith("cap"));
		System.out.println(trie.startsWith("call"));
	}

}
