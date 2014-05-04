package org.ge3k.achilles;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;

/**
 * Created by ge3k on 22/4/14.
 */
public interface WebText {

    public String htmlFileToTextString(File file) throws TransformerException;

    public File htmlFileToMarkdownfile(File file);

    public String htmlStringToTextString(String s) throws TransformerException;

}
