import java.util.*;

/**
 * Diese Klass testet die Schuler Klasse.
 * @author Christian Grubmüller
 * @version 2020-03-07
 */

public class Test {
	public static void main(String[] args) {
		Schueler s1 = new Schueler(1,"Georg","Burkel",'B');
		Schueler s2 = new Schueler(2,"Carmen","Dimov",'A');
		Schueler s3 = new Schueler(3,"Igor","Filipovic",'B');
		
		System.out.println(".equals wird getestet");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s1));
		System.out.println();
		System.out.println(".compareTo wird getestet");
		System.out.println(s2.compareTo(s1));
		System.out.println(s2.compareTo(s2));
		System.out.println(s2.compareTo(s3));
		System.out.println();
		System.out.println("Schuler in SortedSet wird getestet");
		Set<Schueler> ss = new HashSet<>();
		ss.add(s1);
		ss.add(s2);
		ss.add(s3);
		System.out.println("Die Vornamen der Schüler werden ausgegeben");
		for (Schueler temp: ss) {
			System.out.println(temp.getVorname());
		}
		System.out.println("Die Größe des SortedSet wird ausgegeben");
		System.out.println(ss.size());
	}
}
