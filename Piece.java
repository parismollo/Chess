public class Piece{
	private boolean couleur; // true pour blanc, false pour noir.
	private String nom; // nom de la piece.

	public Piece(boolean couleur, String nom){
		this.couleur = couleur;
		this.nom = nom;
	}

	public String toString(){
		String str = this.nom;
		String r = (this.couleur) ? str.substring(0, 1).toLowerCase() + str.substring(1) : str.substring(0, 1).toUpperCase() + str.substring(1);
		return r;
	}
	public boolean getCouleur(){
		return this.couleur;
	}
	public boolean estValide(Deplacement d, Plateau p){
		int depart[] = d.getDepart();
		int arrivee[] = d.getArrivee();
		if(!p.horsLimite(d)){
			// Check if point d'arrive il y a une piece de meme couleur
			Case dep = p.getCase(depart[0], depart[1]);
			Case arr = p.getCase(arrivee[0], arrivee[1]);
			if(dep.estVide()){
				System.out.println("Départ est vide");
				return false;
			}
			else if(!arr.estVide()){
					if(arr.getPiece().couleur == this.couleur){
						System.out.println("Case arrivée a même couleur en classe Piece");
						return false;
				}
			}
			return true;
		}
		System.out.println("Hors limite dans classe pièce");
		return false;
	}
}