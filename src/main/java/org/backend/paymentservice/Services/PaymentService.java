package org.backend.paymentservice.Services;


import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.backend.paymentservice.PaymentGateway.PaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String makePayment(Long orderId, Long amount) throws RazorpayException, StripeException {
        return paymentGateway.generatePaymentLink(orderId, amount);
    }


}
