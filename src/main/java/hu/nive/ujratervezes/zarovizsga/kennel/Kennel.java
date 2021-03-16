package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    private List<Dog> dog = new ArrayList<>();

    public List<Dog> getDogs() {
        return dog;
    }

    public void addDog(Dog dog){
        Kennel.this.dog.add(dog);
    }

    public void feedAll(){
        for (Dog currentDog: dog){
            currentDog.feed();
        }
    }

}
