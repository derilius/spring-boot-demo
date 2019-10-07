package pl.derilius.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/private")
public class PrivateController {

    @GetMapping("/user")
    public ResponseEntity<String> user(
            Principal principal
    ) {
        String response = "";
        if (principal != null) {
            System.out.println(principal.toString());
            response = "principal name: " + principal.getName();
        } else {
            response = "principal is null";
        }

        return ResponseEntity.ok()
                .body(response);
    }

}
