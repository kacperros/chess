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

public class RandomAlgorithm implements ChessAlgorithm {

	Map<FieldCoordinates, ChessPiece> pieces;
	Random generator = new Random();
	

	@Override
	public Move suggestMove(Board board, Player player, List<Move> movesAlreadySuggested) throws SurrenderException {
		pieces = player.showPieces();
		List<FieldCoordinates> fields = new ArrayList<>();
		fields.addAll(pieces.keySet());
		int max = fields.size();
		for (int i = max; i > 0; i--) {
			int rand = generator.nextInt(fields.size());
			FieldCoordinates coords = fields.get(rand);
			Field candidateField = board.getFieldAbsolute(coords.x, coords.y);
			ChessPiece piece = candidateField.getChessPiece();
			List<Field> possibilities = piece.getPossibleMoves(candidateField);
			if(possibilities.size() != 0){
				int choice = generator.nextInt(possibilities.size());
				Move suggestedMove = new Move(candidateField, possibilities.get(choice));
				if(checkIfAlreadySuggested(movesAlreadySuggested, suggestedMove))
					continue;
				else					
					return suggestedMove;
			} else {
				fields.remove(rand);
			}
		}
		throw new SurrenderException();
	}

	private boolean checkIfAlreadySuggested(List<Move> movesAlreadySuggested, Move suggestedMove) {
		return movesAlreadySuggested.contains(suggestedMove);
		
	}

	@Override
	public void moveAccepted() {
		// TODO Auto-generated method stub
		
	}

}
