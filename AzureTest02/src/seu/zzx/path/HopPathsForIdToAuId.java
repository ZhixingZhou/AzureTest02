package seu.zzx.path;

import java.util.Iterator;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import seu.zzx.api.VisitAPI;
import seu.zzx.list.AttributeList;

public class HopPathsForIdToAuId {
	public static JSONArray getPath(long id1,long id2){
		JSONArray path = new JSONArray("[]");
		boolean flag = false;
		StringBuffer sb = new StringBuffer();
		JSONObject jsonObjectID1 = VisitAPI.getJsonObjectForId(id1);
		JSONObject jsonObjectAUID2 = VisitAPI.getJsonObjectForAuId(id2);
		Set<Long> AuId1 = AttributeList.getAuIdArray(jsonObjectID1);
		//id1--->auid2
		if(AuId1.size()>0){
			if(AuId1.contains(id2)){
				if(!flag){
					flag = true;
					sb.append("[[").append(id1).append(",").append(id2).append("]");
				}else{
					sb.append(",").append("[").append(id1).append(",").append(id2).append("]");
				}
			}
		}
		//id1--->id--->auid2
		Set<Long> RId1 = AttributeList.getRIdArray(jsonObjectID1);
		if(RId1.size()>0){
			Iterator<Long> it = RId1.iterator();
			while(it.hasNext()){
				long rid1 = it.next();
				JSONObject jsonObject = VisitAPI.getJsonObjectForId(rid1);
				Set<Long> auid22 = AttributeList.getAuIdArray(jsonObject);
				if(auid22.contains(id2)){
					if(!flag){
						flag = true;
						sb.append("[[").append(id1).append(",").append(rid1).append(",").append(id2).append("]");
					}else{
						sb.append(",[").append(id1).append(",").append(rid1).append(",").append(id2).append("]");
					}
				}
			}
		}
		//id1--->id--->id--->auid2
		if(RId1.size()>0){
			Iterator<Long> it = RId1.iterator();
			while(it.hasNext()){
				long rid1 = it.next();
				JSONObject jsonObject = VisitAPI.getJsonObjectForId(rid1);
				Set<Long> RId2 = AttributeList.getRIdArray(jsonObject);
				if(RId2.size()>0){
					Iterator<Long> it2 = RId2.iterator();
					while(it2.hasNext()){
						long rid2 = it2.next();
						JSONObject jsonObject3 = VisitAPI.getJsonObjectForId(rid2);
						Set<Long> AuId3 = AttributeList.getAuIdArray(jsonObject3);
						if(AuId3.size()>0){
							if(AuId3.contains(id2)){
								if(!flag){
									flag = true;
									sb.append("[[").append(id1).append(",").append(rid1).append(",").append(rid2).append(",").append(id2).append("]");
								}else{
									sb.append(",").append("[").append(id1).append(",").append(rid1).append(",").append(rid2).append(",").append(id2).append("]");
								}
							}
						}
					}
				}
			}
		}
		//id1--->fid--->id--->auid2
		Set<Long> FId1 = AttributeList.getFIdArray(jsonObjectID1);
		if(FId1.size()>0){
			Iterator<Long> it = FId1.iterator();
			while(it.hasNext()){
				long fid1 = it.next();
				JSONObject jsonObject = VisitAPI.getJsonObjectForFId(fid1);
				Set<Long> id11 = AttributeList.getIdArray(jsonObject);
				if(id11.size()>0){
					Iterator<Long> it2 = id11.iterator();
					while(it2.hasNext()){
						long id22 = it2.next();
						JSONObject jsonObject2 = VisitAPI.getJsonObjectForId(id22);
						Set<Long> AuId3 = AttributeList.getAuIdArray(jsonObject2);
						if(AuId3.size()>0){
							if(AuId3.contains(id2)){
								if(!flag){
									flag = true;
									sb.append("[[").append(id1).append(",").append(fid1).append(",").append(id22).append(",").append(id2).append("]");
								}else{
									sb.append(",").append("[").append(id1).append(",").append(fid1).append(",").append(id22).append(",").append(id2).append("]");
								}
							}
						}
					}
				}
			}
		}
		//id1--->cid--->id--->auid2
		Set<Long> CId1 = AttributeList.getCIdArray(jsonObjectID1);
		if(CId1.size()>0){
			Iterator<Long> it = CId1.iterator();
			while(it.hasNext()){
				long cid1 = it.next();
				JSONObject jsonObject = VisitAPI.getJsonObjectForCId(cid1);
				Set<Long> id11 = AttributeList.getIdArray(jsonObject);
				if(id11.size()>0){
					Iterator<Long> it2 = id11.iterator();
					while(it2.hasNext()){
						long id22 = it2.next();
						JSONObject jsonObject2 = VisitAPI.getJsonObjectForId(id22);
						Set<Long> AuId3 = AttributeList.getAuIdArray(jsonObject2);
						if(AuId3.size()>0){
							if(AuId3.contains(id2)){
								if(!flag){
									flag = true;
									sb.append("[[").append(id1).append(",").append(cid1).append(",").append(id22).append(",").append(id2).append("]");
								}else{
									sb.append(",").append("[").append(id1).append(",").append(cid1).append(",").append(id22).append(",").append(id2).append("]");
								}
							}
						}
					}
				}
			}
		}
		//id1---jid---id---auid2
		Set<Long> JId1 = AttributeList.getJIdArray(jsonObjectID1);
		if(JId1.size()>0){
			Iterator<Long> it = JId1.iterator();
			while(it.hasNext()){
				long jid1 = it.next();
				JSONObject jsonObject = VisitAPI.getJsonObjectForJId(jid1);
				Set<Long> id11 = AttributeList.getIdArray(jsonObject);
				if(id11.size()>0){
					Iterator<Long> it2 = id11.iterator();
					while(it2.hasNext()){
						long id22 = it2.next();
						JSONObject jsonObject2 = VisitAPI.getJsonObjectForId(id22);
						Set<Long> AuId3 = AttributeList.getAuIdArray(jsonObject2);
						if(AuId3.size()>0){
							if(AuId3.contains(id2)){
								if(!flag){
									flag = true;
									sb.append("[[").append(id1).append(",").append(jid1).append(",").append(id22).append(",").append(id2).append("]");
								}else{
									sb.append(",").append("[").append(id1).append(",").append(jid1).append(",").append(id22).append(",").append(id2).append("]");
								}
							}
						}
					}
				}
			}
		}
		//id1--->auid--->id--->auid2
		if(AuId1.size()>0){
			Iterator<Long> it = AuId1.iterator();
			while(it.hasNext()){
				long auid1 = it.next();
				if (auid1!=id2) {
					JSONObject jsonObject = VisitAPI
							.getJsonObjectForAuId(auid1);
					Set<Long> id11 = AttributeList.getIdArray(jsonObject);
					if (id11.size() > 0) {
						Iterator<Long> it2 = id11.iterator();
						while (it2.hasNext()) {
							long id22 = it2.next();
							if (id22!=id1) {
								JSONObject jsonObject2 = VisitAPI
										.getJsonObjectForId(id22);
								Set<Long> AuId3 = AttributeList
										.getAuIdArray(jsonObject2);
								if (AuId3.size() > 0) {
									if (AuId3.contains(id2)) {
										if (!flag) {
											flag = true;
											sb.append("[[").append(id1)
													.append(",").append(auid1)
													.append(",").append(id22)
													.append(",").append(id2)
													.append("]");
										} else {
											sb.append(",").append("[")
													.append(id1).append(",")
													.append(auid1).append(",")
													.append(id22).append(",")
													.append(id2).append("]");
										}
									}
								}
							}
						}
					}
				}
			}
		}
		//id1--->auid--->afid--->auid2
		Set<Long> AfId2 = AttributeList.getAfIdArray(jsonObjectAUID2);
		if(AuId1.size()>0){
			Iterator<Long> it = AuId1.iterator();
			while(it.hasNext()){
				long auid1 = it.next();
				if(auid1!=id2){
					JSONObject jsonObject = VisitAPI.getJsonObjectForAuId(auid1);
					Set<Long> afid1 = AttributeList.getAfIdArray(jsonObject);
					if(afid1.size()>0&&AfId2.size()>0){
						Iterator<Long> it1 = afid1.iterator();
						while(it1.hasNext()){
							long afid11 = it1.next();
							if(AfId2.contains(afid11)){
								if(!flag){
									flag = true;
									sb.append("[[").append(id1).append(",").append(auid1).append(",").append(afid11).append(",").append(id2).append("]");
								}else{
									sb.append(",[").append(id1).append(",").append(auid1).append(",").append(afid11).append(",").append(id2).append("]");
								}
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
