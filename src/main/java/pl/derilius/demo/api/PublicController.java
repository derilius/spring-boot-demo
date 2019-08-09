package pl.derilius.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/home")
    public String home() {
        return "Home";
    }

}
