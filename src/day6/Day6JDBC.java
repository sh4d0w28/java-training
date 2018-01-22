package day6;

import java.sql.*;

// 1a - you need include and build instance of a class, cast as Driver, register with DriverManager
// 2

public class Day6JDBC {

    static Connection conn;
    static String connectionString = "jdbc:mysql://localhost:3306/javatrain";
    static String login = "root";
    static String passw = "root";


    public static void main(String[] args) throws SQLException {
        try {
            Driver dbDriver = (Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
            DriverManager.registerDriver(dbDriver);
            conn = DriverManager.getConnection(connectionString, login, passw);
            Statement stmt = conn.createStatement();

            String sql  = "CREATE TABLE IF NOT EXISTS products (\n" +
                    "    id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    name VARCHAR(40),\n" +
                    "    price DECIMAL\n" +
                    ");";
            stmt.execute(sql); // used for ANYTHING! (select, update, delete, ....)
            // ResultSet rs = stmt.executeQuery()  -  for SELECT stmts
            // Integer rows = stmt.executeUpdate(sql) - for anything else INSERT / UPDATE / DELETE....
            stmt.executeUpdate("TRUNCATE TABLE products");
            int truncatedRows = stmt.executeUpdate(sql);
            System.out.format("%d records was truncated\n", truncatedRows);

            sql = "INSERT INTO products(name,price) VALUES " +
                    "('Item#1111', 10.50)," +
                    "('Item#2222', 20.17)," +
                    "('Water bottle', 15)";
            int affectedRows = stmt.executeUpdate(sql);
            System.out.format("%d records was inserted\n", affectedRows);

            sql = "UPDATE products SET price = 2 WHERE id = 1";
            int updatedRows = stmt.executeUpdate(sql);
            System.out.format("%d records was updated\n", updatedRows);

            sql = "SELECT * FROM products";

            if(stmt.execute(sql)) {
                ResultSet rs = stmt.getResultSet();  // several sets for
                ResultSet rs2 = stmt.getResultSet(); // double-sql-select
            }

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("[ -- products -- ]");
            while(rs.next()) {
                System.out.format("#%d %15s (%10.2f)\n", rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
            }

            // rs.beforeFirst(); // will reset result

            PreparedStatement ps = conn.prepareStatement("select * from products where id = ?");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            conn.close();
        }
    }
}
