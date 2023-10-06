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
    private int age = 0;
    
    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
        face.setImage("normal");
        face.setMessage("Hello.");
    }

    //getter and setter for age

    private void pause(long milliseconds){
        try{
            Thread.sleep(milliseconds);
        }catch(Exception e){}
    }
    
    public void feed() {
        if (hunger > 10) {
            hunger = hunger - 10;
        } else {
            hunger = 0;
        }
        if ((int)(Math.random() * 10) == 9){
            face.setMessage("Your pet is sick!");
            face.setImage("sick");
        }
        face.setMessage("Yum, thanks");
        face.setImage("normal");
    }

    public void handleSick(){
        String s = (String)JOptionPane.showInputDialog(new JFrame(), "Do you want to take your pet to the vet?", "Get a response", JOptionPane.PLAIN_MESSAGE);
        if (s.indexOf("yes") > -1 || s.indexOf("Yes") > -1){
            goToVet();
        }else{
            face.setImage("sleep");
            pause(3000);
            if ((int)(Math.random() * 3) == 3){
                face.setMessage("Your pet got better on its own!");
                face.setImage("normal");
            }else{
                face.setMessage("Your pet doesn't feel so good...");
                pause(2000);
                dead();
            }
        }
    }

    private void goToVet(){

    }

    public void dead(){
        face.setImage("dead");
        pause(2000);
        face.setImage("skeleon");
    }
    
    public void exercise() {
        hunger = hunger + 3;
        tiredness+=1;
        face.setMessage("1, 2, 3, jump.  Whew.");
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
