plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

//val skArtifact = "skiko-awt-runtime-windows-x64" // x64 Windowsの場合
val skArtifact = "skiko-awt-runtime-macos-x64" // intel Macの場合
// val skArtifact = "skiko-awt-runtime-linux-arm64" // arm Linuxの場合
val skVersion = "0.7.58"
val lwjglVersion = "3.3.2"
//val lwjglNatives = "natives-windows" // x64 Windowsの場合
val lwjglNatives = "natives-macos" // intel Macの場合
// val lwjglNatives = "natives-linux-arm64" // arm Linuxの場合

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    api("org.jetbrains.skiko:${skArtifact}:${skVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
3
    implementation("org.lwjgl:lwjgl:$lwjglVersion")
    implementation("org.lwjgl:lwjgl-glfw:$lwjglVersion")
    implementation("org.lwjgl:lwjgl-opengl:$lwjglVersion")
    runtimeOnly("org.lwjgl:lwjgl:$lwjglVersion:$lwjglNatives")
    runtimeOnly("org.lwjgl:lwjgl-glfw:$lwjglVersion:$lwjglNatives")
    runtimeOnly("org.lwjgl:lwjgl-opengl:$lwjglVersion:$lwjglNatives")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}