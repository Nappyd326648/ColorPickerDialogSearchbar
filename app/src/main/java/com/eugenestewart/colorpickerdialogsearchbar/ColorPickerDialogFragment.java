package com.eugenestewart.colorpickerdialogsearchbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by nappy on 10/2/2016.
 */

public class ColorPickerDialogFragment extends DialogFragment {

    int red ;
    int blue ;
    int green;

    public Dialog onCreateDialog(Bundle savedInstanceState){
       super.onCreateDialog(savedInstanceState);

        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

         View view = layoutInflater.inflate(R.layout.seekbarlay,null, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose a background color")
                .setView(view);
        final SeekBar rSeekbar = (SeekBar) view.findViewById(R.id.redseek);
        final SeekBar gSeekbar = (SeekBar) view.findViewById(R.id.greenseek);
        final SeekBar bSeekbar = (SeekBar) view.findViewById(R.id.blueseek);

        final TextView rseekbarvalue = (TextView) view.findViewById(R.id.rLable);
        final TextView gseekbarvalue = (TextView) view.findViewById(R.id.gLable);
        final TextView bseekbarvalue = (TextView) view.findViewById(R.id.bLable);

        int rseekbarProgress = rSeekbar.getProgress();
        int gseekbarProgress = gSeekbar.getProgress();
        int bseekbarProgress = bSeekbar.getProgress();



        rSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar,int progress,boolean fromUser){
                rseekbarvalue.setText("Red value: "+progress);
                red= progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        } );

        bSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar,int progress,boolean fromUser){
                bseekbarvalue.setText("Blue value: "+progress);
                blue=progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        } );

        gSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar,int progress,boolean fromUser){
                gseekbarvalue.setText("Green value: "+progress);
                green=progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        } );





        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.colorSelected(Color.rgb(red,green,blue));
            }


        });

        return builder.create();
    }

    interface ColorDialogSelectionListener{
        void colorSelected(int color);
    }
    private ColorDialogSelectionListener mListener;
    public  static  ColorPickerDialogFragment newInstance(){
        ColorPickerDialogFragment fragment = new ColorPickerDialogFragment();
        return fragment;
    }
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        if (activity instanceof  ColorDialogSelectionListener){
            mListener= (ColorDialogSelectionListener) activity;
        }else {
            throw new  RuntimeException(activity.toString()+ "must implement ColorDialogS");
        }
    }


}
