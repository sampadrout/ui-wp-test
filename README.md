# UI Test Project
Sample test automation project for web and mobile, including both android and iOS.

To run the test suite:
mvn clean test -Denvironment=qa -Dcloud=localhost

To generate the report:
mvn allure:report

The report will be available under ./target/site/index.html

While setting the device, please make sure the name capability should be:
IPHONESE -> For iOS specific devices
Pixel -> For android specific devices

Please keep the apk and ipa/zip files under /src/test/resources/apps
If the apps available in MS App Center, please upated the app path in the files
located at /src/test/resources/*Device.json files.

Running a specific test from IDE like Eclipse/IntelliJ, please setup the following:
1. Add the following parameters for a web test:
platformType = web
platformName = chrome

2. Add the following parameters for a ios test:
platformType = mobile
platformName = ios
model = IPHONESE

3. Add the following parameters for a android test:
platformType = mobile
platformName = android
model = Pixel

Also set the Environment Variables as: JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_261.jdk/Contents/Home