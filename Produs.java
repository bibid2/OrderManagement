package Model;

public class Produs {
	public String id, denumire,cantitate;
	
	
	public Produs(String id, String denumire, String cantitate) {
		this.id = id;
		this.denumire = denumire;
		this.cantitate = cantitate;
	}

	public String getCantitate() {
		return cantitate;
	}

	public void setCantitate(String cantitate) {
		this.cantitate = cantitate;
	}

	public Produs(String id, String denumire) {
	    this.id = id;
		this.denumire = denumire;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	
	


}
