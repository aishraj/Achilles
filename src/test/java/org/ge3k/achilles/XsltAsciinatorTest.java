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
        String content = "<h1>" + "Hello, world" + "</h1>";
        String mdString = asciinator.htmlStringToTextString(content);
        Assert.assertEquals("#Hello, world",mdString);
    }
}
