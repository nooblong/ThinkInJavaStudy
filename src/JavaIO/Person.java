package JavaIO;

import nu.xom.*;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Person {
    private String first, last;
    private String adress;
    public Person(String first, String last, String adress) {
        this.first = first;
        this.last = last;
        this.adress = adress;
    }

    public Element getXML(){
        Element person = new Element("person");

        Element firstName = new Element("first");
        firstName.appendChild(first);

        Element lastName = new Element("last");
        lastName.appendChild(last);

        Element ress = new Element("adress");
        ress.appendChild(adress);

        person.appendChild(firstName);
        person.appendChild(lastName);
        person.appendChild(ress);
        return person;
    }

    public Person(Element person){
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
        adress = person.getFirstChildElement("adress").getValue();
    }

    @Override
    public String toString() {
        return first + " " + last + " " + adress;
    }

    public static void format(OutputStream os, Document doc) throws Exception{
        Serializer serializer = new Serializer(os,"ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }

    public static void main(String[] args) throws Exception {
        List<Person> people = Arrays.asList(
                new Person("Dr.Wei", "Yuan", "100"),
                new Person("Dr.Nihong", "Bang", "101"),
                new Person("Dr.Li", "Yinlong", "102"));
        System.out.println(people);

        Element root = new Element("people");
        for (Person p : people)
            root.appendChild(p.getXML());
        Document doc = new Document(root);
        format(System.out, doc);
        format(new BufferedOutputStream(new FileOutputStream("People.xml")), doc);
//        FileWriter fw = new FileWriter("testPeople.xml");
//        fw.write(doc.toXML());
//        fw.flush();
    }
}
