package view;

import java.awt.Graphics;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.*;
import model.Model.Color;
import model.Model.Name;
import model.figures.ChessPiece;
import model.game.Field;

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
	    	super.paintComponent(g);
	    	
	    	ChessPiece chessPiece = field.getChessPiece();
	    	if (chessPiece != null) {
	    		paintChessPiece(chessPiece, g);
	        }
	    }
	    
	    private void paintChessPiece(ChessPiece chessPiece, Graphics g) {
	    	Name name = chessPiece.getName();
    		Color color = chessPiece.getColor();
        	switch(name)
        	{
        		case Pawn:
        			paintPawn(color, g);    	    		
    	    		break;
        		case Rook:
        			paintRook(color, g);     			
        			break;
        		case Knight:
        			paintKnight(color, g);
        			break;
        		case Bishop:
        			paintBishop(color, g);
        			break;
        		case Queen:
        			paintQueen(color, g);
        			break;
        		case King:
        			paintKing(color, g);
        			break;        		
        		default:
        			break;
        			
        	}			
		}

		private void paintKing(Color color, Graphics g) {
			if(color.equals(Color.black))
				g.drawImage(blackKing, 17, 10, this);
			else
				g.drawImage(whiteKing, 17, 10, this);			
		}

		private void paintQueen(Color color, Graphics g) {
			if(color.equals(Color.black))
				g.drawImage(blackQueen, 17, 10, this);
			else
				g.drawImage(whiteQueen, 17, 10, this);
		}

		private void paintBishop(Color color, Graphics g) {
			if(color.equals(Color.black))
				g.drawImage(blackBishop, 17, 10, this);
			else
				g.drawImage(whiteBishop, 17, 10, this);
		}

		private void paintKnight(Color color, Graphics g) {
			if(color.equals(Color.black))
				g.drawImage(blackKnight, 17, 10, this);
			else
				g.drawImage(whiteKnight, 17, 10, this);
		}

		private void paintRook(Color color, Graphics g) {
			if(color.equals(Color.black))
				g.drawImage(blackRook, 17, 10, this);
			else
				g.drawImage(whiteRook, 17, 10, this);
		}

		private void paintPawn(Color color, Graphics g) {
			if(color.equals(Color.black))
				g.drawImage(blackPawn, 17, 10, this);
			else 
				g.drawImage(whitePawn, 17, 10, this);			
		}		
}
