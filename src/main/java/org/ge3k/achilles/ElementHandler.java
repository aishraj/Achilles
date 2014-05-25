package org.ge3k.achilles;

import org.jsoup.nodes.TextNode;

/**
 * Created by ge3k on 19/5/14.
 */
public interface ElementHandler {
    public void elementHandler(ElementHandler parentElementHandler, ElementHandler elementHandler, HtmlConverter converter);
    public void handleText(TextNode node, HtmlConverter converter);
}
