package de.claudioaltamura.java.micrometer;

import java.time.Duration;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import reactor.core.publisher.Flux;

public class Example {

	public static void main(String[] args) {
		MeterRegistry meterRegistry = SampleRegistry.prometheus();

		var key = "counter";
		Counter counter = meterRegistry.counter("counter", key, "mycounter");

		Flux.interval(Duration.ofMillis(30))
				.doOnEach(d -> {
					int random = (int)(Math.random()*10000);
					counter.increment(random);
				})
				.log()
				.blockLast();
	}


}
