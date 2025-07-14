import java.sql.*;

public class insertIntoDb {
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
            String query = String.format("INSERT INTO students(name, age, marks) VALUES('%s', %o, %f)", "Pratisha", 20, 76.9);
            System.out.println(query);
            int rows = statement.executeUpdate(query);

            if(rows > 0){
                System.out.println("Data inserted successfully: "+ rows);
            }else{
                System.out.println("Data not inserted");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

