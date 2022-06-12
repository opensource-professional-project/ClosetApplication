package com.example.closet_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Arrays;

public class voteresult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voteresult);

        setTitle("투표 결과");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        int[] voteresult5 = intent.getIntArrayExtra("originalCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        Integer imageFileId[] = {R.drawable.fall1, R.drawable.fall2,
                R.drawable.fall3, R.drawable.fall4, R.drawable.fall5,
                R.drawable.fall6, R.drawable.fall7, R.drawable.fall8,
                R.drawable.fall9,R.drawable.fall10,R.drawable.fall11,R.drawable.fall12,
                R.drawable.fall13,R.drawable.fall14,R.drawable.fall15,R.drawable.fall16};

        TextView tvTop = findViewById(R.id.tvTop);
        ImageView ivTop = findViewById(R.id.ivTop);
        int maxEntry = 0;
        for (int i = 1; i < voteResult.length; i++) {
            if (voteResult[maxEntry] < voteResult[i])
                maxEntry = i;
        }
        tvTop.setText(imageName[maxEntry]);
        ivTop.setImageResource(imageFileId[maxEntry]);

//        TextView tv[] = new TextView[imageName.length];
//        TextView vote[] = new TextView[imageName.length];

//        Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
//                R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9, R.id.tv10, R.id.tv11, R.id.tv12,
//                R.id.tv13,R.id.tv14,R.id.tv15,R.id.tv16};
//       Integer numVote[] = {R.id.vote1,R.id.vote2,R.id.vote3,R.id.vote4,R.id.vote5,R.id.vote6,
//               R.id.vote7,R.id.vote8,R.id.vote9,R.id.vote10,R.id.vote11,R.id.vote12,R.id.vote13,
//               R.id.vote14,R.id.vote15,R.id.vote16};

        TextView tv[] = new TextView[5];
        TextView vote[] = new TextView[5];

        Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5};
        Integer numVote[] = {R.id.vote1,R.id.vote2,R.id.vote3,R.id.vote4,R.id.vote5};

        Arrays.sort(voteResult);
        int idxnum = 0;
        int[] voteidx = new int[5];

        for(int i=0;i<voteresult5.length;i++){
            Log.d("voteID", String.valueOf(voteresult5[i]));
        }


        for(int i=voteResult.length-1; i>=voteResult.length-5; i--)
        {
            for(int j = 0; j<voteResult.length; j++)
            {
                if(voteResult[i]==voteresult5[j])
                {
                    voteidx[idxnum] = j;
                    Log.d("voteID", String.valueOf(voteidx[idxnum]));
                    idxnum++;


                }
            }
        }

//        for (int i = 0; i < voteResult.length; i++) {
//            tv[i] = (TextView) findViewById(tvID[i]);
//            vote[i] = (TextView) findViewById(numVote[i]);
//        }
//
//        for (int i = 0; i < voteResult.length; i++) {
//            tv[i].setText(imageName[i]);
//            String numbering = String.valueOf(voteResult[i]);
//            vote[i].setText(numbering);
//        }

        for(int i = 0; i<voteidx.length; i++) {
            tv[i] = (TextView) findViewById(tvID[i]);
            vote[i] = (TextView) findViewById((numVote[i]));
        }

        for(int i = 0; i<voteidx.length; i++) {
            tv[i].setText(imageName[voteidx[i]]);
            String numbering = String.valueOf(voteResult[voteResult.length-i-1]);
            vote[i].setText(numbering);
        }

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(v -> {
            finish();
        });


    }
}