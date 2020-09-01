package stack;

public class PBStackCheck {

    public static void main(String[] args) {

        PBStack<Character> rollNumber = new PBStack<>();
        rollNumber.push('I');
        rollNumber.push('J');
        rollNumber.push('A');
        rollNumber.push('L');
        rollNumber.push('A');
        rollNumber.push('B');
        rollNumber.pop();
        rollNumber.pop();

        System.out.println(rollNumber.printStack());
    }
}
