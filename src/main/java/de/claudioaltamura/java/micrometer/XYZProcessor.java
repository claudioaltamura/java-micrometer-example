package de.claudioaltamura.java.micrometer;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

public class XYZProcessor {

	public static final String METRIC_NAME = "process_counter";

	private final MeterRegistry meterRegistry;

	public XYZProcessor(MeterRegistry meterRegistry) {
		this.meterRegistry = meterRegistry;
	}

	public void execute(String key, String value) {
		//do something

		//tagged counter
		Counter counter = meterRegistry.counter(METRIC_NAME, key, value);
		counter.increment();
	}

}
