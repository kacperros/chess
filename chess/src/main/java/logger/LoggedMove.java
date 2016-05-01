package logger;

import model.Model;
import model.game.FieldCoordinates;
import model.game.MoveResult;

public class LoggedMove {
	public Model.Color playerColor;
	public Model.Name movingChessPiece;
	public FieldCoordinates startPosition;
	public FieldCoordinates endPosition;
	public MoveResult moveResult;
	public Model.Name pieceKilled;
}
