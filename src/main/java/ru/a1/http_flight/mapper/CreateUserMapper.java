package ru.a1.http_flight.mapper;

import ru.a1.http_flight.dto.CreateUserDto;
import ru.a1.http_flight.entity.Gender;
import ru.a1.http_flight.entity.Role;
import ru.a1.http_flight.entity.User;
import ru.a1.http_flight.util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, User> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .birthDay(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))

                .build();
    }
}
