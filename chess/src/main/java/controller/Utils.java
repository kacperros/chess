package controller;

import model.Model;

public class Utils {
	
	public static Model.Color getOpposingColor(Model.Color color) {
		if (color.equals(Model.Color.white))
			return Model.Color.black;
		else
			return Model.Color.white;
	}

}
