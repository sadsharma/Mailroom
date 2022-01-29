/**
 * @author Sadikshya Sharma
 * SBU ID: 113305452
 * Recitation 3
 * Mail room manager class that runs the system, methods for each option in
 * the menu.
 */
import java.util.*;
public class MailRoomManager extends PackageStack {
    private static PackageStack stack1 = new PackageStack("7");
    private static PackageStack stack2 = new PackageStack("7");
    private static PackageStack stack3 = new PackageStack("7");
    private static PackageStack stack4 = new PackageStack("7");
    private static PackageStack stack5 = new PackageStack("7");
    /*stack one through five "7" is used to show that the these should have
    the capacity of 7*/
    private static PackageStack floorStack = new PackageStack("infinite");
    //floor stack "infinite" means infinite capacity
    private static int arrivalDate ;
    private static boolean continueSystem = true;
    // to end the system
    private static Scanner input = new Scanner(System.in);
    /**
     * main menu prints menu options and calls the method based on the the
     * option chosen by the user.
     */
    public static void main(String[] args) {
        printMenu();
        while (continueSystem) {
            System.out.println("                                       ");
            System.out.println("Please select an option: ");
            String optionChosen = input.nextLine().toLowerCase();
            if (optionChosen.equals("d")) {
                deliverPackage();
            } else if (optionChosen.equals("g")) {
                getPackage();
            } else if (optionChosen.equals("t")) {
                makeItTomorrow();
            } else if (optionChosen.equals("p")) {
                printStacks();
            } else if (optionChosen.equals("m")) {
                movePackage();
            } else if (optionChosen.equals("f")) {
                findPackages();
            } else if (optionChosen.equals("l")) {
                listAllPackages();
            } else if (optionChosen.equals("e")) {
                emptyTheFloor();
            } else if (optionChosen.equals("x")) {
                printMenu();
            } else if (optionChosen.equals("q")) {
                quit();
            } else {
                System.out.println("That is not a valid menu option!");
                System.out.println("To refer back to the menu, enter option 'X'!");
            }
            System.out.println("                                       ");
        }
    }
    /**
     * prints the menu in the beginning and when option x is chosen.
     */
    public static void printMenu() {
        System.out.println("Menu: ");
        System.out.println("D - Deliver Package");
        System.out.println("G - Get Packages for a user - gets the topmost " +
                "package for a user");
        System.out.println("T - Make it tomorrow");
        System.out.println("P - print the stacks");
        System.out.println("M - move a package from one stack to another");
        System.out.println("F - Find packages in the wrong stack and move to " +
                "Floor");
        System.out.println("L - List all the packages awaiting a user");
        System.out.println("E - Empty the floor, moving all packages to the " +
                "trash.");
        System.out.println("Q - Quit");
        System.out.println("X - Print Menu");
    }

