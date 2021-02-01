import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Match {

	private String game;
	private String team1;
	private String team2;
	private int team1Runs;
	private int team2Runs;
	private int team1Wickets;
	private int team2Wickets;
	private String result;
	private String tempTeam1;
	private String tempTeam2;

	public void playMatch(Cricket cricket) throws IOException {

		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader get = new BufferedReader(in);

		System.out.println("Enter first team name:");
		tempTeam1 = get.readLine();
		if (cricket.verifyTeam(tempTeam1)) {
			team1 = tempTeam1;
		} else {
			System.out.println("Entered team is not present in system.");
		}

		System.out.println("Enter second team name:");
		tempTeam2 = get.readLine();
		if (cricket.verifyTeam(tempTeam2)) {
			team2 = tempTeam2;
		} else {
			System.out.println("Entered team is not present in system.");
		}

		System.out.println("Enter runs for: " + team1);
		team1Runs = Integer.parseInt(get.readLine());
		System.out.println("Enter wickets for: " + team1);
		team1Wickets = Integer.parseInt(get.readLine());
		System.out.println("Enter runs for: " + team2);
		team2Runs = Integer.parseInt(get.readLine());
		System.out.println("Enter wickets for: " + team2);
		team2Wickets = Integer.parseInt(get.readLine());

		game = team1 + " vs " + team2;
		System.out.println(game);

		if (team1Runs == team2Runs) {
			result = "Draw";
			System.out.println("Team: " + team1 + " scored " + team1Runs + " with " + team1Wickets + " wickets.");
			System.out.println("Team: " + team2 + " scored " + team2Runs + " with " + team2Wickets + " wickets.");
			System.out.println(result);
		} else if (team1Runs > team2Runs) {
			result = team1 + " wins.";
			System.out.println("Team: " + team1 + " scored " + team1Runs + " with " + team1Wickets + " wickets.");
			System.out.println("Team: " + team2 + " scored " + team2Runs + " with " + team2Wickets + " wickets.");
			System.out.println("Team " + result);
		} else {
			result = team2 + " wins.";
			System.out.println("Team: " + team1 + " scored " + team1Runs + " with " + team1Wickets + " wickets.");
			System.out.println("Team: " + team2 + " scored " + team2Runs + " with " + team2Wickets + " wickets.");
			System.out.println("Team " + result);
		}
	}

	public String getGame() {
		return game;
	}

	public String getTeam1() {
		return team1;
	}

	public String getTeam2() {
		return team2;
	}

	public int getTeam1Runs() {
		return team1Runs;
	}

	public int getTeam2Runs() {
		return team2Runs;
	}

	public int getTeam1Wickets() {
		return team1Wickets;
	}

	public int getTeam2Wickets() {
		return team2Wickets;
	}

	public String getResult() {
		return result;
	}

	public String getTempTeam1() {
		return tempTeam1;
	}

	public String getTempTeam2() {
		return tempTeam2;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public void setTeam1Runs(int team1Runs) {
		this.team1Runs = team1Runs;
	}

	public void setTeam2Runs(int team2Runs) {
		this.team2Runs = team2Runs;
	}

	public void setTeam1Wickets(int team1Wickets) {
		this.team1Wickets = team1Wickets;
	}

	public void setTeam2Wickets(int team2Wickets) {
		this.team2Wickets = team2Wickets;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setTempTeam1(String tempTeam1) {
		this.tempTeam1 = tempTeam1;
	}

	public void setTempTeam2(String tempTeam2) {
		this.tempTeam2 = tempTeam2;
	}

}
