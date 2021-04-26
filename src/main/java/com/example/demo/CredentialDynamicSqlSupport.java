package com.example.demo;

import java.sql.JDBCType;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CredentialDynamicSqlSupport {
	
	public static final Credential credential = new Credential();
	
	public static final class Credential extends SqlTable {
		
        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);
        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public Credential() {
            super("credential");
        }
        
    }

}
