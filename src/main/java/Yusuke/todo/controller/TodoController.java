package Yusuke.todo.controller;

import Yusuke.todo.entity.Todo;
import Yusuke.todo.form.TodoForm;
import Yusuke.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        Todo todo = todoService.findById(id);
           if (todo.getId() == null) {
            throw new ExceptionControllerAdvice.TodoException();
        }
        model.addAttribute("todoList", todoService.findById(id));
        return "edit";
    }


    @PatchMapping("/toggle-status")
    public String toggle(@RequestParam Long id){
        todoService.toglleUpdate(id);
        return "redirect:/";
    }
    @PutMapping("/edit/complete")
    public  String complete(@RequestParam Long id, TodoForm todoForm){
        todoService.update(id,todoForm);
        return "redirect:/";
    }




}

