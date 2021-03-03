package org.geektimes.projects.user.service;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.repository.UserRepository;
import org.geektimes.projects.user.sql.DBConnectionManager;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

import static org.geektimes.projects.user.sql.DBConnectionManager.DATABASE_URL;


/**
 * @author Lin Zehuan
 */
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl() {

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        DBConnectionManager dbConnectionManager = new DBConnectionManager();
        try {
            dbConnectionManager.setConnection(DriverManager.getConnection(DATABASE_URL));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DatabaseUserRepository databaseUserRepository = new DatabaseUserRepository(dbConnectionManager);
        this.userRepository = databaseUserRepository;
    }

    @Override
    public boolean register(User user) {

        return userRepository.save(user);
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return null;
    }
}
