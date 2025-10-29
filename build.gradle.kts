plugins {
    kotlin("multiplatform") version "2.2.21"
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
                implementation("com.github.kittinunf.fuel:fuel:3.0.0-alpha04")
                implementation("io.coil-kt.coil3:coil-network-core:3.3.0")
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
