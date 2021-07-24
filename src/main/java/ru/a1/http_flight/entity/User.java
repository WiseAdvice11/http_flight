package ru.a1.http_flight.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Long      id ;
    private String    name ;
    private LocalDate birthDay ;
    private String    email ;
    private String    password ;
    private Role      role ;
    private Gender    gender ;

}
