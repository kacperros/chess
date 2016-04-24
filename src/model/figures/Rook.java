package model.figures;

import java.util.List;

import exceptions.InvalidMoveException;
import model.Board;
import model.Field;
import model.FieldCoordinates;
import model.Model;

/**
 * Wieża
 * */
public class Rook extends ChessPiece {

	public Rook(Model.Color color, Board board) {
		super(color, Model.Name.Rook, board);
	}

	@Override
	public void movePiece(Field pieceField, Field targetField) throws InvalidMoveException{
		FieldCoordinates start = pieceField.getFieldCoordintes();
		FieldCoordinates end = targetField.getFieldCoordintes();
		int deltaX = end.x - start.x;
		int deltaY = end.y - start.y;
		if(deltaX != 0 && deltaY != 0)
			throw new InvalidMoveException();
		Field nextField;
		int dx = setDerivativeChange(deltaX);
		int dy = setDerivativeChange(deltaY);
		int delta =  Math.abs(Math.max(Math.abs(deltaX), Math.abs(deltaY)));
		for(int i = 1; i <= delta ; i++){
			nextField = board.getField(start.x + i*dx, start.y+i*dy);
			if(nextField.getChessPiece() != null 
					&& (i != delta 
					|| nextField.getChessPiece().getColor() == this.getColor()))
				throw new InvalidMoveException();
		}
		pieceField.removeChessPiece();
		targetField.setChessPiece(this);		
	}

	private int setDerivativeChange(int delta) {
		if(delta == 0)
			return 0;
		else
			return delta/Math.abs(delta);
	}

	@Override
	public boolean isInPossiblePath(Field pieceField, Field targetField) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Field> possibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
