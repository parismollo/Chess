public class Roi extends Piece{
	public Roi(boolean blanc){
		super(blanc, "roi");
	}
	public boolean estValide(Deplacement d, Plateau p){
		if(super.estValide(d, p)){
			if(d.dist()==1){
				return true;
			}
		}
		return false;
	}
}