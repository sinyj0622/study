package com.eomcs.util;

import java.lang.reflect.Array;

public class LinkedList<E> {

  Node<E> first; 

  Node<E> last;

  int size;

  public void add(E value) {
    Node<E> newNode = new Node<E>();
    newNode.value = value;

    if (first == null) {
      last = first = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }

    this.size++;
  }


  public E get(int index) {
    if (index < 0 || index >= size)
      return null;

    Node<E> cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    return cursor.value;

  }


  public void add(int index, E value) { //insert인 경우
    if (index < 0 || index >= size)
      return;

    Node<E> newNode = new Node<>();
    newNode.value = value;

    Node<E> cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }

    if (index == 0) {
      newNode.next = first;
      first = newNode;

    } else {
      newNode.next = cursor.next;
      cursor.next = newNode;
    }


    this.size++;
  }

  
  public E remove(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node<E> cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    
    Node<E> deletedNode = null;
    if (index == 0) {
      deletedNode = first;
      first = deletedNode.next;
    } else {
    Node deleteNode = cursor.next;
    cursor.next = deleteNode.next;
    }
    deletedNode.next = null; //삭제하는노드
    size--;
    
    return deletedNode.value; 
  }
  
  public E set(int index, E value) {
    if (index < 0 || index >= size)
      return null;

    Node<E> cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    E oldValue = cursor.value;
    cursor.value = value;
    
    return oldValue;

  }
  
  public Object[] toArray() { // 목록의 값을 배열로 가져옴
    Object[] arr = new Object[size];
    Node<E> cursor = first;
    
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next; //다음칸으로 이동
    }
    
    return arr;
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) { // 목록의 값을 배열로 가져옴
    
    if (arr.length < this.size) {
      arr = (E[]) Array.newInstance(arr.getClass().getComponentType(), size);
    }
    Node<E> cursor = first;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next; //다음칸으로 이동
    }
    
    return arr;
  }
  
  static class Node<T> {
    T value;
    Node<T> next;
  }
  
  public int size() {
    return this.size;
  }
}
