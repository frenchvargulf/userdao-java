import entity.User;
import entity.UserDao;

public class Main {

    private static final UserDao userDao = new UserDao();

    public static void main(String[] args) {
        registerUser("some user 3", "password", "1353sfsf5@gmail.com");
        registerUser("some user 4", "password", "2etgde@gmail.com");
        registerUser("some user 5", "password", "e35353@gmail.com");
        readUser(25);
        readUser(136363636);
        updateUser(25, "newName", "newPassword", "newEmail@emai.com");
        updateUser(125, "newName", "newPassword", "newEmail@emai.com");
        removeUser(25);
        findUsers();
    }

    public static void registerUser(String name, String password, String email) {
        User user = new User();
        user.setUserName(name);
        user.setPassword(password);
        user.setEmail(email);
        userDao.create(user);
    }

    public static void readUser(int userId) {
        User user = userDao.read(userId);
        System.out.println(user.getUserName());
    }

    public static void updateUser(int userId, String updatedName, String updatedPassword, String updatedEmail) {
        User userToUpdate = userDao.read(userId);
        userToUpdate.setUserName(updatedName);
        userToUpdate.setEmail(updatedEmail);
        userToUpdate.setPassword(updatedPassword);
        userDao.update(userToUpdate);
    }

    public static void removeUser(int userIdToRemove) {
        userDao.remove(userIdToRemove);
    }

    public static void findUsers() {
        User[] allUsers = userDao.findAllUsers();
        for (User u : allUsers) {
            System.out.println(u.getUserName());
        }
    }

}
