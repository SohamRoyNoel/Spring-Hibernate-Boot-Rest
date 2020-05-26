package ioc;

public class App {

	public static void main(String[] args) {
		
		Coach ft = new FootballCoach(null);
		String s = ft.DailyWorkOuts();
		System.out.println(s);

	}

}
