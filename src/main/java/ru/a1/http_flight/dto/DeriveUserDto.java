package ru.a1.http_flight.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DeriveUserDto {

    String name;
    String birthDay;
    String email;
    String password;
    String role;
    String gender;






}
