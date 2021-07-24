package ru.a1.http_flight.service;

import ru.a1.http_flight.dao.UserDao;
import ru.a1.http_flight.dto.CreateUserDto;
import ru.a1.http_flight.entity.User;
import ru.a1.http_flight.exception.ValidationException;
import ru.a1.http_flight.mapper.CreateUserMapper;
import ru.a1.http_flight.validator.CreateUserValidator;
import ru.a1.http_flight.validator.ValidationResult;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final CreateUserMapper    createUserMapper    = CreateUserMapper.getInstance();
    private final UserDao             userDao             = UserDao.getInstance();


    public Long create (CreateUserDto userDto) {
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.mapFrom(userDto);
        userDao.save(userEntity);

        return userEntity.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }

}
