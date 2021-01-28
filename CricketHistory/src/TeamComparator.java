import java.util.Comparator;
import java.util.Date;

public class TeamComparator {
	private String name;
	private Date dateOfCreation;
	private String homeground;

	public TeamComparator(String name, Date dateOfCreation, String homeground) {
		this.name = name;
		this.dateOfCreation = dateOfCreation;
		this.homeground = homeground;
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

	public static Comparator<TeamComparator> getTeamNameComparator() {
		return teamNameComparator;
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

	public static void setTeamNameComparator(Comparator<TeamComparator> teamNameComparator) {
		TeamComparator.teamNameComparator = teamNameComparator;
	}

	public static Comparator<TeamComparator> teamNameComparator = new Comparator<TeamComparator>() {
		public int compare(TeamComparator t1, TeamComparator t2) {
			String teamName1 = t1.getName().toUpperCase();
			String teamName2 = t2.getName().toUpperCase();

			return teamName1.compareTo(teamName2);
		}
	};
	
	public static Comparator<TeamComparator> teamDateComparator = new Comparator<TeamComparator>() {
		public int compare(TeamComparator t1, TeamComparator t2) {
			Date team1Date = t1.getDateOfCreation();
			Date team2Date = t2.getDateOfCreation();

			return team1Date.compareTo(team2Date);
		}
	};
}