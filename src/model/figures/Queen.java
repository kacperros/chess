package model.figures;

import model.Chessman;
import model.Model;
import model.Model.Color;
import model.Model.Name;

/**
 * Hetman
 * */

public class Queen extends Chessman{

	public Queen(Model.Color color, Model.Name name) {
		super(color, name);
	}
	/**
	@Override
	public String getName() {
		return this.color.toString() + "Queen";
	}
	*/
}
