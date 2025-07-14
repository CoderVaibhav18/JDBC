import java.sql.*;
public class delete {
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
            String query = String.format("DELETE FROM students WHERE id = %d", 2);
            int rows = statement.executeUpdate(query);
            if(rows>0){
                System.out.println("deleted successfully");
            }else{
                System.out.println("deleted not affected");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
