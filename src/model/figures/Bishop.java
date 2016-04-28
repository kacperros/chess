package model.figures;

import java.util.List;

import exceptions.InvalidMoveException;
import model.Board;
import model.Field;
import model.Model;

/**
 * Goniec
 * */
public class Bishop extends ChessPiece {

	public Bishop(Model.Color color, Board board) {
		super(color, Model.Name.Bishop, board);
	}

	@Override
	public void movePiece(Field pieceField, Field targetField) throws InvalidMoveException{
		if (!isMovePossible(pieceField, targetField))
			throw new InvalidMoveException();
		else {
			pieceField.removeChessPiece();
			targetField.setChessPiece(this);
		}
	}

	@Override
	public boolean isMovePossible(Field pieceField, Field targetField) {
		int deltaX = targetField.getFieldCoordintes().x - pieceField.getFieldCoordintes().x;
		int deltaY = targetField.getFieldCoordintes().y - pieceField.getFieldCoordintes().y;
		if(Math.abs(deltaX) != Math.abs(deltaY))
			return false;
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
					return false;
			}
		}
		return true;
	}

	@Override
	public List<Field> possibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}