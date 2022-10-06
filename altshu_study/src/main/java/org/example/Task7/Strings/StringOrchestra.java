package org.example.Task7.Strings;

public class StringOrchestra {
    Bass bass;
    Cello cello;
    Guitar guitar;
    Violin violin;

    public StringOrchestra() {
        bass = new Bass();
        cello = new Cello();
        guitar = new Guitar();
        violin = new Violin();
    }

    public void playYourParts() {
        bass.playStrings();
        cello.playStrings();
        guitar.playStrings();
        violin.playStrings();
    }
}
