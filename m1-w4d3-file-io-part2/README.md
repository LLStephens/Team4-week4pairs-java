# File I/O Part 2 Exercises (Pair)

## FindAndReplace

Write a program that can be used to replace all occurrences of one word with another word.  

The program should accept 4 parameters

* The search term
* The term to replace the search term with
* The source file path.  *This must be an existing file.  If the user enters an invalid source file path, the program will indicate this and exit.*
* The destination file path.  *The program will create a copy of the source file with the requested replacements at this location.  If a file or directory already exists at this location, the program will print an error and exit.*

Example of invoking the program:

```
java com.techelevator.FindAndReplace Alice Barbara alices_adventures_in_wonderland.txt barbaras_adventures_in_wonderland.txt
```