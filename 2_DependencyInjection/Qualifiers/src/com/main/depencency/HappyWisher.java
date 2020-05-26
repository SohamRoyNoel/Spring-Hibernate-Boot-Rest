package com.main.depencency;

import org.springframework.stereotype.Component;

@Component
public class HappyWisher implements FortuneWisher {

	@Override
	public String getFortune() {
		return "You look Ducking Good Boy";
	}

}
