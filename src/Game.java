
public class Game {
	public static int stepHuman() {
		int step;
		do {
			System.out.println("please enter your step ranging from 1 to 3");
			step = TextIO.getInt();
		} while (step < 1 || step > 3);
		return step;
	}
	public static int stepDummy() {
		return (int) (3 * Math.random()) + 1;
	}
	public static void main(String[] args) {
		System.out.println("  It is an interesting math game.\n" + 
				"  Two players take turns to call out integers .\n" + 
				"  The number of integers must less than or equals to 3.\n" + 
				"  And the integers called out must be increasing by 1.\n" + 
				"  This rule is implemented by choosing the step ranging from 1 to 3.\n" + 
				"  The one forced to calls out 21 lose the game.\n" + 
				"  For example:\n" + 
				"  P1: 1,2,3\n" + 
				"  P2: 4\n" + 
				"  P1: 5\n" + 
				"  P2: 6,7,8\n" + 
				"  P1: 9,10\n" + 
				"  P2: 11,12\n" + 
				"  P1: 13,14\n" + 
				"  P2: 15,16\n" + 
				"  P1: 17,18,19\n" + 
				"  P2: 20,21\n" + 
				"  In the above example player2 loses the game\n" + 
				"  You can choose to play with dummy computer or super Intelligent computer\n" + 
				"  Have fun!!!!");
		System.out.println();
		System.out.println("Are you ready to start?\nYou can answer Y or N");
		boolean boo = TextIO.getBoolean();
		if (!boo) { 
			System.out.println("See you");
		} else {
			int computerChoice;
			do {
				System.out.println("please choose the computer you wanna fight against\n"
					+ "enter 1 for dummy or 2 for super intelligent");
				computerChoice = TextIO.getInt();
			} while (computerChoice != 1 && computerChoice != 2);
			Player computer = new Player("Computer");
			computer.setCanMove(false);
			Player human = new Player("You");
			human.setCanMove(true);
			Countingto21 gameBoard = new Countingto21();
			while (!gameBoard.getGameEnded()) {
				if (human.getCanMove()) {
					gameBoard.fillSequence(human, computer, stepHuman());
				} else if (computerChoice == 1) {
					gameBoard.fillSequence(computer, human, stepDummy());
				} else {
					gameBoard.fillSequence(computer, human, gameBoard.stepSuper());
				}
			}// while
			if (gameBoard.getSequence()[21].getName().equals("You")) {
				System.out.println("poor, pathetic humanbeings, the future belongs to machine\n"
					+ "you will see that coming soon"); 
			} else {
				System.out.println("You coward, I know you choose to fight dummy computer\n"
						+ "this proves nothing\n"
						+ "the future still belongs to machine");
			}
		}// big if and else
	}// main
}
