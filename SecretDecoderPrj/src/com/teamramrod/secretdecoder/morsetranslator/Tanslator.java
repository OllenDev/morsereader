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
	private static final int UNITS_PER_SENTINAL = 9;

	public void startMessage(){
		if(units.size() == UNITS_PER_SENTINAL){
			boolean allOn = false;
			for(Unit unit : units){
				if(unit.isOn()){
					allOn = true;
				}
			}
			if(allOn){
				record = true;
			}
		}
	}
	
	public void findCharacterBreak(){
		//TODO if there are 3 GAPs in a row, there is a new character
		if(units.size() == UNITS_PER_CHARACTER_SPACE){
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
