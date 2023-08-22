package feedbackreport.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import feedbackreport.demo.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDetailsRepository userRepository;

    public UserController(UserDetailsRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public ResponseEntity<JsonNode> verifyUserLoginDetails(
            @RequestParam String username, @RequestParam String password, @RequestParam String usertype) {

        boolean userExists = userRepository.countByUsernameAndPasswordAndUserType(
                username, password, usertype);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode responseNode = mapper.createObjectNode();

        if (userExists) {
            responseNode.put("status", "found");
        } else {
            responseNode.put("status", "not found");
        }

        responseNode.put("user_type", usertype);

        return ResponseEntity.ok(responseNode);
    }
}
