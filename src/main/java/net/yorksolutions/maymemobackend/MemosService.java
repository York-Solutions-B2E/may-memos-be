package net.yorksolutions.maymemobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MemosService {

    private UserAccountRepository repository;

    @Autowired
    public MemosService(@NonNull UserAccountRepository repository) {
        this.repository = repository;
    }

    public void register(String username, String password) {
        if (repository.findByUsername(username).isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        } else {
            repository.save(new UserAccount(username, password));
        }
    }

    public void login() {}
}
