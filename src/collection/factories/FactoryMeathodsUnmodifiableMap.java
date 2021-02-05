package collection.factories;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FactoryMeathodsUnmodifiableMap {

	public static void main(String[] args) {

		
		Map<String, Integer> originalMap = new HashMap<>();
		originalMap.put("Shashank", 15);
		originalMap.put("Akanksha", 14);
		System.out.println("OriginalMap: "+ originalMap);//print OriginalMap

		/* 1. Unmodifiable Map */
		Map<String, Integer> unModMap1 = Collections.unmodifiableMap(originalMap);
		//unModMap1.put("Thakur", 11); // Exception - java.lang.UnsupportedOperationException
		
		// original Map can be modified and this change reflects in UnModifiable map
		originalMap.put("Thakur", 17);
		System.out.println("OriginalMap: "+ originalMap);//print OriginalMap
		System.out.println("unModifiableMap: "+ unModMap1);//print unModifiableMap
		/* This Gives the main Concept of unmodifiable VIEWS
		 * VIEWS = unModifiableMap cannot be modified
		 * WhereAs If View needs modification, then modify the originalMap instead, it will get reflected */
		
		/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */
		
		/* 2. Copy of Map */
		Map<String, Integer> copyOfOriginalMap = Map.copyOf(originalMap);
		
		originalMap.put("Singh", 45);
		System.out.println();
		System.out.println("OriginalMap: "+ originalMap);//print OriginalMap
		System.out.println("unModifiableMap: "+ unModMap1);//print unModifiableMap
		System.out.println("CopyOfOriginalMap: "+ copyOfOriginalMap);//print copyOfOriginalMap
		/* Copy of map Creates a unModifiable Copy of original Map 
		 * Any Modification in OriginalMap after the copy Map is created, won't reflect in CopyOfOriginalMap*/
		
		// copyOfOriginalMap.put("Sankalp", 87); // throws java.lang.UnsupportedOperationException
		
		/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */
		
		/* 3. Simpler Map creation, One Liner, unmodifiable */
		Map<String, Integer> easyCreatUnModiMap = Map.of("Thakur", 33, "Singh", 24);
		//easyCreatUnModiMap.put("Surname", 76); // throws java.lang.UnsupportedOperationException
		System.out.println("\n easyCreatUnModiMap: "+easyCreatUnModiMap);
		
		// Map.of(K, V...) creates a map with quick one liner code,  this map is unmodifiable 
		
		/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */
	}

}
