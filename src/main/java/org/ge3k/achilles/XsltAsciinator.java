package org.ge3k.achilles;

import org.ge3k.achilles.Asciinator;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by ge3k on 22/4/14.
 */
public class XsltAsciinator implements Asciinator {

    @Override
    public String htmlFileToTextString(File file) throws TransformerException {
        return null;
    }

    @Override
    public File htmlFileToMarkdownfile(File file) {
        return null;
    }

    @Override
    public String htmlStringToTextString(String s) throws TransformerException {
        File xsltFile = new File("src/main/resources/markdown.xsl");

        Source xmlSource = new StreamSource(new StringReader(s));
        Source xsltSource = new StreamSource(xsltFile);

        TransformerFactory transFact =
                TransformerFactory.newInstance();
        Transformer trans = transFact.newTransformer(xsltSource);

        StringWriter result = new StringWriter();
        trans.transform(xmlSource, new StreamResult(result));
        return result.toString();
    }
}
