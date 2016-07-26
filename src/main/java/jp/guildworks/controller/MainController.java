package jp.guildworks.controller;

import jp.guildworks.entity.Todo;
import jp.guildworks.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class MainController {

    @Autowired
    private TodoService todoService;

    @ModelAttribute("todos")
    List<Todo> queryAllTodos(){
        return todoService.findAll();
    }

    @RequestMapping("/")
    String home() {
        return "index";
    }
}
