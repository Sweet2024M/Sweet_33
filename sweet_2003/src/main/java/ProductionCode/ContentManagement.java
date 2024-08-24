package ProductionCode;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ContentManagement {

    private static final String BASE_PATH = "files"; // Use relative path
    private static final String RECIPES_FILE_PATH = Paths.get(BASE_PATH, "recipes.txt").toString();
    private static final String FEEDBACK_FILE_PATH = Paths.get(BASE_PATH, "feedback.txt").toString();
    private static final String RESPONSE_FILE_PATH = Paths.get(BASE_PATH, "responseFeedback.txt").toString();

    private static final String RECIPE_DELETED_MESSAGE = "Recipe deleted successfully.";
    private static final String RESPONSE_SENT_MESSAGE = "Response sent successfully.";
    private static final String FEEDBACK_DELETED_MESSAGE = "Feedback deleted successfully.";

   private void printFileContent(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        	String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            handleException(e, "Error reading file: " + filePath);
        }
    }
     
    public void printContent() {
    	printFileContent(RECIPES_FILE_PATH);
    }
    
    private List<String> readFileLines(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            handleException(e, "Error reading file lines: " + filePath);
        }
        return lines;
    }

    private void writeFile(String filePath, List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            handleException(e, "Error writing to file: " + filePath);
        }
    }

    private void appendToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            handleException(e, "Error appending to file: " + filePath);
        }
    }

    private String findUsernameById(String id, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines()
                .filter(line -> line.startsWith(id + ":"))
                .map(line -> line.split(":")[1])
                .findFirst()
                .orElse(null);
        } catch (IOException e) {
            handleException(e, "Error finding username by ID in file: " + filePath);
        }
        return null;
        
    }

    private void handleException(IOException e, String message) {
        // Log the error and notify the user
        System.err.println(message);
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, message);
    }

    public List<String> viewRecipes() {
       return readFileLines(RECIPES_FILE_PATH);
    }

    public void deleteRecipes(String product) {
        List<String> recipes = readFileLines(RECIPES_FILE_PATH);
        recipes.removeIf(line -> line.startsWith(product + ":"));
        writeFile(RECIPES_FILE_PATH, recipes);
        printMessages(RECIPE_DELETED_MESSAGE);
    }

    public void responseFeedback(String id, String responseMessage) {
        String username = findUsernameById(id, FEEDBACK_FILE_PATH);
        String response = "Response to " + username + ": " + responseMessage;
        appendToFile(RESPONSE_FILE_PATH, response);
        printMessages(RESPONSE_SENT_MESSAGE);
    }

    public List<String> viewFeedback() {
        return readFileLines(FEEDBACK_FILE_PATH);
    }

    public void deleteFeedback(String id) {
        List<String> feedbacks = readFileLines(FEEDBACK_FILE_PATH);
        feedbacks.removeIf(line -> line.startsWith(id + ":"));
        writeFile(FEEDBACK_FILE_PATH, feedbacks);
        printMessages(FEEDBACK_DELETED_MESSAGE);
    }

    public void printMessages(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

	public int countRecipes() {
		List<String> recipes = readFileLines(RECIPES_FILE_PATH);
		return recipes.size();
	}
}