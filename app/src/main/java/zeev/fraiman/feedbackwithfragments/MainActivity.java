package zeev.fraiman.feedbackwithfragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button bSms, bMail, bPhone;
    FrameLayout flFragments;
    Context context;
    SMSFragment smsFragment;
    MailFragment mailFragment;
    PhoneFragment phoneFragment;
    TextView tvFromFragment;

    private BroadcastReceiver networkReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
            bMail.setEnabled(isConnected);
        }
    };

    private BroadcastReceiver phoneStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateButtonsState();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initElements();
        updateButtonsState(); // Начальная проверка состояния сети

        bSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smsFragment = new SMSFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flFragments, smsFragment);
                ft.commit();
            }
        });

        bMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mailFragment = new MailFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flFragments, mailFragment);
                ft.commit();
            }
        });

        bPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneFragment = new PhoneFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flFragments, phoneFragment);
                ft.commit();
                String phoneNumber = phoneFragment.st1;
                Toast.makeText(context, "" + phoneNumber, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Регистрируем receiver для интернет-соединения
        registerReceiver(networkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

        // Регистрируем receiver для мобильной сети с несколькими фильтрами
        IntentFilter phoneFilter = new IntentFilter();
        phoneFilter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
        phoneFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(phoneStateReceiver, phoneFilter);

        // Обновляем состояние кнопок при возобновлении активности
        updateButtonsState();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(networkReceiver);
        unregisterReceiver(phoneStateReceiver);
    }

    public void receiveData(String data) {
        Toast.makeText(context, "" + data, Toast.LENGTH_SHORT).show();
    }

    private void initElements() {
        bMail = findViewById(R.id.bMail);
        bSms = findViewById(R.id.bSMS);
        bPhone = findViewById(R.id.bPhone);
        flFragments = findViewById(R.id.flFragments);
        tvFromFragment = findViewById(R.id.tvFromFragment);
        context = MainActivity.this;
    }

    private void updateButtonsState() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobileNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean isMobileNetworkAvailable = mobileNetwork != null &&
                mobileNetwork.isAvailable() &&
                mobileNetwork.isConnected();

        bSms.setEnabled(isMobileNetworkAvailable);
        bPhone.setEnabled(isMobileNetworkAvailable);
    }
}