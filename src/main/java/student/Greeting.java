package student;

/**
 * The Greeting class represents a greeting message for a specific locality.
 * It includes both ASCII and Unicode greeting formats.
 */
public class Greeting {
    /** ID of the locality. */
    private int localityID;

    /** Name of the locality. */
    private String localityName;

    /** ASCII greeting message. */
    private String asciiGreeting;

    /** Unicode greeting message. */
    private String unicodeGreeting;

    /** Format string for the greeting. */
    private String formatStr;

    /**
     * Default constructor that sets up a generic "Hello, {name}!" greeting.
     *
     * @param localityID   ID of the locality
     * @param localityName Name of the locality
     */
    public Greeting(int localityID, String localityName) {
        this(localityID, localityName, "Hello");
    }

    /**
     * Constructor that assumes a greeting format of "{greeting}, {name}!".
     *
     * @param localityID   ID of the locality
     * @param localityName Name of the locality
     * @param greeting     Greeting using ASCII characters
     */
    public Greeting(int localityID, String localityName, String greeting) {
        this(localityID, localityName, greeting, greeting, "%s, %%s!");
    }

    /**
     * Constructor that fully defines a greeting with both ASCII and Unicode support.
     *
     * @param localityID      ID of the locality
     * @param localityName    Name of the locality
     * @param asciiGreeting   Greeting using ASCII characters
     * @param unicodeGreeting Greeting using Unicode characters
     * @param formatStr       Format string for the greeting
     */
    public Greeting(int localityID, String localityName, String asciiGreeting,
                    String unicodeGreeting, String formatStr) {
        this.localityID = localityID;
        this.localityName = localityName;
        this.asciiGreeting = asciiGreeting;
        this.unicodeGreeting = unicodeGreeting;
        this.formatStr = formatStr;
    }

    /** @return the locality ID */
    public int getLocalityID() {
        return localityID;
    }

    /** @return the locality name */
    public String getLocalityName() {
        return localityName;
    }

    /** @return the ASCII greeting */
    public String getAsciiGreeting() {
        return asciiGreeting;
    }

    /** @return the Unicode greeting */
    public String getUnicodeGreeting() {
        return unicodeGreeting;
    }

    /** @return the greeting format string */
    public String getFormatStr() {
        return String.format(formatStr, unicodeGreeting);
    }

    /**
     * Returns the formatted greeting string based on ASCII or Unicode preference.
     *
     * @param asciiOnly If true, returns ASCII format; otherwise, Unicode
     * @return The formatted greeting string
     */
    public String getFormatStr(boolean asciiOnly) {
        return String.format(formatStr, asciiOnly ? asciiGreeting : unicodeGreeting);
    }

    /**
     * Converts the object to a string representation.
     *
     * @return The formatted string of the object
     */
    @Override
    public String toString() {
        return String.format("{localityID:%d, localityName:\"%s\", asciiGreeting:\"%s\", unicodeGreeting:\"%s\"}",
                localityID, localityName, asciiGreeting, unicodeGreeting);
    }
}
