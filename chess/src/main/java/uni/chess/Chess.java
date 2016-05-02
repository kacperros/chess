package uni.chess;
import java.util.Scanner;

import controller.HumanComputerGameController;
import exceptions.InvalidMoveException;
import exceptions.SurrenderException;
import view.View;
import model.Model;
import model.Move;
import model.game.Field;;

public class Chess {
	
	private static void sleep(){
        try {
            Thread.sleep(500);                 //1000 milisekund = 1 sekunda
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
	
	public static void main(String[] args) {
		
		boolean checked = new Boolean(false);
		
		int sourceX=-1;
		int sourceY=-1;
		int destinationX=-1;
		int destinationY=-1;
		
        System.out.println("wybierz opcje: \n1.Losowy vs MinMax \n2.Ty vs MinMax \n3.Ty vs Losowy ");
        Scanner read = new Scanner(System.in);
        String decision = read.nextLine();
        
        Field source=null;
        Field destination=null;
        
        if(decision.equals("1")){

        }
        else if(decision.equals("2")){

        } else if (decision.equals("3")) {

        }
        
        else {
        	System.out.println("Zly wybor, uruchom ponownie");
        }
        
        read.close();
        
        int tab[] = new int[2]; 
        
        for (int i=0;i<2;++i)
        {
        	tab[i] = -1; 
        }
        
        HumanComputerGameController game = new HumanComputerGameController(Model.Color.white);
	    
	    View view = new View(game.getBoard(), tab, checked);	    
        
	    while(true){
	    		    	
	    	while (tab[0]==-1 || tab[1]==-1)
	    	{
	    		view.update(game.getBoard());    		
		    	sleep();
	    	}
	    	
	    	sourceX = tab[0];
	    	sourceY = tab[1];
	    	
	    	tab[0]=-1;
	    	tab[1]=-1;
	    	
	    	while (tab[0]==-1 || tab[1]==-1)
	    	{
	    		view.update(game.getBoard());    		
		    	sleep();
	    	}
	    	
	    	destinationX = tab[0];
	    	destinationY = tab[1];
	    	
	    	tab[0]=-1;
	    	tab[1]=-1;
	    	
	    	source = game.getBoard().getFieldAbsolute(sourceX, sourceY);
	    	destination = game.getBoard().getFieldAbsolute(destinationX, destinationY);
	    	
	    	System.out.println("source: ");
	    	System.out.println(sourceX);
	    	System.out.println(sourceY);
	    	System.out.println("destination: ");
	    	System.out.println(destinationX);
	    	System.out.println(destinationY);
	    	
	    	Move move = new Move (source, destination);
	    	
	        for (int i=0;i<2;++i)
	        {
	        	tab[i] = -1; 
	        }
	    	
	    	try
	    	{
	    		game.playerMove(move);
	    	} catch (InvalidMoveException e) {
	    		System.out.println("wyjatek od czlowieka");	
	    		e.printStackTrace();
	    	}
	    	
	    	view.update(game.getBoard());
	    	sleep();
	    	
	     	try
	    	{
	     		game.opponentMove();
	    	} catch (SurrenderException e) {
	    		System.out.println("wyjatek od komputera");	
				e.printStackTrace();
			}
	    	
	    	view.update(game.getBoard());	
	    }
	    
	}

}
