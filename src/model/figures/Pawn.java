package model.figures;

import model.Chessman;
import model.Model;
import model.Model.Color;
import model.Model.Name;

/**
 * Pionek
 * */
public class Pawn extends Chessman{

	public Pawn(Model.Color color, Model.Name name) {
		super(color, name);
	}
	/**
	@Override
	public String getName() {
		
		return this.color.toString() + "Pawn";
	}
	*/
}
