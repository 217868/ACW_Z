package awcz.lab_2;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class MainController {

    @GetMapping()
    public String Main(@RequestParam("cmd") Optional<String> cmd) {
        if (cmd == null) return "Hello world";
        if (cmd.isEmpty()) return "Hello world";

        switch (cmd.get()) {
            case "time":
                return executeTime();
            case "rev":
                return executeRev();
            default:
                return "Hello world";
        }
    }

    private String executeTime() {
        return "time command";
    }

    private String executeRev() {
        return "rev command";
    }
}
