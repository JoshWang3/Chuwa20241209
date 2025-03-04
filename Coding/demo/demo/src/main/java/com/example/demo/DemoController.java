import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/process")
    public String processRequest() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " handling request");
        return "Request processed by " + Thread.currentThread().getName();
    }

    @GetMapping("/error")
    public String throwError() {
        throw new IllegalArgumentException("This is a bad request!");
    }
}
