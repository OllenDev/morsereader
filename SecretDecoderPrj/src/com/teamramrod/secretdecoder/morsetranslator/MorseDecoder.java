package com.teamramrod.secretdecoder.morsetranslator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MorseDecoder {

	public final static Map<String, String> CHARACTER_MAP = getMorseCodeMap();
	
	public static String getCharacter(List<Unit> units){
		//Convert the List of units to an array of MorseStatus
		return CHARACTER_MAP.get(getMorseString(units));
	}
	
	public static boolean isUnitOn(List<Unit> units, int index){
		if(index < units.size() && units.get(index).isOn()){
			return true;
		}
		return false;
	}
	
//	public static final MorseStatus getMorseStatus(List<Unit> units){
//		if(units != null && !units.isEmpty()){
//			for(Unit unit : units){
//				if(!unit.isOn() && units.size() == 1){
//					return MorseStatus.GAP;
//				}else{
//					if(isUnitOn(units, units.indexOf(unit)+1) && isUnitOn(units, units.indexOf(unit)+2)){
//						return MorseStatus.DASH;
//					}else{
//						return MorseStatus.DOT;
//					}
//				}
//			}
//		}
//		return null;
//	}
	
	public static final String getMorseString(List<Unit> units){
		String code = "";
		if(units != null && !units.isEmpty()){
			for(int i = 0; i < units.size(); i++){
				Unit unit = units.get(i);
				if(!unit.isOn()){
					code = code + " ";
				}else{
					if(isUnitOn(units, units.indexOf(unit)+1) && isUnitOn(units, units.indexOf(unit)+2)){
						code = code + "-";
						i=i+2;
					}else{
						code = code + ".";
					}
				}
			}
		}
		return code;
	}
	
	private static final Map<String, String> getMorseCodeMap(){
		Map<String, String> morseMap = new HashMap<String, String>();
		String a = "."+" "+"-";
		String b = "-"+" "+"."+" "+"."+" "+".";
		String c = "-"+" "+"."+" "+"-"+" "+".";
		String d = "-"+" "+"."+" "+".";
		String e = ".";
		String f = "."+" "+"."+" "+"-";
		String g = "-"+" "+"-"+" "+".";
		String h = "."+" "+"."+" "+"."+" "+".";
		String i = "."+" "+".";
		String j = "."+" "+"-"+" "+"-"+" "+"-";
		String k = "-"+" "+"."+" "+"-";
		String l = "."+" "+"-"+" "+"."+" "+".";
		String m = "-"+" "+"-";
		String n = "-"+" "+".";
		String o = "-"+" "+"-"+" "+"-";
		String p = "."+" "+"-"+" "+"-"+" "+".";
		String q = "-"+" "+"-"+" "+"."+" "+"-";
		String r = "."+" "+"-"+" "+".";
		String s = "."+" "+"."+" "+".";
		String t = "-";
		String u = "."+" "+"."+" "+"-";
		String v = "."+" "+"."+" "+"."+" "+"-";
		String w = "."+" "+"-"+" "+"-";
		String x = "-"+" "+"."+" "+"."+" "+"-";
		String y = "-"+" "+"."+" "+"-"+"-";
		String z = "-"+" "+"-"+" "+"."+" "+".";
		String one = "."+" "+"-"+" "+"-"+" "+"-"+" "+"-";
		String two = "."+" "+"."+" "+"-"+" "+"-"+" "+"-";
		String three = "."+" "+"."+" "+"."+" "+"-"+" "+"-";
		String four = "."+" "+"."+" "+"."+" "+"."+" "+"-";
		String five = "."+" "+"."+" "+"."+" "+"."+" "+".";
		String six = "-"+" "+"."+" "+"."+" "+"."+" "+".";
		String seven = "-"+" "+"-"+" "+"."+" "+"."+" "+".";
		String eight = "-"+" "+"-"+" "+"-"+" "+"."+" "+".";
		String nine = "-"+" "+"-"+" "+"-"+" "+"-"+" "+".";
		String zero = "."+" "+"."+" "+"-"+" "+"-"+" "+"-";
		morseMap.put(a,"a");
		morseMap.put(b,"b");
		morseMap.put(c,"c");
		morseMap.put(d,"d");
		morseMap.put(e,"e");
		morseMap.put(f,"f");
		morseMap.put(g, "g");
		morseMap.put(h, "h");
		morseMap.put(i, "i");
		morseMap.put(j, "j");
		morseMap.put(k, "k");
		morseMap.put(l, "l");
		morseMap.put(m, "m");
		morseMap.put(n, "n");
		morseMap.put(o, "o");
		morseMap.put(p, "p");
		morseMap.put(q, "q");
		morseMap.put(r, "r");
		morseMap.put(s, "s");
		morseMap.put(t, "t");
		morseMap.put(u, "u");
		morseMap.put(v, "v");
		morseMap.put(w, "w");
		morseMap.put(x, "x");
		morseMap.put(y, "y");
		morseMap.put(z, "z");
		morseMap.put(one, "1");
		morseMap.put(two, "2");
		morseMap.put(three, "3");
		morseMap.put(four, "4");
		morseMap.put(five, "5");
		morseMap.put(six, "6");
		morseMap.put(seven, "7");
		morseMap.put(eight, "8");
		morseMap.put(nine, "9");
		morseMap.put(zero, "0");
		
		return morseMap;
	}
}
