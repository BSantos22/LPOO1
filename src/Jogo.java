import java.util.*;


public class Jogo {
	public static void main(String[] args) {
		Labirinto labirinto = new Labirinto();
		Heroi heroi = new Heroi(1,1);
		Dragao dragao = new Dragao(1,3);
		Scanner sc = new Scanner(System.in);
		
		labirinto.print();
		
		while (true) {
			System.out.println("Move: ");
			String tecla = sc.next();
			if (tecla.equals("w") || tecla.equals("a") || tecla.equals("s") || tecla.equals("d")) {
				heroi.move(tecla, labirinto);
				if (heroi.x == labirinto.saida.x && heroi.y == labirinto.saida.y) {
					labirinto.print();
					System.out.println("O heroi venceu!");
					break;
				}
				
				heroi.apanha(labirinto.espada, labirinto);
				
				int luta = heroi.lutardragao(dragao);
				
				if (luta == 1) {
					labirinto.print();
					System.out.println("O heroi morreu!");
					break;
				}
				else if (luta == 2){
					dragao.morre(labirinto);
					System.out.println("O dragao morreu!");
				}
			}
			
			
			labirinto.print();
		}
		
		sc.close();
	}
}