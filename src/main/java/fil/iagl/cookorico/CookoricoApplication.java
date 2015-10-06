package fil.iagl.cookorico;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
@MapperScan(value = "fil.iagl.cookorico.dao")
public class CookoricoApplication {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);

		final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(resolver.getResources("classpath*:**/*Mapper.xml"));

		return sessionFactory.getObject();
	}

	@Bean
	public DataSource dataSource() {

		BasicDataSource ds = new BasicDataSource();
		ds.setUsername("cookorico");
		ds.setPassword("cookorico");
		 ds.setUrl("jdbc:postgresql://172.28.1.104:5432/cookoricodb");
//		// url to dev at home
//		ds.setUrl("jdbc:postgresql://localhost:5432/cookoricodb");
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setMaxWait(25);
		return ds;
	}

	public static void main(String[] args) {
		SpringApplication.run(CookoricoApplication.class, args);
	}
}