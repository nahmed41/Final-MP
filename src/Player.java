
public class Player {
	
	private String name;
	public void setName(String setName) {
		this.name = setName;
	}
	public String getName() {
		return this.name;
	}
	
	private boolean canMove;
	// true if it is the player's turn to move
	public void setCanMove(boolean setCanMove) {
		this.canMove = setCanMove;
	}
	public boolean getCanMove() {
		return this.canMove;
	}
	public Player(String setName) {
		this.name = setName;
	}
}


