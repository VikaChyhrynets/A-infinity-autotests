package elements;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String email;
    private String passportID;
    private String password;

    public User(UserBuilder builder) {
        this.email = builder.email;
        this.passportID = builder.passportID;
        this.password = builder.password;
    }


    public static class UserBuilder {
        private String email;
        private String passportID;
        private String password;


        public UserBuilder() {
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withPassportID(String passportID) {
            this.passportID = passportID;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }


    }


}
