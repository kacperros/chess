package controller;

import java.util.ArrayList;
import java.util.List;

import algorithms.ChessAlgorithm;
import exceptions.SurrenderException;
import model.Model.Color;
import model.Move;
import model.game.Board;
import model.game.Player;

public class ArtificialPlayer extends Player{
	private final ChessAlgorithm algorithm;
	private List<Move> suggestedMovesThisTurn = new ArrayList<>();
	private final Player opponent;

	public ArtificialPlayer(Color color, Board board, Player opponent, ChessAlgorithm chessAlgorithm) {
		super(color, board);
		this.algorithm = chessAlgorithm;
		this.opponent = opponent;
	}
	
	public Move move() throws SurrenderException{
		return algorithm.suggestMove(board, this, opponent, suggestedMovesThisTurn);
	}
	
	public boolean denyMove(Move move){
		suggestedMovesThisTurn.add(move);
		if(suggestedMovesThisTurn.size() > 5000)
			return true;
		return false;
	}
	
	public void acceptMove(){
		suggestedMovesThisTurn.clear();
	}

}
