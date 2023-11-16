import org.bson.Document;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

    // Constructors, getters, setters, and toString method remain unchanged...

    public Document toDocument() {
        Document document = new Document();
        document.append("street", this.street)
                .append("city", this.city)
                .append("state", this.state)
                .append("zipCode", this.zipCode);

        return document;
    }
}
