package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.plaf.SliderUI;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import controller.ChessGame;
import exceptions.InvalidMoveException;
import exceptions.SurrenderException;
import model.Move;
import model.figures.ChessPiece;
import model.game.Board;
import model.game.Field;
import model.game.FieldCoordinates;
import model.game.Player;

public class MinMaxAlgorithm implements ChessAlgorithm {

	private Map<FieldCoordinates, ChessPiece> pieces;
	private final Random generator = new Random();
	private final Board board;
	private final Player player;
	private final Player opponent;
	private final List<Move> movesAlreadySuggested = new ArrayList<>();
	private final ChessGame chessGame;
	private int depth = 2;

	public MinMaxAlgorithm(Board board, Player player, Player opponent, ChessGame chessgame) {
		this.board = board;
		this.player = player;
		this.opponent = opponent;
		this.chessGame = chessgame;
	}

	@Override
	public Move suggestMove() throws SurrenderException {
		depth = depth - 1;
		Move pickedMove = null;
		if (depth % 2 == 0) {
			pieces = opponent.showPieces();
		} else {
			pieces = player.showPieces();
		}
		List<FieldCoordinates> listOfFieldCoordinates = new ArrayList<>();
		listOfFieldCoordinates.addAll(pieces.keySet());
		for (FieldCoordinates fieldCoordinates : listOfFieldCoordinates) {
			Field candidateField = board.getFieldAbsolute(fieldCoordinates.x, fieldCoordinates.y);
			ChessPiece piece = candidateField.getChessPiece();
			List<Field> possibilitiesFields = piece.getPossibleMoves(candidateField);
			for (Field field : possibilitiesFields) {
				Move suggestedMove = new Move(candidateField, field);
				if (checkIfAlreadySuggested(movesAlreadySuggested, suggestedMove)) {
					continue;
				} else {
					if (pickedMove == null) {
						pickedMove = suggestedMove;
					}

					if (depth >= 0) {
						try {
							chessGame.movePieceAndLogMove(suggestedMove.startField, suggestedMove.endField);
							if (depth % 2 == 0) {
								suggestedMove.moveValue += suggestMove().moveValue;
							} else {
								suggestedMove.moveValue -= suggestMove().moveValue;
							}
							chessGame.revertMove();
						} catch (InvalidMoveException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					if (suggestedMove.moveValue > pickedMove.moveValue) {
						pickedMove = suggestedMove;
					}
				}
			}
		}
		
		depth = depth + 1;

		if (pickedMove != null && pickedMove.moveValue > 0) {
			System.out.println(pickedMove.moveValue);
			return pickedMove;
		} else {
			movesAlreadySuggested.clear();
			int max = listOfFieldCoordinates.size();
			for (int i = max; i > 0; i--) {
				int random = generator.nextInt(listOfFieldCoordinates.size());
				FieldCoordinates fieldCoordinates = listOfFieldCoordinates.get(random);
				Field candidateField = board.getFieldAbsolute(fieldCoordinates.x, fieldCoordinates.y);
				ChessPiece piece = candidateField.getChessPiece();
				List<Field> possibilitiesFields = piece.getPossibleMoves(candidateField);
				if (possibilitiesFields.size() != 0) {
					int k = 0;
					while (k < possibilitiesFields.size() * 3) {
						int choice = generator.nextInt(possibilitiesFields.size());
						Move suggestedMove = new Move(candidateField, possibilitiesFields.get(choice));
						if (checkIfAlreadySuggested(movesAlreadySuggested, suggestedMove)) {
							k++;
							continue;
						} else
							return suggestedMove;
					}
				} else {
					listOfFieldCoordinates.remove(random);
				}
			}
			throw new SurrenderException();
		}
	}

	private boolean checkIfAlreadySuggested(List<Move> movesAlreadySuggested, Move suggestedMove) {
		return movesAlreadySuggested.contains(suggestedMove);

	}

	@Override
	public void moveAccepted() {
		movesAlreadySuggested.clear();

	}

	@Override
	public List<Move> getSuggestedMovesThisTurn() {
		return movesAlreadySuggested;
	}
}
