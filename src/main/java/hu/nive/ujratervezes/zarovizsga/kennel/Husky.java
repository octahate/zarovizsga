package hu.nive.ujratervezes.zarovizsga.kennel;

public class Husky extends Dog{

    protected Husky(String name) {
        super(name);
    }

    @Override
    void feed() {
        happiness+=4;
    }

    @Override
    void play(int hours) {
        happiness+=hours*3;
    }
}
