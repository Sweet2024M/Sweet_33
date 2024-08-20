package ProductionCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ContentManagement {

    public String feedbackDeleteMessage;
    public String responseMessage;
    public String RecipeDeletedMessage;

    public void viewRecipes() {
        String filePath = "C:\\Users\\THINKPAD\\git\\Softwar_proj\\alternativeSweet\\files\\recipes.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
    }

    public void deleteRecipes(String product) {
        String filePath = "C:\\Users\\THINKPAD\\git\\Softwar_proj\\alternativeSweet\\files\\recipes.txt";
        List<String> recipes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Check if the line starts with the product name
                if (!line.toLowerCase().startsWith(product.toLowerCase() + ":")) {
                    recipes.add(line); // Add the line to the list if it should not be deleted
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String recipe : recipes) {
                writer.write(recipe);
                writer.newLine();
            }
            RecipeDeletedMessage = "Recipe deleted successfully.";
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
    }

    public void responseFeedback(String id, String responsMessage) {
        String feedbackFilePath = "C:\\Users\\THINKPAD\\git\\Softwar_proj\\alternativeSweet\\files\\feedback.txt";
        String responseFilePath = "C:\\Users\\THINKPAD\\git\\Softwar_proj\\alternativeSweet\\files\\responseFeedback.txt";
        String username = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(feedbackFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line to get the id and username
                String[] feedbackParts = line.split(":");
                if (feedbackParts.length >= 3 && feedbackParts[0].equals(id)) {
                    username = feedbackParts[1]; // Get the username from the feedback
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }

        if (username != null) {
            // Formulate the response message
            String response = "Response to " + username + ": " + responsMessage;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(responseFilePath, true))) {
                writer.write(response);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception appropriately in your application
            }
            responsMessage = "Response sent successfully.";
        } else {
            System.out.println("Feedback with ID " + id + " not found.");
        }
    }

    public void viewFeedback() {
        String filePath = "C:\\Users\\THINKPAD\\git\\Softwar_proj\\alternativeSweet\\files\\feedback.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
    }

    public void deleteFeedback(String id) {
        String filePath = "C:\\Users\\THINKPAD\\git\\Softwar_proj\\alternativeSweet\\files\\feedback.txt";
        List<String> feedbacks = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line to get the id
                String[] parts = line.split(":");
                if (parts.length > 1 && !parts[0].equals(id)) {
                    feedbacks.add(line); // Add the line to the list if it should not be deleted
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String feedback : feedbacks) {
                writer.write(feedback);
                writer.newLine();
            }
            feedbackDeleteMessage = "Feedback deleted successfully.";
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
    }

    public void printMessages(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
