package SpringBootCourse.services;

import SpringBootCourse.models.User;
import SpringBootCourse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> showUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User showOneUser(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Transactional
    public void delete(int id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    @Transactional
    public void add(User user) {
        userRepository.save(user);
    }

    public void update(int id, User user) {
        user.setId(id);
        userRepository.save(user);
    }
}
