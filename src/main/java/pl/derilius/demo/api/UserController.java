package pl.derilius.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.derilius.demo.domain.user.dto.User;

@RestController
@RequestMapping(value = "/")
public class UserController {

    @GetMapping("/user")
    public ResponseEntity<User> user(
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok()
                .body(user);
    }

}
