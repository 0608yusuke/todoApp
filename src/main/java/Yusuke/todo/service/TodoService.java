package Yusuke.todo.service;

import Yusuke.todo.controller.ExceptionControllerAdvice;
import Yusuke.todo.entity.Todo;
import Yusuke.todo.form.TodoForm;
import Yusuke.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> searchAllTodo() {
        return todoRepository.findAll();
        }
    public void register(TodoForm todoForm) {
        todoRepository.save(Todo.of(todoForm));
    }

    public List<Todo> findByTitle(String title) {
        return todoRepository.findByTitleContainingOrderByDeadlineDesc(title);
    }

    public void toggle(long id){
        Todo todo = todoRepository.findById(id);
        boolean status = todo.isStatus();
        status = !status;
        todo.setStatus(status);
        todoRepository.save(todo);
    }

    public Todo findById(long id){
        Todo todo = todoRepository.findById(id);
        if (todo == null) {
            throw new ExceptionControllerAdvice.TodoException();
        }
        return todo;
    }


    public void update(long id,TodoForm todoForm){
        Todo editedTodo = todoRepository.findById(id);

        editedTodo.setId(id);
        editedTodo.setTitle(todoForm.getTitle());
        editedTodo.setDeadline(todoForm.getDeadline());
        editedTodo.setUpdateTime(LocalDateTime.now());
        todoRepository.save(editedTodo);
    }

}
