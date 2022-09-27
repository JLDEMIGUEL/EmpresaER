package com.vipera.empresaer.rest.utils.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {


    private final String TOPIC_NAME = "MyTopic2";
    private final String GROUP_ID = "MyGroup";


    @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
    public void listenGroupFoo(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("Received Message: " + message + "from partition: " + partition);
    }
}
