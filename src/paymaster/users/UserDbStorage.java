package paymaster.users;

import paymaster.accounts.AccountTypeEnum;
import paymaster.log.Log;

import java.sql.*;
import java.util.*;

public class UserDbStorage implements IUserStorage {

    private static String connectionString = "jdbc:mysql://localhost:3306/javatrain";
    private static String login = "root";
    private static String passw = "root";

    private Connection conn;
    public HashMap<Integer, User> users = new HashMap<>();

    public UserDbStorage() {
        try {
            Driver dbDriver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
            DriverManager.registerDriver(dbDriver);
            conn = DriverManager.getConnection(connectionString, login, passw);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int getSize() {
        return users.size();
    }

    public HashMap<Integer, User> loadUsers(){

        users = new HashMap<>();

        String sql = String.format("SELECT u.id, u.name, a.type, a.amount FROM users u INNER JOIN accounts a ON u.id = a.user_id");
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                if (rs.getString("type") == "paymaster.accounts.SavingsAccount") {
                    User u = new User(rs.getString("name"), AccountTypeEnum.SAVINGS, rs.getDouble("amount"));
                    users.put(rs.getInt("id"), u);
                } else {
                    User u = new User(rs.getString("name"), AccountTypeEnum.CHECKING, rs.getDouble("amount"));
                    users.put(rs.getInt("id"), u);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public boolean addUser(User u) {
        String sql = String.format("INSERT INTO users (name) VALUES ('%s')", u.getName());
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                Log.printlnError("Problem with insert user");
                return false;
            }

            ResultSet keys = stmt.getGeneratedKeys();
            Integer key = -1;
            if (keys.next()) {
                key = keys.getInt(1);
            }

            PreparedStatement stmtAcc = conn.prepareStatement(
                    String.format("INSERT INTO accounts (user_id, type, amount) " +
                            "VALUES (%d, '%s', %f)", key, u.getAccount().getClass().getName(), u.getAccount().getBalance()
                    )
            );
            affectedRows = stmtAcc.executeUpdate();
            if (affectedRows == 0) {
                Log.printlnError("Problem with insert account");
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        loadUsers();
        return true;
    }

    public User findUser(String username) {
        for(Integer uid: users.keySet()) {
            if (users.get(uid).getName().equals(username)) {
                return users.get(uid);
            }
        }
        Log.printlnError("User not found");
        return null;
    }

    public void sort(Comparator<User> cmp) {
        return;
    }

    public void printUsers() {
        System.out.println(" --- --- --- ");
        System.out.println(" USERS LIST  ");
        System.out.println(" --- --- --- ");
        users.forEach((k,v)->{System.out.format("#%d %s ACCID: %d BAL: %f\n", k, v.getName(), v.getAccount().getId(), v.getAccount().getBalance());});
        System.out.println(" --- --- --- ");
    }
}