    /**
     * delivers a package to the mail room, it is set in one of the stacks
     * ready for pick up
     */
    public static void deliverPackage() {

        System.out.println("Please enter the recipient's name: ");
        String recipientName = input.nextLine();
        System.out.println("Please enter the weight of the package(lbs): ");
        double weight = input.nextDouble();
        if(weight <= 0)
        {
            System.out.println("That is not a valid weight for a package, a " +
                    "package has to be over 0 pounds!");
            System.out.println("Try again: ");
            weight = input.nextDouble();
        }
        input.nextLine();
        Package newPackage = new Package(recipientName, arrivalDate, weight);
        if (recipientName.toLowerCase().charAt(0) >= 'a' &&
                recipientName.toLowerCase().charAt(0) <= 'g') {
            if (stack1.isFull()) {
                if (!stack2.isFull()) {
                    stack2.push(newPackage);
                } else if (!stack3.isFull()) {
                    stack3.push(newPackage);
                } else if (!stack4.isFull()) {
                    stack4.push(newPackage);
                } else if (!stack5.isFull()) {
                    stack5.push(newPackage);
                } else {
                    floorStack.push(newPackage);
                }
            } else {
                stack1.push(newPackage);
            }
        } else if (recipientName.toLowerCase().charAt(0) >= 'h' &&
                recipientName.toLowerCase().charAt(0) <= 'j') {
            if (stack2.isFull()) {
                if (!stack1.isFull()) {
                    stack1.push(newPackage);
                } else if (!stack3.isFull()) {
                    stack3.push(newPackage);
                } else if (!stack4.isFull()) {
                    stack4.push(newPackage);
                } else if (!stack5.isFull()) {
                    stack5.push(newPackage);
                } else {
                    floorStack.push(newPackage);
                }
            } else {
                stack2.push(newPackage);
            }
        } else if (recipientName.toLowerCase().charAt(0) >= 'k' &&
                recipientName.toLowerCase().charAt(0) <= 'm') {
            if (stack3.isFull()) {
                if (!stack1.isFull()) {
                    stack1.push(newPackage);
                } else if (!stack2.isFull()) {
                    stack2.push(newPackage);
                } else if (!stack4.isFull()) {
                    stack4.push(newPackage);
                } else if (!stack5.isFull()) {
                    stack5.push(newPackage);
                } else {
                    floorStack.push(newPackage);
                }
            } else {
                stack3.push(newPackage);
            }
        } else if (recipientName.toLowerCase().charAt(0) >= 'n' &&
                recipientName.toLowerCase().charAt(0) <= 'r') {
            if (stack4.isFull()) {
                if (!stack1.isFull()) {
                    stack1.push(newPackage);
                } else if (!stack2.isFull()) {
                    stack2.push(newPackage);
                } else if (!stack3.isFull()) {
                    stack3.push(newPackage);
                } else if (!stack5.isFull()) {
                    stack5.push(newPackage);
                } else {
                    floorStack.push(newPackage);
                }
            } else {
                stack4.push(newPackage);
            }
        } else if (recipientName.toLowerCase().charAt(0) >= 's' &&
                recipientName.toLowerCase().charAt(0) <= 'z') {
            if (stack5.isFull()) {
                if (!stack1.isFull()) {
                    stack1.push(newPackage);
                } else if (!stack2.isFull()) {
                    stack2.push(newPackage);
                } else if (!stack3.isFull()) {
                    stack3.push(newPackage);
                } else if (!stack4.isFull()) {
                    stack4.push(newPackage);
                } else {
                    floorStack.push(newPackage);
                }
            } else {
                stack5.push(newPackage);
            }
        } else {
            System.out.println("That is not a valid name!");
        }
        System.out.println("A " + newPackage.getWeight() + " lbs package " +
                "is waiting for " + newPackage.getRecipient());
    }
    /**
     * gets the top most package for a user, if there is three in a stack for
     * one person it will get the one that is the highest in the stack.
     * I put all the stacks in an array and looped through the array, each
     * loop calls the getPackageSubset method which I created which actually
     * gets the package, this method figures out which stack should the
     * package be gotten from and then checks the other stacks if that stack
     * does not have a package for that person.
     */
    public static void getPackage()
    {
        PackageStack[] stacks = new PackageStack[7];
        stacks[0] = stack1; stacks[1] = stack2; stacks[2] = stack3;
        stacks[3] = stack4; stacks[4] = stack5; stacks[5] = floorStack;
        stacks[6] = null;
        System.out.println("Enter the recipient's name: ");
        String name = input.nextLine();
        Package poppedPackage = null;
        if (name.charAt(0) >= 'a' && name.charAt(0) <= 'g')
        {
            stacks[6] = stacks[0];
        } else if (name.charAt(0) >= 'h' && name.charAt(0) <= 'j') {
            stacks[6] = stacks[1];
        } else if (name.charAt(0) >= 'k' && name.charAt(0) <= 'm')
        {
            stacks[6] = stacks[2];
        } else if (name.charAt(0) >= 'n' && name.charAt(0) <= 'r') {
            stacks[6] = stacks[3];
        } else if (name.charAt(0) >= 's' && name.charAt(0) <= 'z') {
            stacks[6] = stacks[4];
        } else {
            stacks[6] = stacks[5];
        }
        poppedPackage = getPackageSubset(stacks[6], name);
        if(poppedPackage == null)
        {
            poppedPackage = getPackageSubset(stack1, name);
            if(poppedPackage == null)
            {
                poppedPackage = getPackageSubset(stack2, name);
                if(poppedPackage == null)
                {
                    poppedPackage = getPackageSubset(stack3, name);
                    if(poppedPackage == null)
                    {
                        poppedPackage = getPackageSubset(stack4, name);
                        if(poppedPackage == null)
                        {
                            poppedPackage = getPackageSubset(stack5, name);
                            if(poppedPackage == null)
                            {
                                poppedPackage = getPackageSubset(floorStack,
                                        name);
                            }
                        }
                    }
                }
            }
        }
        if(poppedPackage ==  null)
        {
            System.out.println("There is no package under that name!");
        }
        else
        {
            System.out.println("give " + poppedPackage.getRecipient() +
                    "'s package that was delivered on day " + poppedPackage.getArrivalDate());
        }
    }
    /**
     * This is the subset method for getPackage which actually finds the top
     * most package and returns that package
     */
    public static Package getPackageSubset(PackageStack currentStack,
                                          String name)
    {
        int countPopped = 0;
        Package poppedPackage = null;
        for(int i = currentStack.getSize(); i > 0; i--)
        {
            if(currentStack.peek().getRecipient().equalsIgnoreCase(name))
            {
                poppedPackage = currentStack.pop();
            }
            else
            {
                floorStack.push(currentStack.pop());
                countPopped++;
            }
        }
        for(int i  = 0; i < countPopped; i++)
        {
            currentStack.push(floorStack.pop());
        }
        return poppedPackage;
    }

