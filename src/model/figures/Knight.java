package model.figures;

import model.Chessman;
import model.Model;
import model.Model.Color;
import model.Model.Name;

/**
 * Koń
 * */
public class Knight extends Chessman {

	public Knight(Model.Color color, Model.Name name) {
		super(color, name);
	}
	/**
	@Override
	public String getName() {
		
		return this.color.toString() + "Knight";
	}
	*/
}
