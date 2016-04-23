package model.figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.InvalidMoveException;
import model.Board;
import model.Field;
import model.Model;

public class KnightTest {
	
	private Board board;
	
	@Before
	public void setupBoard(){
		board = new Board();
		board.emptyBoard();
		Field testField = board.getField(3, 3);
		testField.setChessPiece(new Knight(Model.Color.black, board));
		board.getField(3, 2).setChessPiece(new Pawn(Model.Color.black, board));
	}
	
	@Test
	public void correctMove() throws Exception{
		Field startField = board.getField(3, 3);
		Field targetField = board.getField(4, 1);
		ChessPiece knight = startField.getChessPiece();
		knight.movePiece(startField, targetField);
		
		assertTrue(board.getField(3, 2).getChessPiece() != null);
		assertTrue(board.getField(4, 1).getChessPiece().equals(knight));
	}
	
	@Test(expected = InvalidMoveException.class)
	public void incorrectMove() throws Exception{
		Field startField = board.getField(3, 3);
		Field targetField = board.getField(5, 1);
		ChessPiece knight = startField.getChessPiece();
		knight.movePiece(startField, targetField);
	}
	
	@Test(expected = InvalidMoveException.class)
	public void inValidKill() throws Exception{
		Field startField = board.getField(3, 3);
		Field targetField = board.getField(4, 1);
		ChessPiece knight = startField.getChessPiece();
		targetField.setChessPiece(new Pawn(Model.Color.black, board));
		knight.movePiece(startField, targetField);
	}
	
	@Test
	public void validKill() throws Exception{
		Field startField = board.getField(3, 3);
		Field targetField = board.getField(4, 1);
		ChessPiece knight = startField.getChessPiece();
		targetField.setChessPiece(new Pawn(Model.Color.white, board));
		knight.movePiece(startField, targetField);
		
		assertTrue(board.getField(3, 3).getChessPiece() == null);
		assertTrue(board.getField(4, 1).getChessPiece().equals(knight));
	}

}
