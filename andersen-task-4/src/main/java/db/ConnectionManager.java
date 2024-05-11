package db;

import java.sql.*;

public class ConnectionManager {
    private static Connection cn = null;

    static {
        try {
            Class.forName(DBConstants.DRIVER_DB);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        try {
            if (cn == null || cn.isClosed()){
                cn = DriverManager.getConnection(
                        DBConstants.URL_DB,
                        DBConstants.USER_DB,
                        DBConstants.PASSWORD_DB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cn;
    }

    public static void closeConnection(){
        if (cn != null){
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement st){
        if (st != null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
