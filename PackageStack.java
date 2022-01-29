/**
 * @author Sadikshya Sharma
 * SBU ID: 113305452
 * Recitation 3
 * This class is to create a stack of package
 */
import java.util.ArrayList;
public class PackageStack{
    private final int capacity = 7;
    private String shouldHaveCapacity;
    private int size = 0;
    private ArrayList<Package> stack = new ArrayList<>();

    /**
     * default constructor
     */
    public PackageStack(){}

    /**
     * constructor that makes it possible to see which one should have a
     * capacity and which should not
     * @param capPackages "7" means it should have the capacity of 7
     *                    otherwise the capacity is infinite
     */
    public PackageStack(String capPackages)
    {
        shouldHaveCapacity = capPackages;
    }

    /**
     * operates as the pop function of the stack
     * @returns the popped package
     */
    public Package pop()
    {
        size = size - 1;
        return stack.remove(stack.size()-1);
    }

    /**
     * operates as a push function of the stack adds the package onto the stack
     * @param newPackage
     */
    public void push(Package newPackage)
    {
        stack.add(newPackage);
        size = size + 1;
    }

    /**
     * operates as the peek function of the stack
     * @return the package all the way at the top of the stack
     */
    public Package peek()
    {
        return stack.get(stack.size()-1);
    }

    /**
     * @return the size of a given stack, the size is changed with push and
     * pop functions
     */
    public int getSize()
    {
        return size;
    }

    /**
     * checks if the stack is empty
     * @returns true if the stack size is 0 and false otherwise
     */
    public boolean isEmpty()
    {
        if(stack.size() == 0)
        {
            return true;
        }
        return false;
    }

    /**
     * checks if the stack is full for the stacks which have a capacity
     * @returns true when stack has 7 values if it is a stack which should
     * have a capacity (unlike the floor stack)
     */
    public boolean isFull()
    {
        if(shouldHaveCapacity.equals("7") && stack.size() == capacity )
        {
            return true;
        }
        return false;
    }

    /**
     * prints out the stack
     */
    public void print()
    {
        for( int i = 0; i < stack.size(); i++)
        {
            System.out.print("[ " + stack.get(i).getRecipient() + " " +
                    stack.get(i).getArrivalDate() + " ] ");
        }
    }
}
