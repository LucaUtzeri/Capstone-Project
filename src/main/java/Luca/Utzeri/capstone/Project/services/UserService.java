package Luca.Utzeri.capstone.Project.services;

import Luca.Utzeri.capstone.Project.entities.User;
import Luca.Utzeri.capstone.Project.exceptions.NotFoundException;
import Luca.Utzeri.capstone.Project.repositories.UserDAO;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private Cloudinary cloudinaryUploader;

    public User findByEmail(String email) {
        return userDAO.findByEmail(email).orElseThrow(() -> new NotFoundException("Email " + email + " not found."));
    }

    public User findById(UUID id){
        return userDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public User findByIdAndUpdate(UUID id, User user){
        User userFound = this.findById(id);
//        userFound.setUsername(user.getUsername());
        userFound.setEmail(user.getEmail());
        userFound.setPassword(user.getPassword());
        userFound.setName(user.getName());
        userFound.setLastName(user.getLastName());

        return userDAO.save(userFound);
    }

    public void findByIdAndDelete(UUID userId) {
        User userFound = this.findById(userId);
        userDAO.delete(userFound);
    }

    public User uploadAvatar(UUID id, MultipartFile file) throws IOException {
        User userFound = this.findById(id);
        String avatarURL = (String) cloudinaryUploader.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
        userFound.setAvatar(avatarURL);
        return userDAO.save(userFound);
    }
}
