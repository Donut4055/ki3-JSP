package Model;

import java.util.*;

public class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    // Thêm người dùng vào danh sách
    public void addUser(User user) {
        users.add(user);
    }

    // Lấy danh sách người dùng
    public List<User> getUsers() {
        return users;
    }

    // Xóa người dùng theo id
    public void removeUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}

