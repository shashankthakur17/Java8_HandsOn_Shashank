package datastructures.basics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> myList = new ArrayList<>();
		myList.add("Shashank");
		myList.add("Singh");
		myList.add("Thakur");
		
		/*
		 * Iterator<String> iteratorRef = myList.iterator();
		 * while(iteratorRef.hasNext()) { //myList.remove(iteratorRef.next()); // this
		 * line raise java.util.ConcurrentModificationException
		 * 
		 * String tgempVAr = iteratorRef.next(); if(tgempVAr.equalsIgnoreCase("Singh"))
		 * { iteratorRef.remove(); } }
		 */
		System.out.println(myList);
		
		 ListIterator<String> iterator = myList.listIterator();
		 while(iterator.hasNext()) {
			 System.out.println(iterator.hasPrevious());
			 //System.out.println(iterator.previous());
			 System.out.println(iterator.nextIndex());
			 //System.out.println(iterator.next());
			 System.out.println(iterator.previousIndex());
			 if(iterator.next().equals("Singh")) {
				 iterator.add("sssssssiinnngggg");
			 }
		 }
		 System.out.println(myList);
		 
	}

}
