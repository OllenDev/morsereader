package com.teamramrod.secretdecoder.morsetranslator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MorseDecoder {

	public static String getCharacter(List<Unit> units){
		//Convert the List of units to an array of MorseStatus
		List<MorseStatus> statusList = new ArrayList<MorseStatus>();
		if(units != null && !units.isEmpty()){
			for(Unit unit : units){
				if(!unit.isOn()){
					statusList.add(MorseStatus.GAP);
				}else{
					if(isUnitOn(units, units.indexOf(unit)+1) && isUnitOn(units, units.indexOf(unit)+2)){
						statusList.add(MorseStatus.DASH);
					}else{
						statusList.add(MorseStatus.DOT);
					}
				}
			}
		}
		MorseStatus status[] = new MorseStatus[statusList.size()];
		return getMorseCodeMap().get(statusList.toArray(status));
	}
	
	public static boolean isUnitOn(List<Unit> units, int index){
		if(index < units.size() && units.get(index).isOn()){
			return true;
		}
		return false;
	}
	
	public static final Map<MorseStatus[], String> getMorseCodeMap(){
		Map<MorseStatus[], String> morseMap = new HashMap<MorseStatus[], String>();
		MorseStatus a[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH};
		MorseStatus b[] = {MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT};
		MorseStatus c[] = {MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT};
		MorseStatus d[] = {MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT};
		MorseStatus e[] = {MorseStatus.DOT};
		MorseStatus f[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH};
		MorseStatus g[] = {MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT};
		MorseStatus h[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT};
		MorseStatus i[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT};
		MorseStatus j[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH};
		MorseStatus k[] = {MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH};
		MorseStatus l[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT};
		MorseStatus m[] = {MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH};
		MorseStatus n[] = {MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT};
		MorseStatus o[] = {MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH};
		MorseStatus p[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT};
		MorseStatus q[] = {MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH};
		MorseStatus r[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT};
		MorseStatus s[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT};
		MorseStatus t[] = {MorseStatus.DASH};
		MorseStatus u[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH};
		MorseStatus v[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH};
		MorseStatus w[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH};
		MorseStatus x[] = {MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH};
		MorseStatus y[] = {MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.DASH};
		MorseStatus z[] = {MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT};
		MorseStatus one[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH};
		MorseStatus two[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH};
		MorseStatus three[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH};
		MorseStatus four[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH};
		MorseStatus five[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT};
		MorseStatus six[] = {MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT};
		MorseStatus seven[] = {MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT};
		MorseStatus eight[] = {MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT};
		MorseStatus nine[] = {MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DOT};
		MorseStatus zero[] = {MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DOT, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH, MorseStatus.GAP, MorseStatus.DASH};
		morseMap.put(a, "a");
		morseMap.put(b, "b");
		morseMap.put(c, "c");
		morseMap.put(d, "d");
		morseMap.put(e, "e");
		morseMap.put(f, "f");
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
