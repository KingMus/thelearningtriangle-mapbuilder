package de.thelearningtriangle.mapbuilder.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

/**
 * this class loads and writes map from/in files
 * 
 * @author Marco Mueller
 *
 */
public class FileController {

	// information from author: bad usage of arrays. TODO change later to better
	// data type

	/**
	 * this method reads a file and creates an int-Arrays from the values
	 * 
	 * @return int[][] array, which contains the field types from the map as int
	 *         values
	 * @author Marco Mueller
	 * @param file
	 *            - a file which should be used
	 */
	public static Field[][] parseMapFromFile(File file) {

		BufferedReader br = null;
		String splitChar = ",";

		String line = "";

		List<String[]> fileData = new ArrayList<String[]>();
		Field[][] map = null;

		try {

			br = new BufferedReader(new FileReader(file));

			while ((line = br.readLine()) != null) {

				String[] oneLineOfData = line.split(splitChar);
				fileData.add(oneLineOfData);

			}

			map = new Field[fileData.size()][fileData.size()];

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Field.of(Integer.parseInt(fileData.get(i)[j]));
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return map;

	}

	/**
	 * creates a file from a given map
	 * 
	 * @param map
	 *            - the game map
	 * @author Marco Mueller
	 */
	public static void parseFileFromMap(Field[][] map) {
		PrintWriter fileWriter = null;

		try {
			JFileChooser fc = new JFileChooser();
			fc.showSaveDialog(null);

			fileWriter = new PrintWriter(new FileWriter(fc.getSelectedFile().getPath()));

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					fileWriter.print("" + map[i][j].getValue());

					if (j < map.length - 1) {
						fileWriter.print(",");
					}

				}

				fileWriter.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null)
				fileWriter.close();
		}

	}

}
