package com.example.energysurvival;

public class Player {

    private String username;
    private double scoreLv1;
    private double scoreLv2;
    private double scoreLv3;

    public Player (){

    }

    public Player (String username, double score){

        this.username = username;
        this.scoreLv1 = score;

    }


    public String getUsername() {
        return username;
    }

    public double getScoreLv1() {
        return scoreLv1;
    }

    public double getScoreLv2() {
        return scoreLv2;
    }

    public double getScoreLv3() {
        return scoreLv3;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setScoreLv1(double scoreLv1) {

        this.scoreLv1 = scoreLv1;

    }

    public void setScoreLv2(double scoreLv1) {

        this.scoreLv2 = scoreLv2;

    }

    public void setScoreLv3(double scoreLv3) {
        this.scoreLv3 = scoreLv3;
    }

}
