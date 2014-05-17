package com.teamramrod.secretdecoder.morsetranslator;

import java.util.List;

public class Unit {

	public static final int ON_THRESHOLD = 10; 
	
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
		if(frames != null && !frames.isEmpty()){
			int onCount = 0;
			for(Frame frame : frames){
				if(frame.isOn()){
					onCount += 1;
				}
			}
			if(onCount >= ON_THRESHOLD){
				return true;
			}
		}
		
		return false;
	}
	
	
}
