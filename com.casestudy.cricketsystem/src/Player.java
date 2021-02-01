import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
	private String name;
	private int age;
	private PlayerType roll = PlayerType.BATSMEN;
	private static String playFor = "Unplaced";//make position
	
	public Player() {}
	
	public Player(String playerName) {
		this.name = playerName;
	}

	public void createPlayer(Cricket cricket) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader get = new BufferedReader(in);

		System.out.println("Enter Player Name: ");
		name = get.readLine();
		System.out.println("Enter Player Age: ");
		age = Integer.parseInt(get.readLine());

		System.out.println("Enter Player Roll: ");
		System.out.println("1.Batsmen");
		System.out.println("2.Bowler");
		System.out.println("3.All Rounder");
		System.out.println("4.Wicket Keeper");
		int playerRoll = Integer.parseInt(get.readLine());
		switch(playerRoll) {
			case 1:
				roll = PlayerType.BATSMEN;
				break;
			case 2:
				roll = PlayerType.BOWLER;
				break;
			case 3:
				roll = PlayerType.ALL_ROUNDER;
				break;
			case 4:
				roll = PlayerType.WICKET_KEEPER;
				break;
			default:
				break;
		}
		
		System.out.println("For which team he plays: ");
		String teamName = get.readLine();
		if (cricket.verifyTeam(teamName)) {
			playFor = teamName;
		} else {
			System.out.println("Their is no team by the name " + teamName);
			playFor = "Unplaced";
		}
		System.out.println("Player created successfully");
	}

	public void showPlayerDetails() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(roll);
		System.out.println(playFor);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getPlayFor() {
		return playFor;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void setPlayFor(String playFor) {
		Player.playFor = playFor;
	}
}
