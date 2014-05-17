package com.teamramrod.secretdecoder.morsetranslator;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class MorseDecoderTest extends TestCase {

	public void testGetCharacter() {
		
		fail("Not yet implemented");
	}

	public void testIsUnitOn() {
		fail("Not yet implemented");
	}

	public void testGetMorseStatus() {
		fail("Not yet implemented");
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
