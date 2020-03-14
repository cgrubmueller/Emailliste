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
		String[] temp = new String[0];
		this.emailliste.get(schueler).toArray(temp);
		return temp;
	}
	
	public void delSchueler(Schueler schueler) {
		if (this.emailliste.containsKey(schueler)) this.emailliste.remove(schueler);
	}
	
	public void delAddress(Schueler schueler, String address) {
		if (this.emailliste.containsKey(schueler)) {
			this.emailliste.get(schueler).remove(address);
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
				while (it.hasNext()) {
					if (it.hasNext()) {
						temp.append(it + ", ");
					} else {
						temp.append(it);
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
