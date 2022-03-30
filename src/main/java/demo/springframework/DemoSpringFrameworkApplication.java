package demo.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class DemoSpringFrameworkApplication {
    public static void main(String[] args){
        SpringApplication.run(DemoSpringFrameworkApplication.class, args);
    }
}
