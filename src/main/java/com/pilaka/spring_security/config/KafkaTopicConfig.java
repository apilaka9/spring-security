package com.pilaka.spring_security.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




    @Configuration
    public class KafkaTopicConfig {

        @Bean
        public NewTopic projectTopic() {
            return new NewTopic(
                    "project-events",
                    3,
                    (short) 1
            );
        }

}