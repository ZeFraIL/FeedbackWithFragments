package zeev.fraiman.feedbackwithfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class AboutMeFragment extends Fragment {

    Button button;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View zeev = inflater.inflate(R.layout.fragment_about_me, container, false);

        button=zeev.findViewById(R.id.button);

        return zeev;
    }
}