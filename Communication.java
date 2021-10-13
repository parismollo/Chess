import java.util.Scanner;

public class Communication{
	Scanner scanResponse;

	public Communication(){
		this.scanResponse = new Scanner(System.in);
	}
	public Deplacement demanderDeplacement(){
		System.out.println("\nIndiquez le deplacement que vous souhaitez realiser. Exemple: 22;11. Pour deplacer la piece a la case de depart 22 a la case d'arrivee 11.");
		String res = this.scanResponse.next();
		// verify_res(res); [TODO]
		Deplacement d = new Deplacement(Character.getNumericValue(res.charAt(0)), Character.getNumericValue(res.charAt(1)), Character.getNumericValue(res.charAt(3)), Character.getNumericValue(res.charAt(4)));
		return d;
	}
	// public static void main(String args[]){
	// 	Communication c = new Communication();
	// 	c.demanderDeplacement();
	// }
}