import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.3"
	id("io.spring.dependency-management") version "1.0.13.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	id("com.netflix.dgs.codegen") version "5.2.4"
}

group = "com.juice"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.jetbrains.kotlin:kotlin-test")

	implementation(platform("org.springframework.boot:spring-boot-dependencies:2.6.3"))
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	runtimeOnly("org.postgresql:postgresql")

	implementation("com.netflix.graphql.dgs:graphql-dgs-spring-boot-starter:5.1.1")
	implementation("com.netflix.graphql.dgs:graphql-dgs-extended-scalars:5.1.1")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.generateJava {
	generateClient = true
	typeMapping = mutableMapOf(
		"UUID" to "java.util.UUID"
	)
}