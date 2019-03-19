package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {

	private String upload_folder="D:/F/temp/";
	
	@GetMapping("/")
	public String index() {
	return "upload";
	}
	
//	@PostMapping("/upload") 
//    public String singleFileUpload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) {
//
//        if (file.isEmpty()) {
//            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//            return "redirect:uploadStatus";
//        }
//
//        try {
//
//            // Get the file and save it somewhere
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(upload_folder + file.getOriginalFilename());
//            Files.write(path, bytes);
//
//            redirectAttributes.addFlashAttribute("message",
//                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
//            		
//            try
//            {  
//
////             Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"D:\\K\\bin\\kibana.bat\""); 
////             Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"D:\\E\\bin\\elasticsearch.bat\""); 
////             Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"D:\\F\\batchfileF.bat\"");
////             Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"D:\\L\\bin\\batchfileL.bat\""); 
//            	
//                Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"D:\\cdbatch.bat\""); 
//            } 
//            catch (Exception e) 
//            { 
//                System.out.println("HEY Buddy ! U r Doing Something Wrong. You're a horrible person, buddy. "); 
//                e.printStackTrace(); 
//            } 
//            
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "redirect:/uploadStatus";
//    }
	
	@PostMapping("/upload")
	public String addPaths(@RequestParam("paths") String paths) throws IOException {
	
		File configFile=new File("D:\\F\\filebeat.yml");
		if(configFile.exists())
		{
			  String[] words=null; 
			  FileReader fr = null;
			  String s,putData;
			try {
				fr = new FileReader(configFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  //Creation of File Reader object
		      BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object	
		      while((s=br.readLine())!=null)   //Reading Content from the file
		      {
		         words=s.split(" ");  //Split the word using space
		          for (String word : words) 
		          {
		                 if (word.equals("paths:"))   //Search for the given word
		                 {
		                	  putData = s.replaceAll("paths:", "paths"+paths);
		                	  FileWriter fw = new FileWriter(configFile);
		                      BufferedWriter bw = new BufferedWriter(fw);
		                      bw.write("Some text here for a reason");
		                      bw.write(putData);
		                 }
		          }
		      }
		} 
		return "redirect:/uploadStatus";
		}
	
	
	
	  @GetMapping("/uploadStatus")
	    public String uploadStatus() {
	        return "uploadStatus";
	    }

}
