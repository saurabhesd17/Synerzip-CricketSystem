import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cricket {
	public List<Team> teams = new ArrayList<Team>();
	public List<Match> match = new ArrayList<Match>();

	public boolean verifyTeam(String teamName) {
		boolean flag = false;
		for (Team team : teams) {
			if (teamName.equals(team.getName()))
				flag = true;
		}

		return flag;
	}

	public void totalTeamsByName() {
		System.out.println("There are " + teams.size() + " teams in our system.");
		
		Collections.sort(teams, new TeamSortName());
		for (Team team : teams) {
			System.out.println(team.getName());
		}
	}

	public void totalTeamsByDate() {
		System.out.println("There are " + teams.size() + " teams in our system.");

		Collections.sort(teams, new TeamSortDate());
		for (Team team : teams) {
			System.out.println(team.getName() + " " + team.getDateOfCreation());
		}
	}

	public void searchTeam(String teamName) {
		System.out.println(teamName);
		for (Team team : teams) {
			if (team.getName().equals(teamName)) {
				System.out.println("Team Name: " + team.getName());
				System.out.println("Team Homeground: " + team.getHomeground());
				System.out.println("Created in: " + team.getDateOfCreation());
			}else {
				System.out.println("Inside method");
			}
		}
	}

	public void showGames() {
		for (Match matches : match) {
			System.out.println("Match: " + matches.getGame());
		}
	}
}