package awcz.lab_2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping
    public String HelloWorld() {
        return "Hello world";
    }
}
