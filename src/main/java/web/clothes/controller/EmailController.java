package web.clothes.controller;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import web.clothes.dto.request.EmailRequest;
import web.clothes.service.MailService;


@RestController
@RequestMapping("/api/v1/email")
@RequiredArgsConstructor
public class EmailController {

    private final MailService mailService;

    @PostMapping("/send")
    public String sendEmail(@RequestParam String to,
                            @RequestParam String subject,
                            @RequestParam String body) {
        mailService.sendSimpleEmail(to, subject, body);
        return "Email sent successfully to " + to;
    }

    @PostMapping("/forgot")
    public String forgot(@RequestBody EmailRequest emailRequest) throws MessagingException {
        mailService.sendNewPasswordEmail(emailRequest.getEmail(), "new password");
        return "Email sent successfully to " + emailRequest.getEmail();
    }
}
