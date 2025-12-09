import java.sql.*;


public class DemoInsertDynamicData {

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

    /**
     *
     * when we have dynamic values to insert and we are clear about the query
     * then we should use preparedStatement.
     * create the query with '?' for all the placeholders then set them by column index using PreparedStatement obj.
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
        String query = "insert into student value(?,?)";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,username,pass);
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, 4);
        st.setString(2, "Mandeep");
        int rowsAffected = st.executeUpdate();

        System.out.println(rowsAffected + " Row(s) are Affected" );

        st.close();
        con.close();

    }

}
