package Yusuke.todo.service;

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
    public void saveTodo(TodoForm todoForm) {
        todoRepository.save(Todo.of(todoForm));
    }

    public List<Todo> findByTitle(String title) {
        return todoRepository.findByTitleContainingOrderByDeadlineDesc(title);
    }

    public Todo what(long id){
        return todoRepository.findById(id);
        //boolean status = testTodo.isStatus();
        //status = !status;
        //testTodo.setStatus(status);
    }
    public List<Todo> test(long id){
        return todoRepository.findByIdOrderByDeadlineDesc(id);
        }

    public  void toggleStatus(boolean testTodo){

    }

    public void update(Long id,TodoForm todoForm){
        Todo edittodo = new Todo();

        edittodo.setId(id);
        edittodo.setTitle(todoForm.getTitle());
        edittodo.setDeadline(todoForm.getDeadline());
        edittodo.setCreateTime(LocalDateTime.now());
        todoRepository.save(edittodo);
    }

}
