package org.example.Task7;

import org.example.Task7.Keyboards.KeysOrchestra;
import org.example.Task7.Strings.StringOrchestra;

public class Main {
    public static void main(String[] args) {
        KeysOrchestra keysOrchestra = new KeysOrchestra();
        StringOrchestra stringOrchestra = new StringOrchestra();
        System.out.println("Keyboards perform:");
        keysOrchestra.playYourParts();
        System.out.println("\nStrings perform:");
        stringOrchestra.playYourParts();
    }
}
