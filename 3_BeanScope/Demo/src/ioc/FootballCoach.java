package ioc;

import depencency.FortuneWisher;

public class FootballCoach implements Coach {
	
	// inject dependency - CONSTRUCTOR INJECTION
	private FortuneWisher fw;
	
	
	public FootballCoach(FortuneWisher fw) {
		this.fw = fw;
	}

	@Override
	public String DailyWorkOuts() {
		return "Practice Football";
	}

	@Override
	public String getFortune() {
		return fw.getFortune();
	}
	
	
	
	// HOOKS : initialize
	public void startUp() {
		System.out.println("The method is started");
	}
	// Hooks : Destroy
	public void endUps() {
		System.out.println("The method is ended");
	}
}
