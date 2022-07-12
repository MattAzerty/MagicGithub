package com.openclassrooms.magicgithub.api;

import com.openclassrooms.magicgithub.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS_RANDOM;
import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.generateUsers;

public class FakeApiService implements ApiService {

    private List<User> users = generateUsers();
    private List<User> randomUserList = new ArrayList<>(FAKE_USERS_RANDOM);


    /**
     * Return a list of {@link User}
     * Those users must be generated by {@link FakeApiServiceGenerator}
     */
    @Override
    public List<User> getUsers() {
        // return users list
        return users;
    }

    /**
     * Generate a random {@link User} and add it {@link FakeApiService#users} list.
     * This user must be get from the {@link FakeApiServiceGenerator#FAKE_USERS_RANDOM} list.
     */
    @Override
    public void generateRandomUser() {
        // generate a random user from FAKE_USERS_RANDOM list while avoiding repetition as much as possible

        Random rand = new Random();
        User randomUser = User.random();

        while (users.contains(randomUser)){

            if (users.containsAll(FAKE_USERS_RANDOM)){
                break;
            }
            randomUserList.remove(randomUser);
            randomUser = randomUserList.get(rand.nextInt(randomUserList.size()));
        }
        users.add(randomUser);
    }

    /**
     * Delete a {@link User} from the {@link FakeApiService#users} list.
     */
    @Override
    public void deleteUser(User user) {
        //remove user from users list
        users.remove(user);
    }
}
