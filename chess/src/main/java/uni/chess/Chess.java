package uni.chess;

import java.util.Scanner;

import controller.HumanComputerGameController;
import controller.HumanVsRandom;
import model.Model;
import view.View;

public class Chess {

	public static void main(String[] args) {

		HumanComputerGameController game = new HumanComputerGameController(Model.Color.white);
		System.out.println("wybierz opcje: \n1.Losowy vs MinMax \n2.Ty vs MinMax \n3.Ty vs Losowy ");
		Scanner read = new Scanner(System.in);
		String decision = read.nextLine();

		if (decision.equals("1")) {

		} else if (decision.equals("2")) {
			read.close();
			int coords[] = new int[2];
			for (int i = 0; i < 2; ++i)
				coords[i] = -1;
			long times[] = new long[2];
			game.setControllerToMinMax();
			View view = new View(game.getBoard(), coords, times);

			HumanVsRandom human = new HumanVsRandom(game, view, coords, times);

			human.play();

		} else if (decision.equals("3")) {
			read.close();
			int coords[] = new int[2];
			for (int i = 0; i < 2; ++i)
				coords[i] = -1;
			long times[] = new long[2];
			game.setControllerToRandom();
			
			View view = new View(game.getBoard(), coords, times);

			HumanVsRandom human = new HumanVsRandom(game, view, coords, times);

			human.play();

		} else {
			System.out.println("Zly wybor, uruchom ponownie");
		}

	}

}