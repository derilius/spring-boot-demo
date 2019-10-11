package pl.derilius.demo.domain.user;

import pl.derilius.demo.domain.user.dto.UserDTO;

class UserMapper {

    static UserDTO dto(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .authorities(user.getAuthorities())
                .build();
    }

}
