import java.sql.*;


public class DemoInsertDataClass {

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

        int userid = 3;
        String uname = "Asmit";

        /**
         * select only one data based on condition.
         */
        String query = "insert into student value("+ userid + ",'" + uname+ "')";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,username,pass);
        Statement st = con.createStatement();
        int rowsAffected = st.executeUpdate(query);

        System.out.println(rowsAffected + " Row(s) are Affected" );

        st.close();
        con.close();

    }

}
