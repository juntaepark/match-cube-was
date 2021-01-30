package com.carnival.matchcube;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.SpringApplication;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@SpringBootApplication
public class MatchCubeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatchCubeApplication.class, args);
	}
    //	MyBatis는 App 전체에서 활용할 수 있도록 Application Class에서 초기화 rjrj
    //	아래 코드를 참고해 JavaBean을 생성
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		// /src/main/resources/mapper/*Mapper.xml 파일들을 불러들이기로 설정
		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
		sessionFactory.setMapperLocations(res);
		return sessionFactory.getObject();
	}

}