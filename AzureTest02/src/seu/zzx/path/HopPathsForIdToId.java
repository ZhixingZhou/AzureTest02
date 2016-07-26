package seu.zzx.path;

import java.util.Iterator;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import seu.zzx.api.VisitAPI;
import seu.zzx.list.AttributeList;

public class HopPathsForIdToId {
	public static JSONArray getPath(long id1,long id2){
		JSONArray path = new JSONArray("[]");
		boolean flag = false;
		StringBuffer sb = new StringBuffer();
		JSONObject jsonObjectID1 = VisitAPI.getJsonObjectForId(id1);
		JSONObject jsonObjectID2 = VisitAPI.getJsonObjectForId(id2);
		Set<Long> RId1 = AttributeList.getRIdArray(jsonObjectID1);
		//id1---->id2
		if(RId1.size()>0){
			if(RId1.contains(id2)){
				if(!flag){
					flag = true;
					sb.append("[[").append(id1).append(",").append(id2).append("]");
				}else{
					sb.append(",").append("[").append(id1).append(",").append(id2).append("]");
				}
			}
			/*
			Iterator<Long> it = RId1.iterator();
			while(it.hasNext()){
				long rid1 = it.next();
				if(id2==rid1){
					if(!flag){
						flag = true;
						sb.append("[[").append(id1).append(",").append(id2).append("]");
					}else{
						sb.append(",").append("[").append(id1).append(",").append(id2).append("]");
					}
					break;
				}
			}
			*/
		}
		//id1--->id--->id2
		if(RId1.size()>0){
			Iterator<Long> it = RId1.iterator();
			while(it.hasNext()){
				long rid1 = it.next();
				if (rid1!=id2&&rid1!=id1) {
					JSONObject jsonObject = VisitAPI.getJsonObjectForId(rid1);
					Set<Long> RId2 = AttributeList.getRIdArray(jsonObject);
					if (RId2.size() > 0) {
						if (RId2.contains(id2)) {
							if (!flag) {
								flag = true;
								sb.append("[[").append(id1).append(",")
										.append(rid1).append(",").append(id2)
										.append("]");
							} else {
								sb.append(",").append("[").append(id1)
										.append(",").append(rid1).append(",")
										.append(id2).append("]");
							}
						}
					}
				}
			}
		}
		//id1--->fid--->id2
		Set<Long> FId1 = AttributeList.getFIdArray(jsonObjectID1);
		Set<Long> FId2 = AttributeList.getFIdArray(jsonObjectID2);
		if(FId1.size()>0&&FId2.size()>0){
			Iterator<Long> it = FId1.iterator();
			while(it.hasNext()){
				long fid1 = it.next();
				if(FId2.contains(fid1)){
					if(!flag){
						flag = true;
						sb.append("[[").append(id1).append(",").append(fid1).append(",").append(id2).append("]");
					}else{
						sb.append(",").append("[").append(id1).append(",").append(fid1).append(",").append(id2).append("]");
					}
				}
			}
		}
		//id1--->cid--->id2
		Set<Long> CId1 = AttributeList.getCIdArray(jsonObjectID1);
		Set<Long> CId2 = AttributeList.getCIdArray(jsonObjectID2);
		if(CId1.size()>0&&CId2.size()>0){
			Iterator<Long> it = CId1.iterator();
			while(it.hasNext()){
				long cid1 = it.next();
				if(CId2.contains(cid1)){
					if(!flag){
						flag = true;
						sb.append("[[").append(id1).append(",").append(cid1).append(",").append(id2).append("]");
					}else{
						sb.append(",").append("[").append(id1).append(",").append(cid1).append(",").append(id2).append("]");
					}
				}
			}
		}
		//id1--->jid--->id2
		Set<Long> JId1 = AttributeList.getCIdArray(jsonObjectID1);
		Set<Long> JId2 = AttributeList.getCIdArray(jsonObjectID2);
		if(JId1.size()>0&&JId2.size()>0){
			Iterator<Long> it = JId1.iterator();
			while(it.hasNext()){
				long jid1 = it.next();
				if(JId2.contains(jid1)){
					if(!flag){
						flag = true;
						sb.append("[[").append(id1).append(",").append(jid1).append(",").append(id2).append("]");
					}else{
						sb.append(",").append("[").append(id1).append(",").append(jid1).append(",").append(id2).append("]");
					}
				}
			}
		}
		//id1--->auid--->id2
		Set<Long> AuId1 = AttributeList.getCIdArray(jsonObjectID1);
		Set<Long> AuId2 = AttributeList.getCIdArray(jsonObjectID2);
		if(AuId1.size()>0&&AuId2.size()>0){
			Iterator<Long> it = AuId1.iterator();
			while(it.hasNext()){
				long auid1 = it.next();
				if(AuId2.contains(auid1)){
					if(!flag){
						flag = true;
						sb.append("[[").append(id1).append(",").append(auid1).append(",").append(id2).append("]");
					}else{
						sb.append(",").append("[").append(id1).append(",").append(auid1).append(",").append(id2).append("]");
					}
				}
			}
		}
		//id1--->id--->id--->id2
		if(RId1.size()>0){
			Iterator<Long> it = RId1.iterator();
			while(it.hasNext()){
				long rid1 = it.next();
				if (rid1!=id2&&rid1!=id1) {
					JSONObject jsonObject = VisitAPI.getJsonObjectForId(rid1);
					Set<Long> RId2 = AttributeList.getRIdArray(jsonObject);
					if (RId2.size() > 0) {
						Iterator<Long> it2 = RId2.iterator();
						while (it2.hasNext()) {
							long rid2 = it2.next();
							if (rid2!=id2&&rid2!=id2) {
								JSONObject jsonObject3 = VisitAPI
										.getJsonObjectForId(rid2);
								Set<Long> RId3 = AttributeList
										.getRIdArray(jsonObject3);
								if (RId3.size() > 0) {
									if (RId3.contains(id2)) {
										if (!flag) {
											flag = true;
											sb.append("[[").append(id1)
													.append(",").append(rid1)
													.append(",").append(rid2)
													.append(",").append(id2)
													.append("]");
										} else {
											sb.append(",").append("[")
													.append(id1).append(",")
													.append(rid1).append(",")
													.append(rid2).append(",")
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
		//id1--->fid--->id--->id2
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
						if (id22!=id2&&id22!=id1) {
							JSONObject jsonObject2 = VisitAPI
									.getJsonObjectForId(id22);
							Set<Long> RId3 = AttributeList
									.getRIdArray(jsonObject2);
							if (RId3.size() > 0) {
								if (RId3.contains(id2)) {
									if (!flag) {
										flag = true;
										sb.append("[[").append(id1).append(",")
												.append(fid1).append(",")
												.append(id22).append(",")
												.append(id2).append("]");
									} else {
										sb.append(",").append("[").append(id1)
												.append(",").append(fid1)
												.append(",").append(id22)
												.append(",").append(id2)
												.append("]");
									}
								}
							}
						}
					}
				}
			}
		}
		//id1--->cid--->id--->id2
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
						if (id22!=id2&&id22!=id1) {
							JSONObject jsonObject2 = VisitAPI
									.getJsonObjectForId(id22);
							Set<Long> RId3 = AttributeList
									.getRIdArray(jsonObject2);
							if (RId3.size() > 0) {
								if (RId3.contains(id2)) {
									if (!flag) {
										flag = true;
										sb.append("[[").append(id1).append(",")
												.append(cid1).append(",")
												.append(id22).append(",")
												.append(id2).append("]");
									} else {
										sb.append(",").append("[").append(id1)
												.append(",").append(cid1)
												.append(",").append(id22)
												.append(",").append(id2)
												.append("]");
									}
								}
							}
						}
					}
				}
			}
		}
		//id1--->jid--->id--->id2
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
						if (id22!=id2&&id22!=id1) {
							JSONObject jsonObject2 = VisitAPI
									.getJsonObjectForId(id22);
							Set<Long> RId3 = AttributeList
									.getRIdArray(jsonObject2);
							if (RId3.size() > 0) {
								if (RId3.contains(id2)) {
									if (!flag) {
										flag = true;
										sb.append("[[").append(id1).append(",")
												.append(jid1).append(",")
												.append(id22).append(",")
												.append(id2).append("]");
									} else {
										sb.append(",").append("[").append(id1)
												.append(",").append(jid1)
												.append(",").append(id22)
												.append(",").append(id2)
												.append("]");
									}
								}
							}
						}
					}
				}
			}
		}
		//id1--->AuId--->id--->id2
		if(AuId1.size()>0){
			Iterator<Long> it = AuId1.iterator();
			while(it.hasNext()){
				long auid1 = it.next();
				JSONObject jsonObject = VisitAPI.getJsonObjectForAuId(auid1);
				Set<Long> id11 = AttributeList.getIdArray(jsonObject);
				if(id11.size()>0){
					Iterator<Long> it2 = id11.iterator();
					while(it2.hasNext()){
						long id22 = it2.next();
						if (id22!=id2&&id22!=id1) {
							JSONObject jsonObject2 = VisitAPI
									.getJsonObjectForId(id22);
							Set<Long> RId3 = AttributeList
									.getRIdArray(jsonObject2);
							if (RId3.size() > 0) {
								if (RId3.contains(id2)) {
									if (!flag) {
										flag = true;
										sb.append("[[").append(id1).append(",")
												.append(auid1).append(",")
												.append(id22).append(",")
												.append(id2).append("]");
									} else {
										sb.append(",").append("[").append(id1)
												.append(",").append(auid1)
												.append(",").append(id22)
												.append(",").append(id2)
												.append("]");
									}
								}
							}
						}
					}
				}
			}
		}
		//id1--->id---fid--->id2
		if(RId1.size()>0&&FId2.size()>0){
			Iterator<Long> it = RId1.iterator();
			while(it.hasNext()){
				long rid1 = it.next();
				if (rid1!=id1&&rid1!=id2) {
					JSONObject jsonObject = VisitAPI.getJsonObjectForId(rid1);
					Set<Long> fid1 = AttributeList.getFIdArray(jsonObject);
					if (fid1.size() > 0) {
						Iterator<Long> it1 = fid1.iterator();
						while (it1.hasNext()) {
							long fid11 = it1.next();
							if (FId2.contains(fid11)) {
								if (!flag) {
									flag = true;
									sb.append("[[").append(id1).append(",")
											.append(rid1).append(",")
											.append(fid11).append(",")
											.append(id2).append("]");
								} else {
									sb.append(",").append("[").append(id1)
											.append(",").append(rid1)
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
		//id1--->id--->cid--->id2
		if(RId1.size()>0&&CId2.size()>0){
			Iterator<Long> it = RId1.iterator();
			while(it.hasNext()){
				long rid1 = it.next();
				if (rid1!=id1&&rid1!=id2) {
					JSONObject jsonObject = VisitAPI.getJsonObjectForId(rid1);
					Set<Long> cid1 = AttributeList.getCIdArray(jsonObject);
					if (cid1.size() > 0) {
						Iterator<Long> it1 = cid1.iterator();
						while (it1.hasNext()) {
							long cid11 = it1.next();
							if (CId2.contains(cid11)) {
								if (!flag) {
									flag = true;
									sb.append("[[").append(id1).append(",")
											.append(rid1).append(",")
											.append(cid11).append(",")
											.append(id2).append("]");
								} else {
									sb.append(",").append("[").append(id1)
											.append(",").append(rid1)
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
		//id1--->id--->jid--->id2
		if(RId1.size()>0&&JId2.size()>0){
			Iterator<Long> it = RId1.iterator();
			while(it.hasNext()){
				long rid1 = it.next();
				if (rid1!=id1&&rid1!=id2) {
					JSONObject jsonObject = VisitAPI.getJsonObjectForId(rid1);
					Set<Long> jid1 = AttributeList.getJIdArray(jsonObject);
					if (jid1.size() > 0) {
						Iterator<Long> it1 = jid1.iterator();
						while (it1.hasNext()) {
							long jid11 = it1.next();
							if (JId2.contains(jid11)) {
								if (!flag) {
									flag = true;
									sb.append("[[").append(id1).append(",")
											.append(rid1).append(",")
											.append(jid11).append(",")
											.append(id2).append("]");
								} else {
									sb.append(",").append("[").append(id1)
											.append(",").append(rid1)
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
		//id1--->id--->auid--->id2
		if(RId1.size()>0&&AuId2.size()>0){
			Iterator<Long> it = RId1.iterator();
			while(it.hasNext()){
				long rid1 = it.next();
				if (rid1!=id1&&rid1!=id2) {
					JSONObject jsonObject = VisitAPI.getJsonObjectForId(rid1);
					Set<Long> auid1 = AttributeList.getAuIdArray(jsonObject);
					if (auid1.size() > 0) {
						Iterator<Long> it1 = auid1.iterator();
						while (it1.hasNext()) {
							long auid11 = it1.next();
							if (AuId2.contains(auid11)) {
								if (!flag) {
									flag = true;
									sb.append("[[").append(id1).append(",")
											.append(rid1).append(",")
											.append(auid11).append(",")
											.append(id2).append("]");
								} else {
									sb.append(",").append("[").append(id1)
											.append(",").append(rid1)
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
		if(flag){
			sb.append("]");
			path = new JSONArray(sb.toString());
		}
		return path;
	}
}
