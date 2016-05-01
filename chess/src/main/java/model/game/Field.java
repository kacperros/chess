package model.game;

import model.figures.ChessPiece;

public class Field {
	
	private ChessPiece chessPiece;
	private FieldCoordinates fieldCoordinates;
	private final FieldCoordinates permanentCoordinates;
	
	public Field(int x, int y)
	{
		this.chessPiece=null;
		this.fieldCoordinates = new FieldCoordinates(x, y);
		this.permanentCoordinates = new FieldCoordinates(x, y);
	}
	
	public Field(int x, int y, ChessPiece chessman)
	{
		this.chessPiece=chessman;
		this.fieldCoordinates = new FieldCoordinates(x, y);
		this.permanentCoordinates = new FieldCoordinates(x, y);
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
	
	public void setFieldCoordinates(int x, int y){
		this.fieldCoordinates.x = x;
		this.fieldCoordinates.y = y;
	}
	
	public FieldCoordinates getPermanentCoordinates(){
		return this.permanentCoordinates;
	}
}
