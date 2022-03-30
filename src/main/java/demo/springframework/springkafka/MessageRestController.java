package demo.springframework.springkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send/{topic}/{message}")
    public String send(@PathVariable String topic,
                       @PathVariable String message){
        kafkaTemplate.send(topic, message);
        return "Message Sent ...";
    }
}
