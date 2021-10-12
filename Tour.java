public class Tour extends Piece{
	public Tour(boolean blanc){
		super(blanc, "tour");
	}
	public boolean estValide(Deplacement d, Plateau p){
		if(super.estValide(d, p)){
			if(d.typeDeplacement()=='v' || d.typeDeplacement()=='h'){
				return true;
			}
		}
		return false;
	}
}