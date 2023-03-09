package managers;
import worker_related.Worker;
import java.util.HashMap;

public class CollectionManager {
    private HashMap<Integer, Worker> workerMap;
    private String creationDate;

    public CollectionManager(HashMap<Integer, Worker> workerMap, String creationDate) {
        this.workerMap = workerMap;
        this.creationDate = creationDate;
    }

    public HashMap<Integer, Worker> getWorkerMap() { return workerMap; }
    public void setWorkerMap(HashMap<Integer, Worker> workerMap) { this.workerMap = workerMap; }
    public String getCreationDate() { return creationDate; }
    public void setCreationDate(String creationDate) { this.creationDate = creationDate; }
}
