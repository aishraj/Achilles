package org.ge3k.achilles;

import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Whitelist;

import javax.xml.transform.TransformerException;

/**
 * Created by ge3k on 4/5/14.
 */
public class WebTextImpl implements WebText {

    private Whitelist mwhiteList = Whitelist.basicWithImages()
            .addTags("div",
                    "h1", "h2", "h3", "h4", "h5", "h6",
                    "table", "tbody", "td", "tfoot", "th", "thead", "tr",
                    "hr",
                    "span", "font")
            .addAttributes("th", "colspan", "align", "style")
            .addAttributes("td", "colspan", "align", "style")
            .addAttributes(":all", "title", "style");

    @Override
    public String htmlStringToTextString(String html) throws TransformerException {
        TextifyConverter textifyConverter = new TextifyConverter();
        Cleaner cleaner = new Cleaner(mwhiteList);
        textifyConverter.setDocumentCleaner(cleaner);
        return textifyConverter.convert(html);
    }
}
