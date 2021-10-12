public class Dame extends Piece{
	public Dame(boolean blanc){
		super(blanc, "dame");
	}
	public boolean estValide(Deplacement d, Plateau p){
		if(super.estValide(d, p)){
			if(d.typeDeplacement()!='x'){
				return true;
			}
		}
		return false;
	}
}