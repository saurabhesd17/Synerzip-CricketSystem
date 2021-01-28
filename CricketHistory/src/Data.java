import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Data {
	public List<Team> teamList = new ArrayList<Team>();
	public List<Player> players = new ArrayList<Player>();
	public List<Match> match = new ArrayList<Match>();
	public List<TeamComparator> teamSorted = new ArrayList<TeamComparator>();

	public boolean verifyTeam(String teamName) {
		boolean flag = false;
		for(Team team : teamList) {
			if(teamName.equals(team.getName()))
				flag = true;
		}
		
		return flag;
	}
	
	public void addPlayerToTeam(String playerName) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader get = new BufferedReader(in);
		
		for(Player player : players) {
			if(playerName.equals(player.getName())) {
				System.out.println("Enter team name");
				String teamName = get.readLine();
				if(verifyTeam(teamName)) {
					player.setPlayFor(teamName);
					System.out.println("Player added successfully");
				}else {
					System.out.println("Their is no team by name " + teamName);
				}
			}
		}
	}
	
	public void removePlayerFromTeam(String playerName) {
		for(Player player : players) {
			if(playerName.equals(player.getName())) {
				System.out.println("Player Name: " + playerName);
				System.out.println("Plays for team: " + player.getPlayFor());
				player.setPlayFor("Unplaced");
				System.out.println("Now: " + player.getPlayFor());
			}
		}
	}
	
	public void totalTeamsByName() {
		System.out.println("There are " + teamList.size() + " teams in our system.");

		Collections.sort(teamSorted, TeamComparator.teamNameComparator);
		for (TeamComparator team : teamSorted) {
			System.out.println(team.getName());
		}
	}

	public void totalTeamsByDate() {
		System.out.println("There are " + teamList.size() + " teams in our system.");
		
		Collections.sort(teamSorted, TeamComparator.teamDateComparator);
		for (TeamComparator team : teamSorted) {
			System.out.println(team.getName() + " " + team.getDateOfCreation());
		}
	}

	public void searchTeam(String teamName) {
		for (Team team : teamList) {
			if (teamName.equals(team.getName())) {
				System.out.println("Team Name: " + team.getName());
				System.out.println("Team Homeground: " + team.getHomeground());
				System.out.println("Created in: " + team.getDateOfCreation());
			}
		}
	}

	public void playersInTeam(String teamName) {
		int count = 0;
		for (Player player : players) {
			if (teamName.equals(player.getPlayFor())) {
				count++;
			}
		}

		System.out.println("There are " + count + " players are in team currently");
	}

	public void showTeamPlayers(String teamName) {
		List<String> playerName = new ArrayList<>();
		
		for (Player player : players) {
			String team = player.getPlayFor();
			if (team.equals(teamName)) {
				playerName.add(player.getName());
			}
		}

		Collections.sort(playerName);
		for (String name : playerName) {
			System.out.println(name);
		}
	}

	public void searchPlayer(String playerName) {
		for (Player player : players) {
			if (playerName.equals(player.getName())) {
				System.out.println("Player Name: " + player.getName());
				System.out.println("Player Age: " + player.getAge());
				System.out.println("Play As: " + player.getPlayAs());
				System.out.println("Player is: " + player.getHanded());
				System.out.println("Type: " + player.getType());
				System.out.println("Total Runs: " + player.getRuns());
				System.out.println("Total Innings: " + player.getInnings());
				System.out.println("Average Run: " + player.getAverageRuns());
				System.out.println("100's: " + player.getHundreds());
				System.out.println("50's: " + player.getFifties());
				System.out.println("Plays For: " + player.getPlayFor());
			}
		}
	}

	public void showGames() {
		for (Match matches : match) {
			System.out.println("Match: " + matches.getGame());
		}
	}

}