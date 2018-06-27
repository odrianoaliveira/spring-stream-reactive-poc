package tech.adriano.streamsubscriber;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Slf4j
@EnableBinding(Processor.class)
@SpringBootApplication
public class StreamSubscriberApplication {

    @StreamListener
    public void receive1(@Input(Processor.INPUT) Flux<String> input) {
        input.subscribe(this::process, this::onError);
    }

    @StreamListener
    public void receive2(@Input(Processor.INPUT) Flux<String> input) {
        input.subscribe(this::process, this::onError);
    }

    @StreamListener
    public void receive3(@Input(Processor.INPUT) Flux<String> input) {
        input.subscribe(this::process, this::onError);
    }

    @StreamListener
    public void receive4(@Input(Processor.INPUT) Flux<String> input) {
        input.subscribe(this::process, this::onError);
    }

    private void onError(Throwable throwable) {
        log.error(throwable.getMessage());
    }

    private void process(String s) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(s);
    }

    public static void main(String[] args) {
        SpringApplication.run(StreamSubscriberApplication.class, args);
    }
}
