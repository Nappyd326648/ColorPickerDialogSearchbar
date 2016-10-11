package com.eugenestewart.colorpickerdialogsearchbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements ColorPickerDialogFragment.ColorDialogSelectionListener {

    Button mChooseBackgroundColor;
    RelativeLayout mBackround;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mBackround = (RelativeLayout) findViewById(R.id.background);
        mChooseBackgroundColor = (Button) findViewById(R.id.show_color_button);

        mChooseBackgroundColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorPickerDialogFragment dialog = ColorPickerDialogFragment.newInstance();
                dialog.show(getFragmentManager(),"Color Dialog");
            }
        });
    }
    public void colorSelected(int color){
        mBackround.setBackgroundColor(color);
    }
}
