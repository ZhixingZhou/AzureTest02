package seu.zzx.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class AttributeList {
	public static Set<Long> getIdArray(JSONObject jsonObject) {
		Set<Long> set = new HashSet<Long>();
		JSONArray jsonArray = jsonObject.getJSONArray("entities");
		for (int i = 0; i < jsonArray.length(); ++i) {
			JSONObject jsonObject1 = jsonArray.getJSONObject(i);
			if (jsonObject1.has("Id")) {
				set.add(jsonObject1.getLong("Id"));
			}
		}
		return set;
	}
	
	public static Set<Long> getRIdArray(JSONObject jsonObject) {
		Set<Long> set = new HashSet<Long>();
		JSONArray jsonArray = jsonObject.getJSONArray("entities");
		for (int i = 0; i < jsonArray.length(); ++i) {
			JSONObject jsonObject1 = jsonArray.getJSONObject(i);
			if (jsonObject1.has("RId")) {
				JSONArray jsonRIdArray = jsonObject1.getJSONArray("RId");
				for (int j = 0; j < jsonRIdArray.length(); ++j) {
					set.add(jsonRIdArray.getLong(j));
				}
			}
		}
		return set;
	}

	public static Set<Long> getAuIdArray(JSONObject jsonObject) {
		Set<Long> set = new HashSet<Long>();
		JSONArray jsonArray = jsonObject.getJSONArray("entities");
		for (int i = 0; i < jsonArray.length(); ++i) {
			JSONObject jsonObject1 = jsonArray.getJSONObject(i);
			if (jsonObject1.has("AA")) {
				JSONArray jsonAAArray = jsonObject1.getJSONArray("AA");
				for (int j = 0; j < jsonAAArray.length(); ++j) {
					JSONObject aaObject = jsonAAArray.getJSONObject(j);
					if (aaObject.has("AuId")) {
						set.add(aaObject.getLong("AuId"));
					}
				}
			}
		}
		return set;
	}

	public static Set<Long> getFIdArray(JSONObject jsonObject) {
		Set<Long> set = new HashSet<Long>();
		JSONArray jsonArray = jsonObject.getJSONArray("entities");
		for (int i = 0; i < jsonArray.length(); ++i) {
			JSONObject jsonObject1 = jsonArray.getJSONObject(i);
			if (jsonObject1.has("F")) {
				JSONArray jsonFArray = jsonObject1.getJSONArray("F");
				for (int j = 0; j < jsonFArray.length(); ++j) {
					JSONObject fIdObject = jsonFArray.getJSONObject(j);
					if (fIdObject.has("FId")) {
						set.add(fIdObject.getLong("FId"));
					}
				}
			}
		}
		return set;
	}

	public static Set<Long> getJIdArray(JSONObject jsonObject) {
		Set<Long> set = new HashSet<Long>();
		JSONArray jsonArray = jsonObject.getJSONArray("entities");
		for (int i = 0; i < jsonArray.length(); ++i) {
			JSONObject jsonObject1 = jsonArray.getJSONObject(i);
			if (jsonObject1.has("J")) {
				JSONObject jsonJObject = jsonObject1.getJSONObject("J");
				if (jsonJObject.has("JId")) {
					set.add(jsonJObject.getLong("JId"));
				}
			}
		}
		return set;
	}

	public static Set<Long> getCIdArray(JSONObject jsonObject) {
		Set<Long> set = new HashSet<Long>();
		JSONArray jsonArray = jsonObject.getJSONArray("entities");
		for (int i = 0; i < jsonArray.length(); ++i) {
			JSONObject jsonObject1 = jsonArray.getJSONObject(i);
			if (jsonObject1.has("C")) {
				JSONObject jsonCObject = jsonObject1.getJSONObject("C");
				if (jsonCObject.has("CId")) {
					set.add(jsonCObject.getLong("CId"));
				}
			}
		}
		return set;
	}

	public static Set<Long> getAfIdArray(JSONObject jsonObject) {
		Set<Long> set = new HashSet<Long>();
		JSONArray jsonArray = jsonObject.getJSONArray("entities");
		for (int i = 0; i < jsonArray.length(); ++i) {
			JSONObject jsonObject1 = jsonArray.getJSONObject(i);
			if (jsonObject1.has("AA")) {
				JSONArray jsonAAArray = jsonObject1.getJSONArray("AA");
				for (int j = 0; j < jsonAAArray.length(); ++j) {
					JSONObject aaObject = jsonAAArray.getJSONObject(j);
					if (aaObject.has("AfId")) {
						set.add(aaObject.getLong("AfId"));
					}
				}
			}
		}
		return set;
	}
}
