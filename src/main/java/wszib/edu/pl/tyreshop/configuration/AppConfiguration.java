package wszib.edu.pl.tyreshop.configuration;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("wszib.edu.pl.tyreshop")
public class AppConfiguration {

    @Bean(name="entityManagerFactory")
    public SessionFactory sessionFactory(){
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }


}
