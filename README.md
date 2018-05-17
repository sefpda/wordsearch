WordSearch will process a file and locate selected words contained in a grid. Both words and grid must be present in the file,
with the words on the top row (comma-separated, no spaces), and the letter grid (comma-separated, no spaces) beginning on the
next line. See testGrid.txt in the project root for an example.

To build WordSearch on Unix run the following command from the root directory: ./gradlew build

To run the WordSearch tests on Unix run the following command fron the root directory: ./gradlew clean junitPlatformTest

To run WordSearch on Unix pass in the path to the file to process from the project root, as below.
   ./gradlew run -Dexec.args="testGrid.txt"

For Windows, you should be able to use the above commands by subsituting "gradlew.bat" for "./gradlew".

WordSearch was build with Java 8 on Intellij for Mac and has not been tested on other environments.