package model;

public class Field {
	
	private Chessman chessman;
	int x;
	int y;
	
	public Field(int x, int y)
	{
		this.chessman=null;
		this.x = x;
		this.y = y;
	}
	
	public Field(int x, int y, Chessman chessman)
	{
		this.chessman=chessman;
		this.x = x;
		this.y = y;
	}
	
	public Model.Name getName()
	{
		return this.chessman.getName();
	}
	/**
	public String getName()
	{
		if (this.chessman != null)
		{
			return this.chessman.getName();
		} 
		else 
		{
			return "brak";
		}
	}
	*/
	public void addChessman(Chessman chessman)
	{
		this.chessman=chessman;
	}
	
	public Chessman getChessman()
	{
		return this.chessman;
	}
	
	public void setChessman(Chessman chessman)
	{
		this.chessman = chessman;
	}
	
	public void removeChessman()
	{
		this.chessman=null;
	}
	
}
