public class Pion extends Piece{
	private boolean first_play;

	public Pion(boolean couleur){
		super(couleur, "pion");
		this.first_play = true;
	}

	public void setFirstPlay(){
		this.first_play = false;
	}
	public boolean estValide(Deplacement d, Plateau p){
		boolean estValide = false;
		int arrivee[] = d.getArrivee();
		Case arr = p.getCase(arrivee[0], arrivee[1]);
		boolean couleur_piece_arr = false;
		if(!arr.estVide()){
			couleur_piece_arr = arr.getPiece().getCouleur();
		}

		if(super.estValide(d, p)){
			// 1. move twice forward if first time
			// System.out.println("\nFIRST PLAY: "+first_play);
			// System.out.println(d.isForward(this)+" "+d.dist()+" "+d.typeDeplacement());
			if(first_play){
				if(d.typeDeplacement()=='v' && arr.estVide()){
					if(d.dist()==1 || d.dist()==2){
						estValide = true;
					}
				}
				if(d.typeDeplacement()=='d' && d.dist()==1 && d.isForward(this) && !arr.estVide()){
					// System.out.println("here...");
					if(couleur_piece_arr!=this.getCouleur()){
						// System.out.println("not here...?");
						estValide = true;
					}
				}
			}else{
				// 2. move forward one square
				if(d.typeDeplacement()=='v' && d.isForward(this) && d.dist()==1){
					estValide = true;
				}
				// 3. if tackles, can move one diagonally forward.
				if(d.typeDeplacement()=='d' && d.dist()==1 && d.isForward(this) && !arr.estVide()){
					if(couleur_piece_arr!=this.getCouleur()){
						estValide = true;
					}
				}
			}
		}
		if(this.first_play){
			setFirstPlay();
		}
		return estValide;
	}
}