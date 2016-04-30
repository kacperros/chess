package uni.chess;
import java.util.Scanner;

import controller.ChessGame;
import model.Model;

import view.View;

public class Chess {
	
	private static void sleep(){
        try {
            Thread.sleep(500);                 //500 milisekund = 0,5 sekundy
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
	
	public static void main(String[] args) {
		
        System.out.println("wybierz opcje: \n1.Komputer vs Komputer \n2.Komputer vs Ty");
        Scanner read = new Scanner(System.in);
        String decision = read.nextLine();
        
        if(decision.equals("1")){

        }
        else if(decision.equals("2")){

        }
        else {
        	System.out.println("Zly wybor, uruchom ponownie");
        }
		
	    Model model = new Model();
	    ChessGame game = new ChessGame(model.getBoard());
	    
	    View view = new View(model.getBoard());
		
	    view.update(model.getBoard());
        
	}

}
