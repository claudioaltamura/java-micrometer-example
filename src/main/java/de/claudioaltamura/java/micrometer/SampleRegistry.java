package de.claudioaltamura.java.micrometer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.Duration;

import com.sun.net.httpserver.HttpServer;

import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

public class SampleRegistry {

	private SampleRegistry() {}

	public static PrometheusMeterRegistry prometheus() {
		PrometheusMeterRegistry prometheusRegistry = new PrometheusMeterRegistry(new PrometheusConfig() {
			@Override
			public Duration step() {
				return Duration.ofSeconds(10);
			}

			@Override
			public String get(String k) {
				return null;
			}
		});

		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
			server.createContext("/prometheus", httpExchange -> {
				String response = prometheusRegistry.scrape();
				httpExchange.sendResponseHeaders(200, response.length());
				OutputStream os = httpExchange.getResponseBody();
				os.write(response.getBytes());
				os.close();
			});

			new Thread(server::start).run();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return prometheusRegistry;
	}
}
