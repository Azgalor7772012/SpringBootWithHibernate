package SpringBootCourse.services;

import SpringBootCourse.models.User;
import java.util.List;


public interface Service {


    public List<User> showUsers();


    public User showOneUser(Long id);


    public void delete(Long id);

    public void add(User user);

}
