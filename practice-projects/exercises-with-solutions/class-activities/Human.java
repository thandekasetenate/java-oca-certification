public class Human{
int x;

public static void main(String[] args){
List<Animal> animals = Arrays.asList(
new Animal("fish", false, true),
new Animal("kangaroo", true, false)
);
animals.forEach(a-> System.out.println(a + " can hop? " +((Predicate<Animal>) animal ->animal.canHop()).test(a)));
} 
 class Animal{
private String type;
private Boolean hop;
private Boolean dance;

public Animal(String type, Boolean hop, Boolean dance){
this.type = type;
this.hop = hop;
this.dance = dance;
}

public String getType(){
return type;
}
public boolean getHop(){
return hop;
}
public boolean getDance(){
return dance;
}

}