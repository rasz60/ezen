package com.wvwv.upanddownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
//@MultipartConfig("filesize")로 지정할 수 있다.
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "upload";
	}
	
	@RequestMapping("/uploadSingle")
	// 업로드한 파일은 MultipartHttpServletRequest 객체로 받을 수 있다.
	public String uploadSingle(MultipartHttpServletRequest mtpRequest, Model model) {

		// input name = "src"로 넘어온 파라메터를 받는다. (예제에서는 업로더 이름)
		String src = mtpRequest.getParameter("src");
		System.out.println(src);
		
		// form에 업로드해서 보낸 파일을 받는 인터페이스
		MultipartFile mf = mtpRequest.getFile("s_file");
		
		// upload된 파일의 저장 경로 지정 ( path1 : eclipse project 저장 경로 / path2 : WAS 저장 경로[임시] )
		String path1 = "D:/EzenClass/05_Spring-workspace/springUpAndDownLoad/src/main/webapp/resources/upimage/";
		String path2 = "D:/EzenClass/05_Spring-workspace/apache-tomcat-9.0.56/wtpwebapps/springUpAndDownLoad/resources/upimage/";
		
		// upload file original name
		String originalFileName = mf.getOriginalFilename();
		System.out.println(originalFileName);
		
		// fileSize(Byte)
		String size = mf.getSize() + " bytes";
		System.out.println(size);
		
		// 중복되지 않게 currentTimeMillis를 fileName앞에 추가
		long prefix = System.currentTimeMillis();
		
		// upload 파일의 fullpath
		String safeFile1 = path1 + prefix + originalFileName;
		String safeFile2 = path2 + prefix + originalFileName;
		
		// Download시 사용할 파일 이름
		String dFile = prefix + originalFileName;
		System.out.println(dFile);
		
		try {
			// uploadfile을 지정한 경로에 실제 파일로 저장하는 메서드
			mf.transferTo(new File(safeFile1));
			mf.transferTo(new File(safeFile2));
		} catch (Exception e) {
			e.getMessage();
		}
		
		model.addAttribute("author", src);
		model.addAttribute("fileName", dFile);
		model.addAttribute("fileSize", size);
		
		return "download";
	}
	
	
	@RequestMapping("/uploadMulti")
	public String uploadMulti(MultipartHttpServletRequest mtpRequest, Model model) {
		List<MultipartFile> fileList = mtpRequest.getFiles("m_file");
		
		String src = mtpRequest.getParameter("src");
		
		String path1 = "D:/EzenClass/05_Spring-workspace/springUpAndDownLoad/src/main/webapp/resources/upimage/";
		String path2 = "D:/EzenClass/05_Spring-workspace/apache-tomcat-9.0.56/wtpwebapps/springUpAndDownLoad/resources/upimage/";
		
		for (MultipartFile mf : fileList) {
			String originalFileName = mf.getOriginalFilename();
			String fileSize = mf.getSize() + " bytes";
			long prefix = System.currentTimeMillis();

			try {
				mf.transferTo(new File(path1 + prefix + originalFileName));
				mf.transferTo(new File(path2 + prefix + originalFileName));
			} catch (IllegalStateException | IOException e) {
				e.getMessage();
			}
		}
		return "complete";
	}
	
	@RequestMapping("/download")
	public void download(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		System.out.println("download");
		
		String fileName = request.getParameter("file_name");
		String downloadPath = "D:/EzenClass/05_Spring-workspace/springUpAndDownLoad/src/main/webapp/resources/upimage/";
		
		// 파일을 불러와 바이트로 저장
		byte b[] = new byte[4096];
		
		// 파일을 byte단위로 읽어오는 InputStream
		FileInputStream fileInputStream = new FileInputStream(downloadPath + fileName);
		
		// 파일 형식을 나타내는 MimeType을 얻어옴 ( type / subtype  ex> text/plain, text/html, image/jpeg ... ) 
		String sMimeType = request.getServletContext().getMimeType(downloadPath + fileName);
		
		if(sMimeType == null) {
			sMimeType = "application/octet-stream";
		}
		
		// UTF-8 형식으로 된 파일 이름을 8859_1 형식으로 인코딩
		String sEncoding = new String(fileName.getBytes("UTF-8"), "8859_1");
		
		// 파일의 인코딩을 response 객체에 설정
		response.setHeader("Content-Disposition", "attachment; filename = " + sEncoding);
		
		// 읽어온 파일을 클라이언트가 다운로드 할 수 있게 outStream을 사용
		ServletOutputStream servletOutStream = response.getOutputStream();
		
		int numRead;
		
		// inputStream.read(arr, startIndex, lastIndex) = 리턴값이 -1이면 값이 없거나, 마지막 인덱스까지 읽은 상태
		while ( ( numRead = fileInputStream.read(b, 0, b.length) ) != -1 ) {
			servletOutStream.write(b, 0, numRead);
		}
		// servletOutStream buffer clear
		servletOutStream.flush();
		servletOutStream.close();
		
		fileInputStream.close();
	}
}
