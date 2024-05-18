package com.example.stockproject;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Data {
    public static String CSVDirectory =  "src/main/CSV data";
    public static UserFactory userFactory = new UserFactory();
    public static ArrayList <User> Users = new ArrayList<>();
    public static ArrayList <User> Admins = new ArrayList<>();
    public static ArrayList <User> DeletedUsers = new ArrayList<>();
    public static ArrayList <User> PremiumUsers =new ArrayList<>();
//    private static Market market; // until market class created
    private static int AdminIndex;
    private static int UserIndex;
    private static int Id ;

    public static Map<String, double[]> loadCSVFilesToHashMap(String directoryPath) throws IOException {
        Map<String, double[]> map = new HashMap<>();

        // Get the list of CSV files in the directory
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".csv"));

        if (files != null) {
            for (File file : files) {
                // Get the key from the file name (without the .csv extension)
                String key = file.getName().replace(".csv", "");

                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    String lastLine = null;

                    // Read through the file to get the last line
                    while ((line = br.readLine()) != null) {
                        lastLine = line;
                    }

                    if (lastLine != null) {
                        // Split the last line by commas and convert to an int array
                        String[] stringValues = lastLine.split(",");
                        double[] intValues = new double[stringValues.length - 1];
                        for (int i = 0; i < stringValues.length - 1; i++) {
                            intValues[i] = Double.parseDouble(stringValues[i + 1]);
                        }

                        // Put the key and the int array into the hash map
                        map.put(key, intValues);
                    }
                }
            }
        }

        return map;
    }

    public static void printHashMap(Map<String, double[]> map) {
        for (Map.Entry<String, double[]> entry : map.entrySet()) {
            System.out.print("Key: " + entry.getKey() + ", Values: ");
            for (double value : entry.getValue()) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }




/*************************/
//    public final static String[] popularSymbols = new String[]{"AAPL", "GOOGL", "MSFT", "AMZN", "FB", "TESLA", "NVDA", "NFLX",
//            "BABA", "V", "JNJ", "JPM", "WMT", "PG"};

    public static Map<String, double[]> stockData;
    public static void initStockData() throws IOException {
        stockData=loadCSVFilesToHashMap(CSVDirectory);
    }
    public void addSymbol(String symbol,double initialPrice){
         stockData.put(symbol, new double[]{initialPrice, initialPrice, initialPrice, initialPrice, initialPrice});
    }



//    private final static double[] initialValues = new double[]{0.0, 0.0, 0.0, 0.0};

    // Call Function At start To Load the Data
//    private void loadSymbols() throws IOException {
//        for (String symbol : popularSymbols) {
//            stockData.put(symbol, initialValues);
//        }
//        exportToCSV(stockData);
//    }
    /***********************/
    public static void exportToCSV(Map<String, double[]> map) throws IOException {
        // Get the current date
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        for (Map.Entry<String, double[]> entry : map.entrySet()) {
            String key = entry.getKey();
            double[] values = entry.getValue();

            String filePath = key + ".csv";
            File file = new File(filePath);
            boolean fileExists = file.exists();

            // Create a CSV file with the key as the file name
            try (FileWriter writer = new FileWriter(filePath, true)) {
                if (fileExists) {
                    writer.write(System.lineSeparator()); // Start a new line if appending
                }
                // Write the current date as the first column
                writer.write(currentDate);

                // Write the values to the CSV file
                for (double value : values) {
                    writer.write("," + value);
                }

                // Remove the trailing comma
                writer.flush();
            } catch (IOException e) {
                System.err.println("Error writing to file " + filePath + ": " + e.getMessage());
            }
        }
    }


    public static boolean UsernameIsAvailable(String username){
        for (User value : Users) {
            if (Objects.equals(username, value.username)) {

                return false;
            }
        }
        Id++;
        return true;
    }

    public static boolean AdminNameIsAvailable(String username){
        for (User admin : Admins){
            if (Objects.equals(admin.username , username)){
                return false;
            }
        }

        return true;
    }

    public static boolean VerifyLogin(String username , String password){
            for (User value : Users) {
                if (Objects.equals(username, value.username) && Objects.equals(password, value.password)) {
                    UserIndex = Users.indexOf(value);
                    return true;
                }
            }
        return false;
    }

    public static boolean VerifyAdminLogin(String username , String password){

        System.out.println(Admins);
        for (User value : Admins) {
            if (Objects.equals(username, value.username) && Objects.equals(password, value.password)) {
                AdminIndex = Admins.indexOf(value);
                return true;
            }
        }
        return false;
    }

    public static int getUserIndex() {
        return UserIndex;
    }

    public static int getAdminIndex() {
        return AdminIndex;
    }

    public static User isInList(String username, ArrayList<User> usersList) {
        for (User user : usersList) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static boolean IsAdmin(User user){
        for (User value : Admins) {
            if (Objects.equals(user,value)) {
                return true;
            }
        }
        return false;
    }

    public static void setUsers(String username , String password){
        User user = userFactory.GetUser(userFactory.NORMAL);
        Users.add(user);

        user.setUsername(username);
        user.setPassword(password);
        user.setId(Id);
        System.out.println(Users);
    }

}
