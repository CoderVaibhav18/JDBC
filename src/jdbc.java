import java.sql.*;
public class jdbc {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "vaibhavsathe18";
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double marks = resultSet.getDouble("marks");

                System.out.println("id: " + id);
                System.out.println("name: " + name);
                System.out.println("age: " + age);
                System.out.println("marks: " + marks);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
