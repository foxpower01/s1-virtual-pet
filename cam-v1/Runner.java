import java.util.*;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.*;

// Timer timer = new Timer();
//             timer.schedule(new TimerTask() {
//                 public void run() {
//                             //call whatever method
//                 }
//             }, 0, 5000); 

class InputThread extends Thread {

}

public class Runner {
    private static void pause(long milliseconds){
        try{
            Thread.sleep(milliseconds);
        }catch(Exception e){}
    }

    private static String getName() {
        return JOptionPane.showInputDialog(new JFrame(), "Welcome to Mathletes 2023! What's your name?", "Welcome!", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        VirtualPet p = new VirtualPet();
        p.addMessagePet("Welcome to Mathletes 2023! What's your name?");
        String name = getName();
        p.setName(name);
        p.addMessagePet("Nice to meet you, " + name + "!");
        pause(2000);
        p.addMessagePet("Are you ready for some mathing?");
        String[] options = {"Yes", "No"};
        int result = JOptionPane.showOptionDialog(p.face,
            "Are you ready for some mathing?",
            "Ready?",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);
        p.addMessageUser(options[result]);
        pause(1000);
        if (result == 1) {
            p.addMessagePet("Too bad!");
            pause(1000);
        }
        p.addMessagePet("Let's begin!");
        int score = 0;

        for (int i=0; i < 15; i++) {
            String equation = p.genEquation();
            p.addMessagePet("Here's your problem!\n" + equation);
            AtomicInteger secondsElapsed = new AtomicInteger(0);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    secondsElapsed.incrementAndGet();
                }
            }, 0, 1000);
            while (true){
                double userInput;
                try {
                    userInput = Double.parseDouble(JOptionPane.showInputDialog(new JFrame(),
                        "Type your answer to the equation (as a decimal)", "Problem " + (i+1) + " of 15. Equation: " + equation.substring(13), JOptionPane.PLAIN_MESSAGE
                    ));
                } catch (Exception e) {
                    p.addMessagePet("Bad formatting!");
                    i--;
                    break;
                };
                if (secondsElapsed.get() < (20 - score)){
                    System.out.println(Math.abs(userInput - p.solution));
                    if (Math.abs(userInput - p.solution) <= 0.1){
                        p.addMessagePet("That's correct!");
                        score++;
                        break;
                    }else{
                        p.addMessagePet("That's not quite right. You have " + (20 - score - secondsElapsed.get()) + " seconds left to try again.");
                    }
                }else{
                    p.addMessagePet("You took too long. :( The solution was x = " + p.solution);
                    break;
                }
            }
        }
        
        if (score >= 16){
            p.veryHappy();
        }else if (score >= 10){
            p.happy();
        }else if (score >= 5){
            p.setMood("annoyed");
        }else {
            p.setMood("angry");
        }
        p.addMessagePet("Your score was " + score + " out of 15!");

    }
}
