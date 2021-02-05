package datastructures.trie;

public class BasicTrie {
	
	private TrieNode root;
	public BasicTrie() {
		root = new TrieNode('\0');	// create a root with empty character
	}
	
	public void insert(String word) {
		TrieNode current = root;
		for(int i=0; i< word.length(); i++) {	// loop over every char in word
			char c = word.charAt(i);
			if (current.children[c - 'a'] == null) { // that small Alphabet(char) - 'a' will give us the index of that
														// char in the TrieNode char array
				current.children[c - 'a'] = new TrieNode(c); // if no Node is present at that Node's Children arrays'
																// index, thn put the node
			}
			// else, jump to nextNode
			current = current.children[c - 'a'];
		}
		current.isWord = true;	// Always put the end of last Node for that word to isword = true
	}
	
	/*	Returns if the given is in the trie */
	public boolean search(String word) {
		TrieNode node = getNode(word);
		return node != null && node.isWord;
	}
	
	/*	Returns if there is any word in the trie that starts with the given prefix */
	public boolean startsWith(String prefix) {
		return getNode(prefix) != null;
	}
	
	private TrieNode getNode(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) { // loop over every char in word
			char c = word.charAt(i);
			if (current.children[c - 'a'] == null) {
				return null; // There is no Node created with this char c, hence no point of searching
								// further
			}
			// else, jump to nextNode
			current = current.children[c - 'a'];
		}
		// At the end of this loop(if not returned by null) we will be at a node
		// which will be at the prefix of the word or the last node of the word itself
		return current;
	}
	
	
	private class TrieNode{
		public char c ;
		public boolean isWord;
		public TrieNode[] children;
		public TrieNode(char c) {
			super();
			this.c = c;
			this.isWord = false;
			this.children = new TrieNode[26];
		}
		public char getC() {
			return c;
		}
		public void setC(char c) {
			this.c = c;
		}
		public boolean isWord() {
			return isWord;
		}
		public void setWord(boolean isWord) {
			this.isWord = isWord;
		}
		public TrieNode[] getChildren() {
			return children;
		}
		public void setChildren(TrieNode[] children) {
			this.children = children;
		}
	}
}
