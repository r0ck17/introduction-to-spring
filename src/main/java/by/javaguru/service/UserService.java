package by.javaguru.service;

import by.javaguru.listener.AccessType;
import by.javaguru.listener.EntityEvent;
import by.javaguru.model.User;
import by.javaguru.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public UserService(UserRepository userRepository,
                       ApplicationEventPublisher eventPublisher) {
        this.userRepository = userRepository;
        this.eventPublisher = eventPublisher;
    }

    public Optional<User> findUserById(Long id) {
        eventPublisher.publishEvent(new EntityEvent(Optional.empty(), AccessType.READ));
        Optional<User> userById = userRepository.findUserById(id);
        userById.ifPresent(entity -> eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ, true)));

        return userById;
    }
}
