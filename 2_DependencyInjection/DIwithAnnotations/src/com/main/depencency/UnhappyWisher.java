package com.main.depencency;

import org.springframework.stereotype.Component;

@Component
public class UnhappyWisher implements FortuneWisher {

	@Override
	public String getFortune() {
		return "You've a Ducking Face";
	}

}
