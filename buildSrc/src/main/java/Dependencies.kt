object Dependencies {
    const val gradle = "com.android.tools.build:gradle:${Gradle.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.kotlin}"

    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Kotlin.kotlin}"
    const val coreKtx = "androidx.core:core-ktx:${AndroidX.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${AndroidX.appcompat}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${AndroidX.constraintlayout}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${ThirdParty.retrofit2}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${ThirdParty.retrofit2}"
    const val adapterRxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${ThirdParty.retrofit2}"
    const val converterScalars = "com.squareup.retrofit2:converter-scalars:${ThirdParty.retrofit2}"

    const val okhttp = "com.squareup.okhttp3:okhttp:${ThirdParty.okhttp}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${ThirdParty.okhttp}"

    const val rxjava = "io.reactivex.rxjava2:rxjava:${ThirdParty.rxjava}"
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:${ThirdParty.rxandroid}"

    const val eventbus ="org.greenrobot:eventbus:${ThirdParty.eventbus}"
    const val rxpermissions = "com.github.tbruyelle:rxpermissions:${ThirdParty.rxpermissions}"

    const val junit = "junit:junit:${Test.junit}"
    const val ext = "androidx.test.ext:junit:${Test.ext}"
    const val espresso = "androidx.test.espresso:espresso-core:${Test.espresso}"
}
