package tech.adriano.streamsubscriber;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
@EnableBinding(Processor.class)
@SpringBootApplication
public class StreamSubscriberApplication {

    @StreamListener
    public void receive(@Input(Processor.INPUT) Flux<String> input) {
        input.subscribe(log::info);
    }

    public static void main(String[] args) {
        SpringApplication.run(StreamSubscriberApplication.class, args);
    }
}
