## Things to be done

- Switch over to using idiomatic Java 8. Even though this shall slow down development as there's a certain learning curve involved, I'm going with Java 8.

- The API should accept a file or a string. Use JSoup to validate the file or the string. 

-  For converting HTML items like tables, classes, images or divs, take a look at how MarkDown generates these. Reverse engineering the maximum possible functionality is our goal. [DONE/IN PROGRESS]

- Workplan is : HTML File => Cleaned up representation with known tags => Intermediate representation => Markdown file.

Step 2 and 3 shall be done with the help of  JSoup.

