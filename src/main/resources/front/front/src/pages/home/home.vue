<template>
	<div class="home-preview" :style='{"margin":"0px auto","flexWrap":"wrap","flexDirection":"row","background":"none","display":"flex","width":"100%","justifyContent":"center"}'>




		
		<!-- 新闻资讯 -->
		<div id="animate_newsnews" class="news animate__animated" :style='{"width":"70%","padding":"0px 7%","margin":"0 0 10px","background":"url(),#fff","flex":"1","order":"5"}'>
			<div class="title" :style='{"width":"350px","padding":"12px 0 0","margin":"40px auto 10px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230926/29aeffa47b9e4167bdbde3dbb38c76ef.png) no-repeat left top / auto 100%,url(http://codegen.caihongy.cn/20230926/528003d3e7fe4dd9bd6ff39d76a18b8d.png) no-repeat right top / auto 100%,url(http://codegen.caihongy.cn/20230926/c4688b52f94c4bc283a776058f0027c7.png) repeat-x center top / auto 100%","height":"60px"}'>
				<span :style='{"color":"#333","fontSize":"22px","fontWeight":"500"}'>林业资讯</span>
			</div>
		
		<div v-if="newsList.length" class="list list13 index-pv1" :style='{"padding":"0","margin":"0 auto","color":"#999","background":"none","width":"100%","fontSize":"14px","height":"auto"}'>
		  <div :style='{"width":"100%","margin":"0 0 20px","background":"#fff","justifyContent":"space-between","display":"flex","height":"auto"}'>
		    <div :style='{"width":"50%","padding":"0 10px","height":"auto","order":"2"}'>
			  <template v-for="(item,index) in newsList">
		      <div v-if="index < 3" @click="toDetail('newsDetail', item)" class="list-item animation-box" :style='{"width":"100%","padding":"10px","margin":"10px 0","background":"none","height":"auto"}'>
		        <div :style='{"overflow":"hidden","whiteSpace":"nowrap","color":"#000","width":"100%","lineHeight":"1.5","fontSize":"14px","textOverflow":"ellipsis","fontWeight":"600"}' class="name">{{item.title}}</div>
		        <div :style='{"lineHeight":"24px","fontSize":"14px","overflow":"hidden","color":"#666","textIndent":"2em","height":"48px"}' class="name">{{item.introduction}}</div>
		        <div :style='{"padding":"0 10px","display":"inline-block"}'>
		          <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		          <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.addtime}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","display":"inline-block"}'>
		          <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		          <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.name}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","display":"inline-block"}'>
		          <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		          <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.thumbsupnum}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","display":"inline-block"}'>
		          <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		          <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.storeupnum}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","display":"inline-block"}'>
		          <span class="icon iconfont icon-chakan2" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		          <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.clicknum}}</span>
		        </div>
		      </div>
			  </template>
		    </div>
		    <div :style='{"width":"50%","padding":"10px","height":"auto"}'>
		      <div v-if="newsList.length > 3" class="swiper-container newsSwiper13 new-list-13news">
		        <div class="swiper-wrapper">
				  <template v-for="(item,index) in newsList">
		          <div v-if="index > 2 && index < 6" class="swiper-slide">
		            <div :style='{"width":"100%","position":"relative","height":"auto"}' @click="toDetail('newsDetail', item)">
		              <img :style='{"width":"100%","objectFit":"cover","display":"block","height":"360px"}' :src="baseUrl + item.picture">
		              <div :style='{"width":"100%","position":"absolute","left":"0","bottom":"0","background":"rgba(0,0,0,.3)"}'>
		                <div :style='{"padding":"0 10px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","width":"100%","lineHeight":"44px","fontSize":"14px","textOverflow":"ellipsis"}'>{{item.title}}</div>
		              </div>
		            </div>
		          </div>
				  </template>
		        </div>
		        <!-- Add Pagination -->
		        <div class="swiper-pagination" :style='{"width":"100%","left":"0","textAlign":"right","bottom":"10px"}'></div>
		      </div>
		    </div>
		  </div>
		  <div v-if="newsList.length > 6" :style='{"width":"100%","justifyContent":"space-between","display":"none","height":"auto"}'>
			<template v-for="(item,index) in newsList">
		    <div v-if="index > 5" @click="toDetail('newsDetail', item)" class="list-item animation-box" :style='{"width":"24%","padding":"0 0 10px","position":"relative","background":"#fff","height":"auto"}'>
		      <img :style='{"width":"100%","objectFit":"cover","display":"block","height":"250px"}' :src="baseUrl + item.picture">
		      <div :style='{"padding":"5px 10px","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"100%","lineHeight":"1.5","fontSize":"14px","textOverflow":"ellipsis"}' class="name">{{item.title}}</div>
		      <div :style='{"padding":"0 10px","lineHeight":"24px","fontSize":"14px","overflow":"hidden","color":"#999","height":"48px"}' class="name">{{item.introduction}}</div>
		      <div :style='{"padding":"0 10px","margin":"10px 0 0"}'>
		        <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		        <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.addtime}}</span>
		      </div>
		      <div :style='{"padding":"0 10px","margin":"10px 0 0","display":"inline-block"}'>
		        <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		        <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.name}}</span>
		      </div>
		      <div :style='{"padding":"0 10px","display":"inline-block"}'>
		        <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		        <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.thumbsupnum}}</span>
		      </div>
		      <div :style='{"padding":"0 10px","display":"inline-block"}'>
		        <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		        <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.storeupnum}}</span>
		      </div>
		      <div :style='{"padding":"0 10px","display":"inline-block"}'>
		        <span class="icon iconfont icon-chakan9" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		        <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.clicknum}}</span>
		      </div>
		    </div>
			</template>
		  </div>
		</div>
		<div @click="moreBtn('news')" :style='{"border":"1px solid #1d8001","cursor":"pointer","margin":"40px auto","textAlign":"center","background":"#fff","display":"block","width":"130px","lineHeight":"36px"}'>
			<span :style='{"color":"#1d8001","fontSize":"16px"}'>查看更多</span>
			<i :style='{"color":"#1d8001","fontSize":"16px"}' class="icon iconfont icon-jiantou09"></i>
		</div>
	</div>
	<!-- 新闻资讯 -->
