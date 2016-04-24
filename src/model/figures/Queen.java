package model.figures;

import java.util.List;

import exceptions.InvalidMoveException;
import model.Board;
import model.Field;
import model.FieldCoordinates;
import model.Model;

/**
 * Hetman
 * */

public class Queen extends ChessPiece{

	public Queen(Model.Color color, Board board) {
		super(color, Model.Name.Queen, board);
	}

	@Override
	public void movePiece(Field pieceField, Field targetField) throws InvalidMoveException {
		FieldCoordinates start = pieceField.getFieldCoordintes();
		FieldCoordinates end = targetField.getFieldCoordintes();
		int deltaX = end.x - start.x;
		int deltaY = end.y - start.y;
		if((deltaX == 0 && deltaY != 0)
				|| (deltaX != 0 && deltaY == 0)){
			moveLikeRook(pieceField, targetField);
			return;
		}
		if(Math.abs(deltaX)==Math.abs(deltaY)){
			moveLikeBishop(pieceField, targetField);
			return;
		}
		throw new InvalidMoveException();		
	}

	private void moveLikeRook(Field pieceField, Field targetField) throws InvalidMoveException{
		FieldCoordinates start = pieceField.getFieldCoordintes();
		FieldCoordinates end = targetField.getFieldCoordintes();
		int deltaX = end.x - start.x;
		int deltaY = end.y - start.y;
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
	

	private void moveLikeBishop(Field pieceField, Field targetField) throws InvalidMoveException{
		int deltaX = targetField.getFieldCoordintes().x - pieceField.getFieldCoordintes().x;
		int deltaY = targetField.getFieldCoordintes().y - pieceField.getFieldCoordintes().y;
		if(Math.abs(deltaX) != Math.abs(deltaY))
			throw new InvalidMoveException();
		int dx = deltaX/Math.abs(deltaX);
		int dy = deltaY/Math.abs(deltaY);
		int startX = pieceField.getFieldCoordintes().x;
		int startY = pieceField.getFieldCoordintes().y;
		Field nextField;
		for(int i = 1; i<= Math.abs(deltaX); i++){
			nextField = board.getField(startX + i*dx, startY + i*dy);
			if(nextField.getChessPiece() != null 
					&& (i != Math.abs(deltaX) 
						|| nextField.getChessPiece().getColor() == this.getColor())){
					throw new InvalidMoveException();
			}
		}
		pieceField.removeChessPiece();
		targetField.setChessPiece(this);		
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
