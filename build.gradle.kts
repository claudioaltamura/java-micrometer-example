plugins {
    java
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    implementation("io.micrometer:micrometer-core:1.7.3")

    implementation("io.micrometer:micrometer-registry-prometheus:1.7.3")

    testImplementation("org.assertj:assertj-core:3.20.2")

    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
}

tasks.test {
    // Use junit platform for unit tests.
    useJUnitPlatform()
}
