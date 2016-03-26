package model.figures;

import model.Chessman;
import model.Model;
import model.Model.Color;
import model.Model.Name;

/**
 * Król
 * */
public class King extends Chessman{

	public King(Model.Color color, Model.Name name) {
		super(color, name);
	}
	/**
	@Override
	public String getName() {
		return this.color.toString() + "King";
	}
	*/

}
