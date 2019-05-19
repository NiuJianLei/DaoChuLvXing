package com.example.lenovo.daochulvxing.util;

import com.example.lenovo.daochulvxing.bean.DiquBean;
import com.example.lenovo.daochulvxing.bean.RankLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 灵风 on 2019/5/17.
 */

public class FriendRankUtil {

    /**
     * 对地址排序
     * @param map
     * @return
     */
    public static List<RankLocation> toRankLocation(List<DiquBean.ResultEntity.ChinaEntity.CitiesEntity> loc, Map<String,Integer> map){
        List<RankLocation> rank=new ArrayList<RankLocation>();

        //先获取用户首字母
        for (int i = 0; i < loc.size(); i++) {
            if(loc.get(i)!=null){
                RankLocation rankLocation = new RankLocation();
                rankLocation.location=loc.get(i);
//				rankLocation.index=ChineseToEnglish.getFirstEng(users.get(i).getUsername());
                rankLocation.index=ChineseToEnglish.getFirstEng(loc.get(i).getName());
                rankLocation.pingyin=ChineseToEnglish.getPinYin(loc.get(i).getName());
                rankLocation.szm=ChineseToEnglish.getPinYinHeadChar(loc.get(i).getName());
                rank.add(rankLocation);
            }
        }
        //排序
        List<RankLocation> result=new ArrayList<RankLocation>();

        for (int i = 65; i <= 91; i++) {
            String c=null;
            if(i==91){
                c="#";
            }else{
                c=(char) i+"";
            }
            for (RankLocation rankLocation : rank) {
                if(c.equals(rankLocation.index)){
                    result.add(rankLocation);
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            //判断是否为第一次添加进map
            if(!map.containsKey(result.get(i).index)){
                map.put(result.get(i).index, i);
                result.get(i).isFirst=true;
            }
        }

        return result;
    }
}
