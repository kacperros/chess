package model.figures;

import model.FieldCoordinates;
import model.Model;

/**
 * Abstrakcyjna klasa, po której dziedziczą wszystkie figury.
 */

public abstract class ChessPiece {
	private FieldCoordinates fieldCoordinates;
	private boolean isAlive; 
	private final Model.Color color;
	private final Model.Name name;
	
	public ChessPiece(Model.Color color, Model.Name name) {
		this.color = color;
		this.name = name;
	}
	
	public Model.Name getName()
	{
		return this.name;
	}

	public Model.Color getColor() {
		return color;
	}

	public FieldCoordinates getFieldCoordinates() {
		return fieldCoordinates;
	}
	
	public void setFieldCoordinates(FieldCoordinates coordinates){
		this.fieldCoordinates = coordinates;
	}

	public boolean isAlive() {
		return isAlive;
	}
	
	public void setIsAlive(boolean isAlive){
		this.isAlive = isAlive;
	}
	
}

