package model.figures;

import model.Board;
import model.Field;
import model.Model;

/**
 * Koń
 * */
public class Knight extends ChessPiece {

	public Knight(Model.Color color, Board board) {
		super(color, Model.Name.Knight, board);
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
