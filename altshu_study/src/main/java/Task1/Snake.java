package Task1;

public class Snake implements Animal{
    String name;

    public Snake(String animalName) {
        this.name = animalName;
    }

    @Override
    public void tellMeWhoYouAre() {
        System.out.print(this.name + " " + this.getClass().getSimpleName() + " ");
    }
}
