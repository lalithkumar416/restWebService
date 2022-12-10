package com.learning.restWebService.users;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UsersDaoLayer {
    private static final List<UserModel> users = new ArrayList<>();

    private static int userCount = 0;
    static {
        users.add(new UserModel(++userCount,"Adam", LocalDate.now().minusYears(30)));
        users.add(new UserModel(++userCount,"Eve",LocalDate.now().minusYears(25)));
        users.add(new UserModel(++userCount,"Jim",LocalDate.now().minusYears(20)));
    }

    public List<UserModel> findAll() {
        return users;
    }

    public UserModel save(UserModel user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public UserModel findOne(int userId) {
        return users.stream().filter(userModel -> userModel.getId() == (userId)).findFirst().orElse(null);
    }

    public void deleteById(int userId) {
        Predicate<? super UserModel> predicate = user -> user.getId() == (userId);
        users.removeIf(predicate);
    }
}