<!-- 商品推荐 -->
<div id="animate_recommendlinyeziyuan" class="recommend animate__animated" :style='{"padding":"50px 0","margin":"40px auto 20px","borderColor":"#ddd","background":"url(http://codegen.caihongy.cn/20230925/09fadb584de34276bd9a657b0e94d6b8.png) no-repeat center top / 100% 100%,#fff","borderWidth":"0px 0","width":"100%","borderStyle":"solid","order":"3"}'>
    <div class="title" :style='{"width":"350px","margin":"30px auto","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230926/29aeffa47b9e4167bdbde3dbb38c76ef.png) no-repeat left top / auto 100%,url(http://codegen.caihongy.cn/20230926/528003d3e7fe4dd9bd6ff39d76a18b8d.png) no-repeat right top / auto 100%,url(http://codegen.caihongy.cn/20230926/c4688b52f94c4bc283a776058f0027c7.png) repeat-x center top / auto 100%","height":"60px"}'>
		<span :style='{"padding":"12px 0 0","fontSize":"22px","color":"#333","fontWeight":"500","display":"block"}'>林业资源推荐</span>
	</div>
		<div v-if="linyeziyuanRecommend.length" :style='{"padding":"0 7%","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}' class="list list17 index-pv1">
		  <div v-for="item,index in linyeziyuanRecommend" :key="index"  @click="toDetail('linyeziyuanDetail', item)" :style='{"cursor":"pointer","margin":"20px 0","overflow":"hidden","background":"none","width":"23%","position":"relative","height":"280px"}' class="item">
				<img class="image" v-if="preHttp(item.linditupian)" :src="item.linditupian.split(',')[0]" alt="" />
				<img class="image" v-else :src="baseUrl + (item.linditupian?item.linditupian.split(',')[0]:'')" alt="" />
			<div class="content">
		      <div class="info">
				<div :style='{"overflow":"hidden","whiteSpace":"hidden","color":"#fff","textAlign":"center","width":"100%","lineHeight":"40px","fontSize":"14px","textOverflow":"ellipsis"}' class="name ">{{item.lindimingcheng}}</div>
				<div :style='{"overflow":"hidden","whiteSpace":"hidden","color":"#fff","textAlign":"center","width":"100%","lineHeight":"40px","fontSize":"14px","textOverflow":"ellipsis"}' class="name ">{{item.lindileixing}}</div>
				<div :style='{"overflow":"hidden","whiteSpace":"hidden","color":"#fff","textAlign":"center","width":"100%","lineHeight":"40px","fontSize":"14px","textOverflow":"ellipsis"}' class="name ">{{item.quyu}}</div>
				<div :style='{"padding":"0","display":"none"}'>
		          <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#fff"}'></span>
		          <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"12px"}'>{{item.addtime}}</span>
		        </div>
		        <div :style='{"padding":"0","display":"none"}'>
		          <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#fff"}'></span>
		          <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"12px"}'>{{item.linyejumingcheng}}</span>
		        </div>
		        <div :style='{"padding":"0","display":"none"}'>
		          <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#fff"}'></span>
		          <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"12px"}'>{{item.storeupnum}}</span>
		        </div>
		        <div :style='{"padding":"0","display":"none"}'>
		          <span class="icon iconfont icon-chakan9" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#fff"}'></span>
		          <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"12px"}'>{{item.clicknum}}</span>
		        </div>
		      </div>
		    </div>
		  </div>
		</div>
	<div @click="moreBtn('linyeziyuan')" :style='{"border":"1px solid #fff","cursor":"pointer","margin":"20px auto","textAlign":"center","background":"none","display":"block","width":"130px","lineHeight":"36px"}'>
		<span :style='{"color":"#fff","fontSize":"16px"}'>浏览更多</span>
		<i :style='{"color":"#fff","fontSize":"16px"}' class="icon iconfont icon-jiantou09"></i>
	</div>
