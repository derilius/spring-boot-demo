package pl.derilius.demo.domain.user;

import pl.derilius.demo.domain.user.dto.User;

class UserMapper {

    static User dto(Login login) {
        return User.builder()
                .id(login.getId())
                .mail(login.getMail())
                .password(login.getPassword())
                .firstName(login.getPerson().getFirstName())
                .lastName(login.getPerson().getLastName())
                .active(login.isActive())
                .authorities(login.getAuthorities())
                .build();
    }

}
