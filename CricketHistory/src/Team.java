import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Team implements Cricket {
	private String name;
	private Date dateOfCreation;
	private String homeground;

	public void createTeam(Data data) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader get = new BufferedReader(in);

		System.out.println("Enter Name of the Team");
		name = get.readLine();
		System.out.println("Enter Homeground of the Team");
		homeground = get.readLine();
		dateOfCreation = new Date();
	}

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