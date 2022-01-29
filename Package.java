/**
 * @author Sadikshya Sharma
 * SBU ID: 113305452
 * Recitation 3
 * This class is the basic package class.
 */
public class Package {
    private String recipient;
    private int arrivalDate;
    private double weight;

    /**
     * constructor for package
     * @param recipient is the name of the person receiving the package
     * @param arrivalDate is the date that the package arrived in
     * @param weight the weight of the package
     */
    public Package(String recipient, int arrivalDate, double weight)
    {
        this.recipient = recipient;
        this.arrivalDate = arrivalDate;
        this.weight = weight;
    }

    /**
     * setter method for a recipient
     * @param recipient is the name of the person receiving the package
     */
    public void setRecipient(String recipient)
    {
        this.recipient = recipient;
    }

    /**
     * getter method for the recipient name
     * @return returns name of package recipient
     */
    public String getRecipient()
    {
        return recipient;
    }

    /**
     * mutator method for the arrival date
     * @param arrivalDate is what arrival date will change to
     */
    public void setArrivalDate(int arrivalDate)
    {
        this.arrivalDate = arrivalDate;
    }

    /**
     * getter method for arrival date
     * @return returns the arrival date
     */
    public int getArrivalDate()
    {
        return arrivalDate;
    }

    /**
     * setter method for the weight
     * @param weight sets weight to the parameter weight
     */
    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    /**
     * getter method for weight
     * @returns value of weight
     */
    public double getWeight() {
        return weight;
    }
}
