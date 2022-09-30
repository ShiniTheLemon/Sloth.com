package sloth.helper.randomizer;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Randomizer {



	private String deck_word;
	private String deck_meaning;

	// value is assigned in the quiz DAO
	private Map <String,String> ContainerMap= new HashMap<String,String>();
	// value is given when the Randy() is called
	private Map <String,String> RandomizerMap= new HashMap<String,String>();
	
	
	// called in the servlet
	 void Randy(){
		
	//	RandomMap.put(deck_word, deck_meaning);
	
		
    	Object randomGenerator = ContainerMap.keySet().toArray()[new Random().nextInt(ContainerMap.keySet().toArray().length)];
    	
    	System.out.println(randomGenerator.toString()+"-"+ContainerMap.get(randomGenerator));
    	System.out.println("Randy method has been called!");
    	

		    	String Key1= randomGenerator.toString();
    	String Value1=ContainerMap.get(randomGenerator);
    	RandomizerMap.put(Key1, Value1);
	}


	public Map<String, String> getContainerMap() {
		return ContainerMap;
	}


	public void setContainerMap(Map<String, String> containerMap) {
		ContainerMap = containerMap;
	}


	public String getDeck_word() {
		return deck_word;
	}


	public void setDeck_word(String deck_word) {
		this.deck_word = deck_word;
	}


	public String getDeck_meaning() {
		return deck_meaning;
	}


	public void setDeck_meaning(String deck_meaning) {
		this.deck_meaning = deck_meaning;
	}


	public Map<String, String> getRandomizerMap() {
		return RandomizerMap;
	}


	public void setRandomizerMap(Map<String, String> randomizerMap) {
		RandomizerMap = randomizerMap;
	}
	
	
	
}
