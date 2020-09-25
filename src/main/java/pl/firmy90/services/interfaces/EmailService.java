package pl.firmy90.services.interfaces;

public interface EmailService {

    void sendMessage(String to, String subject, String text);
    void sendMessageNewRegistration(String text);
}
