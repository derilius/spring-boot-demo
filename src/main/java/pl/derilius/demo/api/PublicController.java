package pl.derilius.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import pl.derilius.demo.domain.user.LoginService;
import pl.derilius.demo.domain.user.UserFacade;
import pl.derilius.demo.domain.user.dto.LoginApi;
import pl.derilius.demo.domain.user.dto.RegisterApi;
import pl.derilius.demo.utils.AuthenticationImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/public")
public class PublicController {

    private final TokenEndpoint tokenEndpoint;
    private final UserFacade userFacade;

    @Autowired
    public PublicController(TokenEndpoint tokenEndpoint, UserFacade userFacade) {
        this.tokenEndpoint = tokenEndpoint;
        this.userFacade = userFacade;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @RequestBody RegisterApi api
    ) {
        userFacade.register(api);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<OAuth2AccessToken> login(
            @RequestBody LoginApi api,
            @RequestHeader String authorization
    ) throws HttpRequestMethodNotSupportedException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("username", api.getUsername());
        parameters.put("password", api.getPassword());
        parameters.put("grant_type", "password");
        parameters.put("scope", "ui");
        return tokenEndpoint.postAccessToken(new AuthenticationImpl(), parameters);
    }

    @GetMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return ResponseEntity.ok().build();
    }

}
