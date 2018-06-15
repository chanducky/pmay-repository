package com.mcs.pmay.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chandrakumar
 *
 */
@RestController
@ConfigurationProperties("image.path")
public class ImageDownloadController {
	private String applicantPhoto;
	private String bplCardPhoto;
	private String idProofPhoto;
	private String incomeProofPhoto;
	private String landPhoto1;
	private String landPhoto2;
	private String pattaPhoto;
	private String presentHousePhoto;
	private String rationCardPhoto;
	private String signature;
	private String tempForZip;

	public String getApplicantPhoto() {
		return applicantPhoto;
	}

	public void setApplicantPhoto(String applicantPhoto) {
		this.applicantPhoto = applicantPhoto;
	}

	public String getBplCardPhoto() {
		return bplCardPhoto;
	}

	public void setBplCardPhoto(String bplCardPhoto) {
		this.bplCardPhoto = bplCardPhoto;
	}

	public String getIdProofPhoto() {
		return idProofPhoto;
	}

	public void setIdProofPhoto(String idProofPhoto) {
		this.idProofPhoto = idProofPhoto;
	}

	public String getIncomeProofPhoto() {
		return incomeProofPhoto;
	}

	public void setIncomeProofPhoto(String incomeProofPhoto) {
		this.incomeProofPhoto = incomeProofPhoto;
	}

	public String getLandPhoto1() {
		return landPhoto1;
	}

	public void setLandPhoto1(String landPhoto1) {
		this.landPhoto1 = landPhoto1;
	}

	public String getLandPhoto2() {
		return landPhoto2;
	}

	public void setLandPhoto2(String landPhoto2) {
		this.landPhoto2 = landPhoto2;
	}

	public String getPattaPhoto() {
		return pattaPhoto;
	}

	public void setPattaPhoto(String pattaPhoto) {
		this.pattaPhoto = pattaPhoto;
	}

	public String getPresentHousePhoto() {
		return presentHousePhoto;
	}

	public void setPresentHousePhoto(String presentHousePhoto) {
		this.presentHousePhoto = presentHousePhoto;
	}

	public String getRationCardPhoto() {
		return rationCardPhoto;
	}

