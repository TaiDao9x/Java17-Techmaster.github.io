package entity;

import java.util.List;

public class TimeSheet {

    private Worker worker;
    private List<TimeSheetDetail> timeSheetDetails;

    public TimeSheet(Worker worker, List<TimeSheetDetail> timeSheetDetails) {
        this.worker = worker;
        this.timeSheetDetails = timeSheetDetails;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public List<TimeSheetDetail> getTimeSheetDetails() {
        return timeSheetDetails;
    }

    public void setTimeSheetDetails(List<TimeSheetDetail> timeSheetDetails) {
        this.timeSheetDetails = timeSheetDetails;
    }

    @Override
    public String toString() {
        return "TimeSheet{" +
                "worker=" + worker +
                ", timeSheetDetails=" + timeSheetDetails +
                '}';
    }
}
