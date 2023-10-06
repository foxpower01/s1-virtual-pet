import java.util.*;
import java.util.Timer;

import javax.swing.*;

public class Runner {
    public Runner(){
        VirtualPet p = new VirtualPet();
        p.exercise();

        Timer timer = new Timer();
            ((Object) timer).schedule(new TimerTask() {
                public void run() {
                            //call whatever method
                }
            }, 0, 5000);


    }

    public void ageIncrease(VirtualPet p){
        
    }

    public String getResponse(String q){
        String s = (String)JOptionPane.showInputDialog(new JFrame(), q, "Get a response", JOptionPane.PLAIN_MESSAGE);
        return s;
    }

    private void pause(long milliseconds){
        try{
            Thread.sleep(milliseconds);
        }catch(Exception e){}
    }

    public static void main(String[] args) {
        new Runner();
    }
}
