package com.tz.online.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

    private static Properties prop;
    private static final String FILEPATH = "db_config.properties";
    
    static {
        // ���ҵ�srcΪ��Ŀ¼�����ļ���ת��Ϊ������
        InputStream inStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream(FILEPATH);
        prop = new Properties();
        try {
            prop.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // �ṩ��ȡ����Connection����
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String className = prop.getProperty("oracleDriver");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        String url = prop.getProperty("url");
        Class.forName(className);
        return DriverManager.getConnection(url, user, password);
    }
    
    // �ṩ�ر���Դ�ķ���
    public static void close(ResultSet rs, Statement st, Connection conn) throws SQLException {
        if (rs != null) {
            rs.close();
    }
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    
    // �ṩ�ر���Դ�ķ���
    public static void close(Statement st, Connection conn) throws SQLException {
    	if (st != null) {
    		st.close();
    	}
    	if (conn != null) {
    		conn.close();
    	}
    }
}
