import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import linyeziyuan from '@/views/modules/linyeziyuan/list'
    import news from '@/views/modules/news/list'
    import gongzuorenyuan from '@/views/modules/gongzuorenyuan/list'
    import discusslinyezhengce from '@/views/modules/discusslinyezhengce/list'
    import kaifaqiye from '@/views/modules/kaifaqiye/list'
    import zhengceshenqing from '@/views/modules/zhengceshenqing/list'
    import kaifajihuashenqing from '@/views/modules/kaifajihuashenqing/list'
    import syslog from '@/views/modules/syslog/list'
    import shilinyeju from '@/views/modules/shilinyeju/list'
    import kaifaliyongbaogao from '@/views/modules/kaifaliyongbaogao/list'
    import zhengceleixing from '@/views/modules/zhengceleixing/list'
    import quyu from '@/views/modules/quyu/list'
    import linyezhengce from '@/views/modules/linyezhengce/list'
    import config from '@/views/modules/config/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/linyeziyuan',
        name: '林业资源',
        component: linyeziyuan
      }
      ,{
	path: '/news',
        name: '林业资讯',
        component: news
      }
      ,{
	path: '/gongzuorenyuan',
        name: '工作人员',
        component: gongzuorenyuan
      }
      ,{
	path: '/discusslinyezhengce',
        name: '林业政策评论',
        component: discusslinyezhengce
      }
      ,{
	path: '/kaifaqiye',
        name: '开发企业',
        component: kaifaqiye
      }
      ,{
	path: '/zhengceshenqing',
        name: '政策申请',
        component: zhengceshenqing
      }
      ,{
	path: '/kaifajihuashenqing',
        name: '开发计划申请',
        component: kaifajihuashenqing
      }
      ,{
	path: '/syslog',
        name: '系统日志',
        component: syslog
      }
      ,{
	path: '/shilinyeju',
        name: '市林业局',
        component: shilinyeju
      }
      ,{
	path: '/kaifaliyongbaogao',
        name: '开发利用报告',
        component: kaifaliyongbaogao
      }
      ,{
	path: '/zhengceleixing',
        name: '政策类型',
        component: zhengceleixing
      }
      ,{
	path: '/quyu',
        name: '区域',
        component: quyu
      }
      ,{
	path: '/linyezhengce',
        name: '林业政策',
        component: linyezhengce
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/newstype',
        name: '林业资讯分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
