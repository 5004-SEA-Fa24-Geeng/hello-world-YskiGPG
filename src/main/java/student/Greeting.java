package student;

/**
 * The Greeting class stores the locality ID, locality name, and the corresponding
 * ASCII and Unicode greetings. This helps simplify looking up greetings and makes
 * it easier to add new greeting types without modifying other parts of the code.
 */
public class Greeting {
    private int localityID;
    private String localityName;
    private String asciiGreeting;
    private String unicodeGreeting;
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
    public Greeting(int localityID, String localityName, String asciiGreeting, String unicodeGreeting, String formatStr) {
        this.localityID = localityID;
        this.localityName = localityName;
        this.asciiGreeting = asciiGreeting;
        this.unicodeGreeting = unicodeGreeting;
        this.formatStr = formatStr;
    }

    /**
     * Returns the locality ID.
     *
     * @return the locality ID number
     */
    public int getLocalityID() {
        return this.localityID;
    }

    /**
     * Returns the locality name.
     *
     * @return the locality name
     */
    public String getLocalityName() {
        return this.localityName;
    }

    /**
     * Returns the ASCII greeting.
     *
     * @return the ASCII greeting
     */
    public String getAsciiGreeting() {
        return this.asciiGreeting;
    }

    /**
     * Returns the Unicode greeting.
     *
     * @return the Unicode greeting
     */
    public String getUnicodeGreeting() {
        return this.unicodeGreeting;
    }

    /**
     * Returns the format string for the greeting.
     *
     * @return the greeting format string
     */
    public String getFormatStr() {
        return String.format(this.formatStr, this.unicodeGreeting);
    }

    /**
     * Returns the format string with the appropriate greeting (ASCII or Unicode).
     *
     * @param asciiOnly if true, returns the ASCII greeting format; otherwise, Unicode
     * @return the formatted greeting string
     */
    public String getFormatStr(boolean asciiOnly) {
        return String.format(this.formatStr, asciiOnly ? this.asciiGreeting : this.unicodeGreeting);
    }

    /**
     * Returns a string representation of the Greeting object.
     *
     * @return a formatted string with locality details and greetings
     */
    @Override
    public String toString() {
        return String.format("{localityID:%d, localityName:\"%s\", asciiGreeting:\"%s\", unicodeGreeting:\"%s\"}",
                localityID, localityName, asciiGreeting, unicodeGreeting);
    }
}
