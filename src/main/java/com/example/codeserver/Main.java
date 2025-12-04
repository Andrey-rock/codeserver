package com.example.codeserver;

import com.example.codeserver.listener.NativeKafkaConsumer;

public class Main {
    public static void main(String[] args) {

        String bootstrapServers = "localhost:9092";
        String groupId = "my-group";
        String topic = "code-topic";


        NativeKafkaConsumer consumer = new NativeKafkaConsumer(
                bootstrapServers, groupId, topic);


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutdown signal received...");
            consumer.stop();
        }));


        System.out.println("Starting Kafka Consumer Application...");
        consumer.start();
    }
}

