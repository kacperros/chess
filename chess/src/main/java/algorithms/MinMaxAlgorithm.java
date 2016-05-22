package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import exceptions.SurrenderException;
import model.Move;
import model.figures.ChessPiece;
import model.game.Board;
import model.game.Field;
import model.game.FieldCoordinates;
import model.game.Player;

public class MinMaxAlgorithm implements ChessAlgorithm {

	Map<FieldCoordinates, ChessPiece> pieces;
	Random generator = new Random();

	@Override
	public Move suggestMove(Board board, Player player, Player opponent, List<Move> movesAlreadySuggested) throws SurrenderException {
		Move pickedMove = null;
		pieces = player.showPieces();
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
					if (pickedMove == null || suggestedMove.moveValue > pickedMove.moveValue) {
						pickedMove = suggestedMove;
					}
				}
			}
		}

		if(pickedMove != null && pickedMove.moveValue != 0){
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
						if (checkIfAlreadySuggested(movesAlreadySuggested, suggestedMove)){
							k++;
							continue;
						}
						else
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
		// TODO Auto-generated method stub

	}

}
