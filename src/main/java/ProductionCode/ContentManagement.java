package ProductionCode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ContentManagement {

    private static final String RECIPES_FILE_PATH = "files/recipes.txt";
    private static final String FEEDBACK_FILE_PATH = "files/feedback.txt";
    private static final String RESPONSE_FEEDBACK_FILE_PATH = "files/responseFeedback.txt";

     String feedbackDeleteMessage;
     String responseMessage;
     String RecipeDeletedMessage;

    // Helper method to read lines from a file
    private List<String> readLinesFromFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return lines;
    }

    // Helper method to write lines to a file
    private void writeLinesToFile(String filePath, List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public void viewRecipes() {
        List<String> recipes = readLinesFromFile(RECIPES_FILE_PATH);
        for (String recipe : recipes) {
            System.out.println(recipe);
        }
    }

    public void deleteRecipes(String product) {
        List<String> recipes = readLinesFromFile(RECIPES_FILE_PATH);
        List<String> updatedRecipes = new ArrayList<>();
        for (String line : recipes) {
            if (!line.toLowerCase().startsWith(product.toLowerCase() + ":")) {
                updatedRecipes.add(line);
            }
        }
        writeLinesToFile(RECIPES_FILE_PATH, updatedRecipes);
        RecipeDeletedMessage = "Recipe deleted successfully.";
    }

    public void responseFeedback(String id, String responseMessage) {
        List<String> feedbacks = readLinesFromFile(FEEDBACK_FILE_PATH);
        String username = null;

        for (String line : feedbacks) {
            String[] feedbackParts = line.split(":");
            if (feedbackParts.length >= 3 && feedbackParts[0].equals(id)) {
                username = feedbackParts[1];
                break;
            }
        }

        if (username != null) {
            String response = "Response to " + username + ": " + responseMessage;
            List<String> responses = readLinesFromFile(RESPONSE_FEEDBACK_FILE_PATH);
            responses.add(response);
            writeLinesToFile(RESPONSE_FEEDBACK_FILE_PATH, responses);
           
        } else {
            System.out.println("Feedback with ID " + id + " not found.");
        }
    }

    public void viewFeedback() {
        List<String> feedbacks = readLinesFromFile(FEEDBACK_FILE_PATH);
        for (String feedback : feedbacks) {
            System.out.println(feedback);
        }
    }

    public void deleteFeedback(String id) {
        List<String> feedbacks = readLinesFromFile(FEEDBACK_FILE_PATH);
        List<String> updatedFeedbacks = new ArrayList<>();
        for (String line : feedbacks) {
            String[] parts = line.split(":");
            if (parts.length > 1 && !parts[0].equals(id)) {
                updatedFeedbacks.add(line);
            }
        }
        writeLinesToFile(FEEDBACK_FILE_PATH, updatedFeedbacks);
        feedbackDeleteMessage = "Feedback deleted successfully.";
    }

    public void printMessages(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
