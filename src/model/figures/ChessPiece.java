package model.figures;

import exceptions.InvalidMoveException;
import model.Board;
import model.Field;
import model.Model;

/**
 * Abstrakcyjna klasa, po której dziedziczą wszystkie figury.
 */

public abstract class ChessPiece {
	private boolean isAlive;
	private final Model.Color color;
	private final Model.Name name;

	public ChessPiece(Model.Color color, Model.Name name) {
		this.color = color;
		this.name = name;
	}

	public Model.Name getName() {
		return this.name;
	}

	public Model.Color getColor() {
		return color;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public abstract void movePiece(Board board, Field pieceField, Field targetField) throws InvalidMoveException;

	public abstract boolean isInPossiblePath(Field pieceField, Field targetField);

}
