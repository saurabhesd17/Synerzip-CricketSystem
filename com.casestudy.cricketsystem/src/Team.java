import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Team {
	private String name;
	private Date dateOfCreation;
	private String homeground;
	public Set<String> teamPlayers = new TreeSet<String>();
	public List<Player> players = new ArrayList<Player>();
	
	public Team() {}
	
	public Team(String teamName, Date date) {
		this.name = teamName;
		this.dateOfCreation = date;
	}

	// Creating Player
	public void createTeam(Cricket cricket) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader get = new BufferedReader(in);

		System.out.println("Enter Name of the Team");
		name = get.readLine();
		System.out.println("Enter Homeground of the Team");
		homeground = get.readLine();
		dateOfCreation = new Date();
	}

	// Displaying total number of players in inputed team name
	public void playersInTeam(String teamName) {
		int count = 0;
		for (Player player : players) {
			if (teamName.equals(player.getPlayFor())) {
				count++;
			}
		}

		System.out.println("There are " + count + " players are in team currently");
	}

	/**
	 * 
	 * @param teamName
	 *	Displaying players in a inputed team name
	 */
	public void showTeamPlayers(String teamName) {
		for (Player player : players) {
			if (teamName.equals(player.getPlayFor())) {
				teamPlayers.add(player.getName());
			}
		}

		for (String name : teamPlayers) {
			System.out.println(name);
		}
	}

	// Searching Player
	public void searchPlayer(String playerName) {
		for (Player player : players) {
			if (playerName.equals(player.getName())) {
				System.out.println("Player Name: " + player.getName());
				System.out.println("Player Age: " + player.getAge());
				System.out.println("Plays For: " + player.getPlayFor());
			}
		}
	}

	// Adding player to inputed team name
	public void addPlayerToTeam(String playerName, Cricket cricket) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader get = new BufferedReader(in);

		System.out.println("Enter team name");
		String teamName = get.readLine();
		if (cricket.verifyTeam(teamName)) {
			Player.setPlayFor(teamName);
			System.out.println("Player added successfully");
		} else {
			System.out.println("Their is no team by name " + teamName);
		}
	}

	// Removing player from inputed team name
	public void removePlayerFromTeam(String playerName) {
		for (Player player : players) {
			if (player.getName().equals(playerName)) {
				System.out.println("Player Name: " + playerName);
				System.out.println("Plays for team: " + player.getPlayFor());
				Player.setPlayFor("Unplaced");
				System.out.println("Now: " + player.getPlayFor());
			}
		}
	}

	// Displaying Team Details
	public void showTeamDetails() {
		System.out.println(name);
		System.out.println(homeground);
		System.out.println(dateOfCreation);
	}

	public String getName() {
		return name;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public String getHomeground() {
		return homeground;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public void setHomeground(String homeground) {
		this.homeground = homeground;
	}
}