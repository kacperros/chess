package algorithms;

import java.util.List;

import exceptions.SurrenderException;
import model.Move;
import model.game.Board;
import model.game.Player;

public interface ChessAlgorithm {
	public Move suggestMove(Board board, Player player, Player opponent, List<Move> movesAlreadySuggested) throws SurrenderException;
	
	public void moveAccepted();
}
