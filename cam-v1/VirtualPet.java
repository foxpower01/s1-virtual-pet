/* Virtual Pet, version 1
 * 
 * @author Cam
 * @author ?
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VirtualPet {
    
    VirtualPetFace face;
    private int hunger = 0;   // how hungry the pet is.
    private int tiredness = 0;
    private String userName;
    
    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
        face.setImage("normal");
    }

    //getter and setter for age

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
