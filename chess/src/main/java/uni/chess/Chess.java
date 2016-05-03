package uni.chess;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.Timer;

import controller.HumanComputerGameController;
import exceptions.InvalidMoveException;
import exceptions.SurrenderException;
import view.View;
import model.Model;
import model.Move;
import model.game.Field;;

public class Chess {
	
	static boolean play=true;
	static boolean roundCondition=true;
	
	static boolean flaga=false;
	static boolean round=false;
	
	static boolean timer1=false;
	static boolean timer2=false;
	
	static long startTime = 0;
	static long roundTime = 0;
	
	static Timer timer = new Timer(1000, new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			if(flaga==true)
			{
				startTime = System.currentTimeMillis();
				flaga = false;
				timer1 = true;
			}
			
			if(round==true)
			{
				System.out.println("START ROUND");
				roundTime = System.currentTimeMillis();
				round = false;
				timer2 = true;
			}
			
			if( (System.currentTimeMillis() - roundTime) > 60000 && timer2==true)
			{
				roundCondition = false;
			}
			
			if( (System.currentTimeMillis() - startTime) > 3600000 && timer1==true)
			{
				play=false;
			}
			
			if (timer1)
			{
				//System.out.println("CZAS ROZGRYWKI");
				//System.out.println( (System.currentTimeMillis() - startTime)/1000 );
			}
			
			if (timer2)
			{
				//System.out.println("CZAS TURY");
			//	System.out.println( (System.currentTimeMillis() - roundTime)/1000 );
			}
		}
	});
	
	private static void sleep(){
        try {
            Thread.sleep(500);                 //1000 milisekund = 1 sekunda
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
	
	public static void main(String[] args) {
				
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
	    
	    View view = new View(game.getBoard(), tab);	    
	    
    	if(flaga==false)
    	{
    		flaga=true;
    		timer.start();
    	}
        
	    while(play && roundCondition){
	    	
	    	//
	    	round = true;
	    	
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

	    	//
	    	
	    	destinationX = tab[0];
	    	destinationY = tab[1];
	    	
	    	tab[0]=-1;
	    	tab[1]=-1;
	    	
	    	source = game.getBoard().getFieldAbsolute(sourceX, sourceY);
	    	destination = game.getBoard().getFieldAbsolute(destinationX, destinationY);
	    	
	    	Move move = new Move (source, destination);
	    	
	        for (int i=0;i<2;++i)
	        {
	        	tab[i] = -1; 
	        }

	    	try {
	    		game.playerMove(move);
	    	} catch (InvalidMoveException e) {	
	    		System.out.println("wybierz ponownie");	
	    		e.printStackTrace();
	    		continue;
	    	}
	        
	    	view.update(game.getBoard());
	    	sleep();
	    	
	     	try {
	     		game.opponentMove();
	    	} catch (SurrenderException e) {
	    		System.out.println("Wygrales!!! GRATULACJE ;-) ");	
				e.printStackTrace();
				break;
			}
	    	
	    	view.update(game.getBoard());	
	     
	    }
	    	timer.stop();
	    	System.out.println("Koniec czasu - REMIS!!!");
	    	view.close();
	}

}
