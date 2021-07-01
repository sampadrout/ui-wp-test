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