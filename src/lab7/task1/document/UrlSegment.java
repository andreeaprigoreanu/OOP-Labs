package lab7.task1.document;

public class UrlSegment extends TextSegment {
    private String url;
    private String description;

    public UrlSegment(String url, String description) {
        super();
        this.url = url;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String accept(DocumentVisitor documentVisitor) {
        return documentVisitor.visit(this);
    }
}
