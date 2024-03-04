buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
        classpath("com.android.tools.build:gradle:8.3.0")
        classpath("com.squareup.sqldelight:gradle-plugin:1.5.3")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.44.2")
    }
}

plugins {
    jacoco // code coverage reports
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("delete", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.withType<Test> {
    useJUnitPlatform()
    finalizedBy(tasks.named("jacocoTestReport"))
}

tasks.create("jacocoTestReport", JacocoReport::class.java) {
    group = "Reporting"
    description = "Generate Jacoco coverage reports after running tests."
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
    finalizedBy("jacocoTestCoverageVerification")
}

tasks.create("jacocoTestCoverageVerification", JacocoCoverageVerification::class.java) {
    group = "Verification"
    description = "Verify code coverage metrics after running tests."
    violationRules {
        rule {
            limit {
                //The floating-point literal does not conform to the expected type BigDecimal?
                minimum = BigDecimal("0.75")
            }
        }
    }
}