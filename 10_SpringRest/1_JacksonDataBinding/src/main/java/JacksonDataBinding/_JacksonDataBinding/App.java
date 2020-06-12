package JacksonDataBinding._JacksonDataBinding;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import JacksonDataBinding._JacksonDataBinding.jackson.demo.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
        	
        	ObjectMapper mapper = new ObjectMapper();
        	Student student = mapper.readValue(new File("D:\\JavaWebServicesPractice\\Spring\\10_SpringRest\\JsonData\\sample-full.json"), Student.class);
        	System.out.println("First Name : " + student.getFirstName()); // First Name : Mario
        	System.out.println("Address : " + student.getAddress()); // Address : JacksonDataBinding._JacksonDataBinding.jackson.demo.Address@7c0e2abd
        	System.out.println("City : " + student.getAddress().getCity()); // City : Philadelphia
        	System.out.println("Languages : " + student.getLanguages()); // Languages : [Ljava.lang.String;@48eff760
        	System.out.println("Languages : " + student.getLanguages()[0]); // Languages : Java
        	
        	String[] languages = student.getLanguages();
        	for (String s : languages) {
				System.out.println("Indevidual languages : " + s);
			}
        	/*
        	 * Indevidual languages : Java
				Indevidual languages : C#
				Indevidual languages : Python
				Indevidual languages : Javascript
        	 */
        	
        }catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
