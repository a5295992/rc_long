package com.rc_long.test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TestFIleUpload {
	public static void main(String[] args) throws IOException {
		//
		ByteArrayOutputStream out= new ByteArrayOutputStream();
		out.write("dsdsdsdsd".getBytes());
		BufferedOutputStream bout = new BufferedOutputStream(out);
	}
}
