//package org.backend.paymentservice.Configs;
//
//
//import com.stripe.StripeClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class StripeConfig {
//
//    @Value("${stripe.key.secret}")
//    private String stipeKeySecret;
//
//    public StripeClient getStripeClient() {
//        return new StripeClient(stipeKeySecret);
//    }
//
//
//}
