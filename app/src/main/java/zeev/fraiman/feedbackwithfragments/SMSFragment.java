package zeev.fraiman.feedbackwithfragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSFragment extends Fragment {

    EditText etSMStext, etPhoneNumber;
    Button bSendSMS;
    public String st2="";
    public String st1="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_s_m_s, container, false);
        etPhoneNumber=view.findViewById(R.id.etPhoneNumber);
        etSMStext=view.findViewById(R.id.etSMStext);
        bSendSMS=view.findViewById(R.id.bSendSMS);

        bSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st1=etSMStext.getText().toString();
                st2=etPhoneNumber.getText().toString();
                Toast.makeText(getActivity(),
                        ""+st1+", "+st2, Toast.LENGTH_SHORT).show();

                //MainActivity myactivity=(MainActivity) getActivity();
                //myactivity.updateTextViewData(st1, st2);
                //Toast.makeText(getActivity(), st1+"\n"+st2, Toast.LENGTH_SHORT).show();
                //getFragmentManager().beginTransaction().remove(SMSFragment.this).commit();
            }
        });
        return view;
    }
}