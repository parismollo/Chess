public class Test{
	public static void main(String args[]){
		// Ex1
		// Piece p = new Piece(false, "cavalier");
		// Piece p2 = new Piece(true, "Cavalier");
		// System.out.println(p);
		// System.out.println(p2);
		// System.out.println("-----------------------");
		// // Ex2
		// Piece r = new Roi(true);
		// System.out.println(r);
		// Piece c = new Cavalier(false);
		// System.out.println(c);
		// System.out.println("-----------------------");
		// // Ex 3
		// Case cs= new Case(false, null);
		// System.out.println(cs.estVide());
		// cs.remplirPiece(r);
		// System.out.println(cs.estVide());
		// // cs.enleverPiece();
		// System.out.println(cs.estVide());
		// System.out.println("-----------------------");
		// System.out.println(cs);
		// System.out.println("-----------------------");
		// Plateau pla = new Plateau(8, 8); // 0 - 7; 0 - 7
		// pla.afficher();
		// System.out.println("\n-----------------------");
		// System.out.println("\n"+pla.horsLimite(8, 8)); // true
		// System.out.println("\n"+pla.horsLimite(9, 8)); // true
		// System.out.println("\n"+pla.horsLimite(7, 7)); // false
		// System.out.println("\n-----------------------");
		// pla.remplirCase(8, 8, c); // pas possible
		// pla.remplirCase(7, 7, c); // possible
		// pla.remplirCase(0, 0, c); // possible 
		// pla.afficher();
		// System.out.println("\n");
		// pla.videCase(7, 7);
		// pla.remplirCase(7, 6, r);
		// pla.afficher();

		Deplacement d1 = new Deplacement(5, 1, 3, 3); // d, 2
		Deplacement d2 = new Deplacement(5, 1, 2, 1); // v, 3
		Deplacement d3 = new Deplacement(1, 1, 3, 2); // c, -1
		Deplacement d4 = new Deplacement(6, 5, 5, 1); // x, -1
		Deplacement d5 = new Deplacement(1, 5, 1, 4); // h, 1
		System.out.println(d1.typeDeplacement());
		System.out.println(d2.typeDeplacement());
		System.out.println(d3.typeDeplacement());
		System.out.println(d4.typeDeplacement());
		System.out.println(d5.typeDeplacement());

		System.out.println(d1.dist());
		System.out.println(d2.dist());
		System.out.println(d3.dist());
		System.out.println(d4.dist());
		System.out.println(d5.dist());


	}
}