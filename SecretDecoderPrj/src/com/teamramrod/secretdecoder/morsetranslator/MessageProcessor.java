package com.teamramrod.secretdecoder.morsetranslator;

import java.util.ArrayList;
import java.util.List;

public class MessageProcessor {
	private static final int UNITS_PER_SPACE = 7;
	private static final int UNITS_PER_CHARACTER_SPACE = 3;

	public final static String getTranslatedMessage(List<Unit> units){
		String message = "";
		//Split all units into groups of words
		List<List<Unit>> words = splitWordsIntoLists(units);
		
		//Split all words into characters
		List<String> characters = new ArrayList<String>();
		if(words != null && !words.isEmpty()){
			for(List<Unit> word : words){
				characters.add(splitCharactersIntoLists(word));
			}
		}

		for(String word : characters){
			message = message + word;
		}
		return message;
	}
	
	private static final List<List<Unit>> splitWordsIntoLists(List<Unit> units){
		List<List<Unit>> wordLists = new ArrayList<List<Unit>>();
		List<Integer> wordStartIndex = new ArrayList<Integer>();
		List<Integer> wordEndIndex = new ArrayList<Integer>();
		wordStartIndex.add(0);
		int offCount = 0;
		for(Unit unit : units){
			if(!unit.isOn()){
				offCount += 1;
			}else{
				offCount = 0;
			}
			if(offCount == UNITS_PER_SPACE){
				wordEndIndex.add(units.indexOf(unit) - UNITS_PER_SPACE);
				if(units.indexOf(unit)+1 < units.size())
				wordStartIndex.add(units.indexOf(unit)+1);
			}
		}
		for (int i = 0; i < wordEndIndex.size(); i++) {
			wordLists.add(units.subList(0, wordEndIndex.get(0)));
		}
		return wordLists;
	}
	
	private static final String splitCharactersIntoLists(List<Unit> units){
		String word = "";
		List<Integer> characterStartIndex = new ArrayList<Integer>();
		List<Integer> characterEndIndex = new ArrayList<Integer>();
		characterStartIndex.add(0);
		int offCount = 0;
		for(Unit unit : units){
			if(!unit.isOn()){
				offCount += 1;
			}else{
				offCount = 0;
			}
			if(offCount == UNITS_PER_CHARACTER_SPACE){
				characterEndIndex.add(units.indexOf(unit) - UNITS_PER_CHARACTER_SPACE);
				if(units.indexOf(unit)+1 < units.size())
				characterStartIndex.add(units.indexOf(unit)+1);
			}
		}
		for (int i = 0; i < characterEndIndex.size(); i++) {
			word = word + MorseDecoder.getCharacter(units.subList(0, characterEndIndex.get(0)));
		}
		return word + " ";

	}
}
