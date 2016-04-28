package model.figures;

import java.util.List;

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
		if(!isMovePossible(pieceField, targetField))
			throw new InvalidMoveException();
		pieceField.removeChessPiece();
		targetField.setChessPiece(this);		
	}

	@Override
	public boolean isMovePossible(Field pieceField, Field targetField) {
		FieldCoordinates start = pieceField.getFieldCoordintes();
		FieldCoordinates end = targetField.getFieldCoordintes();
		int deltaX = Math.abs(end.x - start.x);
		int deltaY = Math.abs(end.y - start.y);
		if(!((deltaX == 1 && deltaY==2)||(deltaX==2 && deltaY==1)))
			return false;
		if(targetField.getChessPiece() != null && this.getColor().equals(targetField.getChessPiece().getColor()))
			return false;
		return true;
	}

	@Override
	public List<Field> possibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}


}
