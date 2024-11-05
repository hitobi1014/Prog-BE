import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
//    id("java") // Java 컴파일 x
    id("org.jetbrains.kotlin.jvm") version "1.9.0" // Kotlin 플러그인 추가
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.prog"
version = "0.0.1-SNAPSHOT"

/*
java {
    sourceCompatibility = JavaVersion.VERSION_17
}
*/

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2023.0.0"

// TODO #1 나중에 필요없는 의존 삭제하기
dependencies {
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

    // lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // dev
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // database
//    runtimeOnly("com.mysql:mysql-connector-j")
    runtimeOnly("org.postgresql:postgresql")

    // querydsl
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    annotationProcessor("com.querydsl:querydsl-apt:5.0.0:jakarta")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")

    // p6spy 쿼리로그 -> 운영서버에선 지울것
    implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.9.0")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation("org.springframework.kafka:spring-kafka-test")
//    testImplementation("org.springframework.security:spring-security-test")
//    implementation("io.jsonwebtoken:jjwt:0.9.1")
//    implementation("org.springframework.boot:spring-boot-starter-data-redis")
//    implementation("org.modelmapper:modelmapper:3.1.0")
    implementation("javax.xml.bind:jaxb-api:2.3.0")
    // S3 버킷 추가(AWS 통신용?)
//    implementation("org.springframework.cloud:spring-cloud-starter-aws:2.2.6.RELEASE")

    //SMTP
//    implementation("org.springframework.boot:spring-boot-starter-mail")

    //OpenFeign
//    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
}

//dependencyManagement {
//    imports {
//        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//    }
//}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

//val generatedDir = file("src/main/generated")
//
//tasks.named("clean") {
//    doLast {
//        delete(generatedDir)
//    }
//}

/**
 * QueryDSL Build Options
 */
val querydslDir = "${layout.projectDirectory}/build/generated/querydsl"

//sourceSets {
//    getByName("main").java.srcDirs(querydslDir)
//}

sourceSets {
    getByName("main").java {
        srcDirs("src/main/kotlin", querydslDir) // Kotlin 소스 디렉토리 추가
    }
    getByName("test").java.srcDirs("src/test/kotlin") // Kotlin 테스트 디렉토리 추가
}

/*tasks.withType<JavaCompile> {
    options.generatedSourceOutputDirectory = file(querydslDir)
}*/

tasks.named("clean") {
    doLast {
        file(querydslDir).deleteRecursively()
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}