/*

Name: Wyatt Haston
Lab#: 3
*/

import java.util.*;

public class Quiz {
    private List<Question> questions = new ArrayList<Question>();
    private boolean pass;

    public void addQuestion(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter question text:");
        String text = scan.nextLine();
        System.out.println("Enter question answer:");
        String answer = scan.nextLine();
        System.out.println("How difficult? (1-3)");
        int difficulty;
        do {
            difficulty = scan.nextInt();
            if (difficulty > 3 || difficulty <= 0) {
                System.out.println("Error must be between 1 to 3");
                pass = false;
            } else{
                pass = true;
            }
        }while(pass == false);
        questions.add(new Question(text, answer, difficulty));
    }

    public void removeQuestion(){
        Scanner scan = new Scanner(System.in);
        Object[] array = questions.toArray();
        if(array.length > 0){
            System.out.println("What Question to modify?:");
            for(int i = 0; i < array.length; i++){
                if(array.length > 0) {
                    System.out.println(i + ". " + questions.get(i).getText());
                }
            }
            int choice = scan.nextInt();
            questions.remove(choice);
        } else{
            System.out.println("No Questions Entered");
        }
    }

    public void modifyQuestion(){
        Scanner scan = new Scanner(System.in);
        Object[] array = questions.toArray();
        if(array.length > 0){
            System.out.println("What Question to remove?:");
            for(int i = 0; i < array.length; i++){
                if(array.length > 0) {
                    System.out.println(i + ". " + questions.get(i).getText());
                }
            }
            int choice = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter new text:");
            String text = scan.nextLine();
            questions.get(choice).setText(text);
            System.out.println("Enter new answer:");
            String answer = scan.nextLine();
            questions.get(choice).setAnswer(answer);
            System.out.println("Enter new difficulty:");
            int difficulty = scan.nextInt();
            questions.get(choice).setDifficulty(difficulty);
        }else{
            System.out.println("No Questions Entered");
        }
    }

    public void takeQuiz(){
        Scanner scan = new Scanner(System.in);
        Object[] array = questions.toArray();
        int correct = 0;
        for(int i = 0; i < array.length; i++){
            System.out.println(questions.get(i).getText());
            String answer = scan.nextLine();

            if(answer.toUpperCase().equals(questions.get(i).getAnswer().toUpperCase())){
                System.out.println("Correct!");
                correct++;
            }else{
                System.out.println("Incorrect");
            }
        }

        if(array.length > 0){
            System.out.println("You got " + correct + " out of " + array.length);
        }else{
            System.out.println("No Questions Entered");
        }
    }
}
