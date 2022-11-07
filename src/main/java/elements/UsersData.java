package elements;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UsersData {

    USER_ONE(new User("sporson0@slashdot.org", "4260577H505RB5", "SyVW37Wyqw")),
    USER_TWO(new User("pwozencroft1@uol.com.br", "7060691H555RB5", "8grMELf"));


    private final User user;

}
