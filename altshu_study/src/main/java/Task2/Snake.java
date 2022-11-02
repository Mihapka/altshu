package Task2;

public class Snake extends Animal {
    private AnimalType type;
    private String name;
    private int age;

    public Snake(AnimalType type, String name, int age) {
        this.type = type;
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public AnimalType getType() {
        return type;
    }

    @Override
    public void tellMeWhoYouAre() {
        System.out.println(this.getType() + " " + this.getAge() + " " + this.getName());
    }
}
