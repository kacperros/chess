package model.figures;

import model.Board;
import model.Field;
import model.Model;

/**
 * Hetman
 * */

public class Queen extends ChessPiece{

	public Queen(Model.Color color) {
		super(color, Model.Name.Queen);
	}

	@Override
	public void movePiece(Board board, Field pieceField, Field targetField) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isInPossiblePath(Field pieceField, Field targetField) {
		// TODO Auto-generated method stub
		return false;
	}


}
