package model.game;

import java.util.ArrayList;
import java.util.List;

import model.Model;

public class Player {
	private final Model.Color color;
	private final List<PieceFieldPair> piecesInPlay = new ArrayList<>();
	
	public Player(Model.Color color){
		this.color = color;
	}

	public void update(Field startField, Field endField) {
		// TODO Auto-generated method stub
		
	}
	

}
