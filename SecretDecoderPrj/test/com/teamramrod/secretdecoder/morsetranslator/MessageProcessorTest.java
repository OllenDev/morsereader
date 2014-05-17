package com.teamramrod.secretdecoder.morsetranslator;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class MessageProcessorTest extends TestCase {

	public void testGetTranslatedMessage() {
		List<Unit> units = new ArrayList<Unit>();
		units.add(createOnUnit());
		assertEquals("e", MessageProcessor.getTranslatedMessage(units));
		assertEquals("e", MessageProcessor.getTranslatedMessage(units));
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
