package com.niyue.fling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class BoardLoader {
	private static final String FBALL = "FBALL";
	public static Board load(String filePath) {
		try {
			return load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			System.err.println("Fail to load board file " + e.getMessage());
			throw new IllegalArgumentException(e);
		}
	}
	
	public static Board load(InputStream inputStream) {
		return load(new InputStreamReader(inputStream));
	}
	
	private static Board load(Reader reader) {
		CSVReader csvReader;
		try {
			csvReader = new CSVReader(reader);
			List<String[]> boardCsv = csvReader.readAll();
			boolean[][] status = new boolean[Board.DEFAULT_HEIGHT][Board.DEFAULT_WIDTH];
			for(int y=0;y<boardCsv.size();y++) {
				String[] row = boardCsv.get(y);
				for(int x=0;x<row.length;x++) {
					status[y][x] = FBALL.equals(row[x].trim()); 
				}
			}
			return new Board(status);
		} catch (Exception e) {
			System.err.println("Fail to load board file " + e.getMessage());
			throw new IllegalArgumentException(e);
		}
	}
}
