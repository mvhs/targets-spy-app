## Grandma's Spy App ##

### Overview ###

Your grandmother is worried you may be communicating with the wrong crowd. She has decided to build an app that will monitor your texting activity. The program will search your texts for questionable four-letter words such as `food`, `pear`, or `taco`.

Complete `WordFilter.java` to filter four-letter words from provided texts, then write `SpyApp.java` using the `WordFilter` class to provide an command line interface that takes input from the user and responds with a filtered version.

### Implementation Details ###

For `WordFilter`, you must complete four instance methods, one static method, and a constructor. `WordFilter.java` already contains these method signatures along with comments instructing you how to complete them.

When checking text for four-letter words, you should not consider partial words. This means that the `food` in `seafood` should not be counted or filtered. For a word to be filtered, it must either have a space on both sides or have a space on one side and be the first or last word in the text. Your word filter does not have to account for variations in capitalization unless you want to complete the Bonus Challenge (see below). You do not need to worry about punctuation.

The `replaceFour` method replaces the first instance of `wordToReplace` with `****`

### Tests and Grading ###

`WordFilterTest.java` includes some basic tests of the `WordFilter` class that you can run from the Targets Web Console (or on the command line with `targets check`). These tests are not exhaustive, so you should conduct your own tests as well, but they provide a good baseline so you know when you're on the right track. If any tests fail, the method at fault will be printed to guide you to where your errors are, but since some methods depend on others to work, don't rely on the error output too much.

If you are not completing the Bonus Challenge, only worry about the Required Functionality tests. Failing the Bonus Challenge tests will not affect your grade.

Additional tests similar to those included in `WordFilterTest` will be run on your code after you submit it, so passing the included tests does not guarantee full credit. If you fail any of the tests, Mrs. Anwar will evaluate your code for partial credit.

Because pre-written tests are run on `WordFilter`, you should not modify any of the method signatures in this class.

`SpyApp.java` will still be graded as part of this assignment, but there are no autograder tests, so feel free to develop any command line interface you want, provided it takes text as input and outputs the filtered version of that text.

### Additional Restrictions and Considerations ###

You may not use the `StringBuilder` class or the `replaceAll`, `replace`, `split`, or `contains` methods of the `String` class. The automatic tests will not catch use of these disallowed features, but you will be marked down for using them.

You do not have to keep within the food theme for your four-letter words, but since this is a school assignment, please **do not** use real curse words. Your grandmother doesn't actually know them; she just really hates pears.

For the purposes of this assignment, a word is a sequence of characters separated by spaces. This means that each valid word should either have a space on both sides, or a space on one side if the word is the first or last word in the text. You do not have to worry about punctuation.

Once you complete this assignment, you are free to add other features. However, you should not change the existing methods in `WordFilter` and the included tests should still pass. If you want to make changes that break the tests, please do so with a copy and only submit the version that passes the tests.

### Bonus Challenge ###

If you finish the required functionality and pass all of the tests, you may want to try this bonus challenge.

Your grandmother has released her spy app and is now filtering all uses of words like pear and taco. However, you've found a clever trick to get around the filter. If you capitalize one or more of the letters of a blocked word, the filter won't catch it. Modify `findFour` and `replaceFour` to catch all capitalization variations of a blocked word.

Once you've done this, run the tests again to check that the Bonus Challenge tests pass in addition to the Required Functionality tests.

Mrs. Anwar may give you extra credit on this assignment if you can pass the Bonus Challenge tests **without using regular expressions**. If you can't or don't want to complete the Bonus Challenge, just ignore the Bonus Challenge tests that fail. If the error message really bothers you, then uncomment line 18 in `WordFilterTest.java` to stop the Bonus Challenge tests from running.

### Credits ###

This template and specification is a draft written by Jack Thakar. It is not yet approved by or affiliated with Mrs. Anwar or Monte Vista High School.

### License ###

As this specification is a draft, the code contained within has not yet been released under an open source license. This means that you do not have permission to modify or distribute it. This means that teachers outside of MVHS should not use this template for their classes. Once the spec is finalized, we'll release it under a permissive license to allow use by other students and teachers.