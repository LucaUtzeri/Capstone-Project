package Luca.Utzeri.capstone.Project.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(UUID id){
        super("user id: " + id + " was not found.");
    }

    public NotFoundException(int id){
        super("id: " + id + " was not found.");
    }
}
