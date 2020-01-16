package com.eomcs.util;

import java.util.Arrays;

public class Stack<E> implements Cloneable{

  private static final int DEFAULT_CAPCITY = 10;

  Object[] elementData;
  int size;

  public Stack() {
    this.elementData = new Object[DEFAULT_CAPCITY];
    this.size = 0;
  }

  public void push(E value) {
    if (size == elementData.length) {
      grow();
    }
    this.elementData[size++] = value;
  }

  private void grow() {
    this.elementData = Arrays.copyOf(elementData, newCapacity());
  }

  private int newCapacity() {
    int oldCapacity = this.elementData.length;
    return oldCapacity + (oldCapacity >> 1);
  }

  @SuppressWarnings("unchecked")
  public E pop() {
    if (this.empty())
      return null;
    E value = (E)this.elementData[--this.size];
    this.elementData[this.size] = null; //꺼낸주소를 null로 만듬
    return value;
  }

  public boolean empty() {
    return this.size == 0;
  }
  // Object.clone()의 'shallow copy'이용하여 스택 객체 복사하기
  //=> 객체의 인스턴스 변수를 그대로 복제한다.
  //=> 인스턴스 변수가 가리키는 객체는 복제하지 않는다.
  //
  // 문제점?
  //=> 따라서 인스턴스 변수인 elementData가 가리키는 배열을 복제하지 않는다
  //=> 그래서 배열의 값을 바꾸면 원본 스택에도 영향을 끼친다.
  /* 
   * 
 @Override
 public Stack clone() {
   try {
  return (Stack)super.clone();
   } catch (CloneNotSupportedException ex) {
     // object의 clone() 메서드는 복제가 허용된 객체에 대해서만 해당 인스턴스 변수를 복제한다.
     // 복제가 허용되지 않은 객체에 대해서 clone()을 호출하면
     // CloneNotSupportedException 실행오류가 발생한다.
     // 해결책?
     //  => 해당 클래스의 객체를 복제 할 수 있음을 표시하라.
     // => 방법 : cloneable 인터페이스를 지정해야 한다.
     //     예) class MY implements Cloneable{...}
     System.out.println(ex);
     return null;
   }
}
   */

  // deep copy를 이용하여 객체 복사하기
  // => 데이터가 들어있는 배열도 그대로 복제한다.
  // => 따라서 배열의 값을 바꾸더라도 원본 객체에 영향을 끼치지 않는다.
  //
  @SuppressWarnings("unchecked")
  @Override
  public Stack<E> clone() {
    try {
    // 1) shallow copy를 통해 '이 객체의 인스턴스 변수'는 그대로 복제한다
    Stack<E> temp = (Stack<E>) super.clone();
    
    //2) elementData 배열을 복제
    // => 배열만 복제하고 배열에 저장된 객체(ex: 문자열,member객체)까지는 복제하지 않는다
    // => 어디까지 복제(deep copy의 수준)할 것인지는 상황에 따라 결정한다.
    //
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.elementData[i];
    }
    
    //3) 복제한 스택 객체가 새로 만든 배열을 가리키도록 한다
    temp.elementData = arr;
    
    return temp;
    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }

  
  //non-static 메서드안에 로컬 클래스는 인스턴스 주소를 가질수 있기 때문에 this사용가능..
  public Iterator<E> iterator() {
    // this = 인스턴스 주소;
    
  // local class : 특정 메서드안에서만 사용되는 클래스라면 그 메서드 안에 로컬 클래스로 정의하라.
    class StackIterator<T> implements Iterator<T> {
    Stack<T> stack;  
    
    @SuppressWarnings("unchecked")
    public StackIterator() {
      this.stack = (Stack<T>) Stack.this.clone();
    }
    
    @Override
    public boolean hasNext() {
      return !stack.empty();
    }
    
    @Override
    public T next() {
      return stack.pop();
    }
  }
    // 로컬 클래스의 인스턴스를 생성할때 바깥 클래스(Stack)의 인스턴스 주소를 줘서는 안된다.
    // 즉 생성자를 호출하는 앞쪽에 this를 붙여서는 안된다.
    return new StackIterator<E>();
  }
  
  
  
  
 /*   스태틱 메서드안에 로컬클래스는 인스턴스 주소가 없기 때문에 this 주소가 없다......
  static void m1() {
    // 스태틱 메서드는 클래스 이름으로 바로 호출할 수 있기 때문에 this 변수가 없다
    // 예 Stack.m1();
    
    
    // 스태틱 메서드에서 로컬 클래스를 정의한다면,
    // 그 로컬 클래스는 바깥 클래스의 인스턴스를 직접 접근할 수 없다
     * 
    class A {
     A(){
       Stack s;
       // s = Stack.this; // 컴파일 오류!
       // 이 로컬 클래스는 m1()에서 사용할 것이다
       // m1()은 바깥 클래스의 인스턴스 주소를 모른다
       // 그런데 로컬 클래스에서 위와같이 바깥 클래스의 인스턴스를 사용하려 한다면
       // 문제가 될 것이다.
       // 이런 상황을 방지하고자 자바는 그래서 컴파일 오류를 발생시킨다.
     }
    }
  }
  */

    
  
  
}
