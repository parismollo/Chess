public class Test{
	public static void main(String args[]){
		// Ex1
		Piece p = new Piece(false, "cavalier");
		Piece p2 = new Piece(true, "Cavalier");
		System.out.println(p);
		System.out.println(p2);
		System.out.println("-----------------------");
		// Ex2
		Piece r = new Roi(true);
		System.out.println(r);
		Piece c = new Cavalier(false);
		System.out.println(c);
		System.out.println("-----------------------");
		// Ex 3
		Case cs= new Case(false, null);
		System.out.println(cs.estVide());
		cs.remplirPiece(r);
		System.out.println(cs.estVide());
		// cs.enleverPiece();
		System.out.println(cs.estVide());
		System.out.println("-----------------------");
		System.out.println(cs);
		System.out.println("-----------------------");
		Plateau pla = new Plateau(8, 8); // 0 - 7; 0 - 7
		pla.afficher();
		System.out.println("\n-----------------------");
		System.out.println("\n"+pla.horsLimite(8, 8)); // true
		System.out.println("\n"+pla.horsLimite(9, 8)); // true
		System.out.println("\n"+pla.horsLimite(7, 7)); // false
		System.out.println("\n-----------------------");
		pla.remplirCase(8, 8, c); // pas possible
		pla.remplirCase(7, 7, c); // possible
		pla.remplirCase(0, 0, c); // possible 
		pla.afficher();
		System.out.println("\n");
		pla.videCase(7, 7);
		pla.remplirCase(7, 6, r);
		pla.afficher();

	}
}