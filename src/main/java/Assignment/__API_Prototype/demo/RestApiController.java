package Assignment.__API_Prototype.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;


@RestController
public class RestApiController {
    
    //Returns a list of all characters
    @GetMapping("/characters")
    public Object getCharacters() {
        try{
            //CONSUMING A RESTFUL WEB API
            String url = "https://rickandmortyapi.com/api/character";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String result = restTemplate.getForObject(url, String.class);        
            JsonNode root = mapper.readTree(result);

            List<Character> characters = new ArrayList<Character>();

            int count = 0;
            for (JsonNode node : root.path("results")) {
                if (count >= 10) break;
                Character character = new Character();
                character.setName(node.path("name").asText());
                character.setStatus(node.path("status").asText());
                character.setOrigin(node.path("origin").path("name").asText());
                character.setImage(node.path("image").asText());
                
                characters.add(character);
                count++;
            }
            return characters;
        } catch (JsonProcessingException e) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE,
                    null, e);

            return "error in /characters";
        }
    }
}
