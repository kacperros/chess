package controller;

import algorithms.ChessAlgorithm;
import algorithms.RandomAlgorithm;
import exceptions.InvalidMoveException;
import exceptions.SurrenderException;
import logger.MoveLogger;
import model.Model;
import model.Move;
import model.game.Board;
import model.game.MoveResult;
import model.game.Player;

public class HumanComputerGameController {
	private Board board;
	private ChessGame chessGame;
	private Player humanPlayer;
	private ArtificialPlayer artificialOpponent;
	private ChessAlgorithm chessAlgorithm;
	private MoveLogger logger;

	public HumanComputerGameController(Model.Color playerColor) {
		board = new Board();
		chessAlgorithm = new RandomAlgorithm();
		humanPlayer = new Player(playerColor, board);
		artificialOpponent = new ArtificialPlayer(getOpposingColor(playerColor), board, chessAlgorithm);
		logger = new MoveLogger();
		chessGame = new ChessGame(board, logger, playerColor, humanPlayer, artificialOpponent);
	}
	
	public MoveResult playerMove(Move move) throws InvalidMoveException {
		return chessGame.movePieceAndLogMove(move.startField, move.endField);
	}
	
	public MoveResult opponentMove() throws SurrenderException {		
		Move suggestedMove = null;
		while(true){
			try{
				suggestedMove = artificialOpponent.move();
				MoveResult result = chessGame.movePieceAndLogMove(suggestedMove.startField, suggestedMove.endField);
				artificialOpponent.acceptMove();
				return result;
			} catch (InvalidMoveException invalidMoveException){
				artificialOpponent.denyMove(suggestedMove);
				continue;
			}
		}
	}

	private Model.Color getOpposingColor(Model.Color color) {
		if (color.equals(Model.Color.white))
			return Model.Color.black;
		else
			return Model.Color.white;
	}
	
	public Board getBoard(){
		return board;
	}
	
	public void printLoggerHistory(){
		logger.printHistory();
	}

}
