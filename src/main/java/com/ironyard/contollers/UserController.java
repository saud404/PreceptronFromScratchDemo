package com.ironyard.contollers;

import com.ironyard.entities.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserController {
    public static final String BASE_URL = "https://api.github.com/users/";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(path="/users/{username}", method= RequestMethod.GET)
    public String getUser(Model model, @PathVariable String username){
        GithubUser user = restTemplate.getForObject(BASE_URL + username,GithubUser.class);

    model.addAttribute("user",user);
        return  "home";
    }

}
