import java.util.Arrays;
import java.util.List;

/**
 * StringUtility
 *
 * @author Andres Arevalo, Camila, Walter Chu & Nick
 * @version 1.0
 */
public class StringUtils
{
    private static final int    INITIAL;
    private static final int    SUBSTRING;
    private static final String SPLIT_CHARACTER;
    private static final String JOINER_CHARACTER;

    static
    {
        INITIAL                 = 0;
        SUBSTRING = 1;
        SPLIT_CHARACTER         = " ";
        JOINER_CHARACTER        = ".";
    }

    private StringUtils()
    {
        throw new AssertionError("Cannot be instantiated");
    }

    /**
     * Converts the given string to title case.
     * The first character is converted to uppercase and the rest to lowercase.
     *
     * @param str the string to be converted
     * @return the title case version of the string
     */
    public static String getTitleCase(final String str)
    {
        return str.toUpperCase().charAt(INITIAL) + str.substring(SUBSTRING).toLowerCase();
    }

    /**
     * Gets the initials of each word in the given string.
     * The initials are converted to uppercase and joined by a specified character.
     *
     * @param str the string to extract initials from
     * @return a string containing the initials of each word, joined by the specified character
     */
    public static String getInitials(final String str)
    {
        final List<String> words;
        words = Arrays.stream(str.strip().split(SPLIT_CHARACTER)).toList();

        return words.stream()
                    .map( word -> word.toUpperCase().charAt(INITIAL) + "")
                    .reduce("", (previous, initial) -> previous + initial + JOINER_CHARACTER);
    }

    /**
     * Reverses the given string.
     *
     * @param str the string to be reversed
     * @return the reversed string
     */
    public static String getReverse(final String str)
    {
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * Checks if the given string is a palindrome.
     * A palindrome is a string that reads the same forwards and backwards.
     *(e.g): "level", "radar", "noon"
     * @param str the string to be checked
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(final String str)
    {
        final String cleaned = str.strip().toLowerCase();
        return cleaned.contentEquals(new StringBuilder(str).reverse());
    }
}
