package collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import collection.arraylist.testclasses.CinemaActors;

public class HashMapExample {

	public static void main(String[] args) {


		CinemaActors rajkumarRao = new CinemaActors(30, "Rajkumar Rao", "Stree and Omerta");
		CinemaActors ayyushman = new CinemaActors(36, "Ayyushman Khurrana", "Andhadhundh and Article 15");
		CinemaActors vicky = new CinemaActors(32, "Vicky Kaushal", "Uri and Raazi");
		CinemaActors kartik = new CinemaActors(29, "Kartik Aaryan", "Love Aaj Kal");

		Map<String , CinemaActors> actorsMap = new HashMap<>(); // introduced in java 7 called Diamond representation

		actorsMap.put(rajkumarRao.getName(), rajkumarRao);
		actorsMap.put(ayyushman.getName(), ayyushman);
		actorsMap.put(vicky.getName(), vicky);
		actorsMap.put(kartik.getName(), kartik);
		
		for(Entry<String, CinemaActors> entry: actorsMap.entrySet()) {
			System.out.println(entry);
		};

	}

}
