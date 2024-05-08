package a9;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * The {@code ExerciseTrackerGUI} class provides a graphical user interface for tracking exercises.
 * It extends {@link JFrame} and allows users to add and manage {@link Exercise} objects.
 * The GUI includes various input fields, buttons, and a list to display the exercises.
 */
public class ExerciseTrackerGUI extends JFrame {
    private static final long serialVersionUID = 1L;

    // Menu components
    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu menuFile = new JMenu("File");
    private final JMenu menuHelp = new JMenu("Help");
    private final JMenuItem menuItemLogin = new JMenuItem("Log in");
    private final JMenuItem menuItemLogout = new JMenuItem("Log out");
    private final JMenuItem menuItemSave = new JMenuItem("Save");
    private final JMenuItem menuItemExit = new JMenuItem("Exit");
    private final JMenuItem menuItemAbout = new JMenuItem("About");

    // Labels
    private final JLabel lblName = new JLabel("Name:");
    private final JLabel lblDate = new JLabel("Date (MM/dd/yyyy):");
    private final JLabel lblDuration = new JLabel("Duration (min):");
    private final JLabel lblComment = new JLabel("Comment:");
    private final JLabel lblExerciseType = new JLabel("Exercise Type:");
    private final JLabel lblCustom1 = new JLabel("Distance (miles):");
    private final JLabel lblCustom2 = new JLabel("Total Weight (lbs):");
    private final JLabel lblCustom3 = new JLabel("Wall Height (ft):");
    private final JLabel lblCustom4 = new JLabel("Repetitions:");

    // Input fields
    private final JTextField txtName = new JTextField(15);
    private final JTextField txtDate = new JTextField(15);
    private final JTextField txtDuration = new JTextField(10);
    private final JTextField txtComment = new JTextField(15);
    private final JTextField txtCustom1 = new JTextField(10);
    private final JTextField txtCustom2 = new JTextField(10);
    private final JTextField txtCustom3 = new JTextField(10);
    private final JTextField txtCustom4 = new JTextField(10);

    // Combo box for exercise types
    private final JComboBox<String> comboExerciseType = new JComboBox<>(new String[]{"Run/Walk", "WeightLifting", "Rock Climbing"});

    // Button to add exercises
    private final JButton btnAddExercise = new JButton("Add Exercise");

    // List model and list to display exercises
    private final DefaultListModel<Exercise> exerciseListModel = new DefaultListModel<>();
    private final JList<Exercise> exerciseList = new JList<>(exerciseListModel);

    // Text area for displaying exercise details
    private final JTextArea exerciseDetails = new JTextArea(10, 30);

    // Collection to hold exercises
    private final List<Exercise> exerciseCollection = new ArrayList<>();