</div>
<!-- 商品推荐 -->
</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        newsList: [],
        linyeziyuanRecommend: [],


		newListSwiper13news: null,



      }
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.getNewsList();
		this.getList();
    },
	mounted() {
		window.addEventListener('scroll', this.handleScroll)
		setTimeout(()=>{
			this.handleScroll()
		},100)
		
		this.swiperChanges()
	},
	beforeDestroy() {
	  window.removeEventListener('scroll', this.handleScroll)
	},
    //方法集合
    methods: {
		swiperChanges() {
			if (this['newListSwiper13news']) this['newListSwiper13news'].destroy()
			setTimeout(()=>{
				this['newListSwiper13news'] = new Swiper(".new-list-13news", {"autoplay":{"delay":2500,"disableOnInteraction":false},"pagination":{"el":".swiper-pagination","clickable":true}})
			},750)
		},


		handleScroll() {
			let arr = [
				{id:'search',css:'animate__fadeInUp'},
				{id:'about',css:'animate__fadeInLeft'},
				{id:'system',css:'animate__fadeInRight'},
				{id:'animate_recommendlinyeziyuan',css:'animate__fadeInUp'},
				{id:'animate_newsnews',css:'animate__fadeInLeft'},
				{id:'msgs',css:'animate__fadeInUp'},
				{id:'friendly',css:'animate__fadeInRightBig'}
			]
			
			for (let i in arr) {
				let doc = document.getElementById(arr[i].id)
				if (doc) {
					let top = doc.offsetTop
					let win_top = window.innerHeight + window.pageYOffset
					// console.log(top,win_top)
					if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
						// console.log(doc)
						doc.classList.add(arr[i].css)
					}
				}
			}
		},
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
		getNewsList() {
			let data = {
				page: 1,
				limit: 10,
                sort: 'addtime',
				order: 'desc'
			}
			this.$http.get('news/list', {params: data}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;
					
					
				}
			});
		},
		getList() {
			let autoSortUrl = "";
			let data = {}
          autoSortUrl = "linyeziyuan/autoSort";
          if(localStorage.getItem('frontToken')) {
              autoSortUrl = "linyeziyuan/autoSort2";
          }
			data = {
				page: 1,
				limit: 8,
			}
			this.$http.get(autoSortUrl, {params: data}).then(res => {
				if (res.data.code == 0) {
					this.linyeziyuanRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
			
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {id: item.id}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		// -------- search --------
		.search .select /deep/ .el-input__inner {
			border: 1px solid #ddd;
			border-radius: 2px;
			padding: 0 30px 0 10px;
			box-shadow: 0 0 0px rgba(64, 158, 255, .3);
			outline: none;
			color: rgba(64, 158, 255, 1);
			width: auto;
			font-size: 14px;
			height: 32px;
		}
		
		.search .input /deep/ .el-input__inner {
			border: 1px solid #ddd;
			border-radius: 2px;
			padding: 0 10px;
			box-shadow: 0 0 0px rgba(64, 158, 255, .3);
			color: rgba(64, 158, 255, 1);
			width: auto;
			font-size: 14px;
			height: 32px;
		}
		// -------- search --------
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, -10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1.02) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
	

	.home-preview .news .list13 .newsSwiper13 .swiper-pagination /deep/ span.swiper-pagination-bullet {
				border-radius: 100%;
				margin: 0 4px;
				background: #fff;
				display: inline-block;
				width: 10px;
				opacity: .2;
				height: 10px;
			}
	
	.home-preview .news .list13 .newsSwiper13 .swiper-pagination /deep/ span.swiper-pagination-bullet:hover {
				background: #F5BB00;
				opacity: 1;
			}
	
	.home-preview .news .list13 .newsSwiper13 .swiper-pagination /deep/ span.swiper-pagination-bullet.swiper-pagination-bullet-active {
				background: #F5BB00;
				opacity: 1;
			}







	.home-preview .recommend .list17 .item .image {
				clip-path: polygon(0% 0%, 95% 0, 100% 50%, 95% 100%, 0% 100%);
				object-fit: cover;
				display: block;
				width: 100%;
				transition: 0.3s;
				height: 100%;
			}

	.home-preview .recommend .list17 .item:hover .image {
				transform: scale(1);
			}
	
	.home-preview .recommend .list17 .item .content {
				padding: 10px;
				clip-path: polygon(0% 0%, 95% 0, 100% 50%, 95% 100%, 0% 100%);
				left: 0;
				bottom: -100%;
				background: rgba(0,0,0,.5);
				display: flex;
				width: 100%;
				position: absolute;
				transition: 0.3s;
				height: 100%;
			}
	
	.home-preview .recommend .list17 .item:hover .content {
				bottom: 0;
			}


	.home-preview .lists .list17 .item .image {
				clip-path: polygon(0% 0%, 95% 0, 100% 50%, 95% 100%, 0% 100%);
				object-fit: cover;
				display: block;
				width: 100%;
				transition: 0.3s;
				height: 100%;
			}

	.home-preview .lists .list17 .item:hover .image {
				transform: scale(1);
			}
	
	.home-preview .lists .list17 .item .content {
				padding: 10px;
				clip-path: polygon(0% 0%, 95% 0, 100% 50%, 95% 100%, 0% 100%);
				left: 0;
				bottom: -100%;
				background: rgba(0,0,0,.5);
				display: flex;
				width: 100%;
				align-items: center;
				position: absolute;
				transition: 0.3s;
				height: 100%;
			}
	
	.home-preview .lists .list17 .item:hover .content {
				bottom: 0;
			}
</style>
