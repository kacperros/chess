package model.figures;

import model.Chessman;
import model.Model;
import model.Model.Color;
import model.Model.Name;

/**
 * Wieża
 * */
public class Rook extends Chessman {

	public Rook(Model.Color color, Model.Name name) {
		super(color, name);
	}
	
	/**
	@Override
	public String getName() {
		return this.color.toString() + "Rook";
	}
	*/
}
