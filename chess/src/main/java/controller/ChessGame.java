package controller;

import java.util.HashMap;
import java.util.Map;

import exceptions.ImpossiblePathException;
import exceptions.InvalidMoveException;
import logger.MoveLogger;
import model.Model;
import model.figures.ChessPiece;
import model.game.Board;
import model.game.Field;
import model.game.MoveResult;
import model.game.Player;

public class ChessGame {
	
	private Board board;
	private MoveLogger logger;
	private Model.Color currentPlayerColor;
	private Map<Model.Color, Player> players = new HashMap<>();
	
	public ChessGame(Board board, MoveLogger logger, Model.Color startingColor){
		this.board = board;
		this.logger = logger;
		this.currentPlayerColor = startingColor;
		board.renumberFieldsColorBottom(startingColor);
	}
	
	public void takeBack(){
		
	}
	
	public void suggest(){
		
	}
	
	public MoveResult movePieceAndLogMove(Field startField, Field targetField) throws ImpossiblePathException, InvalidMoveException {
		MoveResult moveResult;
		checkMovePreconditions(startField);
		logger.beginLogTransaction(startField, targetField);
		movePiece(startField, targetField);
		moveResult = checkMoveExtraResults();
		updatePlayers(startField, targetField);
		logger.commitLogTransaction(moveResult);
		switchPlayers();
		board.renumberFields();
		return moveResult;		
	}
	
	private void checkMovePreconditions(Field startField) throws InvalidMoveException {
		if(startField.getChessPiece() == null)
			throw new InvalidMoveException();
		if(!startField.getChessPiece().getColor().equals(currentPlayerColor))
			throw new InvalidMoveException();		
	}
	
	private MoveResult checkMoveExtraResults() throws InvalidMoveException {
		if(isPlayerChecked(currentPlayerColor)){
			revertMove();
			throw new InvalidMoveException();
		}
		if(isPlayerChecked(getOpponentColor())){
			if(isPlayerMated(getOpponentColor()))
				return MoveResult.CHECK_MATE;
			else
				return MoveResult.CHECK;
		}
		if(isPlayerMated(getOpponentColor()))
			return MoveResult.MATE;
		return MoveResult.OK;
	}

	private void updatePlayers(Field startField, Field endField){
		for(Map.Entry<Model.Color, Player> entry : players.entrySet())
			entry.getValue().update(startField, endField);
	}

	private void movePiece(Field startField, Field targetField) throws ImpossiblePathException, InvalidMoveException{
		ChessPiece movedPiece = startField.getChessPiece();
		if(!movedPiece.isMovePossible(startField, targetField) )
			throw new ImpossiblePathException();
		movedPiece.movePiece(startField, targetField);
	}
	
	private void revertMove(){
		
	}
	
	public boolean isPlayerChecked(Model.Color color){
		return false;
	}
	
	public boolean isPlayerMated(Model.Color color){
		return false;
	}
	
	private void switchPlayers(){
		if(Model.Color.white.equals(currentPlayerColor))
			currentPlayerColor = Model.Color.black;
		else
			currentPlayerColor = Model.Color.white;
	}
	
	private Model.Color getOpponentColor(){
		if(currentPlayerColor.equals(Model.Color.white))
			return Model.Color.black;
		else
			return Model.Color.white;
	}

}
