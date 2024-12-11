package pandey.ujjwal.javaConcepts.utility.generator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;

public class PasswordGenerator {
    public static String generateRandomPassword(int n) {
        String upperCaseLetters = RandomStringUtils.random(n, 65, 90, true, true);
        String lowerCaseLetters = RandomStringUtils.random(n, 97, 122, true, true);
        String numbers = RandomStringUtils.randomNumeric(n);
        String specialChars = RandomStringUtils.random(n, 33, 47, false, false);
        String totalChars = RandomStringUtils.random(n, 33, 122, false, false);
        String combinedChars = upperCaseLetters.concat(lowerCaseLetters).concat(numbers).concat(specialChars).concat(totalChars);
        List<Character> pwdCharsList = combinedChars.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.shuffle(pwdCharsList);
        return pwdCharsList.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).substring(0, n);
    }
    public static String sanitizeFilename(String filename) {
        if (filename == null || filename.isEmpty()) {
            return "default_filename"; // Fallback for null or empty filenames
        }
        // Replace invalid characters with underscores
        return filename.replaceAll("[\\\\/:*?\"<>|]", "_");
    }
}