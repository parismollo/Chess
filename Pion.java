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
		boolean couleur_case_arr = arr.getCouleur();
		if(super.estValide(d, p)){
			// 1. move twice forward if first time
			if(first_play){
				if(d.typeDeplacement()=='v' && arr.estVide()){
					if(d.dist()==1 || d.dist()==2){
						estValide = true;
					}
				}
			}else{
				// 2. move forward one square
				if(d.typeDeplacement()=='v' && d.isForward(this)){
					estValide = true;
				}
				// 3. if tackles, can move one diagonally forward.
				if(d.typeDeplacement()=='d' && d.dist()==1 && d.isForward(this)){
					if(couleur_case_arr!=this.getCouleur()){
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