package array;

import exception.PBException;

public class ArrayCheck {

    public static void main(String[] args) {
        try {
         /*   array.PBArrayList<String> nameList = new array.PBArrayList<>();
            nameList.add("Hello");
            System.out.println("Size is " + nameList.size());
            System.out.println("Print value " + nameList.get(1));*/
            PBArrayList<String> nameList = new PBArrayList<>();
            nameList.add("Balaji");
            nameList.add("Proggy Blast");
            nameList.add("Welcome");
            nameList.add("DJ");
            nameList.add("VJ");
            nameList.add("RJ");
            nameList.add("Alia");
            nameList.add("Virat");
            System.out.println("Before set " + nameList.get(0));
            nameList.set(0, "Balaji-SBB");
            System.out.println("After set " + nameList.get(0));

            System.out.println("Before Insert " + nameList.toString());
            nameList.insert(2, "Hello Balaji");
            System.out.println("After Insert " + nameList.toString());

            System.out.println("Before Delete" + nameList.toString());
            nameList.delete(1);
            System.out.println("After Delete" + nameList.toString());

        } catch (PBException e) {
            System.out.println(e.getMessage());
        }
    }
}
