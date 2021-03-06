package evernote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Class for analyzing the amount of strings in a file.
 * Completed for a coding challenge by Evernote. 
 *
 * @author Brad Ware
 */

public class FrequencyAnalyzer {
	
	
	/**
	 * 
	 * @param file - a String passed in to represent the file
	 * @param amount - the amount of strings returned in the list
	 * @param separator - the character that indicates a new string is starting
	 * @return List<String> of all the seperate words in descending order of appearance
	 */
	public static List<String> getFrequency(String file, int amount, char separator) {
		//Empty list is returned if the parameters are invalid
		if(amount <= 0 || file == null || file.length() == 0 ) {
			return new ArrayList<String>();
		}
		ArrayList<String> frequencyList = FrequencyAnalyzer.calculateFrequencies(file, amount, separator);
		return frequencyList;
	}
	
	/**
	 * 
	 * @param file - a String passed in to represent the file
	 * @param amount - the amount of strings returned in the list
	 * @param separator - the character that indicates a new string is starting
	 * @return List<String> of all the seperate words in descending order of appearance
	 */

	private static ArrayList<String> calculateFrequencies(String file, int amount, char separator) {
		//initial variables setUp that are not local to a loop
		final char[] stringList = file.toCharArray();
		final Map<String, Integer> stringMap = new HashMap<String, Integer>();
		final ArrayList<String> sortedWordList = new ArrayList<String>();
		final Map<Integer, ArrayList<String>> appearanceMap = new HashMap<Integer, ArrayList<String>>();
		
		StringBuilder currString = new StringBuilder();
		for(char c: stringList) {
			if(c == separator) {
				if(currString.length() > 0) { //Checking for adding the empty string
					String str = currString.toString();
					if(stringMap.containsKey(str)) {
						int oldValue = stringMap.get(str);
						stringMap.replace(str, ++oldValue);
					} else {
						stringMap.put(str, 1); //first time appearing in the file
					}
					currString.setLength(0);
				}
			} else {
				currString.append(c);
			}
		}
		
		//To put the last string into the table
		final String lastStr = currString.toString();
		if(stringMap.containsKey(lastStr)) {
			int oldValue = stringMap.get(lastStr);
			stringMap.replace(lastStr, ++oldValue);
		} else {
			if(lastStr.length() > 0) {	//Checking for adding the empty string
				stringMap.put(lastStr, 1); 
			}
		}
		
		//Creating the bi-directional map
		int maxAppearances = 0;
		for(Entry<String, Integer> e: stringMap.entrySet()) {
			int currValue = e.getValue();
			String str = e.getKey();
			if(appearanceMap.containsKey(currValue)) {
				ArrayList<String> strList = appearanceMap.get(currValue);
				strList.add(str);
				appearanceMap.replace(currValue, strList);
			} else {
				ArrayList<String> newList = new ArrayList<String>();
				newList.add(str);
				appearanceMap.put(currValue, newList);
			}
			if(currValue > maxAppearances) {
				maxAppearances = currValue;
			}
		}
		
		//Adding to the list in descending order of appearance
		int numItems = 0;
		while(maxAppearances > 0 && numItems < amount) {
			if(appearanceMap.containsKey(maxAppearances)) {
				ArrayList<String> currList = appearanceMap.get(maxAppearances);
				for(String str: currList) {
					sortedWordList.add(str);
					numItems++;
					if(numItems == amount) {
						break;
					}
				}
			} 
			maxAppearances--;
		}
		
		return sortedWordList;
	}
}
