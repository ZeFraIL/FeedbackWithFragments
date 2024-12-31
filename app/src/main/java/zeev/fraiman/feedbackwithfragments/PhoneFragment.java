package zeev.fraiman.feedbackwithfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PhoneFragment extends Fragment {

    EditText etPhone;
    Button bCallNumber;
    String st1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_phone, container, false);
        etPhone=view.findViewById(R.id.etPhone);
        bCallNumber=view.findViewById(R.id.bCallPhone);
        bCallNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st1=etPhone.getText().toString();
                //Toast.makeText(getActivity(), st1, Toast.LENGTH_SHORT).show();
                MainActivity activity = (MainActivity) getActivity();
                if (activity != null) {
                    activity.receiveData(st1);
                }

            }
        });
        return view;
    }
}