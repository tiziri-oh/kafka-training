package demo.springframework.controller;


import demo.springframework.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageController {

    List<Message> messageList = new ArrayList<Message>();

    @PostMapping("/msg")
    public String postMessage(@ModelAttribute Message newMessage){
        messageList.add(newMessage);
        return "redirect:msg";
    }

    @GetMapping("/msg")
    public String showMessage(Model model){
        model.addAttribute("msglist", messageList);
        model.addAttribute("newMessage", new Message());
        return "MesgPage";
    }
}
