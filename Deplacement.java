import java.lang.Math;

public class Deplacement{
	private int x0; //coordonée de départ
	private int y0;

	private int x1;//coordonée d'arrivée
	private int y1;

	public Deplacement(int x0, int y0, int x1, int y1){
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
	}

	public int[] getDepart(){
		int t[] = {this.x0, this.y0};
		return t;
	}


	public int[] getArrivee(){
		int t[] = {this.x1, this.y1};
		return t;
	}


	public char typeDeplacement(){
		// vertical (must stay in the same col)
		if (y0 == y1){
			return 'v';
		}
		// horizontal (must stay in the same row)
		else if(x0 == x1){
			return 'h';
		}
		// diagonal 
		else if(Math.abs(x1-x0)==Math.abs(y1-y0)){
			return 'd';
		}
		else if(x0+2==x1 || x0-2==x1){
			if (y1==x1+1 || y1==x1-1){
				return 'c';
			}
		}else if(y0+2==y1||y0-2==y1){
			if(x1==y1+1||x1==y1-1){
				return 'c';
			}
		}
		return 'x';
	}

	public int dist(){
		char t = typeDeplacement();
		if(t=='h' || t=='v'|| t=='d'){
			return Math.max(Math.abs(x1-x0), Math.abs(y1-y0));
		}
		return -1;
	}

	public boolean isForward(Piece p){
		char t = typeDeplacement();
		if(p.getCouleur()){ // blanc; forward si 
			if(t=='d' || t=='v'){
				if(x1<x0){
					return true;
				}
			}
		}else{
			if(t=='d' || t=='v'){
				if(x1>x0){
					return true;
				}
			}
		}
		return false;
	}
}