package org.ge3k.achilles;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by ge3k on 17/5/14.
 */
public abstract class AbstractElementHandler  implements ElementHandler {

    public void handleIgnoredHTMLElement(Element node, HtmlConverter converter) {
        if(node.isBlock()) {
            converter.getMarkDownWriter().writeBlock(node.toString());
        } else {
            // Note: because this is an inline element, we want to make sure it stays that way!
            // this means turning off prettyPrinting, so that JSoup doesn't add unecessary spacing around
            // the child nodes.
            Document doc = node.ownerDocument();
            boolean oldPrettyPrint = doc.outputSettings().prettyPrint();
            doc.outputSettings().prettyPrint(false);
            converter.getMarkDownWriter().write(node.toString());
            doc.outputSettings().prettyPrint(oldPrettyPrint);
        }
    }

}
