import org.bson.Document;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String email;

    // Existing constructors, getters, setters, and toString methods...

    // New constructor for creating an address with provided information
    public Address(String street, String city, String state, String zipCode, String email) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
    }

    public Document toDocument() {
        Document document = new Document();
        document.append("street", this.street)
                .append("city", this.city)
                .append("state", this.state)
                .append("zipCode", this.zipCode)
                .append("email", this.email);

        return document;
    }
}
