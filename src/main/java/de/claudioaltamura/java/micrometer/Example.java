package de.claudioaltamura.java.micrometer;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import java.time.Duration;
import reactor.core.publisher.Flux;

public class Example {

  public static void main(String[] args) {
    MeterRegistry meterRegistry = SampleRegistry.prometheus();

    var key = "counter";
    Counter counter = meterRegistry.counter("counter", key, "mycounter");

    Flux.interval(Duration.ofMillis(30))
        .take(1000) // 30 seconds worth of emissions (1000 * 30ms)
        .doOnEach(d -> counter.increment())
        .log()
        .blockLast();
      }
}
