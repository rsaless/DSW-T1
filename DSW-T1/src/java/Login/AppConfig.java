package Login;

import javax.sql.DataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter{
    private final DataSource dataSource;
    private final String USER_SELECT = "SELECT email, senha, ativo FROM Usuario WHERE email=?";
    private final String ROLE_SELECT = "SELECT email, nome FROM Papel WHERE email=?";

    
    public AppConfig() throws ClassNotFoundException {
        dataSource = JDBCUtil.getDataSource();
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
            .antMatchers("/teatro/cadastro", "/teatro/insercao", "/teatro/remocao", "/teatro/edicao", "/teatro/atualizacao").hasAnyRole("ADMIN") 
                
            // site
            .antMatchers("/site/cadastro", "/site/insercao", "/site/remocao", "/site/edicao", "/site/atualizacao").hasAnyRole("ADMIN")
            .antMatchers("/site/detalhes/**").hasAnyRole("SITE, ADMIN")
                
            // promocoes
            .antMatchers("/promocao/cadastro", "/promocao/insercao", "/promocao/remocao",
                         "/promocao/edicao", "/promocao/atualizacao").hasAnyRole("ADMIN, TEATRO")
            
            .and().formLogin()
            .and().rememberMe()
            .and().httpBasic()
            .and().logout().logoutSuccessUrl("/")
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
                    
        http.csrf().disable();
    }
    
}
