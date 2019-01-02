import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Collections {

	public static void main(String[] args) {

		// List
		List<String> dyreListe = List.of("Okse", "Ku", "Katt", "Hund", "Okse");

		System.out.println("Dyreliste:");
		System.out.println(dyreListe);
		dyreListe.forEach(k -> System.out.println(k));

		System.out.println("-----------");

		// Set
		Set<String> dyreSet = Set.of("Okse", "Ku", "Katt", "Hund");

		System.out.println("DyreSet:");
		System.out.println(dyreSet);

		dyreSet.forEach(k -> System.out.println(k));
		System.out.println("-----------");

		// Map
		Map<String, String> dyreMap = Map.ofEntries(Map.entry("Ola", "Hund"), Map.entry("Petter", "Katt"),
				Map.entry("Dagros", "Ku"));

		System.out.println("DyreMap:");
		System.out.println(dyreMap);
		dyreMap.forEach((k, v) -> System.out.println(k + " er en " + v));

		System.out.println("-----------");

		// TreeMap - som er sortert etter nøklene
		TreeMap<String, String> dyr = new TreeMap<>();

		dyr.put("Ola", "Hund");
		dyr.put("Pan", "Hund");
		dyr.put("Truls", "Katt");
		dyr.put("Dagros", "Ku");

		// print ut TreeMapen
		System.out.println("TreeMap: ");
		System.out.println(dyr);

		// Før Java 8
		for (Map.Entry<String, String> entry : dyr.entrySet()) {
			System.out.println(entry.getKey() + " er en " + entry.getValue());
		}

		System.out.println("----------------");

		// Etter Java 8
		dyr.forEach((k, v) -> System.out.println(k + " er en " + v));

		
		// Arraylist
		ArrayList<Integer> tall = new ArrayList<>();
		
		tall.add(10);
		tall.add(56);
		tall.add(15);
		tall.add(25);
		
		// print listen
		System.out.println("Tall: "+tall);

		// Sorterer ArrayListen "tall" og endrer den.
		// Collections.sort(tall);
		// System.out.println(tall);
		
		// Sorterer "tall" uten å endre den opprinnelige ArrayListen 
		System.out.print("Sorterte tall: ");
		tall.stream().sorted().forEach((x) -> System.out.print(x +" "));
		System.out.println();
		
		// Sorterer "tall" uten å endre den opprinnelige ArrayListen 
		System.out.print("Omvendt sorterte tall: ");
		tall.stream().sorted(Comparator.reverseOrder()).forEach((x) -> System.out.print(x +" "));
		System.out.println();
						
		//lag produktet av alle tallene i listen

		Integer produkt = tall.stream().reduce(1, (a,b)->a*b);
		
		System.out.println("Produktet av tallene: " +  produkt);
		
		
		}
}
