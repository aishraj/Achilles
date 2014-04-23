package org.ge3k.achilles;

import org.ge3k.achilles.Asciinator;
import org.w3c.tidy.Tidy;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by ge3k on 22/4/14.
 */
public class XsltAsciinator implements Asciinator {

    Tidy tidy;

    XsltAsciinator() {
        tidy = new Tidy();
    }

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
        /**TODO: check if the xhtml is well formed using jtidy **/

        File xsltFile = new File("src/main/resources/markdown.xsl");
        InputStream stream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream parsedStringStream = new ByteArrayOutputStream();
        tidy.setXHTML(true);
        tidy.parse(stream,parsedStringStream);
        s = parsedStringStream.toString();
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
