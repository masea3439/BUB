package aplace;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeString.indexOf;
import static jdk.nashorn.internal.objects.NativeString.indexOf;

public class APlace {

    public static void main(String[] args) throws MalformedURLException, IOException {
        String htmlText = "0";
        URLConnection connection;
        connection = new URL("http://foodfacts.mercola.com/grapefruit.html").openConnection();
        Scanner kb = new Scanner(connection.getInputStream());
        kb.useDelimiter("\\Z");
        htmlText = kb.next();
        System.out.println(htmlText);
        System.out.println("ACTIVATE MANGO");
        titleFind(htmlText);
        bodyFind(htmlText);
        headerFind(htmlText);

    }

    //This gets the paragraphs
    public static void titleFind(String htmlText) {
        int indexOfStart = indexOf(htmlText, "<title>") + 7;
        int indexOfEnd = indexOf(htmlText, "</title>");
        System.out.println("Title: " + htmlText.substring(indexOfStart, indexOfEnd));
    }

    public static void bodyFind(String htmlText) {
        String htmlTextRemain = htmlText;
        int indexOfStart = 0;
        int indexOfEnd = 0;
        ArrayList<paragraph> paragraphs = new ArrayList<paragraph>();
        while (htmlTextRemain.contains("<p>")) {
            indexOfStart = indexOf(htmlTextRemain, "<p>") + 3;
            indexOfEnd = indexOf(htmlTextRemain, "</p>");
            //If statement to catch errors                
            if (indexOfStart < indexOfEnd) {
                paragraphs.add( new paragraph (htmlTextRemain.substring(indexOfStart, indexOfEnd) + "\n", htmlText));
            }
            htmlTextRemain = htmlTextRemain.substring(indexOfEnd + 4, htmlTextRemain.length());
        }
    }

    public static void headerFind(String htmlText) {

    }
}
