package home_work;

import home_work.model.Factory;
import home_work.model.Worker;

import java.util.ArrayList;
import java.util.List;

public class Service {
    public List<Worker> workers = new ArrayList<>();
    public List<Factory> factories = new ArrayList<>();


    public void addWorker(Worker newWorker) {
        workers.add(newWorker);
    }

    public List<Worker> getAllWorker() {
        return workers;
    }

    public void addFactory(Factory newFactory) {
        factories.add(newFactory);
    }

    public List<Factory> getAllFactories() {
        return factories;
    }
}