    /**
     * Constructs the ExerciseTrackerGUI and initializes the GUI components.
     */
    public ExerciseTrackerGUI() {
        setTitle("Exercise Tracker");
        setSize(700, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setupMenuBar();
        setupForm();
        setupExerciseList();

        add(new JScrollPane(exerciseList), BorderLayout.CENTER);
        add(new JScrollPane(exerciseDetails), BorderLayout.EAST);

        disableAllFields();

        comboExerciseType.addActionListener(e -> updateCustomFields());

        btnAddExercise.addActionListener(e -> addExercise());

        exerciseList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Exercise selected = exerciseList.getSelectedValue();
                if (selected != null) {
                    exerciseDetails.setText(selected.toString());
                }
            }
        });

        menuItemLogin.addActionListener(e -> LoginFrame.V(this).setVisible(true));
        menuItemLogout.addActionListener(e -> disableAllFields());
        menuItemSave.addActionListener(e -> saveExercises());
        menuItemExit.addActionListener(e -> System.exit(0));
        menuItemAbout.addActionListener(e -> showAboutMessage());

        updateCustomFields();
    }

    /**
     * Sets up the menu bar with menu items and adds it to the frame.
     */
    private void setupMenuBar() {
        menuBar.add(menuFile);
        menuBar.add(menuHelp);

        menuFile.add(menuItemLogin);
        menuFile.add(menuItemLogout);
        menuFile.add(menuItemSave);
        menuFile.addSeparator();
        menuFile.add(menuItemExit);

        menuHelp.add(menuItemAbout);

        setJMenuBar(menuBar);
    }

    /**
     * Sets up the form with input fields and labels for user interactions.
     * This includes the main exercise attributes and custom fields.
     */
    private void setupForm() {
        JPanel formPanel = new JPanel(new GridLayout(10, 2, 5, 5));

        formPanel.add(lblName);
        formPanel.add(txtName);
        formPanel.add(lblDate);
        formPanel.add(txtDate);
        formPanel.add(lblDuration);
        formPanel.add(txtDuration);
        formPanel.add(lblComment);
        formPanel.add(txtComment);
        formPanel.add(lblExerciseType);
        formPanel.add(comboExerciseType);
        formPanel.add(lblCustom1);
        formPanel.add(txtCustom1);
        formPanel.add(lblCustom2);
        formPanel.add(txtCustom2);
        formPanel.add(lblCustom3);
        formPanel.add(txtCustom3);
        formPanel.add(lblCustom4);
        formPanel.add(txtCustom4);
        formPanel.add(new JLabel(""));
        formPanel.add(btnAddExercise);

        add(formPanel, BorderLayout.WEST);
    }

    /**
     * Sets up the exercise list and details area for displaying selected exercise information.
     */
    private void setupExerciseList() {
        exerciseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        exerciseDetails.setEditable(false);
    }

    /**
     * Updates the visibility and labels of the custom fields based on the selected exercise type.
     */
    private void updateCustomFields() {
        String selectedType = (String) comboExerciseType.getSelectedItem();
        lblCustom1.setVisible(false);
        lblCustom2.setVisible(false);
        lblCustom3.setVisible(false);
        lblCustom4.setVisible(false);
        txtCustom1.setVisible(false);
        txtCustom2.setVisible(false);
        txtCustom3.setVisible(false);
        txtCustom4.setVisible(false);

        switch (selectedType) {
            case "Run/Walk":
                lblCustom1.setText("Distance (miles):");
                lblCustom1.setVisible(true);
                txtCustom1.setVisible(true);
                break;
            case "WeightLifting":
                lblCustom2.setText("Total Weight (lbs):");
                lblCustom2.setVisible(true);
                txtCustom2.setVisible(true);
                break;
            case "Rock Climbing":
                lblCustom3.setText("Wall Height (ft):");
                lblCustom3.setVisible(true);
                txtCustom3.setVisible(true);
                lblCustom4.setText("Repetitions:");
                lblCustom4.setVisible(true);
                txtCustom4.setVisible(true);
                break;
        }
    }

    /**
     * Adds a new exercise to the exercise collection based on user input.
     * The type of exercise is determined by the selection in the combo box.
     */
    private void addExercise() {
        try {
            String name = txtName.getText().trim();
            String date = txtDate.getText().trim();
            double duration = Double.parseDouble(txtDuration.getText().trim());
            String comment = txtComment.getText().trim();
            String selectedType = (String) comboExerciseType.getSelectedItem();

            Exercise exercise = null;

            switch (selectedType) {
                case "Run/Walk":
                    double distance = Double.parseDouble(txtCustom1.getText().trim());
                    exercise = new RunWalk(name, date, duration, distance, comment);
                    break;
                case "WeightLifting":
                    double totalWeight = Double.parseDouble(txtCustom2.getText().trim());
                    exercise = new WeightLifting(name, date, duration, totalWeight, comment);
                    break;
                case "Rock Climbing":
                    double wallHeight = Double.parseDouble(txtCustom3.getText().trim());
                    int repetitions = Integer.parseInt(txtCustom4.getText().trim());
                    exercise = new RockClimbing(name, date, duration, wallHeight, repetitions, comment);
                    break;
            }

            if (exercise != null) {
                exerciseCollection.add(exercise);
                exerciseListModel.addElement(exercise);
                exerciseDetails.setText(exercise.toString());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input, please ensure all fields are filled out correctly.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Saves the collection of exercises to a file selected by the user.
     * If the file extension is not ".txt", it will be added automatically.
     */
    private void saveExercises() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        int returnVal = fileChooser.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String fileName = fileChooser.getSelectedFile().getAbsolutePath();
            if (!fileName.endsWith(".txt")) {
                fileName += ".txt";
            }

            try {
                ExerciseWriter.writeToFile(fileName, exerciseCollection);
                JOptionPane.showMessageDialog(this, "Exercises successfully saved to " + fileName, "Save Successful", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving exercises to file.", "Save Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Shows an "About" message dialog with information about the application.
     */
    private void showAboutMessage() {
        JOptionPane.showMessageDialog(this, "Exercise Tracker\nVersion 1.0\nDeveloped by [Your Name]", "About", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Enables all input fields, combo box, and button.
     */
    public void enableAllFields() {
        txtName.setEnabled(true);
        txtDate.setEnabled(true);
        txtDuration.setEnabled(true);
        txtComment.setEnabled(true);
        txtCustom1.setEnabled(true);
        txtCustom2.setEnabled(true);
        txtCustom3.setEnabled(true);
        txtCustom4.setEnabled(true);
        comboExerciseType.setEnabled(true);
        btnAddExercise.setEnabled(true);
    }

    /**
     * Disables all input fields, combo box, and button.
     */
    public void disableAllFields() {
        txtName.setEnabled(false);
        txtDate.setEnabled(false);
        txtDuration.setEnabled(false);
        txtComment.setEnabled(false);
        txtCustom1.setEnabled(false);
        txtCustom2.setEnabled(false);
        txtCustom3.setEnabled(false);
        txtCustom4.setEnabled(false);
        comboExerciseType.setEnabled(false);
        btnAddExercise.setEnabled(false);
    }

    /**
     * The main method that starts the Exercise Tracker GUI application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ExerciseTrackerGUI gui = new ExerciseTrackerGUI();
            gui.setVisible(true);
        });
    }
}
