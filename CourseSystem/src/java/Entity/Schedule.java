/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author ASUS
 */
public class Schedule {
    private String CNo;
    private String CName;
    private String TName;
    private int TimeNo;
    private String PlaceNo;
    private int CKind;
    private int LeftNum;
    private int WeekNo;
    public Schedule(String cno,String cname,String tname,int timeno,String placeno,int ckind,int leftnum,int weekno){
        this.CName=cname;
        this.CNo=cno;
        this.CKind=ckind;
        this.LeftNum=leftnum;
        this.TimeNo=timeno;
        this.PlaceNo=placeno;
        this.TName=tname;
        this.WeekNo=weekno;
    }
    public Schedule(String cno,String cname,String tname,int ckind){
        this.CName=cname;
        this.CNo=cno;
        this.CKind=ckind;
        this.TName=tname;
    }
    public String getCNo(){
        return this.CNo;
    }
    public String getCName(){
        return this.CName;
    }
    public int getLeftNum(){
        return this.LeftNum;
    }
    public int getCKind(){
        return this.CKind;
    }
    public String getTName(){
        return this.TName;
    }
    public int getTimeNo(){
        return this.TimeNo;
    }
    public String getPlaceNo(){
        return this.PlaceNo;
    }
    public int getWeekNo(){
        return this.WeekNo;
    }
    
    public void setCNo(String cno){
        this.CNo=cno;
    }
    public void setCName(String cname){
        this.CName=cname;
    }
    public void setLeftNum(int leftnum){
        this.LeftNum=leftnum;
    }
    public void setCKind(int ckind){
        this.CKind=ckind;
    }
    public void getTName(String tname){
        this.TName=tname;
    }
    public void getTimeNo(int timeno){
        this.TimeNo=timeno;
    }
    public void getPlaceNo(String placeno){
        this.PlaceNo=placeno;
    }
    public void getWeekNo(String weekno){
        this.PlaceNo=weekno;
    }
}
