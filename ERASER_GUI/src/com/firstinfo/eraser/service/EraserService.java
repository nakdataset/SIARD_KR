package com.firstinfo.eraser.service;

import java.util.Hashtable;
import java.util.Vector;

/**
 * 처분 프로그램 인터페이스
 * 
 * @author 국가기록원
 *
 */
public interface EraserService
{
	/**
	 * 처분 스크립트를 저장한다. >> txt파일 생성
	 * 
	 * @param title
	 * @param date
	 * @param desc
	 * @param sql
	 * @return String
	 */
	public String erasercreate(String title, String date, String desc, String sql);

	/**
	 * 처분 스크립트를 삭제한다. >> txt파일 삭제
	 * 
	 * @param number
	 * @return boolean
	 */
	public boolean eraserdelete(String number);

	/**
	 * 처분 스크립트를 조회한다. >> txt파일 조회
	 * 
	 * @param number
	 * @return Hashtable
	 */
	public Hashtable eraserview(String number);

	/**
	 * 처분 스크립트 목록조회 >> txt파일 조회
	 * 
	 * @return Vector
	 */
	public Vector eraserlist();

	/**
	 * 처분 스크립트 변경 >> 기존 txt파일 삭제 -> 신규 txt파일 생성
	 * 
	 * @param number
	 * @param title
	 * @param date
	 * @param desc
	 * @param sql
	 * @return boolean
	 */
	public boolean eraserchange(String number, String title, String date, String desc, String sql);

	/**
	 * DBMS 접속정보 저장 >> db.properties에 접속정보 저장
	 * 
	 * @param dbsystem
	 * @param address
	 * @param sid
	 * @param user
	 * @param pw
	 * @param jdbc
	 * @return boolean
	 */
	public boolean dbconfigsave(String dbsystem, String address, String sid, String user, String pw, String jdbc);

	/**
	 * DBMS 접속정보 조회
	 * 
	 * @return Hashtable
	 */
	public Hashtable dbconfigview();

	/**
	 * 처분 스크립트 실행 >> DBMS 접속 -> txt파일의 sql읽기 -> sql실행
	 * 
	 * @param number
	 * @param title
	 * @param test
	 * @param onecommit
	 * @return Hashtable
	 */
	public Hashtable eraserexecute(String number, String title, String test, String onecommit, String comment);

	/**
	 * 처분 스크립트 실행 >> DBMS 접속 -> txt파일의 sql읽기 -> sql실행
	 * 
	 * @param number
	 * @param title
	 * @param test
	 * @param onecommit
	 * @return Hashtable
	 */
	public Hashtable eraserexecute(Hashtable hash);

	/**
	 * 처분 스크립트 실행이력 조회
	 * 
	 * @return Vector
	 */
	public Vector historyview();

	/**
	 * 처분 스크립트 실행 SQL 조회
	 * 
	 * @return Vector
	 */
	public String historysqlview(String sql_time);

	/**
	 * 관리자 정보 저장(생성, 수정) >> txt파일 생성
	 * 
	 * @param depart
	 * @param grade
	 * @param name
	 * @param password
	 * @return boolean
	 */
	public boolean managersave(String depart, String grade, String name, String password);

	/**
	 * 관리자 정보 조회
	 * 
	 * @return Hashtable
	 */
	public Hashtable managerview();

	/**
	 * 평가의견 조회
	 * 
	 * @return String
	 */
	public String commentview(String datetime);
}