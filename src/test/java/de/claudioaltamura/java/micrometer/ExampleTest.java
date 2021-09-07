package de.claudioaltamura.java.micrometer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

class ExampleTest {

	private static MeterRegistry meterRegistry;

	@BeforeAll
	public static void setUp() {
		meterRegistry = SampleRegistry.prometheus();
	}

	@Test
	void testCounter() {
		final var processor = new XYZProcessor(meterRegistry);
		final var key = "id";
		final var value = "12345";
		processor.execute(key,value);

		Optional<Counter> counterOptional = Optional.ofNullable(meterRegistry
			.find(XYZProcessor.METRIC_NAME).counter());

		assertTrue(counterOptional.isPresent());
		assertThat(counterOptional.get().count()).isEqualTo(1.0d);
	}

	@Test
	void testTimer() {
		final var processor = new ZYXProcessor(meterRegistry);
		final var key = "id";
		final var value = "12345";
		processor.execute(key,value);

		Optional<Timer> timerOptional = Optional.ofNullable(meterRegistry
				.find(ZYXProcessor.METRIC_NAME).timer());

		assertTrue(timerOptional.isPresent());
		assertThat(timerOptional.get().totalTime(TimeUnit.MILLISECONDS)).isBetween(2.0d, 3.0d);
	}

}