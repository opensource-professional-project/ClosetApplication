package com.example.closet_project.activity;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.closet_project.MarkerItem;
import com.example.closet_project.R;
import com.example.closet_project.adapter.RecylcerAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<MarkerItem> markerItemArrayList = new ArrayList<MarkerItem>();
    Button main, west, back, center;
    RecyclerView recyclerView;

    int images[]={ R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5,
            R.drawable.i6,R.drawable.i7,R.drawable.i8,R.drawable.i9,R.drawable.i10,R.drawable.i11,
            R.drawable.i12,R.drawable.i13,R.drawable.i14,R.drawable.i15,R.drawable.i16,R.drawable.i17,
            R.drawable.i18,R.drawable.i19,R.drawable.i20,R.drawable.i21,R.drawable.i22};

    final LatLng West = new LatLng(36.624701,127.449874);
    final LatLng Main = new LatLng(36.6347236,127.453357);
    final LatLng Back = new LatLng(36.6254941,127.465590);
    final LatLng Center = new LatLng(36.6341819,127.460700);
    String[] s1,s2;
    public int getConut(){
        return markerItemArrayList.size();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle1);
        main=(Button) findViewById(R.id.Main);
        west=(Button) findViewById(R.id.West);
        back=(Button) findViewById(R.id.Back);
        center=(Button) findViewById(R.id.Center);


        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);

        main.setOnClickListener(GoM);
        west.setOnClickListener(GoW);
        back.setOnClickListener(GoB);
        center.setOnClickListener(GoC);

        markerItemArrayList.add(new MarkerItem(   36.6265324   ,   127.450962   ,   "나이키 NSW 클럽 맨투맨 BV2663-063"   ,   1   ));
        markerItemArrayList.add(new MarkerItem(   36.6262968   ,   127.451318   ,   "NSW 클럽 조거팬츠 BV2671-063(나이키)"   ,   2   ));
        markerItemArrayList.add(new MarkerItem(   36.6269086   ,   127.451579   ,   "나이키 조던 미드 그레이"   ,   3   ));
        markerItemArrayList.add(new MarkerItem(   36.627036   ,   127.446437   ,   "22 SS 발렌시아가 로고 엠브로이더리 자수 베이스볼캡"   ,   4   ));
        markerItemArrayList.add(new MarkerItem(   36.6271011   ,   127.453078   ,   "애플워치 시리즈6 44mm 실버 알루미늄"   ,   5   ));
        markerItemArrayList.add(new MarkerItem(   36.6318151   ,   127.459881   ,   "와릿이즌 맨투맨 BLACK"   ,   1   ));
        markerItemArrayList.add(new MarkerItem(   36.6315814   ,   127.459723   ,   "컨셉원 테이퍼드 슬랙스 117902 그레이텍스쳐 네이비"   ,   2   ));
        markerItemArrayList.add(new MarkerItem(   36.63270109   ,   127.4604741   ,   "뉴발란스 992"   ,   3   ));
        markerItemArrayList.add(new MarkerItem(   36.63192221   ,   127.4573947   ,   "칼하트 a18-BLK"   ,   4   ));
        markerItemArrayList.add(new MarkerItem(   36.63129592   ,   127.4609045   ,   "Tissot 씨스타 1000 크로노그래프 "   ,   5   ));
        markerItemArrayList.add(new MarkerItem(   36.63410284   ,   127.4585956   ,   "자바나스 익스트림 맨투맨 10-그레이 스노우"   ,   1   ));
        markerItemArrayList.add(new MarkerItem(   36.6315176   ,   127.457554   ,   "컷오프 패널드 데님 팬츠(라이트블루)"   ,   2   ));
        markerItemArrayList.add(new MarkerItem(   36.63098451   ,   127.4645196   ,   "조던 하이 OG 디올"   ,   3   ));
        markerItemArrayList.add(new MarkerItem(   36.63343187   ,   127.4514191   ,   "아디다스 베이스볼 코튼"   ,   4   ));
        markerItemArrayList.add(new MarkerItem(   36.63403724   ,   127.4533681   ,   "세이코 SNAF03J"   ,   5   ));
        markerItemArrayList.add(new MarkerItem(   36.63319759   ,   127.453788   ,   "리 빅 트위치 루즈핏 크루넥 블랙"   ,   1   ));
        markerItemArrayList.add(new MarkerItem(   36.63369786   ,   127.4549314   ,   "팀 클럽 스우시 반바지(나이키)"   ,   2   ));
        markerItemArrayList.add(new MarkerItem(   36.6309798   ,   127.44969   ,   "조던1 로우 코트 퍼플"   ,   3   ));
        markerItemArrayList.add(new MarkerItem(   36.6237264   ,   127.46132   ,   "mlb 뉴욕양키스"   ,   4   ));
        markerItemArrayList.add(new MarkerItem(   36.62551811   ,   127.4659402   ,   "[마르지엘라]22SS SM1UQ0050 넘버링 빈티지 실버 반지"   ,   5   ));
        markerItemArrayList.add(new MarkerItem(   36.6271737   ,   127.4665762   ,   "NSW HBR NCPS 바람막이 자켓 DV0531-086"   ,   1   ));
        markerItemArrayList.add(new MarkerItem(   36.62581962   ,   127.4648799   ,   "뉴발란스 574"   ,   3   ));

        s1= getResources().getStringArray(R.array.title_name);
        s2=getResources().getStringArray(R.array.price_name);
        RecylcerAdapter recylcerAdapter = new RecylcerAdapter(this,s1,s2,images);
        recyclerView.setAdapter(recylcerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void onMapReady(final GoogleMap googleMap){
        mMap = googleMap;
        Context context =this;


        final LatLng CBNU = new LatLng(36.6283933,127.459223);

        for(MarkerItem markerItem:markerItemArrayList){
            addMarker(markerItem);
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CBNU,15));
    }

    private final Button.OnClickListener GoW = new Button.OnClickListener() {
        public void onClick(View v){ mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(West,15)); }
    };
    private final Button.OnClickListener GoM = new Button.OnClickListener() {
        public void onClick(View v){
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Main,15));
        }
    };
    private final Button.OnClickListener GoB = new Button.OnClickListener() {
        public void onClick(View v){
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Back,15));
        }
    };
    private final Button.OnClickListener GoC = new Button.OnClickListener() {
        public void onClick(View v){
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Center,15));
        }
    };


    public Marker addMarker(MarkerItem markerItem){
        LatLng position = new LatLng(markerItem.getlat(),markerItem.getlon());
        String title = markerItem.getTitle();
        int tag = markerItem.gettag();
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title(title);
        markerOptions.position(position);

        switch (tag){
            case 1:
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.shirt)));
                break;
            case 2:
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.pant)));
                break;
            case 3:
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.shoes)));
                break;
            case 4:
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.cap)));
                break;
            case 5:
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.watch)));
                break;
        }
        return mMap.addMarker(markerOptions);
    }
}