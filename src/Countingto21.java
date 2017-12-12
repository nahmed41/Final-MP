/**
 * It is an interesting math game.
 * Two players take turns to call out integers .
 * The number of integers must less than or equals to 3.
 * And the integers called out must be increasing by 1.
 * This rule is implemented by choosing the step ranging from 1 to 3.
 * The one calls out 21 is the winner.
 * For example:
 * P1: 1,2,3
 * P2: 4
 * P1: 5
 * P2: 6,7,8
 * P1: 9,10
 * P2: 11,12
 * P1: 13,14
 * P2: 15,16
 * P1: 17,18,19
 * P2: 20,21
 * In the above example player2 wins the game
 * You can choose to play with dummy computer or a slightly smarter computer
 * Have fun!!!!
 * @author duanbaihe
 *
 */
public class Countingto21 {	private Player[] sequence = new Player[22];
	public Player[] getSequence() {
		return this.sequence;
	}
	private int currentPlace = 0;
	// the index of the currentPlace
	private boolean gameEnded;
	public boolean getGameEnded() {
		return this.gameEnded;
	}
	// making the Sequence and keep the first element empty
	// so that the highest index would be 21
	public void fillSequence(Player player1, Player player2, int step) {
		if (currentPlace + step >= 21) {
			for (int i = 21; i > currentPlace; i--) {
				this.sequence[i] = player1;
			}
			gameEnded = true;
			player1.setCanMove(false);
			currentPlace = 21;
			System.out.println(player1.getName() + " adds to 21, " + 
			player2.getName() +" win(s)" );
			
		} else {
			for (int i = currentPlace + 1; i <= currentPlace + step; i++ ) {
				this.sequence[i] = player1;
			}
			player1.setCanMove(false);
			player2.setCanMove(true);
			currentPlace = currentPlace + step;
			System.out.println(player1.getName() + " adds to " + currentPlace);
		}
	}
	public int stepSuper() {
		int step = 1;
		while (true) {
			if ((step + currentPlace) % 4 == 0) {
				return step;
			} else {
				step++;
			}
		}
	}
}


