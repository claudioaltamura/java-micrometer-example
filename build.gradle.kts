plugins {
    java
    id("com.diffplug.spotless") version "6.5.2"
    id("com.github.ben-manes.versions") version "0.42.0"
}

repositories {

    mavenCentral()
}

dependencies {
    implementation("io.micrometer:micrometer-core:1.8.5")

    implementation("io.micrometer:micrometer-registry-prometheus:1.8.5")

    implementation ("io.projectreactor.netty:reactor-netty-http:1.0.19")

    testImplementation("org.assertj:assertj-core:3.22.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.test {
    // Use junit platform for unit tests.
    useJUnitPlatform()
}
