package newServlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

//import javax.print.DocFlavor.URL;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Servlet implementation class myPackage
 */
@WebServlet("/myPackage")
public class myPackage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myPackage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//API Setup
		String city = request.getParameter("city");
		String apiKey ="aa68c5f49f959e8c32aa7ab180a53127";
		String APIurl = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apiKey;
	
		//API Integration
		@SuppressWarnings("deprecation")
		URL url = new URL(APIurl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
		//Reading Data from Network
		InputStream inputstream = connection.getInputStream();
		InputStreamReader reader = new InputStreamReader(inputstream);
		System.out.println(inputstream);
		System.out.println(reader);
		
		
		//Want to store it in string
		StringBuilder responseContent = new StringBuilder();
		
		//Create a Scanner object to read from the input
		Scanner sc = new Scanner(reader);
		
		while(sc.hasNext())
		{
			responseContent.append(sc.nextLine());	
		}
		sc.close();
		
		//TypeCasting: Parsing data into JSON
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(responseContent.toString(),JsonObject.class );
		
		 //Date & Time
        long dateTimestamp = jsonObject.get("dt").getAsLong() * 1000;
        String date = new Date(dateTimestamp).toString();
        
        //Temperature
        double temperatureKelvin = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
        int temperatureCelsius = (int) (temperatureKelvin - 273.15);
       
        //Humidity
        int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
        
        //Wind Speed
        double windSpeed = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();
        
        //Weather Condition
        String weatherCondition = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
        
        // Set the data as request attributes (for sending to the jsp page)
        request.setAttribute("date", date);
        request.setAttribute("city", city);
        request.setAttribute("temperature", temperatureCelsius);
        request.setAttribute("weatherCondition", weatherCondition); 
        request.setAttribute("humidity", humidity);    
        request.setAttribute("windSpeed", windSpeed);
        request.setAttribute("weatherData", responseContent.toString());
        
        connection.disconnect();
        
        // Forward the request to the weather.jsp page for rendering
        //request.getRequestDispatcher("index.jsp").forward(request, response);
        
        
        
    	
		//API Setup
        String city2 = "Mumbai";
		String apiKey2 ="aa68c5f49f959e8c32aa7ab180a53127";
		String APIurl2 = "https://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=aa68c5f49f959e8c32aa7ab180a53127";
	
		//API Integration
		@SuppressWarnings("deprecation")
		URL url2 = new URL(APIurl2);
		HttpURLConnection connection2 = (HttpURLConnection) url2.openConnection();
		connection2.setRequestMethod("GET");
		
		//Reading Data from Network
		InputStream inputstream2 = connection2.getInputStream();
		InputStreamReader reader2 = new InputStreamReader(inputstream2);
		
		//Want to store it in string
		StringBuilder responseContent2 = new StringBuilder();
		
		//Create a Scanner object to read from the input
		Scanner sc2 = new Scanner(reader2);
		
		while(sc2.hasNext())
		{
			responseContent2.append(sc2.nextLine());	
		}
		sc2.close();
		
		//TypeCasting: Parsing data into JSON
		Gson gson2 = new Gson();
		JsonObject jsonObject2 = gson2.fromJson(responseContent2.toString(),JsonObject.class );
		
		 //Date & Time
        long dateTimestamp2 = jsonObject2.get("dt").getAsLong() * 1000;
        String date2 = new Date(dateTimestamp2).toString();
        
        //Temperature
        double temperatureKelvin2 = jsonObject2.getAsJsonObject("main").get("temp").getAsDouble();
        int temperatureCelsius2 = (int) (temperatureKelvin2 - 273.15);
       
        //Humidity
        int humidity2 = jsonObject2.getAsJsonObject("main").get("humidity").getAsInt();
        
        //Wind Speed
        double windSpeed2 = jsonObject2.getAsJsonObject("wind").get("speed").getAsDouble();
        
        //Weather Condition
        String weatherCondition2 = jsonObject2.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
        
        // Set the data as request attributes (for sending to the jsp page)
        request.setAttribute("date2", date2);
        request.setAttribute("city2", city2);
        request.setAttribute("temperature2", temperatureCelsius2);
        request.setAttribute("weatherCondition2", weatherCondition2); 
        request.setAttribute("humidity2", humidity2);    
        request.setAttribute("windSpeed2", windSpeed2);
        request.setAttribute("weatherData2", responseContent2.toString());
        connection2.disconnect();
        
        // Forward the request to the weather.jsp page for rendering
//        request.getRequestDispatcher("index.jsp").forward(request, response);
        
        
        

		//API Setup
        String city3 = "Bengaluru";
		String apiKey3 ="aa68c5f49f959e8c32aa7ab180a53127";
		String APIurl3 = "https://api.openweathermap.org/data/2.5/weather?q=Bengaluru&appid=aa68c5f49f959e8c32aa7ab180a53127";
	
		//API Integration
		@SuppressWarnings("deprecation")
		URL url3 = new URL(APIurl3);
		HttpURLConnection connection3 = (HttpURLConnection) url3.openConnection();
		connection3.setRequestMethod("GET");
		
		//Reading Data from Network
		InputStream inputstream3 = connection3.getInputStream();
		InputStreamReader reader3 = new InputStreamReader(inputstream3);
		
		//Want to store it in string
		StringBuilder responseContent3 = new StringBuilder();
		
		//Create a Scanner object to read from the input
		Scanner sc3 = new Scanner(reader3);
		
		while(sc3.hasNext())
		{
			responseContent3.append(sc3.nextLine());	
		}
		sc3.close();
		
		//TypeCasting: Parsing data into JSON
		Gson gson3 = new Gson();
		JsonObject jsonObject3 = gson3.fromJson(responseContent3.toString(),JsonObject.class );
		
		 //Date & Time
        long dateTimestamp3 = jsonObject3.get("dt").getAsLong() * 1000;
        String date3 = new Date(dateTimestamp3).toString();
        
        //Temperature
        double temperatureKelvin3 = jsonObject3.getAsJsonObject("main").get("temp").getAsDouble();
        int temperatureCelsius3 = (int) (temperatureKelvin3 - 273.15);
       
        //Humidity
        int humidity3 = jsonObject3.getAsJsonObject("main").get("humidity").getAsInt();
        
        //Wind Speed
        double windSpeed3 = jsonObject3.getAsJsonObject("wind").get("speed").getAsDouble();
        
        //Weather Condition
        String weatherCondition3 = jsonObject3.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
        
        // Set the data as request attributes (for sending to the jsp page)
        request.setAttribute("date3", date3);
        request.setAttribute("city3", city3);
        request.setAttribute("temperature3", temperatureCelsius3);
        request.setAttribute("weatherCondition3", weatherCondition3); 
        request.setAttribute("humidity3", humidity3);    
        request.setAttribute("windSpeed3", windSpeed3);
        request.setAttribute("weatherData3", responseContent3.toString());
        connection3.disconnect();
        
        // Forward the request to the weather.jsp page for rendering
//        request.getRequestDispatcher("index.jsp").forward(request, response);
        
        

		//API Setup
        String city4 = "Jaipur";
		String apiKey4 ="aa68c5f49f959e8c32aa7ab180a53127";
		String APIurl4 = "https://api.openweathermap.org/data/2.5/weather?q=Jaipur&appid=aa68c5f49f959e8c32aa7ab180a53127";
	
		//API Integration
		@SuppressWarnings("deprecation")
		URL url4 = new URL(APIurl4);
		HttpURLConnection connection4 = (HttpURLConnection) url4.openConnection();
		connection4.setRequestMethod("GET");
		
		//Reading Data from Network
		InputStream inputstream4 = connection4.getInputStream();
		InputStreamReader reader4 = new InputStreamReader(inputstream4);
		
		//Want to store it in string
		StringBuilder responseContent4 = new StringBuilder();
		
		//Create a Scanner object to read from the input
		Scanner sc4 = new Scanner(reader4);
		
		while(sc4.hasNext())
		{
			responseContent4.append(sc4.nextLine());	
		}
		sc4.close();
		
		//TypeCasting: Parsing data into JSON
		Gson gson4 = new Gson();
		JsonObject jsonObject4 = gson4.fromJson(responseContent4.toString(),JsonObject.class );
		
		 //Date & Time
        long dateTimestamp4 = jsonObject4.get("dt").getAsLong() * 1000;
        String date4 = new Date(dateTimestamp4).toString();
        
        //Temperature
        double temperatureKelvin4 = jsonObject4.getAsJsonObject("main").get("temp").getAsDouble();
        int temperatureCelsius4 = (int) (temperatureKelvin4 - 273.15);
       
        //Humidity
        int humidity4 = jsonObject4.getAsJsonObject("main").get("humidity").getAsInt();
        
        //Wind Speed
        double windSpeed4 = jsonObject4.getAsJsonObject("wind").get("speed").getAsDouble();
        
        //Weather Condition
        String weatherCondition4 = jsonObject4.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
        
        // Set the data as request attributes (for sending to the jsp page)
        request.setAttribute("date4", date4);
        request.setAttribute("city4", city4);
        request.setAttribute("temperature4", temperatureCelsius4);
        request.setAttribute("weatherCondition4", weatherCondition4); 
        request.setAttribute("humidity4", humidity4);    
        request.setAttribute("windSpeed4", windSpeed4);
        request.setAttribute("weatherData4", responseContent4.toString());
        connection4.disconnect();
        
        // Forward the request to the weather.jsp page for rendering
//        request.getRequestDispatcher("index.jsp").forward(request, response);
        
        
    	//API Setup
        String city5 = "Ooty";
		String apiKey5 ="aa68c5f49f959e8c32aa7ab180a53127";
		String APIurl5 = "https://api.openweathermap.org/data/2.5/weather?q=Ooty&appid=aa68c5f49f959e8c32aa7ab180a53127";
	
		//API Integration
		@SuppressWarnings("deprecation")
		URL url5 = new URL(APIurl5);
		HttpURLConnection connection5 = (HttpURLConnection) url5.openConnection();
		connection5.setRequestMethod("GET");
		
		//Reading Data from Network
		InputStream inputstream5 = connection5.getInputStream();
		InputStreamReader reader5 = new InputStreamReader(inputstream5);
		
		//Want to store it in string
		StringBuilder responseContent5 = new StringBuilder();
		
		//Create a Scanner object to read from the input
		Scanner sc5 = new Scanner(reader5);
		
		while(sc5.hasNext())
		{
			responseContent5.append(sc5.nextLine());	
		}
		sc5.close();
		
		//TypeCasting: Parsing data into JSON
		Gson gson5 = new Gson();
		JsonObject jsonObject5 = gson5.fromJson(responseContent5.toString(),JsonObject.class );
		
		 //Date & Time
//		long dateTimestamp5 = 1000;
        long dateTimestamp5 = jsonObject5.get("dt").getAsLong() * 1000;
        String date5 = new Date(dateTimestamp5).toString();
        
        //Temperature
        double temperatureKelvin5 = jsonObject5.getAsJsonObject("main").get("temp").getAsDouble();
        int temperatureCelsius5 = (int) (temperatureKelvin5 - 273.15);
       
        //Humidity
        int humidity5 = jsonObject5.getAsJsonObject("main").get("humidity").getAsInt();
        
        //Wind Speed
        double windSpeed5 = jsonObject5.getAsJsonObject("wind").get("speed").getAsDouble();
        
        //Weather Condition
        String weatherCondition5 = jsonObject5.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
        
        // Set the data as request attributes (for sending to the jsp page)
        request.setAttribute("date5", date5);
        request.setAttribute("city5", city5);
        request.setAttribute("temperature5", temperatureCelsius5);
        request.setAttribute("weatherCondition5", weatherCondition5); 
        request.setAttribute("humidity5", humidity5);    
        request.setAttribute("windSpeed5", windSpeed5);
        request.setAttribute("weatherData5", responseContent5.toString());
        connection5.disconnect();
        
        // Forward the request to the weather.jsp page for rendering
        request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
