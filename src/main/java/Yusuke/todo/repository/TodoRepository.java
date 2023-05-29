package Yusuke.todo.repository;

import Yusuke.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/** Todo repository */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByTitleContainingOrderByDeadlineDesc(String title);

    Todo findById(long id);
}


