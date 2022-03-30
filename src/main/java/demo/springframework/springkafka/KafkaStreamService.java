package demo.springframework.springkafka;

import demo.springframework.model.Employee;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.binder.kafka.streams.annotations.KafkaStreamsProcessor;
import org.springframework.stereotype.Service;


@Service
//@EnableBinding(KafkaStreamsProcessor.class)
public class KafkaStreamService {



        //@StreamListener("bdccTopic")
        //@SendTo("resTopic")
        public KStream<String, String> process(KStream<String, String> input) {
            input.foreach((k,v) -> System.out.println(k + " => " + v));
            return input;
            /*
            return input
                    .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
                    .map((key, value) -> new KeyValue<>(value, value))
                    .groupByKey(Grouped.with(Serdes.String(), Serdes.String()))
                    .count(Materialized.as("WordCounts-1"))
                    .toStream();
            //*/
        }
}
