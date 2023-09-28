package collection.set;


import collection.set.SetCustomImpl;

public class TestSetCustomImpl {

	public static void main(String[] args) {

		SetCustomImpl<String> custSet = new SetCustomImpl<>();
		
		custSet.add("Sachin");
		custSet.add("Dravid");
		custSet.add("Ganguli");
		custSet.add("Yuvraj");
		custSet.add("Sehvag");
		
		custSet.display();
	}

}
