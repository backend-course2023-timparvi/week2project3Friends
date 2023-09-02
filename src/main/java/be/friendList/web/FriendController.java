package be.friendList.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FriendController {
	
    private final List<String> kaverilista = new ArrayList<>();

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("kaverit", kaverilista);
        return "index";
    }

    @PostMapping("/addFriend")
    public String addFriend(@RequestParam String kaveriNimi) {
        if (!kaveriNimi.isEmpty()) {
            kaverilista.add(kaveriNimi);
        }
        return "redirect:/index";
    }
}