package model.figures;

import model.Board;
import model.Field;
import model.Model;

/**
 * Goniec
 * */
public class Bishop extends ChessPiece {

	public Bishop(Model.Color color) {
		super(color, Model.Name.Bishop);
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