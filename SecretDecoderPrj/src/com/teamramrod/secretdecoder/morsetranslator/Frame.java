package com.teamramrod.secretdecoder.morsetranslator;

public class Frame {
	
	private boolean on;

	public Frame(){
		
	}
	
	public Frame(boolean on){
		setOn(on);
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}
}
