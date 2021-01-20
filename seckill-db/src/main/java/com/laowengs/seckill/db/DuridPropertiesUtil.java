package com.laowengs.seckill.db;


import java.util.Properties;

public final class DuridPropertiesUtil {
    private DuridPropertiesUtil() {
    }

    public static Properties jdbcProperties(JdbcProperties jdbcProperties){
        Properties properties = new Properties();
        properties.put("url",jdbcProperties.getUrl());
        properties.put("username",jdbcProperties.getUsername());
        properties.put("password",jdbcProperties.getPassword());
        return properties;
    }
}
