package accessibility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Class that creates a HashSet of AccessibilityTest objects and provides
 * various methods to interact with the set
 * @author Stewart Lovell
 * 9/29/2022
 */
public class AccessibilityResults{

    // create a set that will hold all of our AccessibilityTest objects
    Set<AccessibilityTest> set = new HashSet<>();

    /**
     * Constructor for the AccessibilityResults class
     * Takes a file name as a parameter and enters each line of information
     * in the file into a HashSet
     * @param filename - Name of the file to be read
     */
    public AccessibilityResults(String filename) {
        //try - catch block to read in the file and catch a FileNotFoundException
        try (Scanner fileIn = new Scanner(new File(filename))) {
            // while there is still text in the file...
            while (fileIn.hasNextLine()) {
                // read in the next line, split the line into pieces
                String line = fileIn.nextLine();
                String[] pieces = line.split(" ");

                // Concatenate everything after the 5th word together, and store it in a string
                // (this is the description, we want it all to be together)
                String desc = "";
                for (int i = 5; i < pieces.length; i++) {
                    desc += pieces[i] + " ";
                }
                // construct a new AccessibilityTest object with the extracted text information and add it to the set
                set.add(new AccessibilityTest(pieces[0], pieces[1], pieces[2], pieces[3], pieces[4], desc));
            }
            //catch block in-case the file is not found
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    /**
     * Returns the number of tests that were run
     * (number of lines in the text file, or objects in the set)
     * @return - Size of the set
     */
    public int numTests () {
        return set.size();
    }

    /**
     * Takes in a String, then searches each AccessibilityTest object's description in the HashSet for that String,
     * printing the toString method of the object if it finds a match, as well as the
     * number of total matches found
     * @param details - String to be searched for in the test descriptions
     */
    public void showTestResults (String details) {
        // create a counter to keep track of the number of matches
        int count = 0;
        // for each AccessibilityTest object in the set...
        for (AccessibilityTest objects : set) {
            // if the object's description contains the given search String...
            if (objects.getDescription().toLowerCase().contains(details.toLowerCase())) {
                // increment the count
                count++;
                // print out the matching object's toString
                System.out.println(objects);
            }
        }
        // display the total matches found
        System.out.println(System.lineSeparator() + "Total tests matching your search: " + count);
    }

    /**
     * Takes in a String, then searches each AccessibilityTest object's category in the HashSet for that String,
     * printing the toString method of the object if it finds a match, as well as the
     * number of total matches found
     * @param category - String to be searched for in the test categories
     */
    public void showByCategory (String category) {
        // create a counter to keep track of the number of matches
        int count = 0;
        // for each AccessibilityTest object in the set...
        for (AccessibilityTest objects : set) {
            // if the object's category contains the given search String...
            if (objects.getCategory().toLowerCase().contains(category.toLowerCase())) {
                // increment the count
                count++;
                // print out the matching object's toString
                System.out.println(objects);
            }
        }
        // display the total matches found
        System.out.println(System.lineSeparator() + "Total tests in this category: " + count);
    }

    /**
     * Searches the Set of AccessibilityTest Objects for each test where all four
     * results (Google, WAVE, SortSite, and ASLint) are equal to "notfound", printing
     * the toString method of the object if it finds a match, as well as the number
     * of total matches found
     */
    public void showAllFailed () {
        // create a counter
        int count = 0;
        // for each object in the set...
        for (AccessibilityTest objects : set) {
            // if all four results are equal to "notfound"...
            if (objects.getGoogleResult().equalsIgnoreCase("notfound")
            && objects.getWaveResult().equalsIgnoreCase("notfound")
            && objects.getSortsiteResult().equalsIgnoreCase("notfound")
            && objects.getAslintResult().equalsIgnoreCase("notfound")) {
                // increment count
                count++;
                // print object's toString
                System.out.println(objects);
            }
        }
        // display total matches
        System.out.println(System.lineSeparator() + "Total tests failed: " + count);
    }

    /**
     * Takes in two Strings, searches the HashSet of AccessibilityTest for a matching checker
     * (Google, WAVE, SortSite, or ASLint) and a matching category, then for results where
     * the checker's result equals either "error" or "error_paid", returning the count
     * of the total matches found
     * @param checker - One of the four checker companies (Google, WAVE, SortSite, ASLint, can be partial and is case-insensitive)
     * @param category - Any of the test categories (can be partial and is case-insensitive)
     * @return - The count of total matches found
     */
    public int numPass(String checker, String category) {
        // create Strings to represent the four checker companies
        String google = "Google";
        String wave = "WAVE";
        String sortSite = "SortSite";
        String asLint = "ASLint";

        // create a counter
        int count = 0;
        // for each object in the set
        for (AccessibilityTest objects : set) {
            // if the google String contains the checker String
            // and the object's category contains the given category String...
            if (google.toLowerCase().contains(checker.toLowerCase())
                    && objects.getCategory().toLowerCase().contains(category.toLowerCase())) {
                // if the result of the test is either "error" or "error_paid"
                if (objects.getGoogleResult().equalsIgnoreCase("error")
                || objects.getGoogleResult().equalsIgnoreCase("error_paid")) {
                    // increment the count
                    count++;
                }
                // repeat the logic above for WAVE, SortSite, and ASLint
            } else if (wave.toLowerCase().contains(checker.toLowerCase())
                    && objects.getCategory().toLowerCase().contains(category.toLowerCase())) {
                if (objects.getWaveResult().equalsIgnoreCase("error")
                || objects.getWaveResult().equalsIgnoreCase("error_paid")) {
                    count++;
                }
            } else if (sortSite.toLowerCase().contains(checker.toLowerCase())
                    && objects.getCategory().toLowerCase().contains(category.toLowerCase())) {
                if (objects.getSortsiteResult().equalsIgnoreCase("error")
                || objects.getWaveResult().equalsIgnoreCase("error_paid")) {
                    count++;
                }
            } else if (asLint.toLowerCase().contains(checker.toLowerCase())
                    && objects.getCategory().toLowerCase().contains(category.toLowerCase())) {
                if (objects.getAslintResult().equalsIgnoreCase("error")
                || objects.getAslintResult().equalsIgnoreCase("error_paid")) {
                    count++;
                }
            }
        }
        // return the count
        return count;
    }
}