package com.eomcs.basic.ex06;

//# 흐름 제어문 - do ~ while 반복문
//
public class Exam3_4 {
  public static void main(String[] args) {
    int i = 0;

    // 1부터 10까지 출력하기
    do 
      System.out.println(++i);   //0+1=1을 
    while (i < 10);              //i에 넣고 반복

    System.out.println("---------------------");

    // 여러 개의 문장을 반복할 때는 블록으로 묶어라!
    i = 0;
    do {
      i += 1;
      System.out.println(i);
    } while (i < 10);
  }
}
