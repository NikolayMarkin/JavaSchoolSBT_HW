package ru.sbt.salaryreport;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class SalaryReportMain {
    public static void main(String[] args) throws SQLException {
        SalaryReportBuilder reportBuilder = new SalaryReportBuilder(
                DriverManager.getConnection("jdbc:sqlserver://localhost:1433", "username", "password")
        );
        String htmlReport = reportBuilder.buildHtmlReport("IT", LocalDate.of(2016, 9, 1), LocalDate.of(2016, 9, 31));
        new SalaryHtmlReportNotifier().sendHtmlSalaryReport(htmlReport, "test@gmail.com");
    }
}
