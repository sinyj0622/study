package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.sql.Connection;
import java.util.Scanner;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.util.ConnectionFactory;
import com.eomcs.util.Prompt;

public class PhotoBoardDeleteServlet implements Servlet {

  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;
  ConnectionFactory conFactory;

  public PhotoBoardDeleteServlet(PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao,
      ConnectionFactory conFactory) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
    this.conFactory = conFactory;
  }



  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "번호? ");

    // 트랜잭션 시작
    Connection con = conFactory.getConnection();
    // 사진 게시글을 삭제전 먼저 자식테이블에 있는 첨부파일 데이터를 삭제한다.
    con.setAutoCommit(false);

    try {
      if (photoFileDao.deleteAll(no) == 0) {
        throw new Exception("해당 번호의 사진 게시글이 없습니다.");
      }

      if (photoBoardDao.delete(no) > 0) {
        con.commit();
        out.println("사진 게시글을 삭제했습니다.");

      }
    } catch (Exception e) {
      out.println(e.getMessage());
      con.rollback();
    } finally {
      con.setAutoCommit(true);
    }
  }
}
