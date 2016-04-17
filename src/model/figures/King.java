package model.figures;

import model.Board;
import model.Field;
import model.Model;
/**
 * Król
 * */
public class King extends ChessPiece{

	public King(Model.Color color) {
		super(color, Model.Name.King);
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
