package pl.derilius.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.derilius.demo.domain.user.dto.UserDTO;

@RestController
@RequestMapping(value = "/private")
public class PrivateController {

    @GetMapping("/user")
    public ResponseEntity<UserDTO> user(
            @AuthenticationPrincipal UserDTO user
    ) {
        return ResponseEntity.ok()
                .body(user);
    }

}
