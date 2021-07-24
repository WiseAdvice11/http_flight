package ru.a1.http_flight.validator;

import ru.a1.http_flight.dto.CreateUserDto;
import ru.a1.http_flight.entity.Gender;
import ru.a1.http_flight.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto> {

private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        var validationResult = new ValidationResult();
        if (!LocalDateFormatter.IsValid(object.getBirthday())) {
            validationResult.add(Error.of("Invalid birthday format","format is not correct"));
        }
        if(Gender.valueOf(object.getGender())==null) {

            validationResult.add(Error.of("invalid gender","Gender is invalid"));
        }
        return validationResult;
    }


}
