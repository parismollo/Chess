public class Case{
	private boolean blanc; // true si blanc, false si noir.
	private Piece piece; // si null la case est vide
	
	public Case(boolean b, Piece p){
		this.blanc = b;
		this.piece = p;
	}
	public Piece getPiece(){
		return this.piece;
	}
	public boolean estVide(){
		return (this.piece==null);
	}
	public void remplirPiece(Piece p){
		this.piece = (estVide()) ? p : this.piece;
	}
	public void enleverPiece(){
		this.piece = null;
	}
	public String toString(){
		String s = "";
		if (!estVide()) {
			s = String.valueOf(this.piece.toString().charAt(0));
		}else{
			s = (blanc) ? "-" : "*";
		}
		return s;
	}

}