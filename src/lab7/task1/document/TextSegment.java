package lab7.task1.document;

/**
 * Represents a text segment of a document that needs to be parsed.
 */
public abstract class TextSegment implements DocumentVisitable{
    private String content;

    TextSegment(String content) {
        this.content = content;
    }

    TextSegment() {
    }

    public String getContent() {
        return content;
    }

    // TODO add method for applying the visitor
    public abstract String accept(DocumentVisitor documentVisitor);
}
