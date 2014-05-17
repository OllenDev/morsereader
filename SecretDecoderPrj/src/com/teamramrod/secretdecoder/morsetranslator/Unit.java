package com.teamramrod.secretdecoder.morsetranslator;

import java.util.List;

public class Unit {

	private List<Frame> frames;

	public Unit(List<Frame> frames) {
		setFrames(frames);
	}

	public List<Frame> getFrames() {
		return frames;
	}

	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}
	
	public void addFrame(Frame frame){
		frames.add(frame);
	}
	
	public boolean isOn(){
		//TODO
		return false;
	}
}
