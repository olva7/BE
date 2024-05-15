package MI.com.example.MI_Project.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/hi")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("helooooo!!!!");
    }

}
