package model;

/**
 * Abstrakcyjna klasa, po której dziedziczą wszystkie figury.
 */

public abstract class Chessman {
	/**	polozenie - wspolrzedna x */
	int x;
	/**	polozenie - wspolrzedna y */
	int y;
	/**	parametr mowiacy czy dana figura zyje */
	boolean life; 
	/**	kolor figury*/
	Model.Color color;
	/**	pełna nazwa figury */
	Model.Name name;
	
	//public abstract String getName();
	
	public Chessman(Model.Color color, Model.Name name) {
		this.color = color;
		this.name = name;
	}
	
	public Model.Name getName()
	{
		return this.name;
	};
}

