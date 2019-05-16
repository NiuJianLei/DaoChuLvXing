package com.example.lenovo.daochulvxing.bean;


import java.util.List;

public class XiangBean {


    /**
     * result : {"route":{"city":"日本·石川","priceInCents":190,"description":"你好，我是千夏。来日本学习、工作加起来已快10年了，目前在东京一家媒体做媒体策划。我最初来日本时生活在日本北陆的石川县，在这里的日子让我与手工艺、茶道、和服等等日本传统结下了不解之缘，我也有幸担任了石川县的观光特使，因此能进一步发掘并传递石川的魅力。  这次我要带你去的地方是石川县的首府\u2014\u2014金泽市。在日本这个灾难频发的国家 ，金泽可以说是一个福地，这里没有太多自然灾害，也没有经历战火的破坏，所以自然景观原汁原味、名胜古迹保存完好，是一个美景与历史文化的宝库。另外，目前被全世界推崇的日本匠人精神和传统手工艺也是金泽最大的魅力之一。  如果你已经走遍了日本的热点城市，那不如学习当地人，在周末乘坐新干线来到金泽，在这里寻找旧时的江户风情和京都古韵。如果你没来过日本，不妨选择从金泽试水，我保证无论是自然风光、历史文化，还是艺术、美食，这座小城都毫不逊色。 我们从世界最美的车站开始旅程，去欣赏金箔工艺、到许愿圣地祈求心愿达成、逛金泽最著名的庭园和民俗风情小巷，当然还要去金泽人自家的厨房尝鲜\u2026\u2026 一路慢走慢行，安静地感受这座北陆小城的古朴素雅。","cityID":42,"shareImageWechat":"http://cdn.banmi.com/banmiapp/rahdna/1517830337811_7642a7498f796779e38b82a59e7c69ed.jpg","title":"金泽","isPurchased":true,"purchasedTimes":1744,"banmiID":48,"sequence":-16,"shareContent":"日本北陆传统艺术之乡","shareTitle":"艺术の乡金泽之旅","videoURL":"","price":"1.9","intro":"日本北陆传统艺术之乡","shareURL":"http://banmi.com/app2017/route3.html?id=191&referer=7835","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1517830337811_7642a7498f796779e38b82a59e7c69ed.jpg","id":191,"isCollected":false},"reviews":[{"createdAt":"4月前","images":[],"userPhoto":"http://media.banmi.com/photos/1450056908845_4c2c37867de51891ecab70ab303189c7","userName":"彭博勛","reviewID":2718,"content":"去市场里吃最新鲜的食材是最棒滴！"},{"createdAt":"4月前","images":[],"userPhoto":"http://media.banmi.com/photos/1451972644954_f2244faa58ff272163b209c32e552c8d","userName":"米霍","reviewID":2708,"content":"东茶屋街一定要去呀，拍照超有感觉，屋子也都保留着原来的风格"},{"createdAt":"5月前","images":[],"userPhoto":"http://media.banmi.com/photos/1451314206839_d325bcfcb6af3872d9f990d86dd4d2df","userName":"没有太阳的日子","reviewID":2644,"content":"日本对传统文化的保护和传承太让人敬佩了，金泽绝对值得一去再去，特别有底蕴的地方！"}],"banmi":{"occupation":"日本石川县观光特使","name":"千夏CHIKA","photo":"http://cdn.banmi.com/banmiapp/rahdna/1517992572669_4ccbad2c54247878eae0b37daee85cab.jpg","location":"东京","id":48,"introduction":"大家好，我是千夏。来日本学习、工作加起来已快10年了。 我最初来日本时生活在日本北陆的石川县，在这里的日子让我与手工艺、茶道、和服等等传统文化结下了不解之缘，因此我也有幸担任了石川县的观光特使，能进一步发掘并传递石川的魅力。 后来，我到了东京工作生活，在这个日本的首府，我更加发现文化是可以超越国境的，而且中日文化古来就具有亲密性，我会继续对中日文化交流的追求，以求成为一个传达文化精髓的人。 希望我的路线不仅仅能带来旅行的参考，也能将当地文化分享给你。","photo4":"http://cdn.banmi.com/banmiapp/rahdna/1517992572669_4ccbad2c54247878eae0b37daee85cab.jpg"},"reviewsCount":27,"carousel":["http://cdn.banmi.com/banmiapp/rahdna/1517830337811_7642a7498f796779e38b82a59e7c69ed.jpg"]}
     * code : 0
     * desc :
     */
    private ResultEntity result;
    private int code;
    private String desc;

