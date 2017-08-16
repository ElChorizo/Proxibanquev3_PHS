package org.proxibanque.view;

import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.proxibanque.model.Client;

@ManagedBean (name = "clientService")
@ApplicationScoped
public class ClientService {
	private static final String[] prenoms;
	private static final String[] noms;
	private static final String[] emails;
	private static final String[] tels;
	private static final String[] adresses;
	private static final String[] codes;
	private static final String[] villes;

	static {
		prenoms = new String[10];
		prenoms[0] = "Jean";
		prenoms[1] = "Claude";
		prenoms[2] = "Anne";
		prenoms[3] = "Jean";
		prenoms[4] = "Claude";
		prenoms[5] = "Anne";
		prenoms[6] = "Jean";
		prenoms[7] = "Claude";
		prenoms[8] = "Anne";
		prenoms[9] = "Jean";

		noms = new String[10];
		noms[0] = "Valjean";
		noms[1] = "McKinley";
		noms[2] = "Doolittle";
		noms[3] = "Valjean";
		noms[4] = "McKinley";
		noms[5] = "Doolittle";
		noms[6] = "Valjean";
		noms[7] = "McKinley";
		noms[8] = "Doolittle";
		noms[9] = "Valjean";

		emails = new String[10];
		emails[0] = "truc@bidule.com";
		emails[1] = "bouh@yahoo.com";
		emails[2] = "valhalla@dank.swe";
		emails[3] = "truc@bidule.com";
		emails[4] = "bouh@yahoo.com";
		emails[5] = "valhalla@dank.swe";
		emails[6] = "truc@bidule.com";
		emails[7] = "bouh@yahoo.com";
		emails[8] = "valhalla@dank.swe";
		emails[9] = "truc@bidule.com";

		tels = new String[10];
		tels[0] = "0125";
		tels[1] = "0227";
		tels[2] = "0629";
		tels[3] = "0125";
		tels[4] = "0227";
		tels[5] = "0629";
		tels[6] = "0125";
		tels[7] = "0227";
		tels[8] = "0629";
		tels[9] = "0125";

		adresses = new String[10];
		adresses[0] = "10 rue Racine";
		adresses[1] = "24 rue du Gambré";
		adresses[2] = "45 rue du 11 Novembre";
		adresses[3] = "10 rue Racine";
		adresses[4] = "24 rue du Gambré";
		adresses[5] = "45 rue du 11 Novembre";
		adresses[6] = "10 rue Racine";
		adresses[7] = "24 rue du Gambré";
		adresses[8] = "45 rue du 11 Novembre";
		adresses[9] = "10 rue Racine";

		codes = new String[10];
		codes[0] = "75001";
		codes[1] = "92160";
		codes[2] = "05890";
		codes[3] = "75001";
		codes[4] = "92160";
		codes[5] = "05890";
		codes[6] = "75001";
		codes[7] = "92160";
		codes[8] = "05890";
		codes[9] = "75001";

		villes = new String[10];
		villes[0] = "Antony";
		villes[1] = "Paris";
		villes[2] = "Trouperdu";
		villes[3] = "Antony";
		villes[4] = "Paris";
		villes[5] = "Trouperdu";
		villes[6] = "Antony";
		villes[7] = "Paris";
		villes[8] = "Trouperdu";
		villes[9] = "Antony";

	}

	public java.util.List<Client> createClients(int size) {
		
	java.util.List<Client> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			list.add(new Client(getRandomId(), getRandomNoms(), getRandomPrenoms(), getRandomAdresses(), getRandomCodes(), getRandomVilles(), getRandomTelephones(), getRandomEmails()));
	}
		return list;
	}

	private int getRandomId() {
		return (int) (Math.random() * 50 + 1960);
	}

	private String getRandomNoms() {
		return noms[(int) (Math.random() * 10)];
	}

	private String getRandomPrenoms() {
		return prenoms[(int) (Math.random() * 10)];
	}

	private String getRandomAdresses() {
		return adresses[(int) (Math.random() * 10)];
	}

	private String getRandomCodes() {
		return codes[(int) (Math.random() * 10)];
	}

	private String getRandomVilles() {
		return villes[(int) (Math.random() * 10)];
	}

	private String getRandomTelephones() {
		return tels[(int) (Math.random() * 10)];
	}

	private String getRandomEmails() {
		return emails[(int) (Math.random() * 10)];
	}

	public java.util.List<String> getNoms() {
		return Arrays.asList(noms);
	}

	public java.util.List<String> getPrenoms() {
		return Arrays.asList(prenoms);
	}

	public java.util.List<String> getAdresses() {
		return Arrays.asList(adresses);
	}

	public java.util.List<String> getCodes() {
		return Arrays.asList(codes);
	}

	public java.util.List<String> getVilles() {
		return Arrays.asList(villes);
	}

	public java.util.List<String> getTelephones() {
		return Arrays.asList(tels);
	}

	public java.util.List<String> getEmails() {
		return Arrays.asList(emails);
	}
}
