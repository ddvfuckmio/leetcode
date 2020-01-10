package codes.api.compare;

import java.util.Arrays;
import java.util.Comparator;

public class User {
    public int id;
    public String name;

    public User() {}

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        User user1 = new User(1, "tom");
        User user2 = new User(2, "jack");
        User user3 = new User(3, "jk");

        User[] userList = {user3, user2, user1};

        Arrays.sort(userList, new UserComparator());

        for (User user : userList) {
            System.out.println(user);
        }
    }
}

class UserComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.id - o2.id;
    }
}
