package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {

    protected Beagle(String name) {
        super(name);
    }

    @Override
    void feed() {
        happiness+=2;
    }

    @Override
    void play(int hours) {
        happiness+=hours*2;
    }
}
