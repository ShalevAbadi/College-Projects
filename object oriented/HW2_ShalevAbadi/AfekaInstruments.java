import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AfekaInstruments {

    public static void main(String[] args) {
        ArrayList<MusicalInstrument> allInstruments = new ArrayList<>();
        Scanner consoleScanner = new Scanner(System.in);
        File file = getInstrumentsFileFromUser(consoleScanner);

        loadInstrumentsFromFile(file, allInstruments);

        if(allInstruments.size() == 0) {
            System.out.println("There are no instruments in the store currently");
            return;
        }

        printInstruments(allInstruments);

        int different = getNumOfDifferentElements(allInstruments);

        System.out.println("\n\nDifferent Instruments: " + different);

        MusicalInstrument mostExpensive = getMostExpensiveInstrument(allInstruments);

        System.out.println("\n\nMost Expensive Instrument:\n" + mostExpensive);
        consoleScanner.close();
    }

    public static File getInstrumentsFileFromUser(Scanner consoleScanner){
        boolean stopLoop = true;
        File file;
        do {
            System.out.println("Please enter instruments file name / path:");
            String filepath = consoleScanner.nextLine();
            file = new File(filepath);
            stopLoop = file.exists() && file.canRead();

            if(!stopLoop)
                System.out.println("\nFile Error! Please try again\n\n");
        }while (!stopLoop);

        return file;
    }

    public static void loadInstrumentsFromFile(File file, ArrayList allInstruments){
        Scanner scanner = null;

        try {

            scanner = new Scanner(file);

            addAllInstruments(allInstruments ,loadGuitars(scanner));

            addAllInstruments(allInstruments ,loadBassGuitars(scanner));

            addAllInstruments(allInstruments ,loadFlutes(scanner));

            addAllInstruments(allInstruments ,loadSaxophones(scanner));

        }catch (InputMismatchException | IllegalArgumentException ex){
            System.err.println("\n"+ ex.getMessage());
            System.exit(1);
        }catch (FileNotFoundException ex){
            System.err.println("\nFile Error! File was not found");
            System.exit(2);
        } finally {
            scanner.close();
        }
        System.out.println("\nInstruments loaded from file successfully!\n");

    }

    public static ArrayList loadGuitars(Scanner scanner){
        int numOfInstruments = scanner.nextInt();
        ArrayList guitars = new ArrayList(numOfInstruments);

        for(int i = 0; i < numOfInstruments ; i++)
            guitars.add(new Guitar(scanner));

        return guitars;
    }

    public static ArrayList loadBassGuitars(Scanner scanner){
        int numOfInstruments = scanner.nextInt();
        ArrayList bassGuitars = new ArrayList(numOfInstruments);

        for(int i = 0; i < numOfInstruments ; i++)
            bassGuitars.add(new Bass(scanner));

        return bassGuitars;
    }

    public static ArrayList loadFlutes(Scanner scanner){
        int numOfInstruments = scanner.nextInt();
        ArrayList flutes = new ArrayList(numOfInstruments);

        for(int i = 0; i < numOfInstruments ; i++)
            flutes.add(new Flute(scanner));


        return flutes;
    }

    public static ArrayList loadSaxophones(Scanner scanner){
        int numOfInstruments = scanner.nextInt();
        ArrayList saxophones = new ArrayList(numOfInstruments);

        for(int i = 0; i < numOfInstruments ; i++)
            saxophones.add(new Saxophone(scanner));

        return saxophones;
    }

    public static void addAllInstruments(ArrayList instruments, ArrayList moreInstruments){
        for(int i = 0 ; i < moreInstruments.size() ; i++){
            instruments.add(moreInstruments.get(i));
        }
    }

    public static void printInstruments(ArrayList instruments){
        for(int i = 0 ; i < instruments.size() ; i++)
            System.out.println(instruments.get(i));
    }



    public static int getNumOfDifferentElements(ArrayList instruments){
        int numOfDifferentInstruments;
        ArrayList differentInstruments = new ArrayList();
        System.out.println();

        for(int i = 0 ; i < instruments.size() ; i++){
            if(!differentInstruments.contains((instruments.get(i)))){
                differentInstruments.add(instruments.get(i));
            }
        }

        if(differentInstruments.size() == 1)
            numOfDifferentInstruments = 0;

        else
            numOfDifferentInstruments = differentInstruments.size();


        return numOfDifferentInstruments;
    }

    public static MusicalInstrument getMostExpensiveInstrument(ArrayList instruments){
        double maxPrice = 0;
        MusicalInstrument mostExpensive = (MusicalInstrument) instruments.get(0);

        for(int i = 0 ; i < instruments.size() ; i++){
            MusicalInstrument temp = (MusicalInstrument)instruments.get(i);

            if(temp.getPrice().doubleValue() > maxPrice){
                maxPrice = temp.getPrice().doubleValue();
                mostExpensive = temp;
            }
        }

        return mostExpensive;
    }

}
