package com.company;

public class Jumper {
    int startPosition;
    int endPosition;
    public Jumper(int startPosition,int endPosition)
    {
        this.startPosition=startPosition;
        this.endPosition=endPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }
}
