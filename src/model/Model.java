package model;
/**
 * Model gry. Zawiera wszystkie struktury danych reprezentujace elementy gry i zasady
 * dotyczace rozgrywki.
 *
 */

public class Model {
	/** plansza */
	private Board board;
	
	public enum Color 
	{
		white,
		black
	}
	
	public enum Name 
	{
		whitePawn,
		whiteRook,
		whiteKnight,
		whiteBishop,
		whiteQueen,
		whiteKing,
		blackPawn,
		blackRook,
		blackKnight,
		blackBishop,
		blackQueen,
		blackKing
	}
	
	
	public Model()
	{
		this.board = new Board();
	}
	
	public Board getBoard()
	{
		return this.board;
	}
}
