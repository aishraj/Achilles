## Noteworthy items

-  Need to make the API accept a URI (a remote or a local). Then use JSoup to validate the file (check if it can be done online without dowloading the resource. If no set a max size and check the mime type before getting the resource locally). 

-  For converting HTML items like tables, classes, images or divs, take a look at how MarkDown generates these. Reverse engineering the maximum possible functionality is our goal.

- Workplan is : URL => HTML File => Cleaned up representation with known tags => Intermediate representation => Markdown file.

Step 2 and 3 shall be done with the help of  JSoup.

