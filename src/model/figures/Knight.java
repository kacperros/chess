package model.figures;

import exceptions.InvalidMoveException;
import model.Board;
import model.Field;
import model.FieldCoordinates;
import model.Model;

/**
 * Koń
 * */
public class Knight extends ChessPiece {

	public Knight(Model.Color color, Board board) {
		super(color, Model.Name.Knight, board);
	}

	@Override
	public void movePiece(Field pieceField, Field targetField) throws InvalidMoveException {
		FieldCoordinates start = pieceField.getFieldCoordintes();
		FieldCoordinates end = targetField.getFieldCoordintes();
		int deltaX = Math.abs(end.x - start.x);
		int deltaY = Math.abs(end.y - start.y);
		if(!((deltaX == 1 && deltaY==2)||(deltaX==2 && deltaY==1)))
			throw new InvalidMoveException();
		if(targetField.getChessPiece() != null && this.getColor().equals(targetField.getChessPiece().getColor()))
			throw new InvalidMoveException();
		pieceField.removeChessPiece();
		targetField.setChessPiece(this);		
	}

	@Override
	public boolean isInPossiblePath(Field pieceField, Field targetField) {
		// TODO Auto-generated method stub
		return false;
	}


}
