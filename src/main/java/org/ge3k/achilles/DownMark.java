package org.ge3k.achilles;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Cleaner;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ge3k on 4/5/14.
 */
public class DownMark {

    private final HtmlConverter htmlConverter;
    private Cleaner documentCleaner;
    private final Lock downMarkLock;

    public DownMark() {
        downMarkLock = new ReentrantLock();
        htmlConverter = new HtmlConverter();
    }

    public Cleaner getDocumentCleaner() {
        return documentCleaner;
    }

    public void setDocumentCleaner(Cleaner documentCleaner) {
        this.documentCleaner = documentCleaner;
    }

    public String convert(String html) {
        String convertedString = null;
        Document document = Jsoup.parseBodyFragment(html);
        document = documentCleaner.clean(document);
        downMarkLock.lock();
        try {
            convertedString = htmlConverter.convert(document);
        } finally {
           downMarkLock.unlock();
        }
        return convertedString;
    }
}
