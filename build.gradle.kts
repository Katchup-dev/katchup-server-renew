import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinPluginVersion = "1.9.23"
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version kotlinPluginVersion

    // Ktlint Formatter
    val ktlintVersion = "11.6.1"
    id("org.jlleitschuh.gradle.ktlint") version ktlintVersion
    id("org.jlleitschuh.gradle.ktlint-idea") version ktlintVersion

    kotlin("plugin.allopen") version kotlinPluginVersion
    kotlin("plugin.noarg") version kotlinPluginVersion
}

noArg {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.Embeddable")
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

group = "site.katchup"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-websocket")

    // JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // H2 Database
    runtimeOnly("com.h2database:h2")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    val kotestSpringExtensionVersion = "1.1.3"
    testImplementation("io.kotest.extensions:kotest-extensions-spring:$kotestSpringExtensionVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
