package org.ge3k.achilles;

import org.junit.Assert;

/**
 * Created by ge3k on 22/4/14.
 */
public class WebTextXsltImplTest {
    @org.junit.Test
    public void testHtmlStringToTextString() throws Exception {
        WebText webText = new WebTextXsltImpl();
        String content = "<h1>" + "Hello, world" + "</h1>";
        String mdString = webText.htmlStringToTextString(content);
        Assert.assertEquals("#Hello, world",mdString);
    }
}
