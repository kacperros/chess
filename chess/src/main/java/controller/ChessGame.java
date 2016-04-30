package controller;

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
	
	public ChessGame(Board board, MoveLogger logger, Model.Color color){
		this.board = board;
		this.logger = logger;
		this.currentPlayerColor = color;
	}
	
	public void takeBack(){
		
	}
	
	public void suggest(){
		
	}
	
	public MoveResult movePieceAndLogMove(Field startField, Field targetField) throws ImpossiblePathException, InvalidMoveException {
		MoveResult moveResult;
		if(startField.getChessPiece() == null)
			throw new InvalidMoveException();
		if(!startField.getChessPiece().getColor().equals(currentPlayerColor))
			throw new InvalidMoveException();
		logger.beginLogTransaction(startField, targetField);
		movePiece(startField, targetField);
		if(isPlayerChecked(currentPlayerColor)){
			revertMove();
			throw new InvalidMoveException();
		}
		if(isPlayerChecked(getOpponentColor())){
			if(isPlayerMated(getOpponentColor()))
				moveResult = MoveResult.CHECK_MATE;
			else
				moveResult = MoveResult.CHECK;
		}
		if(isPlayerMated(getOpponentColor()))
			moveResult = MoveResult.MATE;
		moveResult = MoveResult.OK;
		logger.commitLogTransaction(startField, targetField, moveResult);
		switchPlayers();
		return moveResult;		
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
