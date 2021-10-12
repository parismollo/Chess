public class Case{
	private boolean couleur; // true si blanc, false si noir.
	private Piece piece; // si null la case est vide
	
	public Case(boolean couleur, Piece piece){
		this.couleur = couleur;
		this.piece = piece;
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
	public boolean getCouleur(){
		return this.couleur;
	}
	public String toString(){
		String s = "";
		if (!estVide()) {
			s = String.valueOf(this.piece.toString().charAt(0));
		}else{
			s = (couleur) ? "-" : "*";
		}
		return s;
	}

}