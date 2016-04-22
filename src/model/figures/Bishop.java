package model.figures;

import exceptions.InvalidMoveException;
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
	public void movePiece(Board board, Field pieceField, Field targetField) throws InvalidMoveException{
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
		targetField.removeChessPiece();
		targetField.setChessPiece(this);	
	}

	@Override
	public boolean isInPossiblePath(Field pieceField, Field targetField) {
		// TODO Auto-generated method stub
		return false;
	}

}