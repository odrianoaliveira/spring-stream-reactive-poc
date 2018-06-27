package tech.adriano.streampublisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.reactive.StreamEmitter;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
@EnableBinding(Source.class)
@SpringBootApplication
public class StreamPublisherApplication {

    @StreamEmitter
    @Output(Source.OUTPUT)
    public Flux<String> emit() {
        return Flux.interval(Duration.ofMillis(500))
                .map(l -> "Hello " + l);
    }

    public static void main(String[] args) {
        SpringApplication.run(StreamPublisherApplication.class, args);
    }
}
