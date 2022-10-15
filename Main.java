package client;

import accessibility.AccessibilityResults;

public class Main {
    public static void main(String[] args) {
        AccessibilityResults results = new AccessibilityResults("a11yCheckersResults.txt");
        results.showTestResults("Colour");
        results.showByCategory("key");
        results.showAllFailed();
        System.out.println(results.numPass("Goog", ""));
        System.out.println(results.numPass("lint", "htm"));
    }
}