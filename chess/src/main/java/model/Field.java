package model;

import model.figures.ChessPiece;

public class Field {
	
	private ChessPiece chessPiece;
	private final FieldCoordinates fieldCoordinates;
	
	public Field(int x, int y)
	{
		this.chessPiece=null;
		this.fieldCoordinates = new FieldCoordinates(x, y);
	}
	
	public Field(int x, int y, ChessPiece chessman)
	{
		this.chessPiece=chessman;
		this.fieldCoordinates = new FieldCoordinates(x, y);
	}
	
	public ChessPiece getChessPiece()
	{
		return this.chessPiece;
	}
	
	public void setChessPiece(ChessPiece chessman)
	{
		this.chessPiece = chessman;
	}
	
	public void removeChessPiece()
	{
		this.chessPiece=null;
	}
	
	public FieldCoordinates getFieldCoordintes(){
		return this.fieldCoordinates;
	}
	
}
