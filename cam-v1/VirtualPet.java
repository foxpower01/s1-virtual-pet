/* Virtual Pet, version 1
 * 
 * @author Cam
 * @author ?
 */

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VirtualPet {
    
    VirtualPetFace face;
    private int hunger = 0;   // how hungry the pet is.
    private int tiredness = 0;
    private String userName;
    public double solution;
    
    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
        face.setImage("normal");
    }

    public String genEquation() {
        Random rand = new Random();
        int m = rand.nextInt(1, 13);
        int a = rand.nextInt(1, 13);
        int b = rand.nextInt(1, 13);
        this.solution = (double) (b - a) / m;     
        return "Solve for x: " + m + "x + " + a + " = " + b;
    }

    private void pause(long milliseconds){
        try{
            Thread.sleep(milliseconds);
        }catch(Exception e){}
    }
    
    public void addMessageUser(String message){
        face.addMessage(this.userName + ": " + message);
    }

    public void addMessagePet(String message){
        face.addMessage(message);
    }

    public void setName(String name) {
        this.userName = name;
    }

    public void dead(){
        face.setImage("dead");
        pause(2000);
        face.setImage("skeleon");
    }

    public void happy(){
        face.setImage("joyful");
    }

    public void veryHappy(){
        face.setImage("ecstatic");
    }

    public void setMood(String mood){
        face.setImage(mood);
    }
    
    public void exercise() {
        hunger = hunger + 3;
        tiredness+=1;
        face.addMessage("1, 2, 3, jump.  Whew.");
        if (tiredness < 4){
            face.setImage("ecstatic");
        }
        if (tiredness > 3){
            face.setImage("tired");
        }
    }
    
    public void sleep() {
        hunger = hunger + 1;
        tiredness = 0;
        face.setImage("asleep");
    }

} // end Virtual Pet
