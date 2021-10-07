public class Piece{
	private boolean blanc; // true pour blanc, false pour noir.
	private String nom; // nom de la piece.

	public Piece(boolean b, String n){
		this.blanc = b;
		this.nom = n;
	}

	public String toString(){
		String str = this.nom;
		String r = (this.blanc) ? str.substring(0, 1).toLowerCase() + str.substring(1) : str.substring(0, 1).toUpperCase() + str.substring(1);
		return r;
	}
}