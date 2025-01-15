package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    // Wrapper class for XML
    static class EventListWrapper {
        private List<Fallakten> fallaktens;

        public List<Fallakten> getFallaktens() {
            return fallaktens;
        }

        public void setFallaktens(List<Fallakten> fallaktens) {
            this.fallaktens = fallaktens;
        }
    }

    // Read XML
    public static List<Fallakten> readXml(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(EventListWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        EventListWrapper wrapper = (EventListWrapper) unmarshaller.unmarshal(new File(filePath));
        return wrapper.getFallaktens();
    }

    // Display unique members whose name starts with the given letter
    public static void displayMembersStartingWith(List<Fallakten> events, char letter) {
        Set<String> members = events.stream()
                .map(Fallakten::getName)
                .filter(name -> name.charAt(0) == letter)
                .collect(Collectors.toSet());

        members.forEach(System.out::println);
    }

    public static void displaySymptomFieber(List<Fallakten> fallakten) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fallakten.stream()
                .filter(event -> event.getSymptom().equals("Fieber"))
                .sorted(Comparator.comparing(event -> {
                    try {
                        return sdf.parse(event.getDate());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }))
                .forEach(event -> System.out.println(event.getDate() + ": " + event.getName() + " - " + event.getSymptom()));
    }

    public static void main(String[] args) throws JAXBException {

        Scanner scanner = new Scanner(System.in);
        List<Fallakten> fallakten = new ArrayList<>();
        try {
            fallakten = readXml("C:\\Users\\tudor\\Desktop\\proiect retele\\server\\IvanceaTudor722Aufgabe1\\aufg1\\src\\main\\java\\org\\example\\fallakten.xml");
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }

        System.out.print("Enter a capital letter to filter members: ");
        char letter = scanner.nextLine().charAt(0);
        displayMembersStartingWith(fallakten, letter);


    }
}