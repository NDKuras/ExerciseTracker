package a9;

import java.util.Date;

/**
 * The {@code WeightLifting} class represents a specific type of {@link Exercise} involving weight lifting.
 * It includes an attribute for total weight lifted and calculates the calories burned based on that factor.
 */
public class WeightLifting extends Exercise {
    private double totalWeight;

    /**
     * Default constructor that initializes a {@code WeightLifting} exercise with default values.
     */
    public WeightLifting() {
        super();
        setTotalWeight(0);
    }

    /**
     * Constructs a {@code WeightLifting} exercise with specified attributes.
     *
     * @param name       The name of the exercise.
     * @param date       The date of the exercise.
     * @param duration   The duration of the exercise in minutes.
     * @param totalWeight The total weight lifted in pounds.
     * @param comment    Any additional comments about the exercise.
     */
    public WeightLifting(String name, Date date, double duration, double totalWeight, String comment) {
        super(name, date, duration, comment);
        setTotalWeight(totalWeight);
    }

    /**
     * Constructs a {@code WeightLifting} exercise with specified attributes, including the date as a string.
     *
     * @param name       The name of the exercise.
     * @param date       The date of the exercise as a string in MM/dd/yyyy format.
     * @param duration   The duration of the exercise in minutes.
     * @param totalWeight The total weight lifted in pounds.
     * @param comment    Any additional comments about the exercise.
     */
    public WeightLifting(String name, String date, double duration, double totalWeight, String comment) {
        super(name, date, duration, comment);
        setTotalWeight(totalWeight);
    }

    /**
     * Gets the total weight lifted in pounds.
     *
     * @return The total weight lifted in pounds.
     */
    public double getTotalWeight() {
        return totalWeight;
    }

    /**
     * Sets the total weight lifted in pounds.
     * If a negative value is provided, the total weight is set to 0.
     *
     * @param totalWeight The total weight lifted in pounds.
     */
    public void setTotalWeight(double totalWeight) {
        if (totalWeight < 0) {
            this.totalWeight = 0;
        } else {
            this.totalWeight = totalWeight;
        }
    }

    /**
     * Returns the type of the exercise as a string.
     *
     * @return The string "WeightLifting".
     */
    @Override
    public String getType() {
        return "WeightLifting";
    }

    /**
     * Calculates the number of calories burned during the weight lifting exercise.
     * The formula is based on the total weight lifted and the duration.
     *
     * @return The number of calories burned.
     */
    @Override
    public double getCaloriesBurned() {
        return (totalWeight / getDuration()) * 50;
    }

    /**
     * Returns additional custom information about the weight lifting exercise,
     * including the total weight lifted.
     *
     * @return A string representing the total weight lifted.
     */
    @Override
    public String toStringCustomInfo() {
        return String.format("%.2f", totalWeight);
    }
}
