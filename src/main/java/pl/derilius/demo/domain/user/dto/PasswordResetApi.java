package pl.derilius.demo.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordResetApi {

    @NotBlank
    private String newPassword;

    @NotBlank
    private String repeatedPassword;

}
