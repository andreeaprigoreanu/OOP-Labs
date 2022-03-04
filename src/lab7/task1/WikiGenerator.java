package lab7.task1;

import lab7.task1.document.DokuWikiVisitor;
import lab7.task1.document.MarkdownVisitor;
import lab7.task1.document.TextSegment;

import java.util.List;
import java.util.Map;

/**
 * Uses visitors to parse documents and provide dokuwiki and markdown outputs.
 */
public class WikiGenerator {

    private final List<TextSegment> textSegments;

    public WikiGenerator(List<TextSegment> textSegments) {
        this.textSegments = textSegments;
    }

    public StringBuilder getDokuWikiDocument() {
        // TODO apply dokuwiki visitor on the text segments
        DokuWikiVisitor dokuWikiVisitor = new DokuWikiVisitor();
        return dokuWikiVisitor.getDocument(textSegments);
    }

    public StringBuilder getMarkdownDocument() {
        // TODO apply Markdown visitor on the text segments
        MarkdownVisitor markdownVisitor = new MarkdownVisitor();
        return markdownVisitor.getDocument(textSegments);
    }
}
