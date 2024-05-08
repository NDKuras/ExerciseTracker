package a9;

import java.util.Date;

/**
 * The {@code RunWalk} class represents a specific type of {@link Exercise} involving running or walking.
 * It includes an attribute for distance and calculates the calories burned based on that factor.
 */
public class RunWalk extends Exercise {
    private double distance;

    /**
     * Default constructor that initializes a {@code RunWalk} exercise with default values.
     */
    public RunWalk() {
        super();
        setDistance(0);
    }

    /**
     * Constructs a {@code RunWalk} exercise with specified attributes.
     *
     * @param name     The name of the exercise.
     * @param date     The date of the exercise.
     * @param duration The duration of the exercise in minutes.
     * @param distance The distance covered in miles.
     * @param comment  Any additional comments about the exercise.
     */
    public RunWalk(String name, Date date, double duration, double distance, String comment) {
        super(name, date, duration, comment);
        setDistance(distance);
    }

    /**
     * Constructs a {@code RunWalk} exercise with specified attributes, including the date as a string.
     *
     * @param name     The name of the exercise.
     * @param date     The date of the exercise as a string in MM/dd/yyyy format.
     * @param duration The duration of the exercise in minutes.
     * @param distance The distance covered in miles.
     * @param comment  Any additional comments about the exercise.
     */
    public RunWalk(String name, String date, double duration, double distance, String comment) {
        super(name, date, duration, comment);
        setDistance(distance);
    }

    /**
     * Gets the distance covered in miles.
     *
     * @return The distance covered in miles.
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Sets the distance covered in miles.
     * If a negative value is provided, the distance is set to 0.
     *
     * @param distance The distance covered in miles.
     */
    public void setDistance(double distance) {
        if (distance < 0) {
            this.distance = 0;
        } else {
            this.distance = distance;
        }
    }

    /**
     * Returns the type of the exercise as a string.
     *
     * @return The string "Run/Walk".
     */
    @Override
    public String getType() {
        return "Run/Walk";
    }

    /**
     * Calculates the number of calories burned during the run or walk exercise.
     * The formula is based on the distance covered and the duration.
     *
     * @return The number of calories burned.
     */
    @Override
    public double getCaloriesBurned() {
        return (distance / getDuration()) * 9000;
    }

    /**
     * Returns additional custom information about the run or walk exercise,
     * including the distance covered.
     *
     * @return A string representing the distance covered.
     */
    @Override
    public String toStringCustomInfo() {
        return String.format("%.2f", distance);
    }
}
