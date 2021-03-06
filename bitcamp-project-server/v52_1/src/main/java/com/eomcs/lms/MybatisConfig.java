package com.eomcs.lms;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// Mybatis DAO 프록시를 자동생성할 인터페이스를 지정한다.
@MapperScan("com.eomcs.lms.dao")
public class MybatisConfig {


  public MybatisConfig() {
    System.out.println("MybatisConfig 객체 생성!");
  }


  // Spring IoC 컨테이너에 수동으로 객체를 등록하고 싶다면,
  // 수동으로 등록할 객체를 리턴하는 팩토리 메서드를 만든다.
  // => 단 메서드 선언부에 @Bean 애노테이션을 붙여야한다.
  // => 그래야만 Spring IoC 컨테이너는
  // 이 메서드를 호출하고 그 리턴값을 보관한다


  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource, // DB 커낵션풀
      ApplicationContext appCtx // Spring IoC 컨테이너
  ) throws Exception {

    // Spring IoC 컨테이너 용으로 mybatis 측에서 따로 제작한
    // SqlSessionFactory 이다
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setTypeAliasesPackage("com.eomcs.lms.domain");
    sqlSessionFactoryBean.setMapperLocations(
        // Spring IoC 컨테이너를 통해 SQL 맵퍼 파일의 위치 정보를 가져온다
        appCtx.getResources("classpath:com/eomcs/lms/mapper/*Mapper.xml"));
    return sqlSessionFactoryBean.getObject();
  }

}
