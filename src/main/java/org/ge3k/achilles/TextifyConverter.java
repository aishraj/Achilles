package org.ge3k.achilles;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Cleaner;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ge3k on 4/5/14.
 */
public class TextifyConverter {

    private final DocumentConverter documentConverter;
    private Cleaner documentCleaner;
    private final Lock textConvertLock;

    public TextifyConverter() {
        textConvertLock = new ReentrantLock();
        documentConverter = new DocumentConverter();
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
        textConvertLock.lock();
        try {
            convertedString = documentConverter.convert(document);
        } finally {
           textConvertLock.unlock();
        }
    }
}
