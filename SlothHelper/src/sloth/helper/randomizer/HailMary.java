package sloth.helper.randomizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import sloth.helper.DAO.*;

public class HailMary {

	SlothHelperDAO DAOObject= new SlothHelperDAOImp();
	Map<String,String>RandomMap=new HashMap();
	Map<String,String>ContainerMap=new HashMap();
	
	
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	Object randomGenerator = ContainerMap.keySet().toArray()[new Random().nextInt(ContainerMap.keySet().toArray().length)];
	String Key1= randomGenerator.toString();
	String Value1=ContainerMap.get(randomGenerator);
	RandomMap.put(Key1, Value1);
	String word= RandomMap.keySet().toString();
	String meaning=RandomMap.values().toString();

}
