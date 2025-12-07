import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import gongzuorenyuanList from '../pages/gongzuorenyuan/list'
import gongzuorenyuanDetail from '../pages/gongzuorenyuan/detail'
import gongzuorenyuanAdd from '../pages/gongzuorenyuan/add'
import shilinyejuList from '../pages/shilinyeju/list'
import shilinyejuDetail from '../pages/shilinyeju/detail'
import shilinyejuAdd from '../pages/shilinyeju/add'
import kaifaqiyeList from '../pages/kaifaqiye/list'
import kaifaqiyeDetail from '../pages/kaifaqiye/detail'
import kaifaqiyeAdd from '../pages/kaifaqiye/add'
import linyeziyuanList from '../pages/linyeziyuan/list'
import linyeziyuanDetail from '../pages/linyeziyuan/detail'
import linyeziyuanAdd from '../pages/linyeziyuan/add'
import quyuList from '../pages/quyu/list'
import quyuDetail from '../pages/quyu/detail'
import quyuAdd from '../pages/quyu/add'
import kaifajihuashenqingList from '../pages/kaifajihuashenqing/list'
import kaifajihuashenqingDetail from '../pages/kaifajihuashenqing/detail'
import kaifajihuashenqingAdd from '../pages/kaifajihuashenqing/add'
import kaifaliyongbaogaoList from '../pages/kaifaliyongbaogao/list'
import kaifaliyongbaogaoDetail from '../pages/kaifaliyongbaogao/detail'
import kaifaliyongbaogaoAdd from '../pages/kaifaliyongbaogao/add'
import linyezhengceList from '../pages/linyezhengce/list'
import linyezhengceDetail from '../pages/linyezhengce/detail'
import linyezhengceAdd from '../pages/linyezhengce/add'
import zhengceleixingList from '../pages/zhengceleixing/list'
import zhengceleixingDetail from '../pages/zhengceleixing/detail'
import zhengceleixingAdd from '../pages/zhengceleixing/add'
import zhengceshenqingList from '../pages/zhengceshenqing/list'
import zhengceshenqingDetail from '../pages/zhengceshenqing/detail'
import zhengceshenqingAdd from '../pages/zhengceshenqing/add'
import syslogList from '../pages/syslog/list'
import syslogDetail from '../pages/syslog/detail'
import syslogAdd from '../pages/syslog/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import discusslinyezhengceList from '../pages/discusslinyezhengce/list'
import discusslinyezhengceDetail from '../pages/discusslinyezhengce/detail'
import discusslinyezhengceAdd from '../pages/discusslinyezhengce/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'gongzuorenyuan',
					component: gongzuorenyuanList
				},
				{
					path: 'gongzuorenyuanDetail',
					component: gongzuorenyuanDetail
				},
				{
					path: 'gongzuorenyuanAdd',
					component: gongzuorenyuanAdd
				},
				{
					path: 'shilinyeju',
					component: shilinyejuList
				},
				{
					path: 'shilinyejuDetail',
					component: shilinyejuDetail
				},
				{
					path: 'shilinyejuAdd',
					component: shilinyejuAdd
				},
				{
					path: 'kaifaqiye',
					component: kaifaqiyeList
				},
				{
					path: 'kaifaqiyeDetail',
					component: kaifaqiyeDetail
				},
				{
					path: 'kaifaqiyeAdd',
					component: kaifaqiyeAdd
				},
				{
					path: 'linyeziyuan',
					component: linyeziyuanList
				},
				{
					path: 'linyeziyuanDetail',
					component: linyeziyuanDetail
				},
				{
					path: 'linyeziyuanAdd',
					component: linyeziyuanAdd
				},
				{
					path: 'quyu',
					component: quyuList
				},
				{
					path: 'quyuDetail',
					component: quyuDetail
				},
				{
					path: 'quyuAdd',
					component: quyuAdd
				},
				{
					path: 'kaifajihuashenqing',
					component: kaifajihuashenqingList
				},
				{
					path: 'kaifajihuashenqingDetail',
					component: kaifajihuashenqingDetail
				},
				{
					path: 'kaifajihuashenqingAdd',
					component: kaifajihuashenqingAdd
				},
				{
					path: 'kaifaliyongbaogao',
					component: kaifaliyongbaogaoList
				},
				{
					path: 'kaifaliyongbaogaoDetail',
					component: kaifaliyongbaogaoDetail
				},
				{
					path: 'kaifaliyongbaogaoAdd',
					component: kaifaliyongbaogaoAdd
				},
				{
					path: 'linyezhengce',
					component: linyezhengceList
				},
				{
					path: 'linyezhengceDetail',
					component: linyezhengceDetail
				},
				{
					path: 'linyezhengceAdd',
					component: linyezhengceAdd
				},
				{
					path: 'zhengceleixing',
					component: zhengceleixingList
				},
				{
					path: 'zhengceleixingDetail',
					component: zhengceleixingDetail
				},
				{
					path: 'zhengceleixingAdd',
					component: zhengceleixingAdd
				},
				{
					path: 'zhengceshenqing',
					component: zhengceshenqingList
				},
				{
					path: 'zhengceshenqingDetail',
					component: zhengceshenqingDetail
				},
				{
					path: 'zhengceshenqingAdd',
					component: zhengceshenqingAdd
				},
				{
					path: 'syslog',
					component: syslogList
				},
				{
					path: 'syslogDetail',
					component: syslogDetail
				},
				{
					path: 'syslogAdd',
					component: syslogAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'discusslinyezhengce',
					component: discusslinyezhengceList
				},
				{
					path: 'discusslinyezhengceDetail',
					component: discusslinyezhengceDetail
				},
				{
					path: 'discusslinyezhengceAdd',
					component: discusslinyezhengceAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
