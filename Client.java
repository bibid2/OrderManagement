package Model;


public class Client {
	
	public String id, nume, prenume, id_comanda;

	public Client(String id, String nume, String prenume, String id_comanda) {
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
		this.id_comanda = id_comanda;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getId_comanda() {
		return id_comanda;
	}

	public void setId_comanda(String id_comanda) {
		this.id_comanda = id_comanda;
	}
	
	
}
