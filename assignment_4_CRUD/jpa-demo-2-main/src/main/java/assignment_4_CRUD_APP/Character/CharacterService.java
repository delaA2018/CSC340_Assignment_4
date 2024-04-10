package assignment_4_CRUD_APP.Character;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository repo;


    public Character getCharacterById(long id) {
        Character character = repo.getReferenceById(id);
        return character;
    }

    public List<Character> getAllCharacter() {
        List<Character> characterList = repo.findAll();
        return characterList;
    }

    public void deleteCharacterById(long id) {
        repo.deleteById(id);
    }


    public void saveCharacter(Character character) {
        repo.save(character);
    }
    

}
