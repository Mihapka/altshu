package Task2;

public abstract class Animal {

    private AnimalType type;
    private String name;
    private int age;

     enum AnimalType {
        cow,
        cat,
        dog,
         snake
    }

    public AnimalType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    abstract void tellMeWhoYouAre();
}
