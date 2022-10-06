package org.example.Task6;

public interface Animal {
    default void tellHowAreYouMoving(){
        System.out.println("я не знаю кто я, но я двигаюсь.");
    };
}
