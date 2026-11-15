plugins {
    id "com.android.application"
    id "kotlin-android"
    id "dev.flutter.flutter-gradle-plugin"
}

android {
    namespace "com.example.cafevpn"
    compileSdk flutter.compileSdkVersion
    ndkVersion flutter.ndkVersion

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_17
        targetCompatibility JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = '17'
    }

    defaultConfig {
        applicationId "com.example.cafevpn"
        minSdkVersion flutter.minSdkVersion
        targetSdkVersion flutter.targetSdkVersion
        versionCode flutterVersionCode.toInteger()
        versionName flutterVersionName
    }

    buildTypes {
        release {
            signingConfig signingConfigs.debug
        }
    }

    lintOptions {
        checkReleaseBuilds false
    }

    packagingOptions {
        pickFirst 'lib/*/libxray.so'
        exclude 'META-INF/versions/9/OSGI-INF/MANIFEST.MF'
    }
}

flutter {
    source '../..'
}

dependencies {
    implementation files('libs/xray.aar')
}
