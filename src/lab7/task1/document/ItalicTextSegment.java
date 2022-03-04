package lab7.task1.document;

public class ItalicTextSegment extends TextSegment {
    public ItalicTextSegment(String content) {
        super(content);
    }

    @Override
    public String accept(DocumentVisitor documentVisitor) {
        return documentVisitor.visit(this);
    }
}
