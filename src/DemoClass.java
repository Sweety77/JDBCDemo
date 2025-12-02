import java.sql.*;


public class DemoClass {

    /*
    read about class.forName from telusko video
     */

    /**
     *
     * 7 steps of JDBC Connection.
     * 1. import --> java.sql
     * 2. load and register the Driver --> com.sql.jdbc.Driver
     * 3. Create Connection --> Connection
     * 4. Create Statement --> Statement
     * 5. execute the query
     * 6. Processes the result
     * 7. close
     *
     */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url ="jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String pass = "root";

        /**
         * select only one data based on condition.
         */
        String query1 = "select username from student where userid =1";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,username,pass);
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query1);

        resultSet.next();
        String name = resultSet.getString("username");

        System.out.println("Name = " + name);


        /**
         * select all data from the student table
         */

        String query2 = "select * from student";


        ResultSet tableData = st.executeQuery(query2);

        String userData = "";
        while (tableData.next()){
            userData = tableData.getInt(1) +" : " + tableData.getString(2);
            System.out.println(userData);
        }


        st.close();
        con.close();

    }

}
