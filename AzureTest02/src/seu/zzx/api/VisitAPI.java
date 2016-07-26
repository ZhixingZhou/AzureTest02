package seu.zzx.api;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class VisitAPI {
	public static boolean isPaperId(long id) {
		HttpClient httpclient = HttpClients.createDefault();
		boolean k = false;
		try {
			
			  URIBuilder builder = new URIBuilder(
			  "https://oxfordhk.azure-api.net/academic/v1.0/evaluate?expr=Id="
			  + id +
			  "&attributes=AA.AuId&subscription-key=f7cc29509a8443c5b3a5e56b0e38b5a6"
			  );

			URI uri = builder.build();
			HttpGet request = new HttpGet(uri);
			//request.setHeader("Ocp-Apim-Subscription-Key","c43e05544e3047e682ca9d71bbe31d86");
			  HttpResponse response = httpclient.execute(request);
	            HttpEntity entity = response.getEntity();
	          
	         
	            JSONObject jsonObject = new JSONObject(EntityUtils.toString(entity));
	            JSONArray jsonArray = jsonObject.getJSONArray("entities");      
	            	JSONObject jsonObject1 = jsonArray.getJSONObject(0);
	            	if(jsonObject1.has("AA")) k =true;
	      //      	System.out.println(k);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return k;
	}
	public static JSONObject getJsonObjectForId(long id) {
		String str = null;
		JSONObject jsonObject = null;
		HttpClient httpclient = HttpClients.createDefault();
		str = "https://oxfordhk.azure-api.net/academic/v1.0/evaluate?expr=Id="
					+ id
					+ "&attributes=RId,F.FId,C.CId,J.JId,AA.AuId&subscription-key=f7cc29509a8443c5b3a5e56b0e38b5a6";
		try {
			URIBuilder builder = null;
			builder = new URIBuilder(str);

			URI uri = builder.build();
			HttpGet request = new HttpGet(uri);

			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				jsonObject = new JSONObject(EntityUtils.toString(entity));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return jsonObject;
	}
	public static JSONObject getJsonObjectForFId(long id) {
		String str = null;
		JSONObject jsonObject = null;
		HttpClient httpclient = HttpClients.createDefault();
		str = "https://oxfordhk.azure-api.net/academic/v1.0/evaluate?expr=Composite(FId="
					+ id
					+ ")&attributes=Id&subscription-key=f7cc29509a8443c5b3a5e56b0e38b5a6";
		try {
			URIBuilder builder = null;
			builder = new URIBuilder(str);

			URI uri = builder.build();
			HttpGet request = new HttpGet(uri);

			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				jsonObject = new JSONObject(EntityUtils.toString(entity));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return jsonObject;
	}
	public static JSONObject getJsonObjectForCId(long id) {
		String str = null;
		JSONObject jsonObject = null;
		HttpClient httpclient = HttpClients.createDefault();
		str = "https://oxfordhk.azure-api.net/academic/v1.0/evaluate?expr=Composite(CId="
					+ id
					+ ")&attributes=Id&subscription-key=f7cc29509a8443c5b3a5e56b0e38b5a6";
		try {
			URIBuilder builder = null;
			builder = new URIBuilder(str);

			URI uri = builder.build();
			HttpGet request = new HttpGet(uri);

			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				jsonObject = new JSONObject(EntityUtils.toString(entity));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return jsonObject;
	}
	public static JSONObject getJsonObjectForJId(long id) {
		String str = null;
		JSONObject jsonObject = null;
		HttpClient httpclient = HttpClients.createDefault();
		str = "https://oxfordhk.azure-api.net/academic/v1.0/evaluate?expr=Composite(JId="
					+ id
					+ ")&attributes=Id&subscription-key=f7cc29509a8443c5b3a5e56b0e38b5a6";
		try {
			URIBuilder builder = null;
			builder = new URIBuilder(str);

			URI uri = builder.build();
			HttpGet request = new HttpGet(uri);

			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				jsonObject = new JSONObject(EntityUtils.toString(entity));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return jsonObject;
	}
	public static JSONObject getJsonObjectForAuId(long id) {
		String str = null;
		JSONObject jsonObject = null;
		HttpClient httpclient = HttpClients.createDefault();
		str = "https://oxfordhk.azure-api.net/academic/v1.0/evaluate?expr=Composite(AA.AuId="
					+ id
					+ ")&attributes=Id,AA.AfId&subscription-key=f7cc29509a8443c5b3a5e56b0e38b5a6";
		try {
			URIBuilder builder = null;
			builder = new URIBuilder(str);

			URI uri = builder.build();
			HttpGet request = new HttpGet(uri);

			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				jsonObject = new JSONObject(EntityUtils.toString(entity));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return jsonObject;
	}
	public static JSONObject getJsonObjectForAfId(long id) {
		String str = null;
		JSONObject jsonObject = null;
		HttpClient httpclient = HttpClients.createDefault();
		str = "https://oxfordhk.azure-api.net/academic/v1.0/evaluate?expr=Composite(AA.AfId="
					+ id
					+ ")&attributes=AA.AuId&subscription-key=f7cc29509a8443c5b3a5e56b0e38b5a6";
		
		try {
			URIBuilder builder = null;
			builder = new URIBuilder(str);

			URI uri = builder.build();
			HttpGet request = new HttpGet(uri);

			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				jsonObject = new JSONObject(EntityUtils.toString(entity));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return jsonObject;
	}
}
