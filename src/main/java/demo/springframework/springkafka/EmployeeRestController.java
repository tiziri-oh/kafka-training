package demo.springframework.springkafka;

import demo.springframework.model.Employee;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@RestController
public class EmployeeRestController {
    @Autowired
    private KafkaTemplate<String, Employee> kafkaTemplate;

    @GetMapping("/employee/{name}/{dept}/{salary}")
    public String send(@PathVariable String name,
                       @PathVariable String dept,
                       @PathVariable String salary) {
        Employee value = new Employee(name, dept, salary);
        String key = value.md5sum();
        System.out.println("key:" + key);
        kafkaTemplate.send("employee", key, value);
        return "Message Sent ...";
    }
}