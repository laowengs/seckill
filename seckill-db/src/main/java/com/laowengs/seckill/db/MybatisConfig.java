package com.laowengs.seckill.db;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

@Configurable
@EnableTransactionManagement
@MapperScan(basePackages = "com.laowengs.seckill.db.dao", sqlSessionTemplateRef  = "defaultSqlSessionTemplate")
public class MybatisConfig {


    @Bean(name = "defaultDataSource")
    @Primary
    public DataSource defaultDataSource() {
        DataSource dataSource = null;
        try {
            Properties properties = new Properties();
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return dataSource;
    }
    @Bean(name = "defaultSqlSessionFactory")
    @Primary
    public SqlSessionFactory defaultSqlSessionFactory(@Qualifier("defaultDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        return bean.getObject();
    }
    @Bean("defaultSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate defaultSqlSessionTemplate(
            @Qualifier("defaultSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("defaultDataSource") DataSource dataSource) {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return manager;
    }

}
