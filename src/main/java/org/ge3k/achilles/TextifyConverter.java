package org.ge3k.achilles;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Cleaner;

/**
 * Created by ge3k on 4/5/14.
 */
public class TextifyConverter {

    private Cleaner documentCleaner;

    public Cleaner getDocumentCleaner() {
        return documentCleaner;
    }

    public void setDocumentCleaner(Cleaner documentCleaner) {
        this.documentCleaner = documentCleaner;
    }

    public String convert(String html) {
        Document document = Jsoup.parseBodyFragment(html);
        document = documentCleaner.clean(document);
        //todo continue from here on. stil a rough draft.
    }
}
