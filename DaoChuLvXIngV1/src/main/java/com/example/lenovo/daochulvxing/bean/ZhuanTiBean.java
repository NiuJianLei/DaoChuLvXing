package com.example.lenovo.daochulvxing.bean;

import java.util.List;

public class ZhuanTiBean {

    /**
     * result : {"bundles":[{"contentURL":"http://cdn.banmi.com/banmiapp/html/1522659154327.html","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522654270428_8f11bbbd503ff42905aea3a58e78e807.png","title":"艺术之旅"},{"contentURL":"http://cdn.banmi.com/banmiapp/html/1521542677041.html","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521542676849_2e57cca0e9fc7faeefce11894845e0c9.jpg","title":"吃遍中国天南海北"}]}
     * code : 0
     * desc :
     */
    private ResultEntity result;
    private int code;
    private String desc;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ResultEntity getResult() {
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public class ResultEntity {
        /**
         * bundles : [{"contentURL":"http://cdn.banmi.com/banmiapp/html/1522659154327.html","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522654270428_8f11bbbd503ff42905aea3a58e78e807.png","title":"艺术之旅"},{"contentURL":"http://cdn.banmi.com/banmiapp/html/1521542677041.html","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521542676849_2e57cca0e9fc7faeefce11894845e0c9.jpg","title":"吃遍中国天南海北"}]
         */
        private List<BundlesEntity> bundles;

        public void setBundles(List<BundlesEntity> bundles) {
            this.bundles = bundles;
        }

        public List<BundlesEntity> getBundles() {
            return bundles;
        }

        public class BundlesEntity {
            /**
             * contentURL : http://cdn.banmi.com/banmiapp/html/1522659154327.html
             * cardURL : http://cdn.banmi.com/banmiapp/rahdna/1522654270428_8f11bbbd503ff42905aea3a58e78e807.png
             * title : 艺术之旅
             */
            private String contentURL;
            private String cardURL;
            private String title;

            public void setContentURL(String contentURL) {
                this.contentURL = contentURL;
            }

            public void setCardURL(String cardURL) {
                this.cardURL = cardURL;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContentURL() {
                return contentURL;
            }

            public String getCardURL() {
                return cardURL;
            }

            public String getTitle() {
                return title;
            }
        }
    }
}
