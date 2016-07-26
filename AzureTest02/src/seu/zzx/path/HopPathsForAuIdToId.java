package seu.zzx.path;

import java.util.Iterator;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import seu.zzx.api.VisitAPI;
import seu.zzx.list.AttributeList;

public class HopPathsForAuIdToId {
	public static JSONArray getPath(long id1,long id2){
		JSONArray path = new JSONArray("[]");
		boolean flag = false;
		StringBuffer sb = new StringBuffer();
		JSONObject jsonObjectAUID1 = VisitAPI.getJsonObjectForAuId(id1);
		JSONObject jsonObjectID2 = VisitAPI.getJsonObjectForId(id2);
		Set<Long> Id1 = AttributeList.getIdArray(jsonObjectAUID1);
		//auid1--->id2
		if(Id1.size()>0){
			if(Id1.contains(id2)){
				if(!flag){
					flag = true;
					sb.append("[[").append(id1).append(",").append(id2).append("]");
				}else{
					sb.append(",").append("[").append(id1).append(",").append(id2).append("]");
				}
			}
		}
		//auid1--->id--->id2
		if(Id1.size()>0){
			Iterator<Long> it = Id1.iterator();
			while(it.hasNext()){
				long id11 = it.next();
				if(id11!=id2){
					JSONObject jsonObject = VisitAPI.getJsonObjectForId(id11);
					Set<Long> rid1 = AttributeList.getRIdArray(jsonObject);
					if(rid1.contains(id2)){
						if(!flag){
							flag = true;
							sb.append("[[").append(id1).append(",").append(id11).append(",").append(id2).append("]");
						}else{
							sb.append(",").append("[").append(id1).append(",").append(id11).append(",").append(id2).append("]");
						}
					}
				}
			}
		}
		//auid1--->id--->id--->id2
		if(Id1.size()>0){
			Iterator<Long> it = Id1.iterator();
			while(it.hasNext()){
				long id11 = it.next();
				if(id11!=id2){
					JSONObject jsonObject = VisitAPI.getJsonObjectForId(id11);
					Set<Long> rid1 = AttributeList.getRIdArray(jsonObject);
					if(rid1.size()>0){
						Iterator<Long> it1 = rid1.iterator();
						while(it1.hasNext()){
							long id22 = it1.next();
							if(id22!=id2&&id22!=id11){
								JSONObject jsonObject1 = VisitAPI.getJsonObjectForId(id22);
								Set<Long> rid22 = AttributeList.getRIdArray(jsonObject1);
								if(rid22.contains(id2)){
									if(!flag){
										flag = true;
										sb.append("[[").append(id1).append(",").append(id11).append(",").append(id22).append(",").append(id2).append("]");
									}else{
										sb.append(",").append("[").append(id1).append(",").append(id11).append(",").append(id22).append(",").append(id2).append("]");
									}
								}
							}
						}
					}
				}
			}
		}
		//auid1--->id--->fid--->id2
		Set<Long> FId2 = AttributeList.getFIdArray(jsonObjectID2);
		if(Id1.size()>0&&FId2.size()>0){
			Iterator<Long> it = Id1.iterator();
			while(it.hasNext()){
				long id11 = it.next();
				if (id11!=id2) {
					JSONObject jsonObject = VisitAPI.getJsonObjectForId(id11);
					Set<Long> fid1 = AttributeList.getFIdArray(jsonObject);
					if (fid1.size() > 0) {
						Iterator<Long> it1 = fid1.iterator();
						while (it1.hasNext()) {
							long fid11 = it1.next();
							if (FId2.contains(fid11)) {
								if (!flag) {
									flag = true;
									sb.append("[[").append(id1).append(",")
											.append(id11).append(",")
											.append(fid11).append(",")
											.append(id2).append("]");
								} else {
									sb.append(",").append("[").append(id1)
											.append(",").append(id11)
											.append(",").append(fid11)
											.append(",").append(id2)
											.append("]");
								}
							}
						}
					}
				}
			}
		}
		//auid1--->id--->cid--->id2
		Set<Long> CId2 = AttributeList.getCIdArray(jsonObjectID2);
		if(Id1.size()>0&&CId2.size()>0){
			Iterator<Long> it = Id1.iterator();
			while(it.hasNext()){
				long id11 = it.next();
				if (id11!=id2) {
					JSONObject jsonObject = VisitAPI.getJsonObjectForId(id11);
					Set<Long> cid1 = AttributeList.getCIdArray(jsonObject);
					if (cid1.size() > 0) {
						Iterator<Long> it1 = cid1.iterator();
						while (it1.hasNext()) {
							long cid11 = it1.next();
							if (CId2.contains(cid11)) {
								if (!flag) {
									flag = true;
									sb.append("[[").append(id1).append(",")
											.append(id11).append(",")
											.append(cid11).append(",")
											.append(id2).append("]");
								} else {
									sb.append(",").append("[").append(id1)
											.append(",").append(id11)
											.append(",").append(cid11)
											.append(",").append(id2)
											.append("]");
								}
							}
						}
					}
				}
			}
		}
		//auid1--->id--->jid--->id2
		Set<Long> JId2 = AttributeList.getJIdArray(jsonObjectID2);
		if(Id1.size()>0&&JId2.size()>0){
			Iterator<Long> it = Id1.iterator();
			while(it.hasNext()){
				long id11 = it.next();
				if (id11!=id2) {
					JSONObject jsonObject = VisitAPI.getJsonObjectForId(id11);
					Set<Long> jid1 = AttributeList.getJIdArray(jsonObject);
					if (jid1.size() > 0) {
						Iterator<Long> it1 = jid1.iterator();
						while (it1.hasNext()) {
							long jid11 = it1.next();
							if (JId2.contains(jid11)) {
								if (!flag) {
									flag = true;
									sb.append("[[").append(id1).append(",")
											.append(id11).append(",")
											.append(jid11).append(",")
											.append(id2).append("]");
								} else {
									sb.append(",").append("[").append(id1)
											.append(",").append(id11)
											.append(",").append(jid11)
											.append(",").append(id2)
											.append("]");
								}
							}
						}
					}
				}
			}
		}
		//auid--->id--->auid--->id2
		Set<Long> AuId2 = AttributeList.getAuIdArray(jsonObjectID2);
		if(Id1.size()>0&&AuId2.size()>0){
			Iterator<Long> it = Id1.iterator();
			while(it.hasNext()){
				long id11 = it.next();
				if (id11!=id2) {
					JSONObject jsonObject = VisitAPI.getJsonObjectForId(id11);
					Set<Long> auid1 = AttributeList.getAuIdArray(jsonObject);
					if (auid1.size() > 0) {
						Iterator<Long> it1 = auid1.iterator();
						while (it1.hasNext()) {
							long auid11 = it1.next();
							if (AuId2.contains(auid11)&&auid11!=id1) {
								if (!flag) {
									flag = true;
									sb.append("[[").append(id1).append(",")
											.append(id11).append(",")
											.append(auid11).append(",")
											.append(id2).append("]");
								} else {
									sb.append(",").append("[").append(id1)
											.append(",").append(id11)
											.append(",").append(auid11)
											.append(",").append(id2)
											.append("]");
								}
							}
						}
					}
				}
			}
		}
		//auid1--->afid--->auid--->id2
		Set<Long> AfId1 = AttributeList.getAfIdArray(jsonObjectAUID1);
		if(AfId1.size()>0&&AuId2.size()>0){
			Iterator<Long> it = AfId1.iterator();
			while(it.hasNext()){
				long afid1 = it.next();
				JSONObject jsonObject = VisitAPI.getJsonObjectForAfId(afid1);
				Set<Long> auid2 = AttributeList.getAuIdArray(jsonObject);
				if(auid2.size()>0){
					Iterator<Long> it2 = auid2.iterator();
					while(it2.hasNext()){
						long auid22 = it2.next();
						if(AuId2.contains(auid22)&&auid22!=id1){
							if (!flag) {
								flag = true;
								sb.append("[[").append(id1).append(",")
										.append(afid1).append(",")
										.append(auid22).append(",")
										.append(id2).append("]");
							} else {
								sb.append(",").append("[").append(id1)
										.append(",").append(afid1)
										.append(",").append(auid22)
										.append(",").append(id2)
										.append("]");
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
