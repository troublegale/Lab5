package managers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import worker_related.Worker;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.HashMap;

public class FileManager {
    private final String filePath;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public HashMap<Long, Worker> readWorkersFromFile() throws IOException {
        HashMap<Long, Worker> workerMap = new HashMap<>();
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath))) {
            byte[] data = inputStream.readAllBytes();
            String jsonString = new String(data);
            Gson gson = new Gson();
            Worker[] workers = gson.fromJson(jsonString, Worker[].class);
            for (Worker worker : workers) {
                workerMap.put(worker.getId(), worker);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Could not find file: " + e.getMessage());
        } catch (NoSuchFileException e) {
            System.err.println("File is empty: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Could not read workers from file: " + e.getMessage());
        } catch (JsonSyntaxException e) {
            System.err.println("Could not parse workers from file: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Unable to complete: " + e.getMessage());
        }
        return workerMap;
    }

    public void writeWorkersToFile(CollectionManager colMan) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Gson gson = new Gson();
            Worker[] workers = colMan.getWorkerMap().values().toArray(new Worker[0]);
            String jsonString = gson.toJson(workers);
            writer.write(jsonString);
        } catch (IOException e) {
            System.err.println("Could not write workers to file: " + e.getMessage());
        }
    }
}
