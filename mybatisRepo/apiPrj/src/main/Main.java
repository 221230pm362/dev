package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Main {

	public static void main(String[] args) throws Exception  {
		
		//날씨 정보를 받아오는 코드
		StringBuilder sb = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst"); /*URL*/
        sb.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=6IPXodaWeJeJISbBFmD1zT3h4u91nQ75HnufakYGnvgsIiwT%2FUgS79FOvKU6KLuimQiq6pSANLNYpo0tFn%2Fl0g%3D%3D"); /*Service Key*/
        sb.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        sb.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
        sb.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
        sb.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode("20230718", "UTF-8")); /*‘21년 6월 28일 발표*/
        sb.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode("0600", "UTF-8")); /*06시 발표(정시단위) */
        sb.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("55", "UTF-8")); /*예보지점의 X 좌표값*/
        sb.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("127", "UTF-8")); /*예보지점의 Y 좌표값*/
        URL url = new URL(sb.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder responseSb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
        	responseSb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(responseSb);
		
		

	}

}
