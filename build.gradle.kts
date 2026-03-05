plugins {
    java
    id("com.diffplug.spotless") version "8.0.0"
    id("com.github.ben-manes.versions") version "0.53.0"
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

dependencies {
    implementation("io.micrometer:micrometer-core:1.16.3")

    implementation("io.micrometer:micrometer-registry-prometheus:1.12.0")

    implementation("io.projectreactor.netty:reactor-netty-http:1.3.3")

    testImplementation("org.assertj:assertj-core:3.27.7")

    testImplementation(platform("org.junit:junit-bom:6.0.0-M2"))

    testImplementation("org.junit.jupiter:junit-jupiter")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

spotless {
    java {
        googleJavaFormat()
    }
    kotlinGradle {
        ktlint()
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
