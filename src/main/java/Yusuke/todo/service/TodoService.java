package Yusuke.todo.service;

import Yusuke.todo.entity.Todo;
import Yusuke.todo.form.TodoForm;
import Yusuke.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> searchAllTodo() {
        return todoRepository.findAll();
        }
    public void saveTodo(TodoForm todoForm) {
        todoRepository.save(Todo.of(todoForm));
    }
}
