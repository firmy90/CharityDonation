package pl.firmy90.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.firmy90.services.interfaces.EmailService;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class DefaultEmailService implements EmailService {
    private final JavaMailSender javaMailSender;

    @Override
    public void sendMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("nawakbeata@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);

    }

    @Override
    public void sendMessageNewRegistration(String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("nawakbeata@gmail.com");
        message.setTo("nawakbeata@gmail.com");
        message.setSubject("Zarejestrowano nowego użytkownika");
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder builder = stringBuilder.append(LocalDateTime.now()).append(" - Zarejestrowany nowy użytkownik: \n")
                .append(text);
        message.setText(builder.toString());
        javaMailSender.send(message);

    }
}
