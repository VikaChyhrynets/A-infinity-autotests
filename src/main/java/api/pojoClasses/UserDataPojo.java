package api.pojoClasses;

public class UserDataPojo extends MainPojo {

    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public UserDataPojo() {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }
}