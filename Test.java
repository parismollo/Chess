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
		Case cs= new Case(true, null);
		System.out.println(cs.estVide());
		cs.remplirPiece(r);
		System.out.println(cs.estVide());
		cs.enleverPiece();
		System.out.println(cs.estVide());
		System.out.println("-----------------------");

	}
}