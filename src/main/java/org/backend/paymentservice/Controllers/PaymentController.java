package org.backend.paymentservice.Controllers;


import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.backend.paymentservice.Services.PaymentService;
import org.backend.paymentservice.dtos.InitiatePaymentRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String makePayment(@RequestBody InitiatePaymentRequestDto requestDto) {
        try {
            return paymentService.makePayment(
                    requestDto.getOrderId(),
                    requestDto.getAmount()
            );
        } catch (RazorpayException e) {
            System.out.println(e.getMessage());
        } catch (StripeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
