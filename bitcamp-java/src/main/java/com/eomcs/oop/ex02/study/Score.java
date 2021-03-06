package com.eomcs.oop.ex02.study;

public class Score {
  // 변수 선언을 사용하여 메모리 구조 설계 : 인스턴스 변수
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;


  // 메서드를 통해 값을 계산하는 기능을 추가 : 연산자 정의
  // 합계과 평균을 계산하는 기능을 추가
  // 메서드를 다음과 같이 호출할때
  // 인스턴스주소.메서드명();
  // 인스턴스 주소를 자동으로 받는 메서드 문법이 있다
  // "인스턴스 메서드"이다
  // 인스턴스 메서드는 static을 붙이지 않는다
  // 메서드를 호출할때 넘겨준 인스턴스 주소는 내장 변수 this에 자동 보관된다
  // 인스턴스 메서드는 인스턴스 주소 없이 호출할수 없다

  public void calculate() {
    // 인스턴스 메서드는 인스턴스 주소를 받는 내장 변수가 있다
    // 그 변수의 이름은 this
    // 인스턴스 메소드 = 인스턴스 객체를 다루기 쉽도록 만드는 연산자!!오퍼레이터!!!!!!!!
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }

}