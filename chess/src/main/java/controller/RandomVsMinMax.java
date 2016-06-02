package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import controller.HumanComputerGameController;
import exceptions.InvalidMoveException;
import exceptions.SurrenderException;
import model.Move;
import model.game.Field;
import view.View;

public class RandomVsMinMax {
	
	View view;
	ComputerComputerGameController game;
	private long times[];
	private int tab[];
	
	static boolean play=true;
	static boolean roundCondition=true;
	
	static boolean flaga=false;
	static boolean round=false;
	
	static boolean timer1=false;
	static boolean timer2=false;
	
	static long startTime = 0;
	static long roundTime = 0;
	
	static long generalViewTime = 0;
	static long roundViewTime = 0;
	
	public RandomVsMinMax (ComputerComputerGameController a, View b, int c[], long d[] ) {
		this.game = a;
		this.view = b;
		this.tab = c;
		this.times = d;
	}

	private Timer timer = new Timer(50, new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			view.update(game.getBoard());
			
			if(flaga==true)
			{
				startTime = System.currentTimeMillis();
				flaga = false;
				timer1 = true;
			}
			
			if(round==true)
			{
				roundTime = System.currentTimeMillis();
				round = false;
				timer2 = true;
			}
			
			if( (System.currentTimeMillis() - roundTime) > 60000 && timer2==true) //dodano warunek na potrzeby debugowania
			{
				roundCondition = false;
				System.out.println("PRZEKROCZYLES CZAS NA RUCH - PORAŻKA");
			}
			
			if( (System.currentTimeMillis() - startTime) > 3600000 && timer1==true)
			{
				play = false;
			}
			
			if (timer1)
			{
				generalViewTime = (System.currentTimeMillis() - startTime) / 1000;
				times[0] = 3600 - generalViewTime;
			}
			
			if (timer2)
			{
				roundViewTime = (System.currentTimeMillis() - roundTime)/1000;
				times[1] = 60-roundViewTime;
			}
		}
	});
	
	public void sleep(){
        try {
            Thread.sleep(2000);                 //1000 milisekund = 1 sekunda
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
	
	public void play(){   
    	if(flaga==false)
    	{
    		flaga=true;
    		timer.start();
    	}

	    while(play && roundCondition){
    		round = true;    	
	     	try {
	     		game.opponentMoveRandom();
	    	} catch (SurrenderException e) {
	    		System.out.println("Wygral MinMax!!!");	
				return;
			}
	     	sleep();
	     	round = true;
	     	try {
	     		game.opponentMove();
	    	} catch (SurrenderException e) {
	    		System.out.println("Wygral Losowy!!!");	
				return;
			}
	     	sleep();
	    	//view.update(game.getBoard());	
	    }
	    	timer.stop();
	    	System.out.println("Koniec czasu - REMIS!!!");
	    	view.close();
	}

}