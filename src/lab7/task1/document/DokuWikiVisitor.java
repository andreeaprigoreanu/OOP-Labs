package lab7.task1.document;

import java.util.List;

public class DokuWikiVisitor implements DocumentVisitor {
    @Override
    public String visit(ItalicTextSegment italicTextSegment) {
        return "//" + italicTextSegment.getContent() + "//";
    }

    @Override
    public String visit(BoldTextSegment boldTextSegment) {
        return "**" + boldTextSegment.getContent() + "**";
    }

    @Override
    public String visit(UrlSegment urlSegment) {
        String url = urlSegment.getUrl();
        String description = urlSegment.getDescription();
        return "[[" + url.substring(7, url.length()) + "|" + description + "]]";
    }

    @Override
    public String visit(PlainTextSegment plainTextSegment) {
        return plainTextSegment.getContent();
    }

    @Override
    public StringBuilder getDocument(List<TextSegment> textSegments) {
        StringBuilder document = new StringBuilder();
        for (TextSegment textSegment : textSegments) {
            document.append(textSegment.accept(this));
        }

        return document;
    }
}
