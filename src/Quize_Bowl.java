import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Quize_Bowl {
    private Player player;
    private ArrayList<Question> questions;
    private Scanner inputScanner;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Quize_Bowl() {
        this.questions = new ArrayList<>();
        this.inputScanner = new Scanner(System.in);
    }

    public void readQuestions(String filePath) {
        File file = new File(filePath);

        try (Scanner fileScanner = new Scanner(file)) {
            int totalQuestions = Integer.parseInt(fileScanner.nextLine());

            for (int i=0; i<totalQuestions; i++) {
                if (!fileScanner.hasNextLine()) {
                    System.err.println("Warning: File ended unexpectedly. Expected " + totalQuestions + " questions.");
                    break;
                }

                String[] typeAndPoints = fileScanner.nextLine().split(" ");
                System.err.print(typeAndPoints);
                String type = typeAndPoints[0].toUpperCase();
                int points = Integer.parseInt(typeAndPoints[1]);
                
                String questionText = fileScanner.nextLine();

                switch (type) {
                	case "MC": {
                		int numChoices = Integer.parseInt(fileScanner.nextLine());
                		String[] choices = new String[numChoices];
                		
                		for (int j = 0; j < numChoices; j++) {
                            choices[j] = fileScanner.nextLine();
                        }
                		String answerLetter = fileScanner.nextLine();
                		this.questions.add(new QuestionMC(questionText, points, answerLetter, choices));
                		break;
                	}
                	
                	case "TF": {
                        String answer = questionText.split(":")[1];
                        String question = questionText.split(":")[0];
                        
                        boolean answer_bool = Boolean.parseBoolean(answer);
                        this.questions.add(new QuestionTF(question, points, answer_bool));
                        break;
                	}
                	
                	case "SA": {
                		String answer = fileScanner.nextLine();
                        this.questions.add(new QuestionSA(questionText, points, answer));
                        break;
                	}
                	
                	 default:
                         System.err.println("Warning: Skipping unknown question type '" + type + "' in file.");
                         if(fileScanner.hasNextLine()) 
                        	 fileScanner.nextLine();
                         break;
                }
                
            }

        }  catch (FileNotFoundException e) {
            System.err.println("Error: The file was not found at " + filePath);
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error: File format is incorrect. Expected a number but found text.");
            e.printStackTrace();
        }
    }

    public void setup() {
        System.out.print("What is your first name?\n");
        String firstName = inputScanner.nextLine();
        System.out.print("What is your last name?\n");
        String lastName = inputScanner.nextLine();
        this.setPlayer(new Player(firstName, lastName));

        while (true) {
            try {
                System.out.print("What file stores your questions?\n");
                String filename = inputScanner.nextLine();
                readQuestions(filename);
                if (!questions.isEmpty()) {
                    break;
                } else {
                    System.out.println("No questions were loaded from that file. Please try a different file.");
                }
            } catch (Exception e) {
                 System.out.println("Could not read file. Please check the name and try again.");
            }
        }
    }

    private int getNumberOfQuestionsToAsk() {
        int maxQuestions = questions.size();
        
        while (true) {
            System.out.print("\nHow many questions would you like (out of " + maxQuestions + ")?\n");
            String line = inputScanner.nextLine();
            try {
                int num = Integer.parseInt(line);
                if (num > 0 && num <= maxQuestions) {
                    return num;
                } else {
                    System.out.println("Sorry, that is too many.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Sorry, that is not valid.");
            }
        }
	}

    public void play() {
		if (questions.isEmpty()) {
			System.out.println("There are no Questions.");
		}
		
		int questionsToPlay = this.getNumberOfQuestionsToAsk();
		
		Collections.shuffle(questions);
		
		for (int i=0; i<questionsToPlay; i++) {
			Question currentQuestion = questions.get(i);
			int questionPoints = currentQuestion.getPoints();
			
			System.out.println("\nPoints: " + currentQuestion.getPoints());
            System.out.println(currentQuestion);
            String userAnswer = inputScanner.nextLine();
            
            if (userAnswer.equalsIgnoreCase("SKIP")) {
                System.out.println("\nYou have selected to skip that question.");
                continue;
            }
            
            if (currentQuestion.isCorrect(userAnswer)) {
            	this.player.updateScore(questionPoints);
            	System.out.println("\nCorrect" + questionPoints + " points.");
            } else {
                this.player.updateScore(-questionPoints);
                System.out.println("\nIncorrect, the answer was " + currentQuestion.getAnswer() + ". You lose " + questionPoints + " points.");
            }
		}
	}
	
	public void end() {
        System.out.println("\n" + player.getFullName() + ", your game is over!");
        System.out.println("You final score is " + player.getScore() + " points.");
        if (player.getScore() <= 0) {
            System.out.println("Better luck next time!");
        } else {
            System.out.println("Congratulations!");
        }
        inputScanner.close();
    }

    public static void main(String[] args) {
		Quize_Bowl game = new Quize_Bowl();
		game.setup();
        game.play();
        game.end();
	}
}