    @Override
    public String toString() {
        return "XiangBean{" +
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
         * route : {"city":"日本·石川","priceInCents":190,"description":"你好，我是千夏。来日本学习、工作加起来已快10年了，目前在东京一家媒体做媒体策划。我最初来日本时生活在日本北陆的石川县，在这里的日子让我与手工艺、茶道、和服等等日本传统结下了不解之缘，我也有幸担任了石川县的观光特使，因此能进一步发掘并传递石川的魅力。  这次我要带你去的地方是石川县的首府\u2014\u2014金泽市。在日本这个灾难频发的国家 ，金泽可以说是一个福地，这里没有太多自然灾害，也没有经历战火的破坏，所以自然景观原汁原味、名胜古迹保存完好，是一个美景与历史文化的宝库。另外，目前被全世界推崇的日本匠人精神和传统手工艺也是金泽最大的魅力之一。  如果你已经走遍了日本的热点城市，那不如学习当地人，在周末乘坐新干线来到金泽，在这里寻找旧时的江户风情和京都古韵。如果你没来过日本，不妨选择从金泽试水，我保证无论是自然风光、历史文化，还是艺术、美食，这座小城都毫不逊色。 我们从世界最美的车站开始旅程，去欣赏金箔工艺、到许愿圣地祈求心愿达成、逛金泽最著名的庭园和民俗风情小巷，当然还要去金泽人自家的厨房尝鲜\u2026\u2026 一路慢走慢行，安静地感受这座北陆小城的古朴素雅。","cityID":42,"shareImageWechat":"http://cdn.banmi.com/banmiapp/rahdna/1517830337811_7642a7498f796779e38b82a59e7c69ed.jpg","title":"金泽","isPurchased":true,"purchasedTimes":1744,"banmiID":48,"sequence":-16,"shareContent":"日本北陆传统艺术之乡","shareTitle":"艺术の乡金泽之旅","videoURL":"","price":"1.9","intro":"日本北陆传统艺术之乡","shareURL":"http://banmi.com/app2017/route3.html?id=191&referer=7835","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1517830337811_7642a7498f796779e38b82a59e7c69ed.jpg","id":191,"isCollected":false}
         * reviews : [{"createdAt":"4月前","images":[],"userPhoto":"http://media.banmi.com/photos/1450056908845_4c2c37867de51891ecab70ab303189c7","userName":"彭博勛","reviewID":2718,"content":"去市场里吃最新鲜的食材是最棒滴！"},{"createdAt":"4月前","images":[],"userPhoto":"http://media.banmi.com/photos/1451972644954_f2244faa58ff272163b209c32e552c8d","userName":"米霍","reviewID":2708,"content":"东茶屋街一定要去呀，拍照超有感觉，屋子也都保留着原来的风格"},{"createdAt":"5月前","images":[],"userPhoto":"http://media.banmi.com/photos/1451314206839_d325bcfcb6af3872d9f990d86dd4d2df","userName":"没有太阳的日子","reviewID":2644,"content":"日本对传统文化的保护和传承太让人敬佩了，金泽绝对值得一去再去，特别有底蕴的地方！"}]
         * banmi : {"occupation":"日本石川县观光特使","name":"千夏CHIKA","photo":"http://cdn.banmi.com/banmiapp/rahdna/1517992572669_4ccbad2c54247878eae0b37daee85cab.jpg","location":"东京","id":48,"introduction":"大家好，我是千夏。来日本学习、工作加起来已快10年了。 我最初来日本时生活在日本北陆的石川县，在这里的日子让我与手工艺、茶道、和服等等传统文化结下了不解之缘，因此我也有幸担任了石川县的观光特使，能进一步发掘并传递石川的魅力。 后来，我到了东京工作生活，在这个日本的首府，我更加发现文化是可以超越国境的，而且中日文化古来就具有亲密性，我会继续对中日文化交流的追求，以求成为一个传达文化精髓的人。 希望我的路线不仅仅能带来旅行的参考，也能将当地文化分享给你。","photo4":"http://cdn.banmi.com/banmiapp/rahdna/1517992572669_4ccbad2c54247878eae0b37daee85cab.jpg"}
         * reviewsCount : 27
         * carousel : ["http://cdn.banmi.com/banmiapp/rahdna/1517830337811_7642a7498f796779e38b82a59e7c69ed.jpg"]
         */
        private RouteEntity route;

        @Override
        public String toString() {
            return "ResultEntity{" +
                    "route=" + route +
                    ", reviews=" + reviews +
                    ", banmi=" + banmi +
                    ", reviewsCount=" + reviewsCount +
                    ", carousel=" + carousel +
                    '}';
        }

        private List<ReviewsEntity> reviews;
        private BanmiEntity banmi;
        private int reviewsCount;
        private List<String> carousel;

        public void setRoute(RouteEntity route) {
            this.route = route;
        }

        public void setReviews(List<ReviewsEntity> reviews) {
            this.reviews = reviews;
        }

        public void setBanmi(BanmiEntity banmi) {
            this.banmi = banmi;
        }

        public void setReviewsCount(int reviewsCount) {
            this.reviewsCount = reviewsCount;
        }

        public void setCarousel(List<String> carousel) {
            this.carousel = carousel;
        }

        public RouteEntity getRoute() {
            return route;
        }

        public List<ReviewsEntity> getReviews() {
            return reviews;
        }

        public BanmiEntity getBanmi() {
            return banmi;
        }

        public int getReviewsCount() {
            return reviewsCount;
        }

        public List<String> getCarousel() {
            return carousel;
        }

        public class RouteEntity {
            /**
             * city : 日本·石川
             * priceInCents : 190
             * description : 你好，我是千夏。来日本学习、工作加起来已快10年了，目前在东京一家媒体做媒体策划。我最初来日本时生活在日本北陆的石川县，在这里的日子让我与手工艺、茶道、和服等等日本传统结下了不解之缘，我也有幸担任了石川县的观光特使，因此能进一步发掘并传递石川的魅力。  这次我要带你去的地方是石川县的首府——金泽市。在日本这个灾难频发的国家 ，金泽可以说是一个福地，这里没有太多自然灾害，也没有经历战火的破坏，所以自然景观原汁原味、名胜古迹保存完好，是一个美景与历史文化的宝库。另外，目前被全世界推崇的日本匠人精神和传统手工艺也是金泽最大的魅力之一。  如果你已经走遍了日本的热点城市，那不如学习当地人，在周末乘坐新干线来到金泽，在这里寻找旧时的江户风情和京都古韵。如果你没来过日本，不妨选择从金泽试水，我保证无论是自然风光、历史文化，还是艺术、美食，这座小城都毫不逊色。 我们从世界最美的车站开始旅程，去欣赏金箔工艺、到许愿圣地祈求心愿达成、逛金泽最著名的庭园和民俗风情小巷，当然还要去金泽人自家的厨房尝鲜…… 一路慢走慢行，安静地感受这座北陆小城的古朴素雅。
             * cityID : 42
             * shareImageWechat : http://cdn.banmi.com/banmiapp/rahdna/1517830337811_7642a7498f796779e38b82a59e7c69ed.jpg
             * title : 金泽
             * isPurchased : true
             * purchasedTimes : 1744
             * banmiID : 48
             * sequence : -16
             * shareContent : 日本北陆传统艺术之乡
             * shareTitle : 艺术の乡金泽之旅
             * videoURL :
             * price : 1.9
             * intro : 日本北陆传统艺术之乡
             * shareURL : http://banmi.com/app2017/route3.html?id=191&referer=7835
             * cardURL : http://cdn.banmi.com/banmiapp/rahdna/1517830337811_7642a7498f796779e38b82a59e7c69ed.jpg
             * id : 191
             * isCollected : false
             */
            private String city;
            private int priceInCents;
            private String description;
            private int cityID;
            private String shareImageWechat;
            private String title;
            private boolean isPurchased;

            @Override
            public String toString() {
                return "RouteEntity{" +
                        "city='" + city + '\'' +
                        ", priceInCents=" + priceInCents +
                        ", description='" + description + '\'' +
                        ", cityID=" + cityID +
                        ", shareImageWechat='" + shareImageWechat + '\'' +
                        ", title='" + title + '\'' +
                        ", isPurchased=" + isPurchased +
                        ", purchasedTimes=" + purchasedTimes +
                        ", banmiID=" + banmiID +
                        ", sequence=" + sequence +
                        ", shareContent='" + shareContent + '\'' +
                        ", shareTitle='" + shareTitle + '\'' +
                        ", videoURL='" + videoURL + '\'' +
                        ", price='" + price + '\'' +
                        ", intro='" + intro + '\'' +
                        ", shareURL='" + shareURL + '\'' +
                        ", cardURL='" + cardURL + '\'' +
                        ", id=" + id +
                        ", isCollected=" + isCollected +
                        '}';
            }

            private int purchasedTimes;
            private int banmiID;
            private int sequence;
            private String shareContent;
            private String shareTitle;
            private String videoURL;
            private String price;
            private String intro;
            private String shareURL;
            private String cardURL;
            private int id;
            private boolean isCollected;

            public void setCity(String city) {
                this.city = city;
            }

            public void setPriceInCents(int priceInCents) {
                this.priceInCents = priceInCents;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public void setCityID(int cityID) {
                this.cityID = cityID;
            }

            public void setShareImageWechat(String shareImageWechat) {
                this.shareImageWechat = shareImageWechat;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setIsPurchased(boolean isPurchased) {
                this.isPurchased = isPurchased;
            }

            public void setPurchasedTimes(int purchasedTimes) {
                this.purchasedTimes = purchasedTimes;
            }

            public void setBanmiID(int banmiID) {
                this.banmiID = banmiID;
            }

            public void setSequence(int sequence) {
                this.sequence = sequence;
            }

            public void setShareContent(String shareContent) {
                this.shareContent = shareContent;
            }

            public void setShareTitle(String shareTitle) {
                this.shareTitle = shareTitle;
            }

            public void setVideoURL(String videoURL) {
                this.videoURL = videoURL;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public void setShareURL(String shareURL) {
                this.shareURL = shareURL;
            }

            public void setCardURL(String cardURL) {
                this.cardURL = cardURL;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setIsCollected(boolean isCollected) {
                this.isCollected = isCollected;
            }

            public String getCity() {
                return city;
            }

            public int getPriceInCents() {
                return priceInCents;
            }

            public String getDescription() {
                return description;
            }

            public int getCityID() {
                return cityID;
            }

            public String getShareImageWechat() {
                return shareImageWechat;
            }

            public String getTitle() {
                return title;
            }

            public boolean isIsPurchased() {
                return isPurchased;
            }

            public int getPurchasedTimes() {
                return purchasedTimes;
            }

            public int getBanmiID() {
                return banmiID;
            }

            public int getSequence() {
                return sequence;
            }

            public String getShareContent() {
                return shareContent;
            }

            public String getShareTitle() {
                return shareTitle;
            }

            public String getVideoURL() {
                return videoURL;
            }

            public String getPrice() {
                return price;
            }

            public String getIntro() {
                return intro;
            }

            public String getShareURL() {
                return shareURL;
            }

            public String getCardURL() {
                return cardURL;
            }

            public int getId() {
                return id;
            }

            public boolean isIsCollected() {
                return isCollected;
            }
        }

        public class ReviewsEntity {
            /**
             * createdAt : 4月前
             * images : []
             * userPhoto : http://media.banmi.com/photos/1450056908845_4c2c37867de51891ecab70ab303189c7
             * userName : 彭博勛
             * reviewID : 2718
             * content : 去市场里吃最新鲜的食材是最棒滴！
             */
            private String createdAt;
            private List<?> images;
            private String userPhoto;
            private String userName;
            private int reviewID;

            @Override
            public String toString() {
                return "ReviewsEntity{" +
                        "createdAt='" + createdAt + '\'' +
                        ", images=" + images +
                        ", userPhoto='" + userPhoto + '\'' +
                        ", userName='" + userName + '\'' +
                        ", reviewID=" + reviewID +
                        ", content='" + content + '\'' +
                        '}';
            }

            private String content;

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public void setImages(List<?> images) {
                this.images = images;
            }

            public void setUserPhoto(String userPhoto) {
                this.userPhoto = userPhoto;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public void setReviewID(int reviewID) {
                this.reviewID = reviewID;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public List<?> getImages() {
                return images;
            }

            public String getUserPhoto() {
                return userPhoto;
            }

            public String getUserName() {
                return userName;
            }

            public int getReviewID() {
                return reviewID;
            }

            public String getContent() {
                return content;
            }
        }

        public class BanmiEntity {
            /**
             * occupation : 日本石川县观光特使
             * name : 千夏CHIKA
             * photo : http://cdn.banmi.com/banmiapp/rahdna/1517992572669_4ccbad2c54247878eae0b37daee85cab.jpg
             * location : 东京
             * id : 48
             * introduction : 大家好，我是千夏。来日本学习、工作加起来已快10年了。 我最初来日本时生活在日本北陆的石川县，在这里的日子让我与手工艺、茶道、和服等等传统文化结下了不解之缘，因此我也有幸担任了石川县的观光特使，能进一步发掘并传递石川的魅力。 后来，我到了东京工作生活，在这个日本的首府，我更加发现文化是可以超越国境的，而且中日文化古来就具有亲密性，我会继续对中日文化交流的追求，以求成为一个传达文化精髓的人。 希望我的路线不仅仅能带来旅行的参考，也能将当地文化分享给你。
             * photo4 : http://cdn.banmi.com/banmiapp/rahdna/1517992572669_4ccbad2c54247878eae0b37daee85cab.jpg
             */
            private String occupation;
            private String name;
            private String photo;
            private String location;

            @Override
            public String toString() {
                return "BanmiEntity{" +
                        "occupation='" + occupation + '\'' +
                        ", name='" + name + '\'' +
                        ", photo='" + photo + '\'' +
                        ", location='" + location + '\'' +
                        ", id=" + id +
                        ", introduction='" + introduction + '\'' +
                        ", photo4='" + photo4 + '\'' +
                        '}';
            }

            private int id;
            private String introduction;
            private String photo4;

            public void setOccupation(String occupation) {
                this.occupation = occupation;
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

            public void setPhoto4(String photo4) {
                this.photo4 = photo4;
            }

            public String getOccupation() {
                return occupation;
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

            public String getPhoto4() {
                return photo4;
            }
        }

    }

}
