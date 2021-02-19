import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Team team = new Team();
		Player player = new Player();

		boolean condition = true;
		while (condition) {
			System.out.println("1.Team");
			System.out.println("2.Player");
			System.out.println("3.Enter any key to exit");

			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader get = new BufferedReader(in);
			int choice = Integer.parseInt(get.readLine());
			switch (choice) {
			case 1:
				System.out.println("1.Create Team");
				System.out.println("2.Show all teams sorted by name");
				System.out.println("3.Show all teams sorted by date");
				System.out.println("4.Show players in team");
				System.out.println("5.Search Team");
				System.out.println("6.Press any key to go back to previous menu");

				int teamChoice = Integer.parseInt(get.readLine());
				switch (teamChoice) {
				case 1:
					team.createTeam();
					break;
				case 2:
					team.sortTeamsByName();
					break;
				case 3:
					team.sortTeamsByDate();
					break;
				case 4:
					System.out.println("Enter team ID");
					int teamId = Integer.parseInt(get.readLine());
					team.showTeamPlayers(teamId);
					break;
				case 5:
					System.out.println("Enter team name");
					String teamName = get.readLine();
					team.searchTeam(teamName);
					break;
				default:
					break;
				}
				break;
			case 2:
				System.out.println("1.Create Player");
				System.out.println("2.Search Player");
				System.out.println("3.Update Player");
				System.out.println("4.Remove Player");
				System.out.println("5.Press any key to go back to previous menu");
				int playerChoice = Integer.parseInt(get.readLine());
				switch (playerChoice) {
				case 1:
					player.createPlayer(team);
					break;
				case 2:
					System.out.println("Enter player name");
					String playerName = get.readLine();
					player.searchPlayer(playerName);
					break;
				case 3:
					System.out.println("Enter player id");
					int playerId = Integer.parseInt(get.readLine());
					player.updatePlayer(playerId);
					break;
				case 4:
					System.out.println("Enter player name");
					String removeName = get.readLine();
					player.removePlayer(removeName);
					break;
				default:
					break;
				}
				break;
			default:
				System.out.println("Have a nice day:)");
				condition = false;
				break;
			}

		}
	}

}
