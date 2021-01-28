import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
	private String name;
	private int age;
	private PlayAs playAs = PlayAs.PLAYER;
	private Handed handed = Handed.RIGHTY;
	private PlayerType type = PlayerType.BATSMEN;
	private int runs = 10000;
	private int innings = 400;
	private int averageRuns = runs/innings;
	private int hundreds = 50;
	private int fifties = 150;
	private String playFor = "Unplaced";
	
	public void createPlayer(Data data) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader get = new BufferedReader(in);
		
		System.out.println("Enter Player Name: ");
		name = get.readLine();
		System.out.println("Enter Player Age: ");
		age = Integer.parseInt(get.readLine());
		
		System.out.println("Play As: ");
		System.out.println("1.Captain");
		System.out.println("2.Vice Captain");
		System.out.println("3.Player");
		int playAsChoice = Integer.parseInt(get.readLine());
		switch(playAsChoice) {
			case 1:
				playAs = PlayAs.CAPTAIN;
				break;
			case 2:
				playAs = PlayAs.VICE_CAPTAIN;
				break;
			case 3:
				playAs = PlayAs.PLAYER;
				break;
			default:
				break;
		}
		
		System.out.println("Which hand he used: ");
		System.out.println("1.Right");
		System.out.println("2.Left");
		int handChoice = Integer.parseInt(get.readLine());
		switch(handChoice) {
			case 1:
				handed = Handed.RIGHTY;
				break;
			case 2:
				handed = Handed.LEFTY;
				break;
			default:
				break;
		}
		
		System.out.println("Player Type: ");
		System.out.println("1.Batsmen");
		System.out.println("2.Bowler");
		System.out.println("3.All Rounder");
		System.out.println("4.Wicket Keeper");
		System.out.println("5.12th Man");
		int playerChoice = Integer.parseInt(get.readLine());
		switch(playerChoice) {
			case 1:
				type = PlayerType.BATSMEN;
				break;
			case 2:
				type = PlayerType.BOWLER;
				break;
			case 3:
				type = PlayerType.ALL_ROUNDER;
				break;
			case 4:
				type = PlayerType.WICKET_KEEPER;
				break;
			case 5:
				type = PlayerType.TWELTH_MEN;
				break;
			default:
				break;
		}
		
		System.out.println("Enter total runs: ");
		runs = Integer.parseInt(get.readLine());
		System.out.println("Enter total innings: ");
		innings = Integer.parseInt(get.readLine());
		averageRuns = runs/innings;
		System.out.println("How many centuries he made: ");
		hundreds = Integer.parseInt(get.readLine());
		System.out.println("How many fifties he made: ");
		fifties = Integer.parseInt(get.readLine());
		System.out.println("For which team he plays: ");
		String teamName = get.readLine();
		if(data.verifyTeam(teamName)) {
			playFor = teamName;
		}else {
			System.out.println("Their is no team by the name " + teamName);
			playFor = "Unplaced";
		}
		System.out.println("Player created successfully");
	}
	
	public void showPlayerDetails() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(playAs);
		System.out.println(handed);
		System.out.println(type);
		System.out.println(runs);
		System.out.println(innings);
		System.out.println(averageRuns);
		System.out.println(hundreds);
		System.out.println(fifties);
		System.out.println(playFor);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public PlayAs getPlayAs() {
		return playAs;
	}

	public Handed getHanded() {
		return handed;
	}

	public PlayerType getType() {
		return type;
	}

	public int getRuns() {
		return runs;
	}

	public int getInnings() {
		return innings;
	}

	public int getAverageRuns() {
		return averageRuns;
	}

	public int getHundreds() {
		return hundreds;
	}

	public int getFifties() {
		return fifties;
	}

	public String getPlayFor() {
		return playFor;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPlayAs(PlayAs playAs) {
		this.playAs = playAs;
	}

	public void setHanded(Handed handed) {
		this.handed = handed;
	}

	public void setType(PlayerType type) {
		this.type = type;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public void setInnings(int innings) {
		this.innings = innings;
	}

	public void setAverageRuns(int averageRuns) {
		this.averageRuns = averageRuns;
	}

	public void setHundreds(int hundreds) {
		this.hundreds = hundreds;
	}

	public void setFifties(int fifties) {
		this.fifties = fifties;
	}

	public void setPlayFor(String playFor) {
		this.playFor = playFor;
	}
}
