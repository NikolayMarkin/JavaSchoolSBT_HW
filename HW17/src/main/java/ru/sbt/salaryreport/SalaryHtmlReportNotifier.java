package ru.sbt.salaryreport;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class SalaryHtmlReportNotifier {

    public void sendHtmlSalaryReport(String resultingHtml, String recipients) {
        try {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("mail.google.com");

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(recipients);
            helper.setText(resultingHtml, true);
            helper.setSubject("Monthly department salary report");

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
