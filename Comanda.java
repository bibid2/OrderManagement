package Model;

public class Comanda {

	String id, produs, cantitate;

	public Comanda(String id, String produs, String cantitate) {
	
		this.id = id;
		this.produs = produs;
		this.cantitate = cantitate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProdus() {
		return produs;
	}

	public void setProdus(String produs) {
		this.produs = produs;
	}

	public String getCantitate() {
		return cantitate;
	}

	public void setCantitate(String cantitate) {
		this.cantitate = cantitate;
	}
	
}
