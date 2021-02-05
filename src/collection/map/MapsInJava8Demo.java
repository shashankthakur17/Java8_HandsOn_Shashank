package collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapsInJava8Demo {
	
	public static void main(String[] args) {
		Product defaultProd = new Product(-1, "Customers Choice", "100g");
		Product prod1 = new Product(1, "Dairy", "500g");
		Product prod2 = new Product(2, "Grams", "250g");
		Product prod3 = new Product(3, "Instant cook", "100g");
		Product prod4 = new Product(4, "Dry Fruits", "300g");
		
		Map<Integer, Product> productMap = new HashMap<>();
		productMap.put(11, prod1);
		productMap.put(22, prod2);
		productMap.put(33, prod3);
		productMap.put(44, prod4);
		
		System.out.println(productMap);
		
		// map.keySet() returns a SET of keys 
		// And map.values() returns a collection of type == Type of value (in our case Product)
		// modification to any of the above obtained collection Is Not allowed 
		// Only Remove from these collections is allowed, 
		/* this will affect the original Map */
		Set<Integer> keySetProdMap = productMap.keySet();
		System.out.println(keySetProdMap);
		System.out.println(keySetProdMap.remove(22));
		System.out.println(productMap);
		// 	keySetProdMap.add(55); add isn't allowed, will get below exception
		//	java.lang.UnsupportedOperationException
		
		Collection<Product> collectionProd = productMap.values();
		System.out.println("\n\n\n Values: \n" + collectionProd);
		System.out.println(collectionProd.remove(prod4));
		System.out.println("\nValues:\n" + collectionProd);
		System.out.println(productMap);
		// 	collectionProd.add(prod4); add isn't allowed, will get below exception
		//	java.lang.UnsupportedOperationException
		
		
		// EntrySet
		// EntrySet is modifiable, it allows to remove or add a new item in EntrySet
		// This will also modify the original map with a new enrty added to it.
		// oldWay - Set<Map.Entry<Integer, Product>> entrySet = productMap.entrySet();
		var entrySet = productMap.entrySet(); // new way after java 9, hover on var
		
		System.out.println(entrySet);
		System.out.println("entrySet.remove(prod1): " + entrySet.remove(prod1));
		System.out.println(entrySet);
		//System.out.println(entrySet.add(productMap.entry));
		
		
		/* java 8/9 additional methods*/
		
		productMap.replace(11, new Product(11, "MilkMaid", "750g"));
		System.out.println(productMap);
		
		System.out.println("productMap.remove(33, prod2): "+productMap.remove(33, prod2));
		System.out.println("productMap.putIfAbsent(22, prod2): "+productMap.putIfAbsent(22, prod2));
		System.out.println("productMap.getOrDefault(77, defaultProd): "+productMap.getOrDefault(77, defaultProd));
		//productMap.forEach();
		
		System.out.println(productMap.computeIfAbsent(77, id -> new Product(id, "Washicg Powder", "1000g")));
		
		// ForEach in Map
		productMap.forEach((key, prod) -> {
			System.out.println(key);
			System.out.print(prod);
		});
	}
	
	
	private static class Product{
		int id;
		String name;
		String weight;
		
		public Product(int id, String name, String weight) {
			super();
			this.id = id;
			this.name = name;
			this.weight = weight;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getWeight() {
			return weight;
		}
		public void setWeight(String weight) {
			this.weight = weight;
		}
		
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((weight == null) ? 0 : weight.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Product other = (Product) obj;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (weight == null) {
				if (other.weight != null)
					return false;
			} else if (!weight.equals(other.weight))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", weight=" + weight + "] \n ";
		}
	}
}
