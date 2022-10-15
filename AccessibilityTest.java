package accessibility;

/**
 * Class that creates AccessibilityTest objects
 * and includes accessor methods for its fields
 * @author Stewart Lovell
 * 9/29/2022
 */
public class AccessibilityTest {
    private final String category;
    private final String description;
    private final String googleResult;
    private final String waveResult;
    private final String sortsiteResult;
    private final String aslintResult;

    /**
     * Constructor for the AccessibilityTest class, takes five different Strings as parameters
     * @param category - The category of the test
     * @param googleResult - Google's test result
     * @param waveResult - WAVE's test result
     * @param sortsiteResult - SortSite's test result
     * @param aslintResult - ASLint's test result
     * @param description - The description of the test/result
     */
    public AccessibilityTest(String category, String googleResult, String waveResult, String sortsiteResult, String aslintResult, String description) {
        this.category = category;
        this.description = description;
        this.googleResult = googleResult;
        this.waveResult = waveResult;
        this.sortsiteResult = sortsiteResult;
        this.aslintResult = aslintResult;
    }

    /**
     * Getter method for the category of the test
     * @return - The category of the test
     */
    public String getCategory() {
        return category;
    }

    /**
     * Getter method for the description of the test/result
     * @return - The description of the test/result
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter method for Google's test result
     * @return - Google's test result
     */
    public String getGoogleResult() {
        return googleResult;
    }

    /**
     * Getter method for WAVE's test result
     * @return - WAVE's test result
     */
    public String getWaveResult() {
        return waveResult;
    }

    /**
     * Getter method for SortSite's test result
     * @return - SortSite's test result
     */
    public String getSortsiteResult() {
        return sortsiteResult;
    }

    /**
     * Getter method for ASLint's test result
     * @return - ASLint's test result
     */
    public String getAslintResult() {
        return aslintResult;
    }

    /**
     * toString method for the AccessibilityTest class
     * @return - String representation of an AccessibilityTest object
     */
    @Override
    public String toString() {
        return getCategory() + ": " + getDescription() +
                " Google: " + getGoogleResult() + " WAVE: " + getWaveResult()
                + " SortSite: " + getSortsiteResult() + " ASLint: " + getAslintResult();
    }
}
