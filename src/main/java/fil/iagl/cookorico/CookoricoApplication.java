package fil.iagl.cookorico;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import fil.iagl.cookorico.security.CsrfHeaderFilter;

@SpringBootApplication
@MapperScan( "fil.iagl.cookorico.dao")
public class CookoricoApplication {

	@Autowired
	private DataSource dataSource;

	@Bean
	public DataSource dataSource() {

		BasicDataSource ds = new BasicDataSource();
		ds.setUsername("cookorico");
		ds.setPassword("cookorico");
		ds.setUrl("jdbc:postgresql://172.28.1.104:5432/cookoricodb");
		// url to dev at home
		// ds.setUrl("jdbc:postgresql://localhost:5432/cookoricodb");
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setMaxWait(25);
		return ds;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}

	// Security

	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class CookoricoSecurityConfiguration extends WebSecurityConfigurerAdapter {

		private CsrfTokenRepository csrfTokenRepository() {
			HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
			repository.setHeaderName("X-XSRF-TOKEN");
			return repository;
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.httpBasic().and().authorizeRequests().antMatchers("/index.html", "/home.html", "/login.html", "/")
					.permitAll().anyRequest().authenticated().and().csrf().csrfTokenRepository(csrfTokenRepository())
					.and().addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(CookoricoApplication.class, args);
		
	}
}