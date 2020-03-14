import java.util.*;

public class EmailListe {
	SortedMap<Schueler, HashSet<String>> emailliste;
	
	public EmailListe() {
		this.emailliste = new TreeMap<>();
	}
	
	public void addAddress(Schueler schueler, String address) {
		if (this.emailliste.containsKey(schueler)) {
			if (this.emailliste.get(schueler).contains(address)) {
			} else {
				this.emailliste.get(schueler).add(address);
			}
		} else {
			HashSet<String> temp = new HashSet<String>();
			temp.add(address);
			this.emailliste.put(schueler, temp);
		}
	}
	
	public String[] searchAddress(Schueler schueler) {
		String[] temp = new String[this.emailliste.get(schueler).size()];
		this.emailliste.get(schueler).toArray(temp);
		return temp;
	}
	
	public void delSchueler(Schueler schueler) {
		if (this.emailliste.containsKey(schueler)) this.emailliste.remove(schueler);
	}
	
	public void delAddress(Schueler schueler, String address) {
		if (this.emailliste.containsKey(schueler)) {
			if (this.emailliste.get(schueler).contains(address)) this.emailliste.get(schueler).remove(address);
		}
	}
	
	public String toString() {
		StringBuilder temp = new StringBuilder();
			if (!this.emailliste.isEmpty()) {
			for (Schueler cache1: this.emailliste.keySet()) {
				//Schülername
				temp.append(cache1.getVorname() + cache1.getNachname() + ": ");
				//Email-Adressen
				Iterator<String> it = this.emailliste.get(cache1).iterator();
				String cache2 = "";
				while (it.hasNext()) {
					cache2 = it.next();
					if (it.hasNext()) {
						temp.append(cache2 + ", ");
					} else {
						temp.append(cache2);
					}
				}
				//Zeilenumbruch
				temp.append("\r\n");
			}
			return temp.toString();
		}
		return "isEmpty";
	}
}
