package com.eomcs.basic.ex99;

import java.util.Scanner;

public class assign2 {
  public static void main(String[] args){
// 과제 1 : 가위,바위,보 게임 애플리케이션을 작성하라.
// - 실행1
// 가위,바위,보? 보
// 컴퓨터: 가위  (랜덤 값이 출력된다. 힌트: Math.random())
// => 졌습니다.
//
// - 실행2
// 가위,바위,보? 바위
// 컴퓨터: 가위
// => 이겼습니다.

Scanner keyboard = new Scanner(System.in);

String user;
int computer;

System.out.print("가위,바위,보? ");
user = keyboard.nextLine();


System.out.println("컴퓨터: ");
computer = (int) (Math.random() * 3) + 1; 

if (computer){
  System.out.println("");
}


if (user.equals("가위")){
  users = 1; }
  else if(user.equals("바위")){
    users = 2; }
    else if(user.equals("바위")){
      users = 3; };



System.out.println("=> 졌습니다.");








  }
}