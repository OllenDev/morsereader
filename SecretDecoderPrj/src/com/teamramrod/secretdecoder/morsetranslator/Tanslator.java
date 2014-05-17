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

	public void findSentinal(){
		if(units.size() >= UNITS_PER_SENTINAL){
			//Make sure the last 6 units are on
			int onCount = 0;
			for (int i = units.size() - UNITS_PER_SENTINAL; i < units.size(); i++) {
				if(MorseDecoder.isUnitOn(units, i)){
					onCount += 1;
				}
			}
			//Ensure the Units were on until the last unit, which was off
			if(onCount == UNITS_PER_SENTINAL - 1 && !units.get(units.size()).isOn()){
				if(record){
					record = false;
				}else{
					record = true;
				}
				resetAll();
			}
		}
	}
	
	public void addCharacter(){
		//TODO if there are 3 GAPs in a row, there is a new character
		if(units.size() >= UNITS_PER_CHARACTER_SPACE){
			boolean allOff = true;
			for(Unit unit : units){
				if(unit.isOn()){
					allOff = false;
					break;
				}
			}
			if(allOff){
				setTranslation(getTranslation() + MorseDecoder.getCharacter(getUnits()));
			}
		}
	}
	
	public void findWordBreak(){
		//TODO if there are 7 GAPs in a row, there is a new character
		if(units.size() == UNITS_PER_SPACE){
			boolean allOff = true;
			for(Unit unit : units){
				if(unit.isOn()){
					allOff = false;
					break;
				}
			}
			if(allOff){
				setTranslation(getTranslation() );//TODO add the character to the string
			}
			resetAll();
		}
	}
	
	public void processFrame(Frame frame){
		addFrame(frame);
		if(!record){
			findSentinal();
		}else{
			addCharacter();
			findWordBreak();
		}
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
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}
}
