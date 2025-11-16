package com.kafka.producer.Controller;

import com.kafka.producer.RiderLocation;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaProducer {

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

    private final KafkaTemplate<String , RiderLocation> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, RiderLocation> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message){

        RiderLocation riderLocation = new RiderLocation("rider1", 67.3,89.2);

        kafkaTemplate.send("my-topic-new", riderLocation);

        return "Location Send of rider : "+ riderLocation.getRiderId();
    }
}
