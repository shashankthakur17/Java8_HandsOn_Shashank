package collection.factories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MoreFactoryMethodsInCollections {

	public static void main(String[] args) {

		/* 1. Empty Collections */
		List<String> emptyList = Collections.emptyList();
		Map<String, Integer> emptyMap = Collections.emptyMap();
		Set<Integer> emptySet = Collections.emptySet();

		/*
		 * These are immutable empty Collections List,Set,Map So you can't add any
		 * elements to them Usecase - When you want to return a collection or a method
		 * takes a parameter, you can pass them these Factory methods refers to static
		 * instances, to reduce memory consumptions
		 */

		/*
		 * $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		 */

		/* 2. Singleton Collections */
		List<String> singletonList = Collections.singletonList("SingleObj");
		Map<String, Integer> singletonMap = Collections.singletonMap("SingleObj", 11);
		Set<Integer> singletonSet = Collections.singleton(234);

		/*
		 * Immutable Single Value collections Usecase - Use when you want to pass a
		 * single value to the method that takes a collection
		 */

		/*
		 * $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		 */

		/* 3. Immutable Copy of Collections */

		List<String> listOfImmutable = List.of("India", "Nepal");
		// listOfImmutable.add("Tibet"); // throws -
		// java.lang.UnsupportedOperationException
		List<String> immutableList = List.copyOf(listOfImmutable); // way to create immutableList
		List<String> mutableList = new ArrayList<>(listOfImmutable); // way to create mutableList (Old is Gold)
		// immutableList.add("Tibet"); // throws -
		// java.lang.UnsupportedOperationException
		mutableList.add("Ladhak");

		System.out.println("listOfImmutable: " + listOfImmutable);
		System.out.println("immutableList: " + immutableList);
		System.out.println("mutableList: " + mutableList);

		/*
		 * $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		 */

		/* 4 Concept of unmodifiable VIEWS */

		// Modify countries is the only way to modify countriesView
		List<String> countries = new ArrayList<>();
		countries.add("India");
		countries.add("Nepal");
		countries.add("Bhutan");

		List<String> countriesView = Collections.unmodifiableList(countries);

		System.out.println("\n\n countriesView" + countriesView);
		System.out.println("countries" + countries);

		/*
		 * This Gives the main Concept of unmodifiable VIEWS VIEWS = unModifiableMap
		 * cannot be modified WhereAs If View needs modification, then modify the
		 * originalMap instead, it will get reflected
		 */

		System.out.println("\n\n After Modification to Original List, View also changes");
		countries.add("Sri Lanka");
		System.out.println("countries" + countries);
		System.out.println("countriesView" + countriesView);

		/*
		 * $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		 */

		/* 5 Collection.addAll() will create a mutable List, adding all the elements in one line */
		var addAlllist = new ArrayList<String>();
		Collections.addAll(addAlllist, "India", "Tibet", "SriLanka");
		System.out.println("\n addAlllist: " + addAlllist);
		
		/* Collections.shuffle(List) shuffles randomly */
		Collections.shuffle(addAlllist);
		System.out.println("\n addAlllist: " + addAlllist);
	}
}
