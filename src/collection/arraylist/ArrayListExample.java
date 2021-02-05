package collection.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import collection.arraylist.testclasses.CinemaActors;

public class ArrayListExample {

	public static void main(String[] args) {

		CinemaActors rajkumarRao = new CinemaActors(30, "Rajkumar Rao", "Stree and Omerta");
		CinemaActors ayyushman = new CinemaActors(36, "Ayyushman Khurrana", "Andhadhundh and Article 15");
		CinemaActors vicky = new CinemaActors(32, "Vicky Kaushal", "Uri and Raazi");
		CinemaActors kartik = new CinemaActors(29, "Kartik Aaryan", "Love Aaj Kal");

		List<CinemaActors> actorsList = new ArrayList<>(); // intoduced in java 7 called Diamond representation

		// traditional way of adding
		actorsList.add(rajkumarRao);
		actorsList.add(ayyushman);
		actorsList.add(vicky);
		actorsList.add(kartik);

		// New way of adding, after java 9. Arguments (arrayList, T type of Objects)
		Collections.addAll(actorsList, rajkumarRao, ayyushman, vicky, kartik);

		for (CinemaActors actors : actorsList) {
			System.out.println(actors);
		}

		// get
		System.out.println("At 2nd index: " + actorsList.get(2));

		System.out.println();

		Collections.sort(actorsList, new Comparator<CinemaActors>() { // Comparator with its only method compare written
																		// as an anonymous class
			@Override
			public int compare(CinemaActors actor1, CinemaActors actor2) {
				// TODO Auto-generated method stub
				return Integer.compare(actor1.getAge(), actor2.getAge());
			}
		});

		// We can use iterator to traverse an arrayList
		System.out.println("Iterator loop");
		Iterator<CinemaActors> iterator = actorsList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		// Or a for each loop to traverse arrayList
		System.out.println("\n foreach loop");
		for (CinemaActors actors : actorsList) {
			System.out.println(actors);
		}

		// Or stream.forEach loop can also be called to traverse arrayList
		System.out.println("\n Stream foreach loop");
		actorsList.stream().forEach(act -> System.out.println(act));

	}

	/*
	 * 1.	ArrayList  is Resizable-array implementation of the java.util.List interface in java
	 * 2.	Index based structure - ArrayList is an Index based structure in java. 
	 * 3.	Duplicate elements - ArrayList allows to store duplicate elements in java.
	 * 4.	Null elements -Null elements can be added in ArrayList in java.
	 * 5.	Insertion order - ArrayList maintains insertion order in java.
	 * */
}
