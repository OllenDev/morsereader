package com.teamramrod.secretdecoder.morsetranslator;

import java.util.ArrayList;
import java.util.List;

public class Tanslator {

	private List<Frame> frames = new ArrayList<Frame>();
	private List<Unit> units = new ArrayList<Unit>();
	private boolean record = false;
	private String translation;
	
	private static final int FRAME_PER_UNIT = 15;
	private static final int UNITS_PER_SPACE = 7;
	private static final int UNITS_PER_CHARACTER_SPACE = 3;
	private static final int UNITS_PER_SENTINAL = 10;

	public boolean findSentinal(){
		if(units.size() >= UNITS_PER_SENTINAL){
			//Make sure the last 6 units are on
			int onCount = 0;
			for (int i = (units.size() - UNITS_PER_SENTINAL); i < units.size(); i++) {
				if(MorseDecoder.isUnitOn(units, i)){
					onCount += 1;
				}
			}
			//Ensure the Units were on until the last unit, which was off
			if(onCount == UNITS_PER_SENTINAL - 1 && !units.get(units.size()).isOn()){
				return true;
			}
		}
		return false;
	}
	
	//Record true and found sentinal
	public String getMessage(){
		String message = null;
		boolean foundSentinal = findSentinal();
		if(foundSentinal && record){
			message = MessageProcessor.getTranslatedMessage(getUnits());
			resetAll();
		}else if(foundSentinal && !record){
			record = true;
		}
		return message;
	}
	
	public void resetFrames(){
		setFrames(new ArrayList<Frame>());
	}
	
	public void resetUnits(){
		setUnits(new ArrayList<Unit>());
	}
	
	public void resetAll(){
		resetFrames();
		resetUnits();
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}
	public void addUnit(){
		units.add(new Unit(frames));
	}
	public List<Frame> getFrames() {
		return frames;
	}

	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}
	
	public void addFrame(Frame frame){
		frames.add(frame);
		if(frames.size() >= FRAME_PER_UNIT){
			units.add(new Unit(frames));
			resetFrames();
		}
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}
}
