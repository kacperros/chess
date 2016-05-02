package uni.chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.HumanComputerGameController;
import model.Model.Color;
import model.Move;
import model.game.Board;
import model.game.MoveResult;

public class HumanComputerGameControllerTest {
	private HumanComputerGameController controller;
	private Board board;
	
	@Before
	public void initController(){
		controller = new HumanComputerGameController(Color.white);
		board = controller.getBoard();
	}
	
	@Test
	public void testFourMoveOpening() throws Exception{
		Move whiteMove1 = new Move(board.getFieldAbsolute(4, 1), board.getFieldAbsolute(4, 3));
		controller.playerMove(whiteMove1);
		
		MoveResult result = controller.opponentMove();
		assertTrue(result.equals(MoveResult.OK));
		
		Move whiteMove2 = new Move(board.getFieldAbsolute(5, 0), board.getFieldAbsolute(4, 1));
		controller.playerMove(whiteMove2);
		
		result = controller.opponentMove();
		assertTrue(result.equals(MoveResult.OK));
		
		controller.printLoggerHistory();
	}
	

}
