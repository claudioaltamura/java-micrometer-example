package de.claudioaltamura.java.micrometer;

import io.micrometer.core.instrument.MeterRegistry;

public class Example {

	public static void main(String[] args) {
		MeterRegistry registry = SampleRegistry.prometheus();

		final var processor = new XYZProcessor(registry);
		final var key = "id";
		final var value = "12345";
		processor.execute(key, value);
	}


}
