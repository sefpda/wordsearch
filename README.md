WordSearch will process a file and locate selected words contained in a grid. Both words and grid must be present in the file,
with the words on the top row (comma-separated, no spaces), and the letter grid (comma-separated, no spaces) beginning on the
next line. See testGrid.txt in the project root for an example.

To run WordSearch simply pass in the path to the file to WordSearch.class from the project root, as below.
    java -Dfile.encoding=UTF-8 -classpath out/production/WordSearch org.kata.WordSearch testGrid.txt

WordSearch was build with Java 8 on Intellij for Mac and has not been tested on other environments.