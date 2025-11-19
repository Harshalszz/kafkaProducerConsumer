package com.kafka.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.function.Supplier;

@Configuration
public class KafkaProducerStream {

//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    @PostMapping("/send")
//    public String sendMessage(@RequestParam String message){
//        kafkaTemplate.send("my-topic" , message);
//        return "Messsage Sent : " + message;
//    }

    @Bean
    public Supplier<RiderLocation> sendRiderLocation(){

        return () ->{
            RiderLocation riderLocation = new RiderLocation("XZ" , 23.34,56.353);
            System.out.println("Sending: " + riderLocation.getRiderId());
            return riderLocation;
        };
    }


}
