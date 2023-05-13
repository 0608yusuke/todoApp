package Yusuke.todo.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class TodoForm {
    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;


}
