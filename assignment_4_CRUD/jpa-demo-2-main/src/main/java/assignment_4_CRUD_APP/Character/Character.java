package assignment_4_CRUD_APP.Character;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long characterId;

    // Attributes for the Table and to describe the character
    private String characterName;
    private String characterGame;
    private String characterGender;

    // Default constructor
    public Character() {
    }

    // Constructor(s)
    public Character(long characterId, String characterName, String characterGame, String characterGender) {
        this.characterId = characterId;
        this.characterName = characterName;
        this.characterGame = characterGame;
        this.characterGender = characterGender;
    }

    // Getters and setters
    public long getCharacterId() {return characterId;}

    public void setCharacterId(long characterId) {this.characterId = characterId;}

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterGame() {
        return characterGame;
    }

    public void setCharacterGame(String characterGame) {
        this.characterGame = characterGame;
    }

    public String getCharacterGender() {
        return characterGender;
    }

    public void setCharacterGender(String characterGender) {
        this.characterGender = characterGender;
    }
}
