package model.figures;

import model.Board;
import model.Field;
import model.Model;

/**
 * Wieża
 * */
public class Rook extends ChessPiece {

	public Rook(Model.Color color, Board board) {
		super(color, Model.Name.Rook, board);
	}

	@Override
	public void movePiece(Field pieceField, Field targetField) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isInPossiblePath(Field pieceField, Field targetField) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
