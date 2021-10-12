public class Cavalier extends Piece{
	public Cavalier(boolean blanc){
		super(blanc, "cavalier");
	}
	public boolean estValide(Deplacement d, Plateau p){
		if(super.estValide(d, p)){
			if(d.typeDeplacement()=='c'){
				return true;
			}
		}
		return false;
	}
}