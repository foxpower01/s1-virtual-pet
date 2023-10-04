/* Virtual Pet, version 1
 * 
 * @author Cam
 * @author ?
 */
public class VirtualPet {
    
    VirtualPetFace face;
    private int hunger = 0;   // how hungry the pet is.
    private int tiredness = 0;
    
    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
        face.setImage("normal");
        face.setMessage("Hello.");
    }
    
    public void feed() {
        if (hunger > 10) {
            hunger = hunger - 10;
        } else {
            hunger = 0;
        }
        face.setMessage("Yum, thanks");
        face.setImage("normal");
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
