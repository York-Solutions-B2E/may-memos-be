package net.yorksolutions.maymemobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Service
public class MemosService {

    private UserAccountRepository repository;

    private HashMap<UUID, Long> tokenMap;

    @Autowired
    public MemosService(@NonNull UserAccountRepository repository) {
        this.repository = repository;
        this.tokenMap = new HashMap<>();
    }

    public void register(String username, String password) {
        if (repository.findByUsername(username).isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        } else {
            repository.save(new UserAccount(username, password));
        }
    }

    public UUID login(String username, String password) {
        Optional<UserAccount> result = repository.findByUsernameAndPassword(username, password);
        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        else {
            final UUID token = UUID.randomUUID();
            tokenMap.put(token, result.get().id);
            return token;
        }

    }

    public void anotherFunction(UUID token) {
        // check to see if the user is logged in.

        // if they are not, return unauthorized.

        // else, do some functionality.
    }

    public void logout(UUID token) {
        // remove their token, id from the hashmap
    }
}













