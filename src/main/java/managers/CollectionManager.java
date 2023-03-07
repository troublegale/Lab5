package managers;

import worker_related.Worker;

import java.time.LocalDateTime;
import java.util.HashMap;

public class CollectionManager {
    private HashMap<Integer, Worker> workerMap;
    private java.time.LocalDateTime creationDate;

    public CollectionManager(HashMap<Integer, Worker> workerMap) {
        this.workerMap = workerMap;
        creationDate = java.time.LocalDateTime.now();
    }

    public HashMap<Integer, Worker> getWorkerMap() { return workerMap; }
    public void setWorkerMap(HashMap<Integer, Worker> workerMap) { this.workerMap = workerMap; }
    public LocalDateTime getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }
}
