public class Echecs{
	private boolean joueur;
	private Plateau plateau;
	private boolean all_kings_alive;

	public Echecs(){
		this.plateau = create_board();
		insert_pieces(this.plateau);
		this.joueur = true; // true pour blanc, false pour noir
		this.all_kings_alive = true;
		// this.plateau.afficher();
		// System.out.println("\n");
	}
	public void jouerPartie(){
		// this.plateau.afficher();
		Communication communication = new Communication();
		boolean valid_white = false;
		boolean valid_black = false;
		while(all_kings_alive){

			this.plateau.afficher();
			System.out.println("\n");
			System.out.println("Joeur Blanc");
			System.out.println("____________");
			
			do{

				Deplacement deplacement_blanc = communication.demanderDeplacement();
				valid_white = jouerTour(deplacement_blanc, true, this.plateau);

			}while(!valid_white);

			this.plateau.afficher();
			System.out.println("\n");
			if(!all_kings_alive){break;}
			System.out.println("Joeur Noir");
			System.out.println("____________");
			
			do{

				Deplacement deplacement_noir = communication.demanderDeplacement();
				valid_black = jouerTour(deplacement_noir, false, this.plateau);

			}while(!valid_black);
		}
	}

	public void kill_king(){
		this.all_kings_alive = false;
	}

	public boolean jouerTour(Deplacement depla, boolean joueur, Plateau pla){		
		int depart[] = depla.getDepart();
		int arrivee[] = depla.getArrivee();
		Case case_depart = pla.getCase(depart[0], depart[1]);
		Case case_arrivee = pla.getCase(arrivee[0], arrivee[1]);
		// 1. Tester si déplacement est valide au tableau
		if(pla.horsLimite(depla)){/*System.out.println("Hors Limite");*/ return false;}
		if(case_depart.estVide()){/*System.out.println("Départ est vide ");*/ return false;}

		Piece piece_depart = case_depart.getPiece();
		if(piece_depart.getCouleur()!=joueur){/*System.out.println("Pièce départ pas même couleur");*/ return false;}

		if(!case_arrivee.estVide()){
			if(case_arrivee.getPiece().getCouleur()==joueur){
				// System.out.println("Case arrivée même couleur");
				return false;
			}
		}
		// 1.b si déplacement valide pour piece
		if(!piece_depart.estValide(depla, pla)){System.out.println("Déplacement pas valide pour pièce"); return false;}
		// 2. si valide.
		pla.videCase(depart[0], depart[1]);
		// 	a. vider case de départ.
		if(!case_arrivee.estVide()){
			//  b. vider la case d'arrivée si contient pièce adversaire.
			Piece piece_arrivee = case_arrivee.getPiece();
			if (piece_arrivee.estRoi()){
				kill_king();
			}
			pla.videCase(arrivee[0], arrivee[1]);
		}
		//  c. remplir case d'arrivée avec pièce à déplacer.
		pla.remplirCase(arrivee[0], arrivee[1], piece_depart);
		// Mise à jour du tour
		switchJoueur();
		return true;
	}


	public static Plateau create_board(){
		return new Plateau(5, 4); // Silverman Chess
	}
	public Plateau getPlateau(){
		return this.plateau;
	}
	public void switchJoueur(){
		this.joueur = (this.joueur) ? false : true;
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
