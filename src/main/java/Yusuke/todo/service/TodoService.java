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

    public void what(long id){
        Todo testTodo = todoRepository.findById(id);
        boolean status = testTodo.isStatus();
        status = !status;
        testTodo.setStatus(status);
        todoRepository.save(testTodo);
    }
    public List<Todo> findId(long id){

        return todoRepository.findByIdOrderByDeadlineDesc(id);
        }


    public void update(long id,TodoForm todoForm){
        Todo edittodo = todoRepository.findById(id);

        edittodo.setId(id);
        edittodo.setTitle(todoForm.getTitle());
        edittodo.setDeadline(todoForm.getDeadline());
        edittodo.setUpdateTime(LocalDateTime.now());
        edittodo.setCreateTime(edittodo.getCreateTime());
        todoRepository.save(edittodo);
    }

}
