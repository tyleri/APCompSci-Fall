public class Human extends Character{

    public Human(String n){
	super(n);
	hp += 10;
	atk--;
	def += 2;
    }
}
