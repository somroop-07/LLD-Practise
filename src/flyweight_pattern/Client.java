package flyweight_pattern;

import java.util.HashMap;
import java.util.Map;

interface CharacterFlyweight {
	void display(double xCoorinate, double yCoordinate);
}

//Flyweight class
class DocumentCharacter implements CharacterFlyweight {
	
	//Intrinsic properties; class immutable
	private char character;
	private String font;
	private int size;
	
	
	public DocumentCharacter(char character, String font, int size) {
		super();
		this.character = character;
		this.font = font;
		this.size = size;
	}

	public char getCharacter() {
		return character;
	}

	public String getFont() {
		return font;
	}

	public int getSize() {
		return size;
	}

	//pass extrinsic properties using method
	@Override
	public void display(double xCoorinate, double yCoordinate) {
		// TODO Auto-generated method stub
		
	}
	
}
class CharacterFactory {
	//Caching
	private static Map<Character, CharacterFlyweight> characterCache = new HashMap<>();
	
	public static CharacterFlyweight createCharacter (char characterValue) {
		if(characterCache.containsKey(characterValue)) {
			return characterCache.get(characterValue);
		}
		else {
			DocumentCharacter character = new DocumentCharacter(characterValue, "Arial", 10);
			characterCache.put(characterValue, character);
			return character;
		}
	}
}



public class Client {

	public static void main(String[] args) {
		CharacterFlyweight character1 = CharacterFactory.createCharacter('a');
		character1.display(0,0);
		CharacterFlyweight character2 = CharacterFactory.createCharacter('a');
		character2.display(1,1);
		
	}
}
