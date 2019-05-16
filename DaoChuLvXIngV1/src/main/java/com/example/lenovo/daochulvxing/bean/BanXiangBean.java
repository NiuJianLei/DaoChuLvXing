package com.example.lenovo.daochulvxing.bean;

import java.util.List;

public class BanXiangBean {

    /**
     * result : {"activities":[{"date":"2018-06-11 11:29","audioURL":"","images":["http://cdn.banmi.com/banmiapp/rahdna/1528687645655_017ac0c99763774956d6539de09f77bb.jpg","http://cdn.banmi.com/banmiapp/rahdna/1528687668169_d0faf96c50fa3c8a85ffa7e39592b773.jpg","http://cdn.banmi.com/banmiapp/rahdna/1528687672881_7b758f169b9b2d665e826222944f74ad.jpg","http://cdn.banmi.com/banmiapp/rahdna/1528687676506_1a1ade61808bd9c6a4bfb0850779ad67.jpg"],"replyCount":0,"firstImageHeight":0,"firstImageWidth":0,"isLiked":false,"audioLength":0,"likeCount":1,"id":198,"content":"京都三日匆忙就结束了，遇到对的人每天都是儿童节！"},{"date":"2018-03-16 16:33","audioURL":"","images":["http://cdn.banmi.com/banmiapp/rahdna/1521189079955_6bdbdf233f26cf41460141534fd18d16.jpg","http://cdn.banmi.com/banmiapp/rahdna/1521189093580_5a7fe91afa8557cba6940a1aa827134e.jpg"],"replyCount":0,"firstImageHeight":0,"firstImageWidth":0,"isLiked":false,"audioLength":0,"likeCount":18,"id":192,"content":"跟着我一起，带你走进最正宗的西澳世界！"}],"count":2,"limit":20,"banmi":{"routesCount":2,"occupation":"全球深度游旅行玩家","following":1627,"name":"JoJo","photo":"http://cdn.banmi.com/banmiapp/rahdna/1528685160318_380c455a73d17d6bea4a6db74d62fb80.jpg","location":"苏州","id":54,"introduction":"你好，我是旅行玩家JoJo。从高中开始就在澳洲西部的珀斯留学，大学转到了东部的墨尔本。在将近7年的澳洲学习生活中，每个周末只要有空，我就会和朋友去周边旅行。其中我最喜欢的就是在西澳自驾游，不仅景美，西澳人的朴实热情更是让我感觉亲切友好，内心温暖。所以假如你想要一个放松心情、放慢脚步的旅行，我一定会首先推荐你来西澳。  直到现在，我对旅行的上瘾热度也一直未减，一年有将近一半的时间我都在世界各地深度旅行，目前已经流浪过十几个国家，除了澳洲，待得最久的地方就是韩国了。我跑遍了梨泰院、江南、圣水洞等等我喜欢的街区，掘地三尺，挖出了不少我喜欢的地方。尤其因为我喜欢住在当地人家里，和他们一起生活、交谈，这样可以让我最快速地体验到最地道的本地文化，发现最受当地人欢迎的地方。所以跟着我深度游，可以了解每座城市不一样的魅力哦。","isFollowed":false},"share":{"shareContent":"作为全球深度游旅行玩家，我的生活和旅行路线绝对精彩！","shareTitle":"我是JoJo，看看我的私藏旅行线路！","shareImage":"http://cdn.banmi.com/banmiapp/rahdna/1528685160318_380c455a73d17d6bea4a6db74d62fb80.jpg","shareURL":"http://banmi.com/app2017/banmi.html?id=54"},"page":1}
     * code : 0
     * desc :
     */
    private ResultEntity result;
    private int code;
    private String desc;

