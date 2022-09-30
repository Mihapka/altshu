package org.example.Task7.Keyboards;

public class KeysOrchestra {
    Harpsichord harpsichord;
    Organ organ;
    Piano piano;

    public KeysOrchestra() {
        organ = new Organ();
        piano = new Piano();
        harpsichord = new Harpsichord();
    }

    public void playYourParts() {
        organ.playKeys();
        piano.playKeys();
        harpsichord.playKeys();
    }
}
