package com.teamramrod.secretdecoder.morsetranslator;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class MessageProcessorTest extends TestCase {

	public void testGetTranslatedMessageE() {
		List<Unit> units = new ArrayList<Unit>();
		units.add(createOnUnit());
		assertEquals("e ", MessageProcessor.getTranslatedMessage(units));
	}
	
	public void testGetTranslatedMessageWord() {
		List<Unit> units = new ArrayList<Unit>();
		//H
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		//GAP
		units.add(createOffUnit());
		units.add(createOffUnit());
		units.add(createOffUnit());
		//E
		units.add(createOnUnit());
		//GAP
		units.add(createOffUnit());
		units.add(createOffUnit());
		units.add(createOffUnit());
		//L
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		
		//GAP
		units.add(createOffUnit());
		units.add(createOffUnit());
		units.add(createOffUnit());
		
		//L
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		//GAP
		units.add(createOffUnit());
		units.add(createOffUnit());
		units.add(createOffUnit());
		
		//O
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		
		assertEquals("hello ", MessageProcessor.getTranslatedMessage(units));
	}
	

	public void testGetTranslatedMessageSnetance() {
		List<Unit> units = new ArrayList<Unit>();
		//H
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		//GAP
		units.add(createOffUnit());
		units.add(createOffUnit());
		units.add(createOffUnit());
		//E
		units.add(createOnUnit());
		//GAP
		units.add(createOffUnit());
		units.add(createOffUnit());
		units.add(createOffUnit());
		//L
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		
		//GAP
		units.add(createOffUnit());
		units.add(createOffUnit());
		units.add(createOffUnit());
		
		//L
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		//GAP
		units.add(createOffUnit());
		units.add(createOffUnit());
		units.add(createOffUnit());
		
		//O
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOffUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		units.add(createOnUnit());
		
		//SPACE
		units.add(createOffUnit());
		units.add(createOffUnit());
		units.add(createOffUnit());
		units.add(createOffUnit());
		units.add(createOffUnit());
		units.add(createOffUnit());
		units.add(createOffUnit());
		
		//H
				units.add(createOnUnit());
				units.add(createOffUnit());
				units.add(createOnUnit());
				units.add(createOffUnit());
				units.add(createOnUnit());
				units.add(createOffUnit());
				units.add(createOnUnit());
				//GAP
				units.add(createOffUnit());
				units.add(createOffUnit());
				units.add(createOffUnit());
				//E
				units.add(createOnUnit());
				//GAP
				units.add(createOffUnit());
				units.add(createOffUnit());
				units.add(createOffUnit());
				//L
				units.add(createOnUnit());
				units.add(createOffUnit());
				units.add(createOnUnit());
				units.add(createOnUnit());
				units.add(createOnUnit());
				units.add(createOffUnit());
				units.add(createOnUnit());
				units.add(createOffUnit());
				units.add(createOnUnit());
				
				//GAP
				units.add(createOffUnit());
				units.add(createOffUnit());
				units.add(createOffUnit());
				
				//L
				units.add(createOnUnit());
				units.add(createOffUnit());
				units.add(createOnUnit());
				units.add(createOnUnit());
				units.add(createOnUnit());
				units.add(createOffUnit());
				units.add(createOnUnit());
				units.add(createOffUnit());
				units.add(createOnUnit());
				//GAP
				units.add(createOffUnit());
				units.add(createOffUnit());
				units.add(createOffUnit());
				
				//O
				units.add(createOnUnit());
				units.add(createOnUnit());
				units.add(createOnUnit());
				units.add(createOffUnit());
				units.add(createOnUnit());
				units.add(createOnUnit());
				units.add(createOnUnit());
				units.add(createOffUnit());
				units.add(createOnUnit());
				units.add(createOnUnit());
				units.add(createOnUnit());
		assertEquals("hello hello ", MessageProcessor.getTranslatedMessage(units));
	}
	
	private Unit createOnUnit(){
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(true));
		frames.add(new Frame(true));
		frames.add(new Frame(true));
		frames.add(new Frame(true));
		frames.add(new Frame(true));
		frames.add(new Frame(true));
		frames.add(new Frame(true));
		frames.add(new Frame(true));
		frames.add(new Frame(true));
		frames.add(new Frame(true));
		frames.add(new Frame(true));
		frames.add(new Frame(true));
		frames.add(new Frame(true));
		frames.add(new Frame(true));
		frames.add(new Frame(true));
		frames.add(new Frame(true));
		Unit unit = new Unit(frames);
		return unit;
	}

	private Unit createOffUnit(){
		Unit unit = new Unit(new ArrayList<Frame>());
		return unit;
	}
}
