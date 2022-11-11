package SpringBootCourse.services;

import SpringBootCourse.models.User;
import SpringBootCourse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserUserServiceHibernate implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserUserServiceHibernate(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> showUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User showOneUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void add(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void update(User user) {
        userRepository.save(user);
    }

}
