package Luca.Utzeri.capstone.Project.services;

import Luca.Utzeri.capstone.Project.entities.User;
import Luca.Utzeri.capstone.Project.exceptions.BadRequestException;
import Luca.Utzeri.capstone.Project.exceptions.UnauthorizedException;
import Luca.Utzeri.capstone.Project.payloads.UserDTO;
import Luca.Utzeri.capstone.Project.payloads.UserLoginDTO;
import Luca.Utzeri.capstone.Project.repositories.UserDAO;
import Luca.Utzeri.capstone.Project.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserService userSrv;
    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private UserDAO userDao;
    @Autowired
    private PasswordEncoder bcrypt;
  @Autowired
//    private MailgunConfig mailgun;

    public String authenticateUserAndGenerateToken(UserLoginDTO userLog) {
        User user = userSrv.findByEmail(userLog.email());
        if (bcrypt.matches(userLog.password(), user.getPassword())) {
            return jwtTools.createToken(user);
        } else {
            throw new UnauthorizedException("Invalid credentials, try again.");
        }
    }

    public User save(UserDTO user) throws IOException {
        userDao.findByEmail(user.email()).ifPresent(us -> {
            throw new BadRequestException("Email: " + user.email() + " already exist.");
        });
        User newUser = new User();
//        newUser.setUsername(user.username());
        newUser.setEmail(user.email());
        newUser.setPassword(bcrypt.encode(user.password()));
        newUser.setName(user.name());
        newUser.setLastName(user.lastName());
        newUser.setAvatar("https://ui-avatars.com/api/?name" + user.name() + user.lastName());
//        newUser.setUserType(TypeUser.USER);

        User savedUser = userDao.save(newUser);
//        mailgun.sendRegistrationEmail(newUser);
        return savedUser;
    }
}