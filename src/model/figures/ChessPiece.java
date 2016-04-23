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
	protected Board board;

	public ChessPiece(Model.Color color, Model.Name name, Board board) {
		this.color = color;
		this.name = name;
		this.board = board;
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

	public abstract void movePiece(Field pieceField, Field targetField) throws InvalidMoveException;

	public abstract boolean isInPossiblePath(Field pieceField, Field targetField);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChessPiece other = (ChessPiece) obj;
		if (color != other.color)
			return false;
		if (name != other.name)
			return false;
		return true;
	}	
}
