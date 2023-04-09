package Yusuke.todo.entity;

import Yusuke.todo.form.TodoForm;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

/** Todo Entity */
@Data
@Entity
public class Todo {
    public static Todo of(TodoForm todoForm){
        Todo todo = new Todo();
        todo.setTitle(todoForm.getTitle());
        todo.setDeadline(todoForm.getDeadline());
        return todo;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private LocalDate deadline;
    private boolean status;

    @CreationTimestamp
    private LocalDateTime createTime;
    @UpdateTimestamp
    private LocalDateTime updateTime;
}
