package cs112.ud2;

public class Logo {

    //INSTANCE VARIABLS
    private String logoID;
    private int numberOfStops;
    private int[] threadCodes;


    //DEFAULT CONSTRUCTOR
    public Logo(){
        this.logoID = "Null Logo";
        this.numberOfStops = 1;
        this.threadCodes = new int[numberOfStops];

    }

    //FULL CONSTRUCTOR
    public Logo(String logoID, int numberOfStops) throws IvalidNumberOfStops {
        validateNumberOfStops(numberOfStops);
        this.logoID = logoID;
        this.numberOfStops = numberOfStops;
        this.threadCodes = new int[numberOfStops];
    }

    //EXCEPTION HANDLING METHOD
    public void validateNumberOfStops(int numberOfStops) throws IvalidNumberOfStops {
        if (numberOfStops < 1 || numberOfStops > 24) {
            throw new IvalidNumberOfStops("INVALID NUMBER OF STOPS PROVIDED: " + numberOfStops + "number of stops must be between 1 and 24");
        }
    }

    //SETTERS
    //Sets a threadcode at a specific stop
    public void setThreadCode(int index, int threadCode) {
        if (index < 0 || index >= threadCodes.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid Stop Provided: " + index);
        }
        threadCodes[index] = threadCode;
    }

    //GETTERS
    //Gets the threadcode at specific stop
    public int getThreadCode(int index) {
        if (index < 0 || index >= threadCodes.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid Stop Provided: " + index);
        }
        return threadCodes[index];
    }
    public int getNumberOfStops() {
        return numberOfStops;
    }



}
