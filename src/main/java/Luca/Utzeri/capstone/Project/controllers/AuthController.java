package Luca.Utzeri.capstone.Project.controllers;

import Luca.Utzeri.capstone.Project.entities.User;
import Luca.Utzeri.capstone.Project.payloads.UserDTO;
import Luca.Utzeri.capstone.Project.payloads.UserLoginDTO;
import Luca.Utzeri.capstone.Project.payloads.UserLoginResponseDTO;
import Luca.Utzeri.capstone.Project.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authSrv;

    @PostMapping("/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginDTO userLog) {
        String accessToken = authSrv.authenticateUserAndGenerateToken(userLog);
        return new UserLoginResponseDTO(accessToken);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody UserDTO newUser) throws IOException {
        return this.authSrv.save(newUser);
    }
}