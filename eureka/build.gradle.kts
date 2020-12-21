import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("plugin.spring") version "1.4.10"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

repositories {
    jcenter()
    maven(){
        url = uri("http://localhost:8082/artifactory/libs-release-local")
    }
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

dependencyManagement {
    imports {
        mavenBom("ca.kiwii:parent:1.0.0")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

group = "ca.kiwii.eureka"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_11