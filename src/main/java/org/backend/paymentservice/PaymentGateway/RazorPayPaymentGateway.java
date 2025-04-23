package org.backend.paymentservice.PaymentGateway;


import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.json.JSONObject;
import com.razorpay.RazorpayClient;

@Component
@Primary
public class RazorPayPaymentGateway implements PaymentGateway{

    private final RazorpayClient razorpay;

    public RazorPayPaymentGateway(RazorpayClient razorpay) {
        this.razorpay = razorpay;
    }

    @Override
    public String generatePaymentLink(Long orderId, Long amount) throws RazorpayException {

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",amount);
        paymentLinkRequest.put("currency","INR");
       // paymentLinkRequest.put("accept_partial",true);
       // paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",1744432027);
        paymentLinkRequest.put("reference_id",orderId.toString());
        paymentLinkRequest.put("description","Payment for orderid"+ orderId);
        JSONObject customer = new JSONObject();
        customer.put("contact","+919889327094");
        customer.put("name","Danish Ansari");
        customer.put("email","danishdeveloper2018@gmail.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
       // notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://www.scaler.com/academy/mentee-dashboard/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
        return payment.get("short_url").toString();
    }
}
