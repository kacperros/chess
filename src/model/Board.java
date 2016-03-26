package model;

import model.figures.Bishop;
import model.figures.King;
import model.figures.Knight;
import model.figures.Pawn;
import model.figures.Queen;
import model.figures.Rook;

public class Board {
	/**tablica pól*/
	private Field field [][];

	public Board(){
		
		field = new Field[8][8];
		
		for (int i=0;i<8;++i)
		{
			for(int j=0;j<8;++j)
			{
				
			field[i][j] = new Field(i, j);
			
			}
		}
		
		fillBlack2();
		fillBlack1();
		fillWhite2();
		fillWhite1();
	}
	
	public Field getField(int i, int j)
	{
		return this.field[i][j];
	}
	
	public void fillBlack2 () 
	{
		this.field[0][0].addChessman(new Rook(Model.Color.black, Model.Name.blackRook));
		this.field[0][1].addChessman(new Knight(Model.Color.black, Model.Name.blackKnight));
		this.field[0][2].addChessman(new Bishop(Model.Color.black, Model.Name.blackBishop));
		this.field[0][3].addChessman(new Queen(Model.Color.black, Model.Name.blackQueen));
		this.field[0][4].addChessman(new King(Model.Color.black, Model.Name.blackKing));
		this.field[0][5].addChessman(new Bishop(Model.Color.black, Model.Name.blackBishop));
		this.field[0][6].addChessman(new Knight(Model.Color.black, Model.Name.blackKnight));
		this.field[0][7].addChessman(new Rook(Model.Color.black, Model.Name.blackRook));

	}
	
	public void fillBlack1 () 
	{
		for (int i=0;i<8;++i)
		{
			this.field[1][i].addChessman(new Pawn(Model.Color.black, Model.Name.blackPawn));
		}
	}
	
	public void fillWhite2 () 
	{
		this.field[7][0].addChessman(new Rook(Model.Color.white, Model.Name.whiteRook));
		this.field[7][1].addChessman(new Knight(Model.Color.white, Model.Name.whiteKnight));
		this.field[7][2].addChessman(new Bishop(Model.Color.white, Model.Name.whiteBishop));
		this.field[7][3].addChessman(new Queen(Model.Color.white, Model.Name.whiteQueen));
		this.field[7][4].addChessman(new King(Model.Color.white, Model.Name.whiteKing));
		this.field[7][5].addChessman(new Bishop(Model.Color.white, Model.Name.whiteBishop));
		this.field[7][6].addChessman(new Knight(Model.Color.white, Model.Name.whiteKnight));
		this.field[7][7].addChessman(new Rook(Model.Color.white, Model.Name.whiteRook));
	}
	
	public void fillWhite1 () 
	{
		for (int i=0;i<8;++i)
		{
			this.field[6][i].addChessman(new Pawn(Model.Color.white, Model.Name.whitePawn));
		}
	}
	
}
