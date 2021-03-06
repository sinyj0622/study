// 활용 - 지정한 폴더에서 .class 파일만 찾아 출력하라.
package com.eomcs.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0730x {


  public static void main(String[] args) throws Exception {


    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printList(dir);

  }

  static void printList(File dir) {

    // 현재 디렉토리의 하위 파일 및 디렉토리 목록을 알아낸다


    class FileFilter2 implements FileFilter {

      @Override
      public boolean accept(File pathname) {
        if (pathname.isHidden()) {
          return false;
        }
        if (pathname.getName().contains("$")) {
          return false;
        }
        if (pathname.isDirectory() | (pathname.isFile() && pathname.getName().endsWith(".class"))) {
          return true;
        }

        return false;
      }

      File[] files = dir.listFiles(new FileFilter2());
    }


    // 리턴 받은 파일 배열에서 이름을 꺼내 출력한다
    for (File file : files) {
      if (file.isDirectory()) {
        printList(file); // 하위 디렉토리로 들어가라
      } else {
        System.out.printf("%s\n", file.getName());
      }
    }

  }
}


