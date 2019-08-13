package pl.derilius.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import pl.derilius.demo.config.AuthenticationImpl;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/public")
public class PublicController {

    private TokenEndpoint tokenEndpoint;

    @Autowired
    public PublicController(TokenEndpoint tokenEndpoint) {
        this.tokenEndpoint = tokenEndpoint;
    }

    @GetMapping("/home")
    public String home() {
        return "Home";
    }

    @PostMapping("/login")
    public ResponseEntity<OAuth2AccessToken> login(
            @RequestHeader String authorization,
            @RequestParam String username,
            @RequestParam String password
    ) throws HttpRequestMethodNotSupportedException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("username", username);
        parameters.put("password", password);
        parameters.put("grant_type", "password");
        parameters.put("scope", "ui");
        return tokenEndpoint.postAccessToken(new AuthenticationImpl(), parameters);
    }

    @GetMapping("/user")
    public String user(
            Principal principal
    ) {
        if (principal != null) {
            System.out.println(principal.toString());
            return "principal name: " + principal.getName();
        } else {
            return "principal is null";
        }
    }

}
