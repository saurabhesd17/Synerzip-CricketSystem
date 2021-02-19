import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Player {
	private String name;
	private static int teamId;

	/**
	 * Option 2->1
	 * 
	 * @param team
	 * @throws Exception
	 * 
	 *                   createPlayer method creates player by accepting name and
	 *                   team name. If no team name is given then by default he will
	 *                   be unplaced. player's data is stored in database cricket
	 *                   table players.
	 */

	public void createPlayer(Team team) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		try {
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader get = new BufferedReader(in);
			String query = "INSERT INTO PLAYERS VALUES(default,?,?)";
			System.out.println("Enter Player Name: ");
			name = get.readLine();
			System.out.println("Enter Team ID: ");
			teamId = Integer.parseInt(get.readLine());
			con = Database.connect();
			statement = con.prepareStatement(query);
			statement.setString(1, name);
			statement.setInt(2, teamId);
			int count = statement.executeUpdate();
			System.out.println("Player created successfully");
			System.out.println(count + " number of rows affected");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			statement.close();
			con.close();
		}
	}

	/**
	 * Option 2->2 searchPlayer method shows the details of the player. user have to
	 * input player name and method will search player's name in database.
	 */
	public void searchPlayer(String playerName) throws SQLException {
		Connection con = null;
		Statement st = null;
		try {
			String query = "SELECT * FROM PLAYERS WHERE PLAYER_NAME = ('" + playerName + "')";
			con = Database.connect();
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			System.out.println("Player Name: " + rs.getString("PLAYER_NAME"));
			System.out.println("Team Id: " + rs.getInt("TEAM_ID"));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			st.close();
			con.close();
		}
	}

	/**
	 * Option 2->3
	 * 
	 * @param playerName
	 * @throws Exception updatePlayer method updates the player details by accepting
	 *                   player name as input. method can update both player name
	 *                   and team id.
	 */
	public void updatePlayer(int playerId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader get = new BufferedReader(in);
			System.out.println("Enter new name:");
			String newName = get.readLine();
			System.out.println("Enter teamId:");
			int teamId = Integer.parseInt(get.readLine());

			String query = "UPDATE PLAYERS" + " SET PLAYER_NAME =  ('" + newName + "'), TEAM_ID = ('" + teamId + "')"
					+ " WHERE ID = ('" + playerId + "')";
			con = Database.connect();
			st = con.prepareStatement(query);
			int count = st.executeUpdate();
			System.out.println(count + " number of rows affected");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			st.close();
			con.close();
		}
	}

	/**
	 * Option 2->4
	 * 
	 * @param playerName removePlayer methods deleted the player from database.
	 */
	public void removePlayer(String playerName) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			String query = "DELETE FROM PLAYERS WHERE PLAYER_NAME = ('" + playerName + "')";
			con = Database.connect();
			st = con.prepareStatement(query);
			int count = st.executeUpdate();
			System.out.println(count + " number of rows affected");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			con.close();
		}
	}

	/**
	 * 
	 * getters and setters
	 */
	public String getName() {
		return name;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void setTeamId(int teamId) {
		Player.teamId = teamId;
	}
}
