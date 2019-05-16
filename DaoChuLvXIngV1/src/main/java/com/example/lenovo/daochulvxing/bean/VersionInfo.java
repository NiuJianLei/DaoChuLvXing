package com.example.lenovo.daochulvxing.bean;

public class VersionInfo  {

    /**
     * result : {"info":{"is_force_update":"2","feature":"","download_url":"http://cdn.banmi.com/banmiapp/apk/banmi_333.apk","recommend":"3.1.3","title":"","version":"3.3.3"}}
     * code : 0
     * desc : 处理成功
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
         * info : {"is_force_update":"2","feature":"","download_url":"http://cdn.banmi.com/banmiapp/apk/banmi_333.apk","recommend":"3.1.3","title":"","version":"3.3.3"}
         */
        private InfoEntity info;

        public void setInfo(InfoEntity info) {
            this.info = info;
        }

        public InfoEntity getInfo() {
            return info;
        }

        public class InfoEntity {
            /**
             * is_force_update : 2
             * feature :
             * download_url : http://cdn.banmi.com/banmiapp/apk/banmi_333.apk
             * recommend : 3.1.3
             * title :
             * version : 3.3.3
             */
            private String is_force_update;
            private String feature;
            private String download_url;
            private String recommend;
            private String title;
            private String version;

            public void setIs_force_update(String is_force_update) {
                this.is_force_update = is_force_update;
            }

            public void setFeature(String feature) {
                this.feature = feature;
            }

            public void setDownload_url(String download_url) {
                this.download_url = download_url;
            }

            public void setRecommend(String recommend) {
                this.recommend = recommend;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public String getIs_force_update() {
                return is_force_update;
            }

            public String getFeature() {
                return feature;
            }

            public String getDownload_url() {
                return download_url;
            }

            public String getRecommend() {
                return recommend;
            }

            public String getTitle() {
                return title;
            }

            public String getVersion() {
                return version;
            }
        }
    }
}
