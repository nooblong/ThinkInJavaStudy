package annotations;

import java.util.List;

public class PasswordUtils {
    @UseCase(id = 47, description = "Passwords must contain at least one numeric")
    public boolean validataPassword(String password){
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "new password can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prePassword, String password){
        return !prePassword.contains(password);
    }
}
