//package fil.iagl.cookorico;
//
////@Configuration
////@EnableWebSecurity
//public class CookoricoSecurityConfiguration extends WebSecurityConfigurerAdapter{
////
////	@Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////            .authorizeRequests()
////                .antMatchers("/", "/home").permitAll()
////                .anyRequest().authenticated()
////                .and()
////            .formLogin()
////                .loginPage("/test")
////                .permitAll()
////                .and()
////            .logout()
////                .permitAll();
////    }
////
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth
////            .inMemoryAuthentication()
////                .withUser("user").password("password").roles("USER");
////    }
//	
//}
