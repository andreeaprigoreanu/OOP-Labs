package lab7.task1.document;

import java.util.List;

public interface DocumentVisitor {
    public String visit(ItalicTextSegment italicTextSegment);
    public String visit(BoldTextSegment boldTextSegment);
    public String visit(UrlSegment urlSegment);
    public String visit(PlainTextSegment plainTextSegment);
    public StringBuilder getDocument(List<TextSegment> textSegments);
}
