package Task1;

public class Dog implements Animal{
    String name;

    public Dog(String animalName) {
        this.name = animalName;
    }

    @Override
    public void tellMeWhoYouAre() {
        System.out.print(this.name + " " + this.getClass().getSimpleName() + " ");
    }
}
