package a9;

import java.util.Date;

/**
 * The {@code RockClimbing} class represents a specific type of {@link Exercise} involving rock climbing.
 * It includes attributes like wall height and repetitions, and calculates the calories burned based on these factors.
 */
public class RockClimbing extends Exercise {
    private double wallHeight;
    private int repetitions;

    /**
     * Default constructor that initializes a {@code RockClimbing} exercise with default values.
     */
    public RockClimbing() {
        super();
        setWallHeight(0);
        setRepetitions(0);
    }

    /**
     * Constructs a {@code RockClimbing} exercise with specified attributes.
     *
     * @param name        The name of the exercise.
     * @param date        The date of the exercise.
     * @param duration    The duration of the exercise in minutes.
     * @param wallHeight  The height of the climbing wall in feet.
     * @param repetitions The number of repetitions.
     * @param comment     Any additional comments about the exercise.
     */
    public RockClimbing(String name, Date date, double duration, double wallHeight, int repetitions, String comment) {
        super(name, date, duration, comment);
        setWallHeight(wallHeight);
        setRepetitions(repetitions);
    }

    /**
     * Constructs a {@code RockClimbing} exercise with specified attributes, including the date as a string.
     *
     * @param name        The name of the exercise.
     * @param date        The date of the exercise as a string in MM/dd/yyyy format.
     * @param duration    The duration of the exercise in minutes.
     * @param wallHeight  The height of the climbing wall in feet.
     * @param repetitions The number of repetitions.
     * @param comment     Any additional comments about the exercise.
     */
    public RockClimbing(String name, String date, double duration, double wallHeight, int repetitions, String comment) {
        super(name, date, duration, comment);
        setWallHeight(wallHeight);
        setRepetitions(repetitions);
    }

    /**
     * Gets the height of the climbing wall in feet.
     *
     * @return The height of the climbing wall in feet.
     */
    public double getWallHeight() {
        return wallHeight;
    }

    /**
     * Sets the height of the climbing wall in feet.
     * If a negative value is provided, the height is set to 0.
     *
     * @param wallHeight The height of the climbing wall in feet.
     */
    public void setWallHeight(double wallHeight) {
        if (wallHeight < 0) {
            this.wallHeight = 0;
        } else {
            this.wallHeight = wallHeight;
        }
    }

    /**
     * Gets the number of repetitions of the climb.
     *
     * @return The number of repetitions.
     */
    public int getRepetitions() {
        return repetitions;
    }

    /**
     * Sets the number of repetitions of the climb.
     * If a negative value is provided, the repetitions are set to 0.
     *
     * @param repetitions The number of repetitions.
     */
    public void setRepetitions(int repetitions) {
        if (repetitions < 0) {
            this.repetitions = 0;
        } else {
            this.repetitions = repetitions;
        }
    }

    /**
     * Returns the type of the exercise as a string.
     *
     * @return The string "Rock Climbing".
     */
    @Override
    public String getType() {
        return "Rock Climbing";
    }

    /**
     * Calculates the number of calories burned during the rock climbing exercise.
     * The formula is based on wall height, repetitions, and duration.
     *
     * @return The number of calories burned.
     */
    @Override
    public double getCaloriesBurned() {
        return (wallHeight * repetitions / getDuration()) * 100;
    }

    /**
     * Returns additional custom information about the rock climbing exercise,
     * including wall height and repetitions.
     *
     * @return A string representing wall height and repetitions.
     */
    @Override
    public String toStringCustomInfo() {
        return String.format("%.2f\t%d", wallHeight, repetitions);
    }
}
