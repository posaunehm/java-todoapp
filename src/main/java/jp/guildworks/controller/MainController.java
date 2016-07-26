package jp.guildworks.controller;

import jp.guildworks.entity.Todo;
import jp.guildworks.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    String newTodo(@RequestParam("newTodo") String newTodo) {
        Todo todo = new Todo(newTodo);
        todoService.save(todo);

        return "redirect:/";
    }
}
