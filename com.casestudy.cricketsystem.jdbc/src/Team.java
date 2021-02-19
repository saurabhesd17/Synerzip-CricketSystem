import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;

public class Team {
	private String name;
	private Date dateOfCreation;

	/**
	 * Option 1-> 1
	 * 
	 * @param cricket
	 * @throws IOException createTeam methods creates an team by accepting name and
	 *                     of the team. name and creation date are the two
	 *                     parameters in team which will be stored in database
	 *                     cricket table teams. creation date will be automatically
	 *                     stored by the time of team creation.
	 */
	public void createTeam() throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		try {
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader get = new BufferedReader(in);
			String query = "INSERT INTO TEAMS VALUES(default,?,?)";

			System.out.println("Enter Name of the Team");
			name = get.readLine();
			dateOfCreation = new Date();
			java.sql.Date sqlDate = new java.sql.Date(dateOfCreation.getTime());

			con = Database.connect();
			statement = con.prepareStatement(query);
			statement.setString(1, name);
			statement.setDate(2, sqlDate);
			int count = statement.executeUpdate();
			System.out.println(count + " number of rows affected");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			statement.close();
			con.close();
		}
	}

	/**
	 * Option 1->2
	 * 
	 * @throws Exception sortTeamsByName gets all the teams in database cricket ad
	 *                   sorts them in ascending order according to their team name.
	 */
	public void sortTeamsByName() throws SQLException {
		Connection con = null;
		Statement st = null;
		try {
			String query = "SELECT TEAM_NAME FROM TEAMS ORDER BY TEAM_NAME";
			List<String> teams = new ArrayList<>();
			con = Database.connect();
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				teams.add(rs.getString("TEAM_NAME"));
			}
			System.out.println(teams);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			st.close();
			con.close();
		}
	}

	/**
	 * Option 1->3
	 * 
	 * @throws Exception sortTeamsByDate gets all the teams in database cricket ad
	 *                   sorts them in ascending order according to their creation
	 *                   date.
	 */
	public void sortTeamsByDate() throws SQLException {
		Connection con = null;
		Statement st = null;
		try {
			String query = "SELECT TEAM_NAME FROM TEAMS ORDER BY CREATION_DATE";
			List<String> teams = new ArrayList<>();
			con = Database.connect();
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				teams.add(rs.getString("TEAM_NAME"));
			}
			System.out.println(teams);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			st.close();
			con.close();
		}
	}

	/**
	 * Option 1->4
	 * 
	 * @param teamName
	 * @throws Exception showTeamPlayers methods accepts one parameter as teamName.
	 *                   after that it searches in database players having inputed
	 *                   teamName and stores in ArrayList of names.
	 */
	public void showTeamPlayers(int teamId) throws SQLException {
		Connection con = null;
		Statement st = null;
		try {
			String query = "SELECT PLAYER_NAME FROM PLAYERS WHERE TEAM_ID = ('" + teamId + "')";
			List<String> names = new ArrayList<>();
			con = Database.connect();
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				names.add(rs.getString("PLAYER_NAME"));
			}
			System.out.println(names);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			st.close();
			con.close();
		}
	}

	/**
	 * Option 1->5
	 * 
	 * @param teamName
	 * @throws Exception searchTeam methods searches inputed team in database and
	 *                   gives the details of the team if match.
	 */
	public void searchTeam(String teamName) throws SQLException {
		Connection con = null;
		Statement st = null;
		try {
			String query = "SELECT * FROM TEAMS WHERE TEAM_NAME = ('" + teamName + "')";
			con = Database.connect();
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			System.out.println("Team Name: " + rs.getString("TEAM_NAME"));
			System.out.println("Creation Date: " + rs.getDate("CREATION_DATE"));
		} catch (Exception e) {
			System.out.println(e);
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

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
}