	public void setRationCardPhoto(String rationCardPhoto) {
		this.rationCardPhoto = rationCardPhoto;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTempForZip() {
		return tempForZip;
	}

	public void setTempForZip(String tempForZip) {
		this.tempForZip = tempForZip;
	}

	@RequestMapping(value = "/downLoadFilesInZip", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<InputStreamResource> downLoadFilesInZip(@RequestBody Map<String, String> images)
			throws IOException {
		File[] files = new File[10];
		File serverFile = null;
		serverFile = new File(applicantPhoto + File.separator + images.get("applicantPhotoName"));
		if (serverFile.exists()) {
			files[0] = serverFile;
		}
		serverFile = new File(bplCardPhoto + File.separator + images.get("bplPhotoName"));
		if (serverFile.exists()) {
			files[1] = serverFile;
		}
		serverFile = new File(idProofPhoto + File.separator + images.get("idPhotoName"));
		if (serverFile.exists()) {
			files[2] = serverFile;
		}
		serverFile = new File(incomeProofPhoto + File.separator + images.get("incomeProofPhotoName"));
		if (serverFile.exists()) {
			files[3] = serverFile;
		}
		serverFile = new File(landPhoto1 + File.separator + images.get("landPhoto1Name"));
		if (serverFile.exists()) {
			files[4] = serverFile;
		}
		serverFile = new File(landPhoto2 + File.separator + images.get("landPhoto2Name"));
		if (serverFile.exists()) {
			files[5] = serverFile;
		}
		serverFile = new File(pattaPhoto + File.separator + images.get("landRecordPhotoName"));
		if (serverFile.exists()) {
			files[6] = serverFile;
		}
		serverFile = new File(presentHousePhoto + File.separator + images.get("presentInfrontHousePhotoName"));
		if (serverFile.exists()) {
			files[7] = serverFile;
		}
		serverFile = new File(rationCardPhoto + File.separator + images.get("rationCardPhotoName"));
		if (serverFile.exists()) {
			files[8] = serverFile;
		}
		serverFile = new File(signature + File.separator + images.get("applicantSignatureName"));
		if (serverFile.exists()) {
			files[9] = serverFile;
		}
		// String dirPath = "F:\\tempzip";
		//String home = System.getProperty("user.home");
		File dir = new File(tempForZip);
		if(!dir.exists()) {
			dir.mkdir();
		}
		File zipFileName = new File(tempForZip+images.get("surveyId") + "_images.zip");
		System.out.println("Zip file name from image controller=="+zipFileName.getAbsolutePath() + "::--::"+ zipFileName.getName());
		// File zipFileName = new File(tempForZip + "\\tempzip.zip");
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
		zipFiles(files, out);
		out.close();
		File file2Upload = new File(tempForZip+images.get("surveyId") + "_images.zip");
		// File file2Upload = new File(tempForZip + "\\tempzip.zip");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Pragma", "no-cache");
		headers.add("Content-Disposition", "attachment; filename=" + images.get("surveyId") + "_images.zip");
		InputStreamResource inputRsc = new InputStreamResource(new FileInputStream(file2Upload));
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM).body(inputRsc);
	}

	public static void zipFiles(File[] files, ZipOutputStream zos) {
		try {
			byte[] buffer = new byte[1024];
			for (int i = 0; i < files.length; i++) {
				if (files[i] != null && files[i].isFile()) {
					FileInputStream in = new FileInputStream(files[i]);
					zos.putNextEntry(new ZipEntry(files[i].getName()));
					int len;
					while ((len = in.read(buffer)) > 0) {
						zos.write(buffer, 0, len);
					}
					// out.closeEntry();
					in.close();
				}
			}
			// out.close();
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void zipDirectory(String dirPath, ZipOutputStream zos) throws IOException {
		File f = new File(dirPath);
		String[] flist = f.list();
		for (int i = 0; i < flist.length; i++) {
			File ff = new File(f, flist[i]);
			if (ff.isDirectory()) {
				zipDirectory(ff.getPath(), zos);
				continue;
			}
			String filepath = ff.getPath();
			ZipEntry entries = new ZipEntry(filepath);
			zos.putNextEntry(entries);
			FileInputStream fis = new FileInputStream(ff);
			int buffersize = 1024;
			byte[] buffer = new byte[buffersize];
			int count;
			while ((count = fis.read(buffer)) != -1) {
				zos.write(buffer, 0, count);
			}
			fis.close();
		}
	}

	@RequestMapping(value="/showImage" ,method=RequestMethod.GET)
	public void showImage(@RequestParam("filename") String filename, HttpServletResponse response) {
		try {
			
			StringBuilder filePathBuilder = new StringBuilder();
			
			if(filename.contains("pplicantPhoto")) {
				filePathBuilder.append(getApplicantPhoto());
				filePathBuilder.append(File.separator);
				filePathBuilder.append(filename);
				
			}else if(filename.contains("applicantSignature")) {
				filePathBuilder.append(getSignature());
				filePathBuilder.append(File.separator);
				filePathBuilder.append(filename);
			}else if(filename.contains("presentInfrontHousePhoto")) {
				filePathBuilder.append(getPresentHousePhoto());
				filePathBuilder.append(File.separator);
				filePathBuilder.append(filename);
			}
			
			File file = new File(filePathBuilder.toString());
			if(file.exists() && (! file.isDirectory())) {

				FileInputStream fis = new FileInputStream(file);

				byte[] bufferData = new byte[1024];
				int read=0;

				response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
				ServletOutputStream os = response.getOutputStream();
				
				while((read = fis.read(bufferData))!= -1){
					os.write(bufferData, 0, read);
				}
				os.flush();
				os.close();
				fis.close();
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
