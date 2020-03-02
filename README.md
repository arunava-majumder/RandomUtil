# RandomUtil
This is a utility class to load a word list from a input text file whose path is configurable in the properties file. It also provides a functionality to print a word from the list randomly.
For this sample, the properties file and the input word list file are in the same resources folder. We may not need to keep any properties file if we always keep the input word list file in the resources folder.

But the input file could be from any other external folder. Properties file should hold the information for the input file path. And the util class will load the input file from the path accordingly. It may need to derive the java.nio.file.Path with some other useful apis and pass it as argument in the Files.readAllLines(Path input) method.  
