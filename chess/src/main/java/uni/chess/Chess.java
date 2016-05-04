package uni.chess;
import java.util.Scanner;


import controller.HumanVsRandom;
import controller.HumanComputerGameController;
import view.View;
import model.Model;


public class Chess {

	public static void sleep(){
        try {
            Thread.sleep(500);                 //1000 milisekund = 1 sekunda
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
	
	public static void main(String[] args) {
		
        System.out.println("wybierz opcje: \n1.Losowy vs MinMax \n2.Ty vs MinMax \n3.Ty vs Losowy ");
        Scanner read = new Scanner(System.in);
        String decision = read.nextLine();

        if(decision.equals("1")){

        } else if(decision.equals("2")){

        } else if (decision.equals("3")){
        	read.close();
            
            int coords[] = new int[2];
            
            for (int i=0;i<2;++i)
            {
            	coords[i] = -1; 
            }
            
            long times [] = new long[2];	
            
            HumanComputerGameController game = new HumanComputerGameController(Model.Color.white);
    	    
    	    View view = new View(game.getBoard(), coords, times);
    	    
    	    HumanVsRandom human = new HumanVsRandom(game, view, coords, times);
    	    
    	    human.play();

        } else {
        	System.out.println("Zly wybor, uruchom ponownie");
        }

	}

}