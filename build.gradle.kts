plugins {
    id("org.jetbrains.kotlin.js") version "1.4.31"
    kotlin("plugin.serialization") version "1.4.30"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    mavenCentral()
    jcenter()
}

kotlin {
    sourceSets["main"].kotlin.srcDir("src/main/external")
    js {
        useCommonJs()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
        binaries.executable()
    }
}

dependencies {


    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0")


    //React, React DOM + Wrappers (chapter 3)
    implementation("org.jetbrains:kotlin-react:17.0.1-pre.148-kotlin-1.4.21")
    implementation("org.jetbrains:kotlin-react-dom:17.0.1-pre.148-kotlin-1.4.21")
    implementation(npm("react", "17.0.1"))
    implementation(npm("react-dom", "17.0.1"))

    //Kotlin Styled (chapter 3)
    implementation("org.jetbrains:kotlin-styled:5.2.1-pre.148-kotlin-1.4.21")
    implementation(npm("styled-components", "~5.2.1"))

    //Video Player (chapter 7)
    implementation(npm("react-youtube-lite", "1.0.1"))

    //Share Buttons (chapter 7)
    implementation(npm("react-share", "~4.2.1"))

    //Materialize
    implementation(npm("materialize-css", "~1.0.0"))

    implementation(npm("jquery", "~3.5.1"))




    //Coroutines (chapter 8)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")

}

// Heroku Deployment (chapter 9)
tasks.register("stage") {
    dependsOn("build")
}
