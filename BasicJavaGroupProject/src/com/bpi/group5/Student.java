package com.bpi.group5;

public class Student {

	static String varStudentName;
	static String varStudentId;
	static double[] varStudentGrades;
	static double varStudentAvg;
	static String varStudentStatus;
	
	
	public static String getVarStudentName() {
		return varStudentName;
	}
	public static void setVarStudentName(String varStudentName) {
		Student.varStudentName = varStudentName;
	}
	public static String getVarStudentId() {
		return varStudentId;
	}
	public static void setVarStudentId(String varStudentId) {
		Student.varStudentId = varStudentId;
	}
	public static double[] getVarStudentGrades() {
		return varStudentGrades;
	}
	public static void setVarStudentGrades(double[] varStudentGrades) {
		Student.varStudentGrades = varStudentGrades;
	}
	public static double getVarStudentAvg() {
		return varStudentAvg;
	}
	public static void setVarStudentAvg(double varStudentAvg) {
		Student.varStudentAvg = varStudentAvg;
	}
	public static String getVarStudentStatus() {
		return varStudentStatus;
	}
	public static void setVarStudentStatus(String varStudentStatus) {
		Student.varStudentStatus = varStudentStatus;
	}

}
