package a9;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The abstract class `Exercise` provides a blueprint for representing a physical exercise.
 * This class implements the `Comparable` interface, allowing exercises to be sorted by date.
 * Subclasses are expected to define specific types of exercises and their calorie burn rates.
 * <p>
 * The class provides constructors and methods to handle various attributes of an exercise,
 * such as name, date, duration, comments, and calorie burn rate.
 */
public abstract class Exercise implements Comparable<Exercise> {
    private String name;
    private Date date;
    private double duration;
    private String comment;
    private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    /**
     * Default constructor that initializes an exercise with default values.
     */
    public Exercise() {
        name = "Exercise";
        setDate();
        setDuration(0);
        setComment("Unknown exercise");
    }

    /**
     * Constructor that initializes an exercise with specified attributes.
     *
     * @param name     The name of the exercise.
     * @param date     The date of the exercise.
     * @param duration The duration of the exercise in minutes.
     * @param comment  Any additional comments about the exercise.
     */
    public Exercise(String name, Date date, double duration, String comment) {
        setName(name);
        setDate(date);
        setDuration(duration);
        setComment(comment);
    }

    /**
     * Constructor that initializes an exercise with specified attributes,
     * including the date as a string.
     *
     * @param name     The name of the exercise.
     * @param date     The date of the exercise as a string in MM/dd/yyyy format.
     * @param duration The duration of the exercise in minutes.
     * @param comment  Any additional comments about the exercise.
     */
    public Exercise(String name, String date, double duration, String comment) {
        setName(name);
        setDate(date);
        setDuration(duration);
        setComment(comment);
    }

    /**
     * Gets the name of the exercise.
     *
     * @return The name of the exercise.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the exercise.
     *
     * @param name The name of the exercise.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the date of the exercise.
     *
     * @return The date of the exercise.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the exercise.
     *
     * @param date The date of the exercise.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Sets the date of the exercise to the current date.
     */
    public void setDate() {
        this.date = new Date(); // current date
    }

    /**
     * Sets the date of the exercise using a string representation.
     * If the provided string cannot be parsed, the date is set to the current date.
     *
     * @param date The date of the exercise as a string in MM/dd/yyyy format.
     */
    public void setDate(String date) {
        try {
            this.date = df.parse(date);
        } catch (Exception ex) {
            this.date = new Date(); // now
        }
    }

    /**
     * Gets the duration of the exercise in minutes.
     *
     * @return The duration of the exercise.
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the exercise in minutes. If a negative value is provided,
     * the duration is set to 0.
     *
     * @param duration The duration of the exercise in minutes.
     */
    public void setDuration(double duration) {
        if (duration < 0) {
            this.duration = 0;
        } else {
            this.duration = duration;
        }
    }

    /**
     * Gets additional comments about the exercise.
     *
     * @return The comments about the exercise.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets additional comments about the exercise.
     *
     * @param comment The comments about the exercise.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets the date of the exercise as a formatted string in MM/dd/yyyy format.
     *
     * @return The date of the exercise as a string.
     */
    private String getDateAsString() {
        return df.format(date);
    }

    /**
     * Returns additional custom information about the exercise as a string.
     * Subclasses must provide their own implementation.
     *
     * @return The custom information about the exercise.
     */
    public abstract String toStringCustomInfo();

    /**
     * Returns a string representation of the exercise, including its name, type, date,
     * duration, custom information, calories burned, and comments.
     *
     * @return A string representation of the exercise.
     */
    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%.2f\t%s\t%.2f\t%s",
                name, getType(), getDateAsString(), duration, toStringCustomInfo(), getCaloriesBurned(), comment);
    }

    /**
     * Gets the type of exercise. Subclasses must provide their own implementation.
     *
     * @return The type of exercise as a string.
     */
    public abstract String getType();

    /**
     * Calculates the number of calories burned during the exercise.
     * Subclasses must provide their own implementation.
     *
     * @return The number of calories burned.
     */
    public abstract double getCaloriesBurned();

    /**
     * Compares this exercise to another exercise based on their dates.
     *
     * @param other The other exercise to compare to.
     * @return A negative integer, zero, or a positive integer as this exercise's date
     *         is before, equal to, or after the other exercise's date.
     */
    @Override
    public int compareTo(Exercise other) {
        return date.compareTo(other.date);
    }

    /**
     * Returns a summary string of the exercise, including its type, name, date, and
     * calories burned.
     *
     * @return A summary string of the exercise.
     */
    public String toSummaryString() {
        return String.format("%-20s%-25s%-15s%10.2f", getType(), name, getDateAsString(), getCaloriesBurned());
    }
}
