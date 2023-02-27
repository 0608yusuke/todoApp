package Yusuke.todo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {
    /**
     * トップ画面を表示
     *
     * @return 画面表示用HTMLパス
     */
    @GetMapping
    public String index() {
        return "index";
    }
}

