package SpringBootCourse.services;

import SpringBootCourse.models.User;
import java.util.List;


public interface UserService {


    public List<User> showUsers();


    public User showOneUser(Long id);


    public void delete(Long id);

    public void add(User user);

    public void update(User user);

}