    @Override
    public String toString() {
        return "BanXiangBean{" +
                "result=" + result +
                ", code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }

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
         * activities : [{"date":"2018-06-11 11:29","audioURL":"","images":["http://cdn.banmi.com/banmiapp/rahdna/1528687645655_017ac0c99763774956d6539de09f77bb.jpg","http://cdn.banmi.com/banmiapp/rahdna/1528687668169_d0faf96c50fa3c8a85ffa7e39592b773.jpg","http://cdn.banmi.com/banmiapp/rahdna/1528687672881_7b758f169b9b2d665e826222944f74ad.jpg","http://cdn.banmi.com/banmiapp/rahdna/1528687676506_1a1ade61808bd9c6a4bfb0850779ad67.jpg"],"replyCount":0,"firstImageHeight":0,"firstImageWidth":0,"isLiked":false,"audioLength":0,"likeCount":1,"id":198,"content":"京都三日匆忙就结束了，遇到对的人每天都是儿童节！"},{"date":"2018-03-16 16:33","audioURL":"","images":["http://cdn.banmi.com/banmiapp/rahdna/1521189079955_6bdbdf233f26cf41460141534fd18d16.jpg","http://cdn.banmi.com/banmiapp/rahdna/1521189093580_5a7fe91afa8557cba6940a1aa827134e.jpg"],"replyCount":0,"firstImageHeight":0,"firstImageWidth":0,"isLiked":false,"audioLength":0,"likeCount":18,"id":192,"content":"跟着我一起，带你走进最正宗的西澳世界！"}]
         * count : 2
         * limit : 20
         * banmi : {"routesCount":2,"occupation":"全球深度游旅行玩家","following":1627,"name":"JoJo","photo":"http://cdn.banmi.com/banmiapp/rahdna/1528685160318_380c455a73d17d6bea4a6db74d62fb80.jpg","location":"苏州","id":54,"introduction":"你好，我是旅行玩家JoJo。从高中开始就在澳洲西部的珀斯留学，大学转到了东部的墨尔本。在将近7年的澳洲学习生活中，每个周末只要有空，我就会和朋友去周边旅行。其中我最喜欢的就是在西澳自驾游，不仅景美，西澳人的朴实热情更是让我感觉亲切友好，内心温暖。所以假如你想要一个放松心情、放慢脚步的旅行，我一定会首先推荐你来西澳。  直到现在，我对旅行的上瘾热度也一直未减，一年有将近一半的时间我都在世界各地深度旅行，目前已经流浪过十几个国家，除了澳洲，待得最久的地方就是韩国了。我跑遍了梨泰院、江南、圣水洞等等我喜欢的街区，掘地三尺，挖出了不少我喜欢的地方。尤其因为我喜欢住在当地人家里，和他们一起生活、交谈，这样可以让我最快速地体验到最地道的本地文化，发现最受当地人欢迎的地方。所以跟着我深度游，可以了解每座城市不一样的魅力哦。","isFollowed":false}
         * share : {"shareContent":"作为全球深度游旅行玩家，我的生活和旅行路线绝对精彩！","shareTitle":"我是JoJo，看看我的私藏旅行线路！","shareImage":"http://cdn.banmi.com/banmiapp/rahdna/1528685160318_380c455a73d17d6bea4a6db74d62fb80.jpg","shareURL":"http://banmi.com/app2017/banmi.html?id=54"}
         * page : 1
         */
        private List<ActivitiesEntity> activities;
        private int count;
        private int limit;
        private BanmiEntity banmi;
        private ShareEntity share;
        private int page;

        @Override
        public String toString() {
            return "ResultEntity{" +
                    "activities=" + activities +
                    ", count=" + count +
                    ", limit=" + limit +
                    ", banmi=" + banmi +
                    ", share=" + share +
                    ", page=" + page +
                    '}';
        }

        public void setActivities(List<ActivitiesEntity> activities) {
            this.activities = activities;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public void setBanmi(BanmiEntity banmi) {
            this.banmi = banmi;
        }

        public void setShare(ShareEntity share) {
            this.share = share;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public List<ActivitiesEntity> getActivities() {
            return activities;
        }

        public int getCount() {
            return count;
        }

        public int getLimit() {
            return limit;
        }

        public BanmiEntity getBanmi() {
            return banmi;
        }

        public ShareEntity getShare() {
            return share;
        }

        public int getPage() {
            return page;
        }

        public class ActivitiesEntity {
            /**
             * date : 2018-06-11 11:29
             * audioURL :
             * images : ["http://cdn.banmi.com/banmiapp/rahdna/1528687645655_017ac0c99763774956d6539de09f77bb.jpg","http://cdn.banmi.com/banmiapp/rahdna/1528687668169_d0faf96c50fa3c8a85ffa7e39592b773.jpg","http://cdn.banmi.com/banmiapp/rahdna/1528687672881_7b758f169b9b2d665e826222944f74ad.jpg","http://cdn.banmi.com/banmiapp/rahdna/1528687676506_1a1ade61808bd9c6a4bfb0850779ad67.jpg"]
             * replyCount : 0
             * firstImageHeight : 0
             * firstImageWidth : 0
             * isLiked : false
             * audioLength : 0
             * likeCount : 1
             * id : 198
             * content : 京都三日匆忙就结束了，遇到对的人每天都是儿童节！
             */
            private String date;
            private String audioURL;
            private List<String> images;
            private int replyCount;
            private int firstImageHeight;
            private int firstImageWidth;
            private boolean isLiked;
            private int audioLength;
            private int likeCount;
            private int id;
            private String content;

            @Override
            public String toString() {
                return "ActivitiesEntity{" +
                        "date='" + date + '\'' +
                        ", audioURL='" + audioURL + '\'' +
                        ", images=" + images +
                        ", replyCount=" + replyCount +
                        ", firstImageHeight=" + firstImageHeight +
                        ", firstImageWidth=" + firstImageWidth +
                        ", isLiked=" + isLiked +
                        ", audioLength=" + audioLength +
                        ", likeCount=" + likeCount +
                        ", id=" + id +
                        ", content='" + content + '\'' +
                        '}';
            }

            public void setDate(String date) {
                this.date = date;
            }

            public void setAudioURL(String audioURL) {
                this.audioURL = audioURL;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }

            public void setReplyCount(int replyCount) {
                this.replyCount = replyCount;
            }

            public void setFirstImageHeight(int firstImageHeight) {
                this.firstImageHeight = firstImageHeight;
            }

            public void setFirstImageWidth(int firstImageWidth) {
                this.firstImageWidth = firstImageWidth;
            }

            public void setIsLiked(boolean isLiked) {
                this.isLiked = isLiked;
            }

            public void setAudioLength(int audioLength) {
                this.audioLength = audioLength;
            }

            public void setLikeCount(int likeCount) {
                this.likeCount = likeCount;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getDate() {
                return date;
            }

            public String getAudioURL() {
                return audioURL;
            }

            public List<String> getImages() {
                return images;
            }

            public int getReplyCount() {
                return replyCount;
            }

            public int getFirstImageHeight() {
                return firstImageHeight;
            }

            public int getFirstImageWidth() {
                return firstImageWidth;
            }

            public boolean isIsLiked() {
                return isLiked;
            }

            public int getAudioLength() {
                return audioLength;
            }

            public int getLikeCount() {
                return likeCount;
            }

            public int getId() {
                return id;
            }

            public String getContent() {
                return content;
            }
        }

        public class BanmiEntity {
            /**
             * routesCount : 2
             * occupation : 全球深度游旅行玩家
             * following : 1627
             * name : JoJo
             * photo : http://cdn.banmi.com/banmiapp/rahdna/1528685160318_380c455a73d17d6bea4a6db74d62fb80.jpg
             * location : 苏州
             * id : 54
             * introduction : 你好，我是旅行玩家JoJo。从高中开始就在澳洲西部的珀斯留学，大学转到了东部的墨尔本。在将近7年的澳洲学习生活中，每个周末只要有空，我就会和朋友去周边旅行。其中我最喜欢的就是在西澳自驾游，不仅景美，西澳人的朴实热情更是让我感觉亲切友好，内心温暖。所以假如你想要一个放松心情、放慢脚步的旅行，我一定会首先推荐你来西澳。  直到现在，我对旅行的上瘾热度也一直未减，一年有将近一半的时间我都在世界各地深度旅行，目前已经流浪过十几个国家，除了澳洲，待得最久的地方就是韩国了。我跑遍了梨泰院、江南、圣水洞等等我喜欢的街区，掘地三尺，挖出了不少我喜欢的地方。尤其因为我喜欢住在当地人家里，和他们一起生活、交谈，这样可以让我最快速地体验到最地道的本地文化，发现最受当地人欢迎的地方。所以跟着我深度游，可以了解每座城市不一样的魅力哦。
             * isFollowed : false
             */
            private int routesCount;
            private String occupation;
            private int following;
            private String name;
            private String photo;
            private String location;
            private int id;
            private String introduction;
            private boolean isFollowed;

            @Override
            public String toString() {
                return "BanmiEntity{" +
                        "routesCount=" + routesCount +
                        ", occupation='" + occupation + '\'' +
                        ", following=" + following +
                        ", name='" + name + '\'' +
                        ", photo='" + photo + '\'' +
                        ", location='" + location + '\'' +
                        ", id=" + id +
                        ", introduction='" + introduction + '\'' +
                        ", isFollowed=" + isFollowed +
                        '}';
            }

            public void setRoutesCount(int routesCount) {
                this.routesCount = routesCount;
            }

            public void setOccupation(String occupation) {
                this.occupation = occupation;
            }

            public void setFollowing(int following) {
                this.following = following;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public void setIsFollowed(boolean isFollowed) {
                this.isFollowed = isFollowed;
            }

            public int getRoutesCount() {
                return routesCount;
            }

            public String getOccupation() {
                return occupation;
            }

            public int getFollowing() {
                return following;
            }

            public String getName() {
                return name;
            }

            public String getPhoto() {
                return photo;
            }

            public String getLocation() {
                return location;
            }

            public int getId() {
                return id;
            }

            public String getIntroduction() {
                return introduction;
            }

            public boolean isIsFollowed() {
                return isFollowed;
            }
        }

        public class ShareEntity {
            /**
             * shareContent : 作为全球深度游旅行玩家，我的生活和旅行路线绝对精彩！
             * shareTitle : 我是JoJo，看看我的私藏旅行线路！
             * shareImage : http://cdn.banmi.com/banmiapp/rahdna/1528685160318_380c455a73d17d6bea4a6db74d62fb80.jpg
             * shareURL : http://banmi.com/app2017/banmi.html?id=54
             */
            private String shareContent;
            private String shareTitle;
            private String shareImage;
            private String shareURL;

            @Override
            public String toString() {
                return "ShareEntity{" +
                        "shareContent='" + shareContent + '\'' +
                        ", shareTitle='" + shareTitle + '\'' +
                        ", shareImage='" + shareImage + '\'' +
                        ", shareURL='" + shareURL + '\'' +
                        '}';
            }

            public void setShareContent(String shareContent) {
                this.shareContent = shareContent;
            }

            public void setShareTitle(String shareTitle) {
                this.shareTitle = shareTitle;
            }

            public void setShareImage(String shareImage) {
                this.shareImage = shareImage;
            }

            public void setShareURL(String shareURL) {
                this.shareURL = shareURL;
            }

            public String getShareContent() {
                return shareContent;
            }

            public String getShareTitle() {
                return shareTitle;
            }

            public String getShareImage() {
                return shareImage;
            }

            public String getShareURL() {
                return shareURL;
            }
        }
    }
}
