package com.example.closet_project.activity;

import static com.example.closet_project.view.PhRecyclerViewHolder.voteCount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.closet_project.PhRecyclerItem;
import com.example.closet_project.R;
import com.example.closet_project.adapter.VoteAdapter;
import com.example.closet_project.voteresult;

import java.util.ArrayList;
import java.util.List;

public class VoteActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    public static Context context_main;
    public int var;
    List<PhRecyclerItem> itemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        bindList();

        final String[] imgName = {
                "후보 1",
                "후보 2",
                "후보 3",
                "후보 4",
                "후보 5",
                "후보 6",
                "후보 7",
                "후보 8",
                "후보 9",
                "후보 10",
                "후보 11",
                "후보 12",
                "후보 13",
                "후보 14",
                "후보 15",
                "후보 16"
        };

        Button button = (Button)findViewById(R.id.resultbtn); /*페이지 전환버튼*/

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), voteresult.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("originalCount",voteCount);
                intent.putExtra("ImageName", imgName);
                startActivity(intent);
            }
        });
    }
    private void bindList() {
        // List item 생성
        itemList.add(new PhRecyclerItem(R.drawable.fall1, "투표하기","후보1"));
        itemList.add(new PhRecyclerItem(R.drawable.fall2, "투표하기","후보2"));
        itemList.add(new PhRecyclerItem(R.drawable.fall3, "투표하기","후보3"));
        itemList.add(new PhRecyclerItem(R.drawable.fall4, "투표하기","후보4"));
        itemList.add(new PhRecyclerItem(R.drawable.fall5, "투표하기","후보5"));
        itemList.add(new PhRecyclerItem(R.drawable.fall6, "투표하기","후보6"));
        itemList.add(new PhRecyclerItem(R.drawable.fall7, "투표하기","후보7"));
        itemList.add(new PhRecyclerItem(R.drawable.fall8, "투표하기","후보8"));
        itemList.add(new PhRecyclerItem(R.drawable.fall9, "투표하기","후보9"));
        itemList.add(new PhRecyclerItem(R.drawable.fall10, "투표하기","후보10"));
        itemList.add(new PhRecyclerItem(R.drawable.fall11, "투표하기","후보11"));
        itemList.add(new PhRecyclerItem(R.drawable.fall12, "투표하기","후보12"));
        itemList.add(new PhRecyclerItem(R.drawable.fall13, "투표하기","후보13"));
        itemList.add(new PhRecyclerItem(R.drawable.fall14, "투표하기","후보14"));
        itemList.add(new PhRecyclerItem(R.drawable.fall15, "투표하기","후보15"));
        itemList.add(new PhRecyclerItem(R.drawable.fall16, "투표하기","후보16"));



        // Recycler view
        RecyclerView recyclerView = findViewById(R.id.recyceler_view);

        // Adapter 추가
        RecyclerView.Adapter adapter = new VoteAdapter(itemList);
        recyclerView.setAdapter(adapter);

        // Layout manager 추가
        RecyclerView.LayoutManager gridlayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridlayoutManager);
    }
}