    /**
     * This method makes it tomorrow
     * the stacks are stored in an array and it loops through the stacks
     * calling the makeItTomorrowSubset() method which actually finds the
     * packages with an arrival day of 5 days or older then it prints out the
     * removed packages
     */
    public static void makeItTomorrow()
    {
        PackageStack removedPackages = new PackageStack();
        arrivalDate = arrivalDate + 1;
        System.out.println("It is now day " + arrivalDate);
        PackageStack[] stacks = new PackageStack[6];
        stacks[0] = stack1; stacks[1] = stack2; stacks[2] = stack3;
        stacks[3] = stack4; stacks[4] = stack5; stacks[5] = floorStack;
        for(int i = 0; i < stacks.length; i++)
        {
            makeItTomorrowSubset(stacks[i], removedPackages);
        }
        if( !removedPackages.isEmpty())
        {
            System.out.println("Packages: "); removedPackages.print();
            System.out.print( " have been removed from the stacks because they " +
                    "are older than 5 days.");
        }
    }

    /**
     * goes through the stack and checks if a package has an arrival date of
     * 5 days or older
     * @param stack is the stack that the method is currently checking
     * @param removedPackages is the stack that will store the removed
     *                        packages to print
     */
    public static void makeItTomorrowSubset(PackageStack stack,
                                            PackageStack removedPackages) {
        PackageStack tempStack = new PackageStack();
        for (int j = stack.getSize(); j > 0; j--) {
            Package poppedPackage = stack.pop();
            if (poppedPackage.getArrivalDate() <= arrivalDate - 5) {
                removedPackages.push(poppedPackage);
            } else {
                tempStack.push(poppedPackage);
            }
        }
        while (tempStack.getSize() != 0) {
            stack.push(tempStack.pop());
        }
    }

    /**
     * prints out the stacks
     */
    public static void printStacks()
    {
        System.out.println("Current packages: ");
        System.out.println("---------------------------------------");
        System.out.print("Stack 1: ");
        stack1.print();
        System.out.println();
        System.out.print("Stack 2: ");
        stack2.print();
        System.out.println();
        System.out.print("Stack 3: ");
        stack3.print();
        System.out.println();
        System.out.print("Stack 4: ");
        stack4.print();
        System.out.println();
        System.out.print("Stack 5: ");
        stack5.print();
        System.out.println();
        System.out.print("Floor Stack: ");
        floorStack.print();
    }

    /**
     * moves the top package from one stack to another
     */
    public static void movePackage()
    {
        PackageStack[] stacks = new PackageStack[6];
        stacks[0] = stack1; stacks[1] = stack2; stacks[2] = stack3;
        stacks[3] = stack4; stacks[4] = stack5; stacks[5] = floorStack;
        System.out.println("Enter the source stack: (1,2,3,4,5,6(Floor)");
        int sourceStack = input.nextInt();
        System.out.println("Enter destination stack: (1,2,3,4,5,6(Floor)");
        int destinationStack = input.nextInt();
        input.nextLine();

        try {
            stacks[destinationStack - 1].push(stacks[sourceStack - 1].pop());
            System.out.println("The package has been moved from stack " +
                    (sourceStack) + " to stack " + (destinationStack));
        }catch (Exception e)
        {
            System.out.println("There was no package in that stack to move!");
        }
    }

