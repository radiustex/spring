package web.service;
import web.model.User;
import java.util.List;

public interface UserService {
    void createUsersTable();
    void saveUser(User user);
    void removeUserById(long id);
    User getUserById(long id);
    List<User> getUsers();
    void updateUser(long id, User updatedUser);
}