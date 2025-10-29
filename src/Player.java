public class Player {
	private String first_name;
	private String last_name;
	private int points;
	
	public String getFirstName() {
		return this.first_name;
	}
	public String getLastName() {
		return this.last_name;
	}
	public Player(String first_name, String last_name) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.points = 0;
	}
	
	public String getFullName() {
        return this.getFirstName()+ " " + this.getLastName();
    }
	
	public void updateScore(int points) {
        this.points += points;
    }
	
	public int getScore() {
        return points;
    }
}