    /**
     * find packages of that are in the wrong stack and puts them in the floor
     */
    public static void findPackages()
    {
        PackageStack tempStack = new PackageStack();
        for (int j = stack1.getSize(); j > 0; j--)
        {
            Package poppedPackage = stack1.pop();
            if (poppedPackage.getRecipient().charAt(0) < 'a' ||
                    poppedPackage.getRecipient().charAt(0) > 'g')
            {
                floorStack.push(poppedPackage);
            } else
                {
                tempStack.push(poppedPackage);
            }
        }
        while (tempStack.getSize() != 0) {
            stack1.push(tempStack.pop());
        }

        for(int i = 0; i < stack2.getSize(); i++)
        {
            Package poppedPackage = stack2.pop();
            if(poppedPackage.getRecipient().charAt(0) < 'h' ||
                    poppedPackage.getRecipient().charAt(0) > 'j')
            {
                floorStack.push(poppedPackage);
            }
            else
            {
                tempStack.push(poppedPackage);
            }
        }
        while (tempStack.getSize() != 0) {
            stack2.push(tempStack.pop());
        }

        for(int i = 0; i < stack3.getSize(); i++)
        {
            Package poppedPackage = stack3.pop();
            if(poppedPackage.getRecipient().charAt(0) < 'k' ||
                    poppedPackage.getRecipient().charAt(0) > 'm')
            {
                floorStack.push(poppedPackage);
            }
            else
            {
                tempStack.push(poppedPackage);
            }
        }
        while (tempStack.getSize() != 0) {
            stack3.push(tempStack.pop());
        }

        for(int i = 0; i < stack4.getSize(); i++)
        {
            Package poppedPackage = stack4.pop();
            if(poppedPackage.getRecipient().charAt(0) < 'n' ||
                    poppedPackage.getRecipient().charAt(0) > 'r')
            {
                floorStack.push(poppedPackage);
            }
            else
            {
                tempStack.push(poppedPackage);
            }
        }
        while (tempStack.getSize() != 0) {
            stack4.push(tempStack.pop());
        }

        for(int i = 0; i < stack5.getSize(); i++)
        {
            Package poppedPackage = stack5.pop();
            if(poppedPackage.getRecipient().charAt(0) < 's' ||
                    poppedPackage.getRecipient().charAt(0) > 'z')
            {
                floorStack.push(poppedPackage);
            }
            else
            {
                tempStack.push(poppedPackage);
            }
        }
        while (tempStack.getSize() != 0) {
            stack5.push(tempStack.pop());
        }
        System.out.println("Misplaced packages moved to the floor stack.");
    }

    /**
     * all the stacks are in an array so that a for loop can loop through all
     * the stacks calls the method listAllPackagesSubset() which finds all
     * the packages for a user in every stack and puts it into
     * packagesForTheRecipient which is printed
     */
    public static void listAllPackages()
    {
        PackageStack[] stacks = new PackageStack[6];
        stacks[0] = stack1; stacks[1] = stack2; stacks[2] = stack3;
        stacks[3] = stack4; stacks[4] = stack5; stacks[5] = floorStack;
        System.out.println("Enter the recipient's name: ");
        String name = input.nextLine();
        PackageStack packagesForTheRecipient = new PackageStack();
        for(int i = 0; i < stacks.length; i++)
        {
            listAllPackagesSubset(packagesForTheRecipient, name, stacks[i]);
        }

        System.out.println("list of packages for " + name + ": ");
        for(int i = 0; i < packagesForTheRecipient.getSize(); i++)
        {
            System.out.println(packagesForTheRecipient.peek().getRecipient() +
                    "'s " + packagesForTheRecipient.peek().getWeight() +
                    " lb package which came on day " +
                    packagesForTheRecipient.peek().getArrivalDate());
        }
    }

    /**
     * compares each package in every stack to the name we are looking for
     * @param packagesForTheRecipient is where the matching packages are pushed
     * @param name is what we are comparing each package to
     * @param stack the stack we are looking through at the moment
     */
    public static void listAllPackagesSubset(PackageStack packagesForTheRecipient,
                                             String name, PackageStack stack)
    {
        PackageStack tempStack = new PackageStack();
        for (int j = stack.getSize(); j > 0; j--)
        {
            Package poppedPackage = stack.pop();
            if (poppedPackage.getRecipient().equalsIgnoreCase(name))
            {
                packagesForTheRecipient.push(poppedPackage);
            }
            tempStack.push(poppedPackage);
        }
        while (tempStack.getSize() != 0) {
            stack.push(tempStack.pop());
        }

    }
    /**
     * gets rid of all the packages in the floor
     */
    public static void emptyTheFloor()
    {
        for(int i = 0; i < floorStack.getSize(); i++)
        {
            floorStack.pop();
        }
        System.out.println("The floor has been emptied.");
    }

    /**
     * quits the system
     */
    public static void quit()
    {
        continueSystem = false;
        System.out.println("Should have used a different mail system :)");
    }
}
