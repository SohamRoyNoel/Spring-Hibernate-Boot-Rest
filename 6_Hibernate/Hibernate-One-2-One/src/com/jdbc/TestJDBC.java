package com.jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {

		// Windows Authentication
		String ClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String IPAddr = "DESKTOP-LHLA0PA;";
		String DBName="hb_student_tracker";
		String DB_URL = "jdbc:sqlserver://DESKTOP-LHLA0PA;DatabaseName=hb_student_tracker;integratedSecurity=true" ;
		Connection cons = dbConnect (DB_URL,ClassName);
	}

	private static Connection dbConnect(String db_connect_string, String className) {
		java.sql.Connection connection = null;
		String libpath = System.getProperty("java.library.path");
		// Get the apth for AUTHENTICATION DLLs
		libpath = "E:\\Jars\\spring-framework-5.2.6.RELEASE\\SSMS-connection\\sqljdbc_8.2\\enu\\auth\\x64\\;" +libpath;
		System.out.println(libpath);
		Field sysPathsField;
		try {
			sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
			sysPathsField.setAccessible(true);
			sysPathsField.set(null, null);
		} catch (NoSuchFieldException | SecurityException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		try {
			Class.forName(className);
		} catch (UnsatisfiedLinkError | ClassNotFoundException e) {
			System.err.println("Native code library failed to load.\n" + e);
			System.exit(1);
		}
		try{
			connection = DriverManager.getConnection(db_connect_string);
			System.out.println("Connected");

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
