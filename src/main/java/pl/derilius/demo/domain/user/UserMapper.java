package pl.derilius.demo.domain.user;

import pl.derilius.demo.domain.user.dto.User;

class UserMapper {

    static User dto(Login login) {
        return User.builder()
                .id(login.getId())
                .mail(login.getMail())
                .password(login.getPassword())
                .firstName(login.getPeople().getFirstName())
                .lastName(login.getPeople().getLastName())
                .active(login.isActive())
                .authorities(login.getAuthorities())
                .build();
    }

}
