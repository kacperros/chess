package model.figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.InvalidMoveException;
import model.Board;
import model.Field;
import model.Model;

public class BishopTest {
	private Board board;
	
	@Before
	public void setupBoard(){
		board = new Board();
		board.emptyBoard();
		Field testField = board.getField(3, 3);
		testField.setChessPiece(new Bishop(Model.Color.black, board));
	}
	
	@Test
	public void testMoveUpLeft() throws Exception{
		Field startField = board.getField(3, 3);
		ChessPiece bishop = startField.getChessPiece();
		bishop.movePiece(startField, board.getField(1, 5));
		
		Field testField = board.getField(1, 5);
		assertTrue(testField.getChessPiece().getName().equals(bishop.getName()));
		assertTrue(testField.getChessPiece().getColor().equals(bishop.getColor()));
	}
	
	@Test
	public void testMoveUpRight() throws Exception{
		Field startField = board.getField(3, 3);
		ChessPiece bishop = startField.getChessPiece();
		bishop.movePiece(startField, board.getField(6,6));
		
		Field testField = board.getField(6,6);
		assertTrue(testField.getChessPiece().getName().equals(bishop.getName()));
		assertTrue(testField.getChessPiece().getColor().equals(bishop.getColor()));
	}
	
	@Test
	public void testMoveDownLeft() throws Exception{
		Field startField = board.getField(3, 3);
		ChessPiece bishop = startField.getChessPiece();
		bishop.movePiece(startField, board.getField(0, 0));
		
		Field testField = board.getField(0, 0);
		assertTrue(testField.getChessPiece().getName().equals(bishop.getName()));
		assertTrue(testField.getChessPiece().getColor().equals(bishop.getColor()));
	}
	
	@Test
	public void testMoveDownRight() throws Exception{
		Field startField = board.getField(3, 3);
		ChessPiece bishop = startField.getChessPiece();
		bishop.movePiece(startField, board.getField(6, 0));
		
		Field testField = board.getField(6, 0);
		assertTrue(testField.getChessPiece().getName().equals(bishop.getName()));
		assertTrue(testField.getChessPiece().getColor().equals(bishop.getColor()));
	}
	
	@Test (expected = InvalidMoveException.class)
	public void testMoveUpLeft_Obstacle() throws Exception{
		Field startField = board.getField(3, 3);
		Bishop bishop = (Bishop)startField.getChessPiece();
		board.getField(2, 4).setChessPiece(new Bishop(Model.Color.black, board));
		bishop.movePiece(startField, board.getField(1, 5));
	}
	
	@Test(expected = InvalidMoveException.class)
	public void testMoveUpRight_Obstacle() throws Exception{
		Field startField = board.getField(3, 3);
		ChessPiece bishop = startField.getChessPiece();
		board.getField(4, 4).setChessPiece(new Bishop(Model.Color.black, board));
		bishop.movePiece(startField, board.getField(6,6));
	}
	
	@Test(expected = InvalidMoveException.class)
	public void testMoveDownLeft_Obstacle() throws Exception{
		Field startField = board.getField(3, 3);
		ChessPiece bishop = startField.getChessPiece();
		board.getField(1, 1).setChessPiece(new Bishop(Model.Color.black, board));
		bishop.movePiece( startField, board.getField(0, 0));
	}
	
	@Test(expected = InvalidMoveException.class)
	public void testMoveDownRight_Obstacle() throws Exception{
		Field startField = board.getField(3, 3);
		ChessPiece bishop = startField.getChessPiece();
		board.getField(5,1).setChessPiece(new Bishop(Model.Color.black, board));
		bishop.movePiece(startField, board.getField(6, 0));
	}
	
	@Test(expected = InvalidMoveException.class)
	public void testInvalidMove() throws Exception{
		Field startField = board.getField(3, 3);
		ChessPiece bishop = startField.getChessPiece();
		bishop.movePiece(startField, board.getField(3, 0));
	}
	
	@Test(expected = InvalidMoveException.class)
	public void testKill() throws Exception{
		Field startField = board.getField(3, 3);
		ChessPiece bishop = startField.getChessPiece();
		board.getField(6, 6).setChessPiece(new Rook(Model.Color.black, board));
		bishop.movePiece(startField, board.getField(6,6));
	}
	
	@Test
	public void testKillValid() throws Exception{
		Field startField = board.getField(3, 3);
		ChessPiece bishop = startField.getChessPiece();
		board.getField(6, 6).setChessPiece(new Rook(Model.Color.white, board));
		bishop.movePiece(startField, board.getField(6,6));
		
		Field testField = board.getField(6, 6);
		assertTrue(testField.getChessPiece().getName().equals(bishop.getName()));
		assertTrue(testField.getChessPiece().getColor().equals(bishop.getColor()));
	}
}
