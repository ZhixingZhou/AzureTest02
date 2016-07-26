package seu.zzx.path;

import java.util.Iterator;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import seu.zzx.api.VisitAPI;
import seu.zzx.list.AttributeList;

public class HopPathsForAuIdToAuId {
	public static JSONArray getPath(long id1,long id2){
		JSONArray path = new JSONArray("[]");
		boolean flag = false;
		StringBuffer sb = new StringBuffer();
		JSONObject jsonObjectAUID1 = VisitAPI.getJsonObjectForAuId(id1);
		JSONObject jsonObjectAUID2 = VisitAPI.getJsonObjectForAuId(id2);
		Set<Long> AfId1 = AttributeList.getAfIdArray(jsonObjectAUID1);
		Set<Long> AfId2 = AttributeList.getAfIdArray(jsonObjectAUID2);
		//auid1--->afid--->auid2
		if(AfId1.size()>0&&AfId2.size()>0){
			Iterator<Long> afid1 = AfId1.iterator();
			while(afid1.hasNext()){
				long afid11 = afid1.next();
				if(AfId2.contains(afid11)){
					if(!flag){
						sb.append("[[").append(id1).append(",").append(afid11).append(",").append(id2).append("]");
					}else{
						sb.append(",").append("[").append(id1).append(",").append(afid11).append(",").append(id2).append("]");
					}
				}
			}
		}
		//auid1--->id--->auid2
		Set<Long> Id1 = AttributeList.getIdArray(jsonObjectAUID1);
		if(Id1.size()>0){
			Iterator<Long> it = Id1.iterator();
			while(it.hasNext()){
				long id11 = it.next();
				JSONObject jsonObject = VisitAPI.getJsonObjectForId(id11);
				Set<Long> auid1 = AttributeList.getAuIdArray(jsonObject);
				if(auid1.contains(id2)){
					if(!flag){
						sb.append("[[").append(id1).append(",").append(id11).append(",").append(id2).append("]");
					}else{
						sb.append(",").append("[").append(id1).append(",").append(id11).append(",").append(id2).append("]");
					}
				}
			}
		}
		//auid1--->id--->id--->auid2
		if(Id1.size()>0){
			Iterator<Long> it = Id1.iterator();
			while(it.hasNext()){
				long id11 = it.next();
				JSONObject jsonObject = VisitAPI.getJsonObjectForId(id11);
				Set<Long> rid1 = AttributeList.getRIdArray(jsonObject);
				if(rid1.size()>0){
					Iterator<Long> it1 = rid1.iterator();
					while(it1.hasNext()){
						long rid11 = it1.next();
						JSONObject jsonObject1 = VisitAPI.getJsonObjectForId(rid11);
						Set<Long> auid22 = AttributeList.getAuIdArray(jsonObject1);
						if(auid22.contains(id2)){
							if(!flag){
								sb.append("[[").append(id1).append(",").append(id11).append(",").append(rid11).append(",").append(id2).append("]");
							}else{
								sb.append(",").append("[").append(id1).append(",").append(id11).append(",").append(rid11).append(",").append(id2).append("]");
							}
						}
					}
				}
			}
		}
		if(flag){
			sb.append("]");
			path = new JSONArray(sb.toString());
		}
		return path;
	}
}
