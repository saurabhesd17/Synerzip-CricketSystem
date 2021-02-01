import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		Cricket cricket = new Cricket();
		Team team = new Team();

		boolean condition = true;
		while (condition) {
			System.out.println("1.Team");
			System.out.println("2.Player");
			System.out.println("3.Let's play a game");
			System.out.println("4.Enter any key to exit");

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
					team.createTeam(cricket);
					cricket.teams.add(new Team(team.getName(), team.getDateOfCreation()));
					break;
				case 2:
					cricket.totalTeamsByName();
					break;
				case 3:
					cricket.totalTeamsByDate();
					break;
				case 4:
					System.out.println("Enter team name");
					String name = get.readLine();
					team.showTeamPlayers(name);
					break;
				case 5:
					System.out.println("Enter team name");
					String teamName = get.readLine();
					cricket.searchTeam(teamName);
					break;
				default:
					break;
				}
				break;
			case 2:
				System.out.println("1.Create Player");
				System.out.println("2.Search Player");
				System.out.println("3.Add Player to team");
				System.out.println("4.Remove Player from team");
				System.out.println("5.Press any key to go back to previous menu");
				int playerChoice = Integer.parseInt(get.readLine());
				switch (playerChoice) {
				case 1:
					Player player = new Player();
					player.createPlayer(cricket);
					team.players.add(new Player(player.getName()));
					break;
				case 2:
					System.out.println("Enter player name");
					String playerName = get.readLine();
					team.searchPlayer(playerName);
					break;
				case 3:
					System.out.println("Enter player name");
					String addName = get.readLine();
					team.addPlayerToTeam(addName, cricket);
					break;
				case 4:
					System.out.println("Enter player name");
					String removeName = get.readLine();
					team.removePlayerFromTeam(removeName);
					break;
				default:
					break;
				}
				break;
			case 3:
				System.out.println("1.Play Match");
				System.out.println("2.Show all matches");
				System.out.println("3.Press any key to go back to prevous menu");
				int gameChoice = Integer.parseInt(get.readLine());
				switch (gameChoice) {
				case 1:
					Match match = new Match();
					match.playMatch(cricket);
					cricket.match.add(match);
					break;
				case 2:
					cricket.showGames();
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
