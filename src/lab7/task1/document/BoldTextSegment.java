package lab7.task1.document;

public class BoldTextSegment extends TextSegment{
    public BoldTextSegment(String content) {
        super(content);
    }

    @Override
    public String accept(DocumentVisitor documentVisitor) {
        return documentVisitor.visit(this);
    }
}
