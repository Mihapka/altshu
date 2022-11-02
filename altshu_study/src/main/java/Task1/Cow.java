package Task1;

public class Cow implements Animal{
    String name;

    public Cow(String animalName) {
        this.name = animalName;
    }


    @Override
    public void tellMeWhoYouAre() {
        System.out.print(this.name + " " + this.getClass().getSimpleName() + " ");
    }
}
