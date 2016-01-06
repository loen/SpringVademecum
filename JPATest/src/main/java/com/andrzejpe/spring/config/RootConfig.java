package com.andrzejpe.spring.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


/**
 * Created by jedrek on 2016-01-06.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.andrzejpe.spring", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {


        @Bean
        public DataSource dataSource(){
                EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
                EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL)
                        .addScript("/db/create.sql")
                        .addScript("/db/insert.sql")
                        .build();
                return db;
        }

        @Bean
        public  JpaVendorAdapter jpaVendorAdapter() {
                HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
                adapter.setDatabase(Database.HSQL);
                adapter.setShowSql(true);
                adapter.setGenerateDdl(false);
                adapter.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");
                return adapter;
        }

        @Bean
        public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource ds,
                                                                                             JpaVendorAdapter jpaVendorAdapter){
                LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
                emfb.setDataSource(ds);
                emfb.setJpaVendorAdapter(jpaVendorAdapter);
                emfb.setPackagesToScan("com.andrzejpe.spring.dao");
                return emfb;
        }

        @Bean
        public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
                return new JpaTransactionManager(entityManagerFactory);
        }

        @Bean
        public BeanPostProcessor persistenceTranslation() {
                return new PersistenceExceptionTranslationPostProcessor();
        }

        @Bean
        public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
                return new PersistenceAnnotationBeanPostProcessor();
        }
}
