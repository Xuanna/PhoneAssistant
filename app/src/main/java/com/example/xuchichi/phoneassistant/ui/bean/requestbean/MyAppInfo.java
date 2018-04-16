package com.example.xuchichi.phoneassistant.ui.bean.requestbean;

import com.example.xuchichi.phoneassistant.ui.bean.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xuchichi on 2018/4/7.
 */

public class MyAppInfo extends BaseEntity implements Serializable{


    public boolean hasMore;
    public List<DatasBean> datas;

    public static class DatasBean {

        public int addTime;
        public boolean hasSameDevApp;
        public int videoId;
        public String source;
        public String versionName;
        public HdIconBean hdIcon;
        public double ratingScore;
        public String briefShow;
        public int developerId;
        public int fitness;
        public int id;
        public int level1CategoryId;
        public String releaseKeyHash;
        public boolean relateAppHasMore;
        public int rId;
        public int suitableType;
        public boolean briefUseIntro;
        public int ads;
        public String publisherName;
        public int level2CategoryId;
        public int position;
        public boolean favorite;
        public boolean isFavorite;
        public int appendSize;
        public String level1CategoryName;
        public boolean samDevAppHasMore;
        public String displayName;
        public String icon;
        public String screenshot;
        public int ratingTotalCount;
        public int adType;
        public int apkSize;
        public String packageName;
        public long updateTime;
        public int grantCode;
        public int versionCode;
        public int diffFileSize;
        public List<AppTagsBean> appTags;

        public static class HdIconBean {
            /**
             * main : AppStore/06171c4693a3a4f671c8173716c31b7b2855ce85d
             */

            public String main;
        }

        public static class AppTagsBean {
            /**
             * tagId : 228
             * link : sametag/228
             * tagName : 便民
             */

            public int tagId;
            public String link;
            public String tagName;
        }
    }
}
