package controller;

import exceptions.ImpossiblePathException;
import exceptions.InvalidMoveException;
import model.Board;
import model.Field;
import model.figures.ChessPiece;

public class ChessGame {
	
	private Board board;
	
	public ChessGame(Board board){
		this.board = board;
	}
	
	public void movePiece(Field startField, Field targetField) throws ImpossiblePathException, InvalidMoveException{
		ChessPiece movedPiece = startField.getChessPiece();
		if(!movedPiece.isMovePossible(startField, targetField) )
			throw new ImpossiblePathException();
		movedPiece.movePiece(startField, targetField);
	}

}
