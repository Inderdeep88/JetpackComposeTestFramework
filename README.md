# Jetpack Compose Test Framework
Jetpack Compose AndroidTest execution framework in Kotlin and Java. 
Application under test is Jetsnack which is one of the official android sample applications from Google, built with Jetpack Compose.

Some of the elements have been updated in main app code to add standard Test Tags for  identification during test execution.

## Features

- Native Jetpack Compose Test framework
- Page Object Model approach for writing Test Cases
- Spoon based reporting
- Parallel execution on multiple devices
- TestData is fetch from backend (Currently on designer.mocky.io API)


## Requirements for installation

- [JAVA11] - To build the code
- [Android Gradle Plugin 3] - To manage build tasks and dependencies
- [Spoon Runner JAR] - To execute Test Cases on devices and generate HTML report


## Build Apps
Below command will build both the Jetsnack App and Jetsnack Test App.
```
> ./gradlew assembleDebug assembleAndroidTest
```

Output APKs will be generated at below paths for debug variants:

| App | Path |
| ------ | ------ |
| Jetsnack App | app/build/outputs/apk/debug/app-debug.apk |
| Jetsnack Test App | app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk |


## Execute Tests
Below command will execute Tests on the main App

```
> java -jar <path-to-spoon-runner-jar>/spoon-runner-1.7.1-jar-with-dependencies.jar --apk <path-to-main-apk>/app-debug.apk --test-apk <path-to-test-apk>/app-debug-androidTest.apk
```

Example :

```
> cd ${PROJECT_ROOT_DIR}
> java -jar spoon-runner-1.7.1-jar-with-dependencies.jar --apk app/build/outputs/apk/debug/app-debug.apk --test-apk app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk --output app/build/spoon-output
```

## Report Summary

By default the output will be placed in a spoon-output/ folder of the current directory.

You can control additional parameters of the execution using other flags in execution command :
```
> java -jar spoon-runner-1.7.1-jar-with-dependencies.jar --apk app-debug.apk --test-apk app-debug-androidTest.apk command.
```

```
Flags:
    --apk               Application APK
    --fail-on-failure   Non-zero exit code on failure
    --output            Output path
    --sdk               Path to Android SDK
    --test-apk          Test application APK
    --title             Execution title
    --class-name        Test class name to run (fully-qualified)
    --method-name       Test method name to run (must also use --class-name)
    --no-animations     Disable animated gif generation
    --size              Only run test methods annotated by testSize (small, medium, large)
    --adb-timeout       Set maximum execution time per test in seconds (10min default)
```