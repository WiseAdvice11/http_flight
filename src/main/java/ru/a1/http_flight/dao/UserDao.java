package ru.a1.http_flight.dao;

import ru.a1.http_flight.entity.User;
import ru.a1.http_flight.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<Long,User> {

    private static final UserDao INSTANCE = new UserDao ();

    public static UserDao getInstance() {
        return INSTANCE;
    }

    private static final String SAVE_SQL = "INSERT INTO users (name, birthday, email, password, role, gender) " +
                                           "VALUES (?,?,?,?,?,?)";

    @Override
    @SneakyThrows
    public User save(User entity) {
        try (var connection = ConnectionManager.open();
             var preparedStatement = connection.prepareStatement(SAVE_SQL,Statement.RETURN_GENERATED_KEYS)  )  {

            // Записываем обьект в таблицу
            preparedStatement.setObject(1, entity.getName());
            preparedStatement.setObject(2, entity.getBirthDay());
            preparedStatement.setObject(3, entity.getEmail());
            preparedStatement.setObject(4, entity.getPassword());
            preparedStatement.setObject(5, entity.getRole().name());
            preparedStatement.setObject(6, entity.getGender().name());

            // Записываем  id  в обьект если новая запись появилась.
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id",Long.class));

            return entity;
        }


    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }
}
