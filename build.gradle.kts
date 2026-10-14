
plugins {
    `java-library`
    id("org.springframework.boot") version "4.0.7"
    id("io.spring.dependency-management") version "1.1.7"
    `maven-publish`
}

group = "com.enthuzd"
version = "0.1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }

    withSourcesJar()
}

repositories {
    mavenCentral()
}

dependencies {
    // Compile against Spring MVC, but don't expose it as a
    // transitive dependency to consuming applications.
    compileOnly("org.springframework.boot:spring-boot-starter-webmvc")

    // Make framework APIs available for tests.
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }

    repositories {
        mavenLocal()
    }
}

tasks.jar {
    archiveClassifier.set("")
}

tasks.test {
    useJUnitPlatform()
}
