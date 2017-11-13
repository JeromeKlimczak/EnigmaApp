package com.enigma.enigmaapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CodeActivity extends AppCompatActivity {

    private Context ctxt = this;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button mButton0;
    private Button mButtonOk;
    private Button mButtonC;
    private TextView mTxtCode;

    private int nbClick = 0;
    private int code=0;

    private final int ID_INVALID_CODE_DIALOG = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);


        mTxtCode    =(TextView)     findViewById(R.id.txt_code);
        mButton0    =(Button)       findViewById(R.id.bt_0);

        mButton0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mTxtCode.setText(computeCode(0));
            }
        });

        mButton1    =(Button)       findViewById(R.id.bt_1);

        mButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mTxtCode.setText(computeCode(1));
            }
        });

        mButton2    =(Button)       findViewById(R.id.bt_2);

        mButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mTxtCode.setText(computeCode(2));
            }
        });

        mButton3    =(Button)       findViewById(R.id.bt_3);

        mButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mTxtCode.setText(computeCode(3));
            }
        });

        mButton4    =(Button)       findViewById(R.id.bt_4);

        mButton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mTxtCode.setText(computeCode(4));
            }
        });

        mButton5    =(Button)       findViewById(R.id.bt_5);

        mButton5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mTxtCode.setText(computeCode(5));
            }
        });

        mButton6    =(Button)       findViewById(R.id.bt_6);

        mButton6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mTxtCode.setText(computeCode(6));
            }
        });

        mButton7    =(Button)       findViewById(R.id.bt_7);

        mButton7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mTxtCode.setText(computeCode(7));
            }
        });

        mButton8    =(Button)       findViewById(R.id.bt_8);

        mButton8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mTxtCode.setText(computeCode(8));
            }
        });

        mButton9    =(Button)       findViewById(R.id.bt_9);

        mButton9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mTxtCode.setText(computeCode(9));
            }
        });

        mButtonC    =(Button)       findViewById(R.id.bt_c);

        mButtonC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(nbClick != 0 && nbClick != 1) {
                    code = (code / 10);
                    nbClick--;
                    mTxtCode.setText(Integer.toString(code));
                }else{
                    code=0;
                    nbClick=0;
                    mTxtCode.setText("");
                }
            }
        });

        mButtonOk    =(Button)       findViewById(R.id.bt_ok);

        mButtonOk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int resultVal = 0;
                if(nbClick<4) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ctxt);
                    // set dialog message
                    alertDialogBuilder.setTitle("Invalid Code!")
                                      .setCancelable(true);
                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    // show it
                    alertDialog.show();

                    resultVal=-1;
                }
                Intent result = new Intent();
                setResult(resultVal, result);
                finish();
            }
        });
    }

    private String computeCode (int val){
        if(nbClick<4) {
            code = 10 * code + val;
            nbClick++;
        }else{
            Toast toast = Toast.makeText(this, "4 digits is enough!", Toast.LENGTH_LONG);
            toast.show();
        }

        return Integer.toString(code);
    }
}
