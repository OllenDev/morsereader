package com.teamramrod.secretdecoder.morsetranslator;

import java.util.ArrayList;
import java.util.List;

import android.sax.StartElementListener;

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
				characters.add(parseWordIntoString(word));
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
				wordEndIndex.add(units.indexOf(unit) - UNITS_PER_SPACE+1);
				if(units.indexOf(unit)+1 < units.size())
				wordStartIndex.add(units.indexOf(unit)+1);
			}
		}
		wordEndIndex.add(units.size());
		for (int i = 0; i < wordEndIndex.size(); i++) {
			wordLists.add(units.subList(0, wordEndIndex.get(0)));
		}
		return wordLists;
	}
	
	private static final String parseWordIntoString(List<Unit> units){
		String word = "";
		int characterStartIndex = 0;
		int offCount = 0;
		for(int i = 0; i < units.size(); i++){
			Unit unit = units.get(i);
			if(!unit.isOn()){
				offCount += 1;
			}else{
				offCount = 0;
			}
			if(offCount == UNITS_PER_CHARACTER_SPACE){
				word = word + MorseDecoder.getCharacter(units.subList(characterStartIndex, i - UNITS_PER_CHARACTER_SPACE+1));
				characterStartIndex = i +1;

			}else if(i == units.size() - 1){
				word = word + MorseDecoder.getCharacter(units.subList(characterStartIndex,i+1));
			}
		}
		return word + " ";

	}
}
