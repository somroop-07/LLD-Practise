//package core_java;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.List;
//import org.json.simple.*;
//import org.json.simple.parser.*;
//
//
//public class APIConnector {
//	 public static List<Integer> bodyTemperature(String doctorName, int diagnosisId) {
//	        int minTemp = Integer.MAX_VALUE;
//	        int maxTemp = Integer.MIN_VALUE;
//
//	        try {
//	            int page = 1;
//	            int totalPages = 1;
//
//	            while (page <= totalPages) {
//
//	                String urlStr = "https://jsonmock.hackerrank.com/api/medical_records?page=" + page;
//	                URL url = new URL(urlStr);
//	                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//	                conn.setRequestMethod("GET");
//
//	                BufferedReader br = new BufferedReader(
//	                        new InputStreamReader(conn.getInputStream()));
//	                StringBuilder response = new StringBuilder();
//	                String line;
//
//	                while ((line = br.readLine()) != null) {
//	                    response.append(line);
//	                }
//	                br.close();
//
//	                JSONParser parser = new JSONParser();
//	                JSONObject json = (JSONObject) parser.parse(response.toString());
//
//	                totalPages = ((Long) json.get("total_pages")).intValue();
//
//	                JSONArray data = (JSONArray) json.get("data");
//
//	                for (Object o : data) {
//	                    JSONObject record = (JSONObject) o;
//
//	                    // ✅ doctor.name (nested)
//	                    JSONObject doctor = (JSONObject) record.get("doctor");
//	                    String docName = (String) doctor.get("name");
//
//	                    // ✅ diagnosis.id
//	                    JSONObject diagnosis = (JSONObject) record.get("diagnosis");
//	                    int diagId = ((Long) diagnosis.get("id")).intValue();
//
//	                    if (doctorName.equals(docName) && diagnosisId == diagId) {
//
//	                        JSONObject vitals = (JSONObject) record.get("vitals");
//	                        double temp = (Double) vitals.get("bodyTemperature");
//
//	                        int t = (int) temp;
//
//	                        minTemp = Math.min(minTemp, t);
//	                        maxTemp = Math.max(maxTemp, t);
//	                    }
//	                }
//
//	                page++;
//	            }
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//
//	        // edge case
//	        if (minTemp == Integer.MAX_VALUE) {
//	            return Arrays.asList(-1, -1);
//	        }
//
//	        return Arrays.asList(minTemp, maxTemp);
//	    }
//}
