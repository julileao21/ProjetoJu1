package main.support;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
    static ExtentReports extent;
    final static String filePath = ".html";
    static String dataHora = Utils.getDataHora();

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports("reports/report_" + dataHora + filePath, true);
        }
        return extent;
    }
}
