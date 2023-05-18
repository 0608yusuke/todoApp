package Yusuke.todo.controller;

import Yusuke.todo.entity.Todo;
import Yusuke.todo.form.TodoForm;
import Yusuke.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
    /**
     * トップ画面を表示
     *
     * @param model Model
     * @return 画面表示用HTMLパス
     */
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("todoList", todoService.searchAllTodo());
        return "index";
        }

    @PostMapping("/register")
    public String register(TodoForm todoForm) {
        todoService.saveTodo(todoForm);
        return "redirect:/";
    }

    @GetMapping("/search/result")
    public String search(String title,Model model){
        model.addAttribute("todoList", todoService.findByTitle(title));
        return "search";
    }


    @GetMapping("/search")
    public String request(){

        return "search";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Long id,Model model){
        List<Todo> list = todoService.findId(id);
        if (list.size() == 0) {
            getError(model);
        }
        else {
            model.addAttribute("todoList", todoService.findId(id));
        }
        return "edit";
    }


    @PatchMapping("/toggle-status")
    public String toggle(@RequestParam Long id){
        todoService.what(id);
        return "redirect:/";
    }
    @PutMapping("/complete")
    public  String complete(@RequestParam Long id, TodoForm todoForm){
        todoService.update(id,todoForm);
        return "redirect:/";
    }

    @RequestMapping("/e")
    public String getError(Model model) {
        throw new ExceptionControllerAdvice.TodoException();
    }
}

