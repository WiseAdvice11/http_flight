package ru.a1.http_flight.mapper;

public interface Mapper <F,T> {

    T mapFrom(F object);

}
