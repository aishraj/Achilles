package org.ge3k.achilles;

import org.junit.Assert;

import java.io.File;
import java.util.Scanner;

/**
 * Created by ge3k on 22/4/14.
 */
public class XsltAsciinatorTest {
    @org.junit.Test
    public void testHtmlStringToTextString() throws Exception {
        Asciinator asciinator = new XsltAsciinator();
        String content = new Scanner(new File("/home/ge3k/projects/Achilles/src/test/resources/SimpleFile.xhtml")).useDelimiter("\\Z").next();
        String mdString = asciinator.htmlStringToTextString(content);
        Assert.assertEquals(" # Hello world",mdString);
    }
}
