package net.yorksolutions.maymemobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/")
@CrossOrigin
public class MemosController {

    private MemosService service;

    @Autowired
    public MemosController(@NonNull MemosService service){
        this.service = service;
    }

    @GetMapping("/register")
    public void register(@RequestParam String username, String password){
        service.register(username, password);
    }

    @GetMapping("/login")
    public UUID login(@RequestParam String username, String password) {
        return service.login(username, password);
    }


}
