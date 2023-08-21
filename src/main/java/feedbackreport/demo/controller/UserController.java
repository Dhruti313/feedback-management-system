package feedbackreport.demo.controller;
import feedbackreport.demo.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String verifyUserLoginDetails(

        @RequestParam String username,@RequestParam String password , @RequestParam String usertype){

        boolean userExists =userRepository.countByUsernameAndPasswordAndUserType(
                username, password, usertype);
    if(userExists){
        return  "found";
    }
    else{
        return "not found";
    }


    }
}
