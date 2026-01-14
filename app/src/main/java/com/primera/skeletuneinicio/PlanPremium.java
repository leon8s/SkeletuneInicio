package com.primera.skeletuneinicio;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.wallet.AutoResolveHelper;
import com.google.android.gms.wallet.PaymentData;
import com.google.android.gms.wallet.PaymentDataRequest;
import com.google.android.gms.wallet.PaymentsClient;
import com.google.android.gms.wallet.Wallet;
import com.google.android.gms.wallet.WalletConstants;
import com.google.android.material.card.MaterialCardView;
import org.json.JSONObject;
import java.io.InputStream;

public class PlanPremium extends AppCompatActivity implements View.OnClickListener {

    private static final int LOAD_PAYMENT_DATA_REQUEST_CODE = 991;
    private PaymentsClient paymentsClient;
    private MaterialCardView btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_plan_premium);

        paymentsClient = Wallet.getPaymentsClient(
                this,
                new Wallet.WalletOptions.Builder()
                        .setEnvironment(WalletConstants.ENVIRONMENT_TEST)
                        .build());

        btnPay = findViewById(R.id.btnGooglePay);
        btnPay.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnGooglePay) {
            Toast.makeText(this, "Google Pay seleccionado", Toast.LENGTH_SHORT).show();
            iniciarPagoGooglePay();
        }
    }

    private void iniciarPagoGooglePay() {
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.payment_config);
            if (inputStream != null) {
                Log.d("GooglePay", "Archivo JSON leído correctamente");
                Toast.makeText(this, "Archivo JSON leido correctamente", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Log.e("GooglePay", "Error Leyendo payment_config.json", e);
            Toast.makeText(this, "Error Leyendo payment_config.jason: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(this, "Iniciando flujo de pago...", Toast.LENGTH_SHORT).show();

        try {
            JSONObject paymentDataRequestJson = new JSONObject(loadPaymentDataRequest());
            PaymentDataRequest request = PaymentDataRequest.fromJson(paymentDataRequestJson.toString());

            if (request != null) {
                AutoResolveHelper.resolveTask(
                        paymentsClient.loadPaymentData(request),
                        this,
                        LOAD_PAYMENT_DATA_REQUEST_CODE
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error iniciando Google Pay", Toast.LENGTH_SHORT).show();
        }
    }

    private String loadPaymentDataRequest() {
        return "{"
                + "\"apiVersion\": 2,"
                + "\"apiVersionMinor\": 0,"
                + "\"allowedPaymentMethods\": [{"
                + "\"type\": \"CARD\","
                + "\"parameters\": {"
                + "\"allowedAuthMethods\": [\"PAN_ONLY\", \"CRYPTOGRAM_3DS\"],"
                + "\"allowedCardNetworks\": [\"VISA\", \"MASTERCARD\"]"
                + "},"
                + "\"tokenizationSpecification\": {"
                + "\"type\": \"PAYMENT_GATEWAY\","
                + "\"parameters\": {"
                + "\"gateway\": \"example\","
                + "\"gatewayMerchantId\": \"exampleGatewayMerchantId\""
                + "}"
                + "}"
                + "}],"
                + "\"transactionInfo\": {"
                + "\"totalPriceStatus\": \"FINAL\","
                + "\"totalPrice\": \"149.99\","
                + "\"currencyCode\": \"MXN\""
                + "},"
                + "\"merchantInfo\": {"
                + "\"merchantName\": \"Ejemplo App\""
                + "}"
                + "}";
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LOAD_PAYMENT_DATA_REQUEST_CODE) {
            switch (resultCode) {
                case Activity.RESULT_OK:
                    PaymentData paymentData = PaymentData.getFromIntent(data);
                    String info = paymentData.toJson();
                    Toast.makeText(this, "Pago exitoso", Toast.LENGTH_LONG).show();
                    break;

                case Activity.RESULT_CANCELED:
                    Toast.makeText(this, "Pago cancelado", Toast.LENGTH_SHORT).show();
                    break;

                case AutoResolveHelper.RESULT_ERROR:
                    Toast.makeText(this, "Error en el pago", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
