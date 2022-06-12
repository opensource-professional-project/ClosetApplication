package com.example.closet_project;


public class MarkerItem{
  double lat;
  double lon;
  String title;
  int tag;
  public MarkerItem(double lat,double lon, String title,int tag){
      this.lat=lat;
      this.lon=lon;
      this.title=title;
      this.tag=tag;
  }

    public void setlat(double lat){ this.lat=lat; }
    public void setlon(double lon){ this.lon=lon; }
    public void setTitle(String title){ this.title=title; }
    public void settag(int tag){ this.tag=tag; }
    public double getlat(){ return lat; }
    public double getlon(){ return lon; }
    public String getTitle(){ return title; }
    public int gettag(){ return tag; }
}
