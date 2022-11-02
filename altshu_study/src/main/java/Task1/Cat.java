package Task1;

public class Cat implements Animal{
    String name;

    public Cat(String animalName) {
        this.name = animalName;
    }

    @Override
    public void tellMeWhoYouAre() {
        System.out.print(this.name + " " + this.getClass().getSimpleName() + " ");
    }
}
