package linkedlist;

import exception.PBException;

import java.util.concurrent.TimeUnit;

public class LinkedListCheck {

    public static void main(String[] args) {
        PBLinkedList<String> nameList = new PBLinkedList<>();
        /*nameList.addToFront("Tech");
        nameList.addToFront("Balaji");
        nameList.addToFront("Billionire");*/

        long startTime = System.nanoTime();
        /*nameList.addToFront("Balaji");
        nameList.addToFront("Tech");
        *//*nameList.addToLast("Billionire 1");
        nameList.addToLast("Billionire 2");
        nameList.addToLast("Billionire 3");*//*
        nameList.insertLast("Billionire 1");
        nameList.insertLast("Billionire 2");
        nameList.insertLast("Billionire 3");*/

        nameList.insertLast("Billionire 1");
        nameList.insertLast("Billionire 2");
        nameList.insertLast("Billionire 3");
        nameList.insertLast("Billionire 4");
        //nameList.clearItems();
        nameList.removeElement("Billionire 4");

        try {
            nameList.getFirst();
            nameList.getTail();
            nameList.printAll();
            System.out.println("List size is " + nameList.getSize());
        } catch (PBException e) {
            System.out.println(e.getMessage());
        }
        long endTime = System.nanoTime();
        long buildTime = endTime - startTime;
//        long buildTimeInSec = TimeUnit.SECONDS.toMillis(buildTime);
        System.out.println("Build Executed in " + buildTime + " nano seconds");





    }


}
