package pl.derilius.demo.api;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.derilius.demo.domain.user.dto.User;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value = "/")
@Api(tags = "User", produces = "application/json", consumes = "application/json")
public class UserController {

    @GetMapping("/user")
    public ResponseEntity<User> user(
            @ApiIgnore @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok()
                .body(user);
    }

}
