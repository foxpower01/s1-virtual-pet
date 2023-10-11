import java.util.*;
import java.util.Timer;

import javax.swing.*;

// Timer timer = new Timer();
//             timer.schedule(new TimerTask() {
//                 public void run() {
//                             //call whatever method
//                 }
//             }, 0, 5000);  

public class Runner {
    private static void pause(long milliseconds){
        try{
            Thread.sleep(milliseconds);
        }catch(Exception e){}
    }

    private static String getName() {
        return (String)JOptionPane.showInputDialog(new JFrame(), "Welcome to Mathletes 2023! What's your name?", "Welcome!", JOptionPane.PLAIN_MESSAGE);
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
        int result = JOptionPane.showOptionDialog(new JFrame(),
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
        



    }
}
