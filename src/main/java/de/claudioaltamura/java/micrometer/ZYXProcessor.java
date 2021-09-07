package de.claudioaltamura.java.micrometer;

import java.util.concurrent.TimeUnit;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

public class ZYXProcessor {

	public static final String METRIC_NAME = "process.timer";

	private final MeterRegistry meterRegistry;

	public ZYXProcessor(MeterRegistry meterRegistry) {
		this.meterRegistry = meterRegistry;
	}

	public void execute(String key, String value) {
		Timer timer = meterRegistry.timer(METRIC_NAME, key, value);
		//do something
		timer.record(
				() -> {
					try {
						TimeUnit.MILLISECONDS.sleep(2);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				});
	}

}
