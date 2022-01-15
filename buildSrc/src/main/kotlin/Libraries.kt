object Libraries {

    //Build
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val hiltPlugin= "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltPlugin}"

    //App
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltPlugin}"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltAndroidX}"
    const val hiltAndroidXCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltAndroidX}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val androidSupport = "androidx.legacy:legacy-support-v4:${Versions.androidSupport}"

    // NavGraph
    const val navGraphKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    const val navUIKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"
    const val navFeatureKtx = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navVersion}"
    const val navSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navVersion}"
    const val dataBinding = "com.android.databinding:compiler:${Versions.dataBinding}"

    // Network
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    //Test
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val junit = "junit:junit:${Versions.junit}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoAndroid = "org.mockito:mockito-android:${Versions.mockito}"
    const val mockitoNhaarmanKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoNhaarmanKotlin}"
    const val mockitoKotlin =  "org.mockito.kotlin:mockito-kotlin:${Versions.mockitoKotlin}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInline}"
    const val archCoreTesting = "androidx.arch.core:core-testing:${Versions.archCoreTesting}"
    const val assertj = "org.assertj:assertj-core:${Versions.assertj}"

}
