plugins {
    id("java-library")
    alias(libs.plugins.jetbrainsKotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}


dependencies {
    testImplementation(libs.junit.jupiter)
//    testImplementation(libs.mockito.core)
//    testImplementation(libs.mockito.kotlin)

//    implementation(project(":basicutils"))
}
tasks.withType<Test> {
    useJUnitPlatform()
}