package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author darren
 * @create 2020-08-02 10:39
 */
public class DaoUtil {

    private static ThreadLocal<Connection> tl;
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    private static Properties properties;

    static{
        tl = new ThreadLocal<>();
        //获取作为流的资源
        InputStream is = DaoUtil.class.getClassLoader().getResourceAsStream("db.properties");
        properties = new Properties();
        try {
            properties.load(is);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            /*
             * Class.forName("");的作用是要求JVM查找并加载指定的类，如果在类中有静态初始化器的话，
             * JVM必然会执行该类的静态代码段。而在JDBC规范中明确要求这个Driver类必须向
             * DriverManager注册自己，
             */
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {

        Connection connection = tl.get();
        if(connection==null){
            connection = DriverManager.getConnection(url,user,password);
            tl.set(connection);
        }

        return connection;
    }

    public static void closeConnection() throws SQLException {

        Connection connection = tl.get();
        if(connection!=null) {
            connection.close();
            tl.remove();
        }


    }
}
