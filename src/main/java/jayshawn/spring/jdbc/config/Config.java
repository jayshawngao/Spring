package jayshawn.spring.jdbc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:applicationContext-jdbc.xml")
@ComponentScan("jayshawn.spring.jdbc")
public class Config {

}