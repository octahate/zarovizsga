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

    public Dog findByName(String name){
        for (Dog currentDog: dog){
            if (currentDog.getName().equals(name)){
                return currentDog;
            }
        }
        throw new IllegalArgumentException("Nincs ilyen nevű kutya az adatbázisban!");
    }

    public void playWith(String name, int hours){
        findByName(name).play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness){
        List<String> happyDogs = new ArrayList<>();
        for (Dog currentDog: dog){
            if (currentDog.getHappiness() > minHappiness){
                happyDogs.add(currentDog.getName());
            }
        }
        return happyDogs;
    }

}
