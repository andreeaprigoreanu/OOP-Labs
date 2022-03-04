package lab7.task1.document;

public class PlainTextSegment extends TextSegment {
    public PlainTextSegment(String content) {
        super(content);
    }

    @Override
    public String accept(DocumentVisitor documentVisitor) {
        return documentVisitor.visit(this);
    }
}
