package com.example.jeroen.fragmentdemocommunication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentA extends Fragment {

    private final String TAG = FragmentA.class.getSimpleName();

    private Button buttonSend;
    private EditText etFirstNumber, etSecondNumber;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        /*verkrijgen van de bundle waarden die zijn meegegeven
          de 0 geeft de defaultwaarde aan zodat het programma niet crashed*/
        buttonSend = (Button) view.findViewById(R.id.buttonSend);

        etFirstNumber = (EditText) view.findViewById(R.id.etFirstNumber);
        etSecondNumber = (EditText) view.findViewById(R.id.etSecondNumber);

        buttonSend = (Button) view.findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });

        return view;
    }

    private void sendData() {

        int firstNum = Integer.valueOf(etFirstNumber.getText().toString());
        int secondNum = Integer.valueOf(etSecondNumber.getText().toString());

        MyListener myListener = (MyListener) getActivity();
        myListener.add(firstNum, secondNum); // This triggers the execution of the method in MainActivity
    }
}
