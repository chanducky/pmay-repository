package com.mcs.pmay.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author chandrakumar
 *
 */
@Component
public class ImageUpload {
	private ImageUpload() {
	}

	public static void SaveImage(MultipartFile file, String fileName, String directory) {
		if (file != null) {
			try {
				byte[] bytes = file.getBytes();
				File dir = new File(File.separator + directory);
				System.out.println("directory is  : " + dir.getAbsolutePath());

				System.out.println(!dir.exists());
				if (!dir.exists()) {
					System.out.println("dir created.");
					dir.mkdirs();
				}
				File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
				if (serverFile.exists()) {
					serverFile.delete();
				}
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				System.out.println("You successfully uploaded file :" + fileName);
			} catch (Exception e) {
				System.out.println("You failed to upload " + e);
			}
		} else {
			System.out.println("You failed to upload " + fileName + " because the file was empty.");
		}

	}

}
