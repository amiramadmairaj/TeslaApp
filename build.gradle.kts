val ktor_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.0.20"  // Keep your Kotlin version
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"  // Set the Kotlin target JVM version to 17
    }
}

// Set the Java toolchain version
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))  // Set the Java target JVM version to 17
}

tasks.test {
    useJUnitPlatform()
}
