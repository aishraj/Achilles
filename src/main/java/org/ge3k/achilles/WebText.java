package org.ge3k.achilles;

import javax.xml.transform.TransformerException;

/**
 * Created by ge3k on 22/4/14.
 */
public interface WebText {

    public String htmlStringToTextString(String s) throws TransformerException;

}
