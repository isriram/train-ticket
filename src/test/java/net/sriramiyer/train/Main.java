package net.sriramiyer.train;

public class Main {
    public static void main(String[] args){
        Loader loader = new Loader();
        loader.readFromFile();
        loader.readInputsForTesting();
        loader.writeCostsToFile();

        /*try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"))) {
            bufferedWriter.write("This is a sample sentence");
        } catch (IOException e) {
            e.printStackTrace();
        } */

    }
}
