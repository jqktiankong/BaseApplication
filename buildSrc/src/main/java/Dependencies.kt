object Dependencies {
    const val gradle = "com.android.tools.build:gradle:${Gradle.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.kotlin}"
    const val hiltAndroidGradlePlugin =
        "com.google.dagger:hilt-android-gradle-plugin:${Gradle.hiltAndroidGradlePlugin}"
    const val navigationSafeArgsGradlePlugin =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Jetpack.navigation}"

    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Kotlin.kotlin}"
    const val coreKtx = "androidx.core:core-ktx:${AndroidX.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${AndroidX.appcompat}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${AndroidX.constraintlayout}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${AndroidX.recyclerView}"
    const val cardview = "androidx.cardview:cardview:${AndroidX.cardView}"
    const val activityKtx = "androidx.activity:activity-ktx:${AndroidX.activityKtx}"

    const val kotlinxCoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Kotlin.coroutines}"
    const val kotlinxCoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Kotlin.coroutines}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Jetpack.hilt}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Jetpack.hilt}"
    const val hiltLifecycleViewmodel =
        "androidx.hilt:hilt-lifecycle-viewmodel:${Jetpack.hiltJetpack}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Jetpack.hiltJetpack}"

    const val roomRuntime = "androidx.room:room-runtime:${Jetpack.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Jetpack.room}"
    const val roomKtx = "androidx.room:room-ktx:${Jetpack.room}"
    const val roomTesting = "androidx.room:room-testing:${Jetpack.room}"

    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Jetpack.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Jetpack.navigation}"
    const val navigationModule =
        "androidx.navigation:navigation-dynamic-features-fragment:${Jetpack.navigation}"
    const val navigationTesting = "androidx.navigation:navigation-testing:${Jetpack.navigation}"
    const val navigationCompose =
        "androidx.navigation:navigation-compose:${Jetpack.navigationJetpack}"

    const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Jetpack.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Jetpack.lifecycle}"
    const val lifecycleViewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Jetpack.lifecycle}"

    const val composeUi = "androidx.compose.ui:ui:${Jetpack.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Jetpack.compose}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Jetpack.compose}"
    const val composeActivity = "androidx.activity:activity-compose:${Jetpack.composeActivity}"
    const val composeUiJnut = "androidx.compose.ui:ui-test-junit4:${Jetpack.compose}"
    const val composeDebug = "androidx.compose.ui:ui-tooling:${Jetpack.compose}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${ThirdParty.retrofit2}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${ThirdParty.retrofit2}"
    const val adapterRxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${ThirdParty.retrofit2}"
    const val converterScalars = "com.squareup.retrofit2:converter-scalars:${ThirdParty.retrofit2}"

    const val okhttp = "com.squareup.okhttp3:okhttp:${ThirdParty.okhttp}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${ThirdParty.okhttp}"

    const val rxjava = "io.reactivex.rxjava2:rxjava:${ThirdParty.rxjava}"
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:${ThirdParty.rxandroid}"

    const val eventbus = "org.greenrobot:eventbus:${ThirdParty.eventbus}"
    const val rxpermissions = "com.github.tbruyelle:rxpermissions:${ThirdParty.rxpermissions}"

    const val arouterApi = "com.alibaba:arouter-api:${ThirdParty.aouter}"
    const val arouterCompiler = "com.alibaba:arouter-compiler:${ThirdParty.aouter}"

    const val multidex = "com.android.support:multidex:${ThirdParty.multidex}"

    const val koinMain = "io.insert-koin:koin-core:${ThirdParty.koin}"
    const val koinJavaCompatibility = "io.insert-koin:koin-android-compat:${ThirdParty.koin}"

    const val glide = "com.github.bumptech.glide:glide:${ThirdParty.glide}"
    const val coil = "io.coil-kt:coil:${ThirdParty.coil}"
    const val coil_gif = "io.coil-kt:coil-gif:${ThirdParty.coil_gif}"
    const val coil_svg = "io.coil-kt:coil-svg:${ThirdParty.coil_svg}"

    const val junit = "junit:junit:${Test.junit}"
    const val ext = "androidx.test.ext:junit:${Test.ext}"
    const val espresso = "androidx.test.espresso:espresso-core:${Test.espresso}"
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:${Test.leakcanary}"
}
