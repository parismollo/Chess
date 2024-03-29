public class Plateau{
	private int longueur;
	private int largeur;
	private Case[][] cases;

	public Plateau(int longueur, int largeur){
		this.longueur = longueur;
		this.largeur = largeur;
		this.cases = new Case[longueur][largeur];
		generate_cases();
	}

	public void generate_cases(){
		Case c;
		for(int i=0; i<this.longueur; i++){
			for(int j=0;j<this.largeur; j++){
				if(i%2==0){
					c = (j%2==0) ? new Case(false, null) : new Case(true, null);
				}else{
					c = (j%2==0) ? new Case(true, null) : new Case(false, null);
				}
				this.cases[i][j] = c;
			}
		}
	}
	public boolean horsLimite(int x, int y){
		if (x>=this.longueur || y >=this.largeur){
			return true; // true si (x, y) est une case hors limite du tableau
		}
		return false; // false si c'est dedans le tableau valide
	}

	public boolean horsLimite(Deplacement d){
		int depart[] = d.getDepart();
		int arrive[] = d.getArrivee();

		if (depart[0]>=this.longueur || depart[1] >=this.largeur || arrive[0]>=this.longueur || arrive[1] >= this.largeur){
			return true; // true si est une case hors limite du tableau
		}
		return false; // false si c'est dedans le tableau valide
	}
	public Case getCase(int x, int y){
		if(!horsLimite(x, y)){
			return this.cases[x][y];
		}
		return null;
	}
	public void videCase(int x, int y){
		if(!horsLimite(x, y)){
			this.cases[x][y].enleverPiece();
		}
	}
	public void remplirCase(int x, int y, Piece p){
		if(!horsLimite(x, y)){
			this.cases[x][y].remplirPiece(p);
		}
	}
	public void afficher(){
		int counter_w = 0;
		System.out.print("   [0][1][2][3]");
		for(int i=0; i<longueur; i++){
			System.out.println();
			System.out.print("["+counter_w+"] ");
			counter_w++;
			for(int j=0; j<largeur; j++){
				System.out.print(this.cases[i][j].toString()+"  ");
			}
		}
	}
}