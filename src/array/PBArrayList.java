package array;


import exception.PBException;

public class PBArrayList<T> {

    private int initialCapacity = 0;
    private int size = 0;
    private T[] array;

    /**
     * Declare initial constructor
     */

    PBArrayList() {
        //noinspection unchecked
        array = (T[]) new Object[0];
    }

    /**
     * get item based on position
     *
     * @param position
     * @return
     * @throws PBException
     */

    public T get(int position) throws PBException {
        try {
            return (T) this.array[position];
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new PBException("Search Element is greater than array size");
        }
    }

    /**
     * To set the value on particular position
     *
     * @param position
     * @param t
     * @throws PBException
     */

    public void set(int position, T t) throws PBException {
        try {
            array[position] = t;
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new PBException("Failed to set the value");
        }
    }

    /**
     * To check if the list is empty
     */

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * To check if the list is not empty
     */

    public boolean isNotEmpty() {
        return size > 0;
    }

    /**
     * To get current list size
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * To add item at the end of list
     *
     * @param t
     * @throws PBException
     */

    public void add(T t) throws PBException {
        try {
            if (size == initialCapacity) {
                resize();
            }
            array[size] = t;
            size++;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            throw new PBException("Failed to Add");
        }
    }

    /**
     * To insert data on specified index
     *
     * @param index
     * @param t
     */

    public void insert(int index, T t) {
        if (size == initialCapacity) {
            resize();
        }
        for (int j = size; j > index; j--) {
            array[j] = array[j - 1];
        }
        array[index] = t;
        size++;
    }

    /**
     * To delete on specified index
     *
     * @param index
     */

    public void delete(int index) {
        // to assign items upto less than one place to avoid assigning null and prevent one more iteration
        for (int j = index; j < size - 1; j++) {
            array[j] = array[j + 1];
        }
        //reduce the size after only the successful iteration of the reassigning values to array.
        size--;
        resize();
    }

    // TODO:add it into util class
    public String displayItems() {
        StringBuilder builder = new StringBuilder();
        if (array.length == 0) {
            builder.append("[]");
        } else if (array.length > 0) {
            builder.append('[');
            for (int i = 0; i < array.length; i++) {
                builder.append(array[i]);
                if (i < array.length - 1) builder.append(',');
            }
            builder.append(']');
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return "array.PBArrayList{" +
                "initialCapacity=" + initialCapacity +
                ", size=" + size +
                ", array=" + displayItems() +
                '}';
    }

    /**
     * To resize the array based on user input
     */

    private void resize() {
        calculateInitialCapacity();
        Object[] newArray = new Object[initialCapacity];
        for (int i = 0; i < array.length; i++) {
            if (i == initialCapacity) break;
            newArray[i] = array[i];
        }
        System.out.println("Inside resize " + newArray.length);
        array = (T[]) newArray;
    }

    private void calculateInitialCapacity() {
        if (initialCapacity > 0 && initialCapacity / 2 == size) {
            initialCapacity = initialCapacity / 2;
        } else if (initialCapacity == 0) {
            initialCapacity = 1;
        } else if (initialCapacity > 0 && initialCapacity == size) {
            initialCapacity = initialCapacity * 2;
        }

    }

    /*public static void main(String[] args) throws Exception {
        array.PBArrayList<String> nameList = new array.PBArrayList();
        nameList.add("Balaji");
        nameList.add("Proggy Blast");
        nameList.add("Welcome");
        nameList.add("Welcome 1");
        nameList.add("Welcome 2");
        nameList.add("Welcome 3");
        nameList.add("Welcome 4");
        nameList.add("Welcome 5");

        String name = nameList.get(0) + nameList.get(1);
        System.out.println(name);

    }*/

}
