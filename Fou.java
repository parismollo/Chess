public class Fou extends Piece{
	public Fou(boolean blanc){
		super(blanc, "fou");
	}
	public boolean estValide(Deplacement d, Plateau p){
		if(super.estValide(d, p)){
			if(d.typeDeplacement()=='d'){
				return true;
			}
		}
		return false;
	}
}