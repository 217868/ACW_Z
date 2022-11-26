package awcz.lab_2;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
public class MainController {

    @GetMapping()
    public String Main(@RequestParam("cmd") String cmd, @RequestParam("str") Optional<String> str) {
        switch (cmd) {
            case "time":
                return executeTime();
            case "rev":
                return executeRev(str.get());
            default:
                return "Hello world";
        }
    }

    private String executeTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    private String executeRev(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }
}
