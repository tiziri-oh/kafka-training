package demo.springframework.springkafka;

import demo.springframework.model.Employee;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @KafkaListener(topics = "employee", groupId = "groupe-es")
    public void onMessage(ConsumerRecord<String, Employee> cr){
        System.out.println("*************");
        Employee e = cr.value();
        System.out.println(cr.key() + " => name:" + e.getName() + " - dept:" + e.getDepartment());
    }
}
