public class Echecs{
	private boolean joueur;
	private Plateau plateau;

	public Echecs(){
		this.plateau = create_board();
		insert_pieces(this.plateau);
		this.joueur = true; // true pour blanc, false pour noir
		this.plateau.afficher();
	}

	public boolean jouerTour(Deplacement depla, boolean joueur, Plateau pla){		
		int depart[] = depla.getDepart();
		int arrivee[] = depla.getArrivee();
		Case case_depart = pla.getCase(depart[0], depart[1]);
		Case case_arrivee = pla.getCase(arrivee[0], arrivee[1]);
		// 1. Tester si déplacement est valide au tableau
		if(pla.horsLimite(depla)){return false;}
		if(case_depart.estVide()){return false;}

		Piece piece_depart = case_depart.getPiece();
		if(piece_depart.getCouleur()!=joueur){return false;}

		if(!case_arrivee.estVide()){
			if(case_arrivee.getPiece().getCouleur()==joueur){
				return false;
			}
		}
		// 1.b si déplacement valide pour piece
		if(!piece_depart.estValide(depla, pla)){return false;}
		// 2. si valide.
		pla.videCase(depart[0], depart[1]);
		// 	a. vider case de départ.
		if(!case_arrivee.estVide()){
			//  b. vider la case d'arrivée si contient pièce adversaire.
			pla.videCase(arrivee[0], arrivee[1]);
		}
		//  c. remplir case d'arrivée avec pièce à déplacer.
		pla.remplirCase(arrivee[0], arrivee[1], piece_depart);
		return true;
	}

	public static Plateau create_board(){
		return new Plateau(5, 4); // Silverman Chess
	}
	public Plateau getPlateau(){
		return this.plateau;
	}
	public static void insert_pieces(Plateau pla){
		// Pions - ok
		int counter_black = 0;
		int counter_white = 0;
		Piece p1 = new Pion(false);
		Piece p2 = new Pion(true);
		for(int i=0; i<8; i++){
			if(i<4){
				pla.remplirCase(1, counter_black, p1);
				counter_black++;
			}else{
				pla.remplirCase(3, counter_white, p2);
				counter_white++;
			}
		}
		// Tour - ok
		Piece t1 = new Tour(false);
		pla.remplirCase(0, 0, t1);
		pla.remplirCase(0, 3, t1);
		Piece t2 = new Tour(true);
		pla.remplirCase(4, 0, t2);
		pla.remplirCase(4, 3, t2);

		// Dame - ok
		Piece d1 = new Dame(false);
		pla.remplirCase(0, 1, d1);
		Piece d2 = new Dame(true);
		pla.remplirCase(4, 1, d2);

		// Roi - ok
		Piece r1 = new Roi(false);
		pla.remplirCase(0, 2, r1);
		Piece r2 = new Roi(true);
		pla.remplirCase(4, 2, r2); 
		}
}
