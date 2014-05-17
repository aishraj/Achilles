package org.ge3k.achilles;

import org.ge3k.achilles.util.MarkDownWriter;
import org.jsoup.nodes.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/**
 * Created by ge3k on 7/5/14.
 */
public class HtmlConverter {

    private static final String NON_BREAKABLE_ELEMENTS = "i,em,b,strong,font,span";
    private static final String CODE_TT = "code,tt";
    private static final String IMG = "img";
    private static final String A_HREF = "a";
    private static final String BR = "br";
    private static final String HEADINGS = "h1,h2,h3,h4,h5,h6";
    private static final String PARA = "p";
    private static final String PRE = "pre";
    private static final String BLOCKQUOTE = "blockquote";
    private static final String HR = "hr";
    private static final String OL_UL = "ol,ul";
    private static final String HTML_TABLE = "table";

    private Lock htmlConverterLock;
    final Map<String,ElementHandler> blockNodes;
    final Map<String,ElementHandler> inlineNodes;


    private MarkDownWriter markDownWriter;

    private static final Pattern COMMA = Pattern.compile(",");
    private static final Pattern LINK_MULTIPLE_SPACES = Pattern.compile(" {2,}", Pattern.DOTALL);
    private static final Pattern LINK_SAFE_CHARS = Pattern.compile("[^-\\w \\.]+", Pattern.DOTALL);
    private static final String LINK_REPLACEMENT = "_";
    private static final Pattern LINK_EDGE_REPLACE = Pattern.compile(String.format("(^%1$s++)|(%1$s++$)", LINK_REPLACEMENT));
    private static final Pattern LINK_MULTIPLE_REPLACE = Pattern.compile(String.format("%1$s{2,}", LINK_REPLACEMENT));
    private static final Pattern LINK_FILENAME = Pattern.compile("/([^/]++)$");


    public HtmlConverter() {
        htmlConverterLock = new ReentrantLock(true);
        blockNodes = new HashMap<String, ElementHandler>();
        inlineNodes = new HashMap<String, ElementHandler>();
        configureElementHandlers();
    }

    private void configureElementHandlers() {
        addNonLineBreakableNodes(new NonBreakableElements(), NON_BREAKABLE_ELEMENTS);
        addNonLineBreakableNodes(new NonBreakableCodeElements(), CODE_TT);
        addNonLineBreakableNodes(new ImageElement(), IMG);
        addNonLineBreakableNodes(new AnchorElement(), A_HREF);
        addNonLineBreakableNodes(new BreakElement(), BR);
        addLineBreakableNodes(new HeaderElement(), HEADINGS);
        addLineBreakableNodes(new ParagraphElement(), PARA);
        addLineBreakableNodes(new BreakableCodeBlockElement(), PRE);
        addLineBreakableNodes(new BlockQuoteElement(), BLOCKQUOTE);
        addLineBreakableNodes(new HorizontalRuleElement(), HR);
        addLineBreakableNodes(new HtmlListElement(), OL_UL);
        addLineBreakableNodes(new HtmlTableElement(), HTML_TABLE);
    }

    public String convert(Document document) {
        return null;
    }


    private void addLineBreakableNodes(ElementHandler handler, String csvTags) {
        for(final String key : COMMA.split(csvTags)) {
            if(key.length() > 0) {
                blockNodes.put(key, handler);
            }
        }
    }

    public void addNonLineBreakableNodes(ElementHandler handler, String csvTags) {
        for(final String key : COMMA.split(csvTags)) {
            if(key.length() > 0) {
                inlineNodes.put(key, handler);
                blockNodes.put(key, handler);
            }
        }
    }
}
