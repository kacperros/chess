package model.figures;

import java.util.List;

import exceptions.InvalidMoveException;
import model.Board;
import model.Field;
import model.FieldCoordinates;
import model.Model;

/**
 * Pionek
 */
public class Pawn extends ChessPiece {

	public Pawn(Model.Color color, Board board) {
		super(color, Model.Name.Pawn, board);
	}

	@Override
	public void movePiece(Field pieceField, Field targetField) throws InvalidMoveException {
		FieldCoordinates startCoordinates = pieceField.getFieldCoordintes();
		FieldCoordinates endCoordinates = targetField.getFieldCoordintes();
		if (startCoordinates.x == endCoordinates.x && startCoordinates.y == endCoordinates.y - 1) {
			if (targetField.getChessPiece() != null)
				throw new InvalidMoveException();
			else {
				pieceField.removeChessPiece();
				targetField.setChessPiece(this);
				return;
			}
		}
		if (startCoordinates.x == endCoordinates.x 
				&& startCoordinates.y == endCoordinates.y - 2
				&& startCoordinates.y == 1){
			Field transitField = board.getField(startCoordinates.x, 2);
			if(transitField.getChessPiece() != null || targetField.getChessPiece() != null)
				throw new InvalidMoveException();
			else {
				pieceField.removeChessPiece();
				targetField.setChessPiece(this);
				return;
			}				
		}
		if (Math.abs(startCoordinates.x - endCoordinates.x) == 1 
				&& startCoordinates.y == endCoordinates.y - 1
				&& targetField.getChessPiece() != null 
				&& targetField.getChessPiece().getColor() != getColor()){
			pieceField.removeChessPiece();
			targetField.setChessPiece(this);
			return;
		}
		throw new InvalidMoveException();
	}

	@Override
	public boolean isMovePossible(Field pieceField, Field targetField) {
		FieldCoordinates startCoordinates = pieceField.getFieldCoordintes();
		FieldCoordinates endCoordinates = targetField.getFieldCoordintes();
		if (startCoordinates.x == endCoordinates.x 
				&& startCoordinates.y == endCoordinates.y - 1)
			return true;
		if (startCoordinates.x == endCoordinates.x 
				&& startCoordinates.y == endCoordinates.y - 2
				&& startCoordinates.y == 1)
			return true;
		if (Math.abs(startCoordinates.x - endCoordinates.x) == 1 
				&& startCoordinates.y == endCoordinates.y - 1
				&& targetField.getChessPiece() != null 
				&& targetField.getChessPiece().getColor() != getColor())
			return true;
		return false;
	}

	@Override
	public List<Field> possibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}
}
