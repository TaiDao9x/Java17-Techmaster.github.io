package entity;

public class TimeSheetDetail {

    private Factory factory;
    private int workingDay;

    public TimeSheetDetail(Factory factory, int workingDay) {
        this.factory = factory;
        this.workingDay = workingDay;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public int getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(int workingDay) {
        this.workingDay = workingDay;
    }

    @Override
    public String toString() {
        return "TimeSheetDetail{" +
                "factory=" + factory +
                ", workingDay=" + workingDay +
                '}';
    }
}
