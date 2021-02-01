import java.util.Comparator;

public class TeamSortDate implements Comparator<Team>{
	
	@Override
	public int compare(Team t1, Team t2) {
		return t1.getDateOfCreation().compareTo(t2.getDateOfCreation());
	}
}
