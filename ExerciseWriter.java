package a9;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * The {@code ExerciseWriter} class provides methods to write a collection of {@link Exercise} objects to a file
 * or to print them to the console. It includes methods for detailed or summary output.
 */
public class ExerciseWriter {
    /**
     * Writes the full details of each {@link Exercise} in the provided list to a specified file.
     *
     * @param filename  The name of the file to write to.
     * @param exercises The list of exercises to write to the file.
     * @throws IOException If an I/O error occurs during file writing.
     */
    public static void writeToFile(String filename, List<Exercise> exercises) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Exercise exercise : exercises) {
                writer.println(exercise.toString());
            }
        }
    }

    /**
     * Writes a summary of each {@link Exercise} in the provided list to a specified file.
     *
     * @param filename  The name of the file to write to.
     * @param exercises The list of exercises to write to the file.
     * @throws IOException If an I/O error occurs during file writing.
     */
    public static void writeSummaryToFile(String filename, List<Exercise> exercises) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(String.format("%-20s%-25s%-15s%10s", "Type", "Name", "Date", "Calories Burned"));
            for (Exercise exercise : exercises) {
                writer.println(exercise.toSummaryString());
            }
        }
    }

    /**
     * Prints the full details of each {@link Exercise} in the provided list to the console.
     *
     * @param exercises The list of exercises to print.
     */
    public static void printToConsole(List<Exercise> exercises) {
        for (Exercise exercise : exercises) {
            System.out.println(exercise.toString());
        }
    }

    /**
     * Prints a summary of each {@link Exercise} in the provided list to the console.
     *
     * @param exercises The list of exercises to print.
     */
    public static void tabulateSummary(List<Exercise> exercises) {
        System.out.println(String.format("%-20s%-25s%-15s%10s", "Type", "Name", "Date", "Calories Burned"));
        for (Exercise exercise : exercises) {
            System.out.println(exercise.toSummaryString());
        }
    }
}
