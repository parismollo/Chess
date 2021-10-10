public class Echecs{
	public static void main(String args[]){
		// 1. Create game setup
		// 	a. create board
		Plateau pla = create_board();
		// 	b. create pieces
		// 	c. insert pieces
		insert_pieces(pla);
		// 2. Display
		pla.afficher();
	}

	public static Plateau create_board(){
		return new Plateau(5, 4); // Silverman Chess
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