package api.pojoClasses;

public class RegisterPojo extends MainPojo {

    private String email;
    private String password;

    public RegisterPojo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public RegisterPojo() {

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}