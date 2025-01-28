package student; // the "package", in java folder structure matters and creates packages.

import java.util.List;

/**
 * Greeter holds the name of the person and the locality of greeting to be used.
 *
 * <p>
 * The greeter class acts as a container for the user's information
 * and generates an appropriate greeting based on the locality.
 * </p>
 */
public class Greeter {
    /** Holds the name of the person. Immutable. */
    private final String name;

    /** Integer value representing the locality. Mutable. */
    private int locality;

    /** List of available locality options. */
    private static final List<String> LOCALITY_LIST = List.of("Hawaii", "USA", "China", "Italy");

    /** Integer value representing Hawaii. */
    private static final int HAWAII = 1;

    /** Integer value representing China. */
    private static final int CHINA = 3;

    /** Integer value representing Italy. */
    private static final int ITALY = 4;

    /** Default locality value (USA). */
    private static final int DEFAULT_LOCALITY = 2;

    /**
     * Constructor for the Greeter class.
     * Assumes default locality (USA).
     *
     * @param name Name of the person to greet
     */
    public Greeter(String name) {
        this(name, DEFAULT_LOCALITY);
    }

    /**
     * Constructor for the Greeter class.
     *
     * @param name     Name of the person to greet
     * @param locality Locality in which to greet them
     */
    public Greeter(String name, int locality) {
        this.name = name;
        if (locality < 1 || locality > LOCALITY_LIST.size()) {
            throw new IllegalArgumentException(
                    String.format("Locality must be between 1 and %d", LOCALITY_LIST.size()));
        }
        this.locality = locality;
    }

    /**
     * Returns the name of the greeter.
     *
     * @return the name of the greeter
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the locality of the greeter.
     *
     * @return the integer value of the locality
     */
    public int getLocality() {
        return locality;
    }

    /**
     * Sets the locality of the greeter.
     *
     * @param locality The integer value of the locality, if out of range throws an exception
     */
    public void setLocality(int locality) {
        if (locality < 1 || locality > LOCALITY_LIST.size()) {
            throw new IllegalArgumentException(
                    String.format("Locality must be between 1 and %d", LOCALITY_LIST.size()));
        }
        this.locality = locality;
    }

    /**
     * Generates a greeting message.
     *
     * @return The greeting message
     */
    public String greet() {
        return greet(true);
    }

    /**
     * Generates a greeting message based on locality.
     *
     * @param asciiOnly If true, only ASCII characters will be used
     * @return The greeting message
     */
    public String greet(boolean asciiOnly) {
        String greeting;
        switch (locality) {
            case HAWAII:
                greeting = String.format("Aloha, %s!", name);
                break;
            case CHINA:
                greeting = asciiOnly ? String.format("%s, Ni Hao!", name) : String.format("%s, 你好!", name);
                break;
            case ITALY:
                greeting = String.format("Ciao, %s!", name);
                break;
            default:
                greeting = String.format("Hello, %s!", name);
        }
        return greeting;
    }

    /**
     * Returns the string representation of the locality.
     *
     * @return The locality name as a string
     */
    private String getLocalityString() {
        return (locality < 1 || locality >= LOCALITY_LIST.size()) ? "USA" : LOCALITY_LIST.get(locality - 1);
    }

    /**
     * Overrides hashCode to ensure consistent hashing.
     *
     * @return The hashcode value
     */
    @Override
    public int hashCode() {
        return name.hashCode() + locality;
    }

    /**
     * Overrides equals to compare Greeter objects.
     *
     * @param obj The object to compare to
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Greeter) {
            Greeter other = (Greeter) obj;
            return name.equals(other.name) && locality == other.locality;
        }
        return false;
    }

    /**
     * Converts the object to a string representation.
     *
     * @return The formatted string of the object
     */
    @Override
    public String toString() {
        return String.format("{name:\"%s\", locality:\"%s\"}", name, getLocalityString());
    }

    /**
     * Returns a copy of the locality list.
     *
     * @return A copy of the locality list
     */
    public static List<String> getLocalityList() {
        return List.copyOf(LOCALITY_LIST);
    }
}
