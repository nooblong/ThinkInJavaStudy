package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = Main.class.getClassLoader().getResource("jsoup/student.xml").getPath();

        Document document = Jsoup.parse(new File(path),"utf-8");

        Elements elements = document.getElementsByTag("name");

        Element element = elements.get(0);
        System.out.println(element.text());
    }
}
