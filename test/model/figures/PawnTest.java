package model.figures;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.InvalidMoveException;
import model.Board;
import model.Field;
import model.Model;

public class PawnTest {

	@Test
	public void moveForewardOne() throws Exception{
		Board board = new Board();
		Field startField = board.getField(3, 1);
		Field endField = board.getField(3, 2);
		Pawn testPawn = (Pawn) startField.getChessPiece();
		
		testPawn.movePiece(board, startField, endField);
				
		assertTrue(endField.getChessPiece() != null);
		assertTrue(endField.getChessPiece().getColor().equals(Model.Color.white));
	}
	
	@Test (expected=InvalidMoveException.class)
	public void moveForewardOne_ObstaclePresent() throws Exception{
		Board board = new Board();
		Field startField = board.getField(3, 1);
		Field endField = board.getField(3, 2);
		Pawn testPawn = (Pawn) startField.getChessPiece();
		endField.setChessPiece(new Rook(Model.Color.black));
		
		testPawn.movePiece(board, startField, endField);		
	}
	
	@Test
	public void moveForewardTwo() throws Exception{
		Board board = new Board();
		Field startField = board.getField(3, 1);
		Field endField = board.getField(3, 3);
		Pawn testPawn = (Pawn) startField.getChessPiece();
		
		testPawn.movePiece(board, startField, endField);
				
		assertTrue(endField.getChessPiece() != null);
		assertTrue(endField.getChessPiece().getColor().equals(Model.Color.white));
	}
	
	@Test (expected=InvalidMoveException.class)
	public void moveForewardTwo_ObstaclePresent() throws Exception{
		Board board = new Board();
		Field startField = board.getField(3, 1);
		Field endField = board.getField(3, 3);
		Field transitField = board.getField(3, 2);
		transitField.setChessPiece(new Rook(Model.Color.black));
		Pawn testPawn = (Pawn) startField.getChessPiece();
		
		testPawn.movePiece(board, startField, endField);
	}
	
	@Test (expected=InvalidMoveException.class)
	public void moveForewardTwo_ObstaclePresentOnLastField() throws Exception{
		Board board = new Board();
		Field startField = board.getField(3, 1);
		Field endField = board.getField(3, 3);
		endField.setChessPiece(new Rook(Model.Color.black));
		Pawn testPawn = (Pawn) startField.getChessPiece();
		
		testPawn.movePiece(board, startField, endField);
	}
	
	@Test
	public void takeEnemyPiece() throws Exception{
		Board board = new Board();
		Field startField = board.getField(3, 1);
		Field endField = board.getField(4, 2);
		endField.setChessPiece(new Rook(Model.Color.black));
		Pawn testPawn = (Pawn) startField.getChessPiece();
		
		testPawn.movePiece(board, startField, endField);
	}
	
	@Test (expected = InvalidMoveException.class)
	public void takeOwnPiece() throws Exception{
		Board board = new Board();
		Field startField = board.getField(3, 1);
		Field endField = board.getField(4, 2);
		endField.setChessPiece(new Rook(Model.Color.white));
		Pawn testPawn = (Pawn) startField.getChessPiece();
		
		testPawn.movePiece(board, startField, endField);
	}

}
