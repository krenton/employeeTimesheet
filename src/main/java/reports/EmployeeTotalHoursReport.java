package reports;

import dataModel.Project;
import dataModel.Task;

import java.util.HashMap;
import java.util.Map;

public class EmployeeTotalHoursReport extends iReporting{

    EmployeeTotalHoursReport(){}

    @Override
    public void calculate(int year) {

        for (Project p : dataModel.getProjectList()) {
                for (Task t : p.getTaskList()) {
                   if (t.getDate().getYear() == year) {
                       innerDataModel.put(t.getAsignee().getName(), innerDataModel.getOrDefault(t.getAsignee().getName(), 0)+t.getTime());
                   }
                }
            }
    }

    public void printReportToConsole() {
        for (Map.Entry entry : innerDataModel.entrySet()) {
            System.out.println("Employee: " + entry.getKey() + "Time worked: " + entry.getValue() + "\n");
        }
    }

    public void saveToPDF() {
        System.out.println("Not yet implemented.");
    }

    public void saveToXLS() {
        System.out.println("Not yet implemented.");
    }
}
