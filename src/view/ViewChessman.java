package view;

import java.awt.Graphics;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//import model.Field;
import model.*;
import model.Model.Name;

/**
 * Klasa do wyswietlania figur
 *
 */

public class ViewChessman extends JPanel{
	  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Field field;
	
	private final Image blackPawn;
	private final Image blackRook;
	private final Image blackKnight;
	private final Image blackBishop;
	private final Image blackQueen;
	private final Image blackKing;
	
	private final Image whitePawn;
	private final Image whiteRook;
	private final Image whiteKnight;
	private final Image whiteBishop;
	private final Image whiteQueen;
	private final Image whiteKing;


	    /**
	     * @param pole
	     */
	    public ViewChessman(Field field) {
	        this.field = field;
	        
	        this.blackPawn = new ImageIcon("src/materials/blackPawn.png").getImage();
	        this.blackRook = new ImageIcon("src/materials/blackRook.png").getImage();
	        this.blackKnight = new ImageIcon("src/materials/blackKnight.png").getImage();
	        this.blackBishop = new ImageIcon("src/materials/blackBishop.png").getImage();
	        this.blackQueen = new ImageIcon("src/materials/blackQueen.png").getImage();
	        this.blackKing = new ImageIcon("src/materials/blackKing.png").getImage();
	    	
	        this.whitePawn = new ImageIcon("src/materials/whitePawn.png").getImage();
	        this.whiteRook = new ImageIcon("src/materials/whiteRook.png").getImage();
	        this.whiteKnight = new ImageIcon("src/materials/whiteKnight.png").getImage();
	        this.whiteBishop = new ImageIcon("src/materials/whiteBishop.png").getImage();
	        this.whiteQueen = new ImageIcon("src/materials/whiteQueen.png").getImage();
	        this.whiteKing = new ImageIcon("src/materials/whiteKing.png").getImage();
	        
	        
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	    	Chessman chessman = field.getChessman();
	    	
	    	//String name = field.getName();
	        
	    	super.paintComponent(g);
	    	
	    	if (chessman != null) {
	    		Name name = chessman.getName();
	        	switch(name)
	        	{
	        		case blackPawn:
	    	    		g.drawImage(blackPawn, 17, 10, this);
	    	    		break;
	        		case blackRook:
	        			g.drawImage(blackRook, 17, 10, this);
	        			break;
	        		case blackKnight:
	        			g.drawImage(blackKnight, 17, 10, this);
	        			break;
	        		case blackBishop:
	        			g.drawImage(blackBishop, 17, 10, this);
	        			break;
	        		case blackQueen:
	        			g.drawImage(blackQueen, 17, 10, this);
	        			break;
	        		case blackKing:
	        			g.drawImage(blackKing, 17, 10, this);
	        			break;
	        		case whitePawn:
	    	    		g.drawImage(whitePawn, 17, 10, this);
	    	    		break;
	        		case whiteRook:
	        			g.drawImage(whiteRook, 17, 10, this);
	        			break;
	        		case whiteKnight:
	        			g.drawImage(whiteKnight, 17, 10, this);
	        			break;
	        		case whiteBishop:
	        			g.drawImage(whiteBishop, 17, 10, this);
	        			break;
	        		case whiteQueen:
	        			g.drawImage(whiteQueen, 17, 10, this);
	        			break;
	        		case whiteKing:
	        			g.drawImage(whiteKing, 17, 10, this);
	        			break;
	        		default:
	        			break;
	        			
	        	}
	        }
	    	
	    	/**
	        if (name.equals("brak")==false) {
	        	switch(name)
	        	{
	        		case "blackPawn":
	    	    		g.drawImage(blackPawn, 17, 10, this);
	    	    		break;
	        		case "blackRook":
	        			g.drawImage(blackRook, 17, 10, this);
	        			break;
	        		case "blackKnight":
	        			g.drawImage(blackKnight, 17, 10, this);
	        			break;
	        		case "blackBishop":
	        			g.drawImage(blackBishop, 17, 10, this);
	        			break;
	        		case "blackQueen":
	        			g.drawImage(blackQueen, 17, 10, this);
	        			break;
	        		case "blackKing":
	        			g.drawImage(blackKing, 17, 10, this);
	        			break;
	        		case "whitePawn":
	    	    		g.drawImage(whitePawn, 17, 10, this);
	    	    		break;
	        		case "whiteRook":
	        			g.drawImage(whiteRook, 17, 10, this);
	        			break;
	        		case "whiteKnight":
	        			g.drawImage(whiteKnight, 17, 10, this);
	        			break;
	        		case "whiteBishop":
	        			g.drawImage(whiteBishop, 17, 10, this);
	        			break;
	        		case "whiteQueen":
	        			g.drawImage(whiteQueen, 17, 10, this);
	        			break;
	        		case "whiteKing":
	        			g.drawImage(whiteKing, 17, 10, this);
	        			break;
	        		default:
	        			break;
	        			
	        	}
	        }
	        */
	    }

}
