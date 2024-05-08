package a9;

import java.util.Comparator;

/**
 * The `ExerciseCompareByCalories` class implements the `Comparator` interface
 * to compare two `Exercise` objects based on the number of calories burned.
 * This comparison sorts exercises in descending order of calories burned.
 */
public class ExerciseCompareByCalories implements Comparator<Exercise> {
    /**
     * Compares two `Exercise` objects based on the number of calories burned.
     * The comparison is in descending order, meaning the exercise with more calories
     * burned will come before the exercise with fewer calories burned.
     *
     * @param e1 The first `Exercise` object to compare.
     * @param e2 The second `Exercise` object to compare.
     * @return A negative integer if `e1` has more calories burned than `e2`,
     *         zero if they have the same number of calories burned,
     *         or a positive integer if `e2` has more calories burned than `e1`.
     */
    @Override
    public int compare(Exercise e1, Exercise e2) {
        return Double.compare(e2.getCaloriesBurned(), e1.getCaloriesBurned());
    }
}
