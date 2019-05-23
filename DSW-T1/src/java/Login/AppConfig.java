package Login;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter{
    private static DataSource dataSource;
    private final String USER_SELECT = "SELECT email, senha, ativo FROM Usuario WHERE email = ?";
    private final String ROLE_SELECT = "SELECT u.email, p.nome FROM Usuario u, Papel p,"
                + " Usuario_Papel up WHERE up.usuario_id = u.id and"
                + " up.papel_id = p.id and u.email = ?";

    
    public AppConfig() throws ClassNotFoundException {
        dataSource = AppConfig.getDataSource();
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder builder)throws Exception{
        builder.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery(USER_SELECT)
            .authoritiesByUsernameQuery(ROLE_SELECT)
            .passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
            // teatro
            .antMatchers("/teatro/form.jsf").hasAnyRole("TEATRO, ADMIN") 
                
            // site
            .antMatchers("/site/form.jsf").hasAnyRole("SITE, ADMIN")
            .antMatchers("/site/detalhes.jsf").hasAnyRole("SITE, ADMIN")
                
            // promocoes
            .antMatchers("/promocao/form.jsf").hasAnyRole("ADMIN, TEATRO")
            //.anyRequest().permitAll()
            .and().formLogin()
            .and().rememberMe()
            .and().httpBasic()
            .and().logout().logoutSuccessUrl("/")
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
                    
        http.csrf().disable();
    }
    
    public static DataSource getDataSource() throws ClassNotFoundException {

        if (dataSource == null) {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/Trabalho1";
            String user = "root";
            String password = "root";
            dataSource = new DriverManagerDataSource(url, user, password);
        }

        return dataSource;
    }
    
}
