plugins {
    kotlin("multiplatform") version "2.0.0"
}

repositories {
    mavenCentral()
}

kotlin {
    jvm()

    iosArm64()
    macosArm64()
    iosX64()
    macosX64()
    iosSimulatorArm64()

    sourceSets {
        commonMain {
            dependencies {
                implementation("com.github.kittinunf.fuel:fuel:3.0.0-alpha03")
                implementation("io.coil-kt.coil3:coil-network-core:3.0.0-alpha09")
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
