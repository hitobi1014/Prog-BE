plugins {
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"

    kotlin("jvm") version "2.0.20"
    kotlin("plugin.jpa") version "2.0.20"
    kotlin("plugin.spring") version "2.0.20"
    kotlin("plugin.allopen") version "2.0.20"
    kotlin("kapt") version "2.0.20"
//    id("org.jetbrains.kotlin.plugin.jpa") version "2.0.20"
//    id("org.jetbrains.kotlin.plugin.spring") version "2.0.20"
//    id("org.jetbrains.kotlin.plugin.allopen") version "2.0.20"
//    id("org.jetbrains.kotlin.kapt") version "2.0.20"
}

group = "com.prog"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8") // Kotlin 표준 라이브러리 추가
    implementation("org.jetbrains.kotlin:kotlin-reflect") // Kotlin 리플렉션 추가

    // spring boot
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
//    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
//    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-websocket")
//    implementation("org.springframework.kafka:spring-kafka")

    // dev
//    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // database
    runtimeOnly("org.postgresql:postgresql")

    // kotlin querydsl 설정
//    implementation("com.querydsl:querydsl-jpa:5.0.0")
////    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
//    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")
//    kapt("org.springframework.boot:spring-boot-configuration-processor")

    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    implementation("com.querydsl:querydsl-apt:5.0.0:jakarta")
    implementation("jakarta.persistence:jakarta.persistence-api")
    implementation("jakarta.annotation:jakarta.annotation-api")

    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
    kapt("org.springframework.boot:spring-boot-configuration-processor")

    // p6spy 쿼리로그 -> 운영서버에선 지울것
//    implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.9.0")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation("org.springframework.kafka:spring-kafka-test")
//    testImplementation("org.springframework.security:spring-security-test")
//    implementation("io.jsonwebtoken:jjwt:0.9.1")
//    implementation("org.springframework.boot:spring-boot-starter-data-redis")
//    implementation("org.modelmapper:modelmapper:3.1.0")
//    implementation("javax.xml.bind:jaxb-api:2.3.0")
    // S3 버킷 추가(AWS 통신용?)
//    implementation("org.springframework.cloud:spring-cloud-starter-aws:2.2.6.RELEASE")

    //SMTP
//    implementation("org.springframework.boot:spring-boot-starter-mail")

    //OpenFeign
//    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

/**
 * QueryDSL Build Options
 */
val querydslDir = "${layout.projectDirectory}/build/generated/querydsl"

sourceSets {
    getByName("main").java {
        srcDirs("src/main/kotlin", querydslDir) // Kotlin 소스 디렉토리 추가
    }
    getByName("test").java.srcDirs("src/test/kotlin") // Kotlin 테스트 디렉토리 추가
}

/*tasks.withType<JavaCompile> {
    options.generatedSourceOutputDirectory = file(querydslDir)
}*/

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.Embeddable")
    annotation("jakarta.persistence.MappedSuperclass")
}

noArg {
    annotation("jakarta.persistence.Entity")
}

tasks.named("clean") {
    doLast {
        file(querydslDir).deleteRecursively()
    }
}