import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

// const toSigninpage = () => import("@/views/Signinpage");

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
    {
      path: '/downloadexcel',
      name: 'DownloadExcel',
      component: () => import('../views/DownloadExcel')
    },
    {
      path: '/message',
      name: 'Message',
      component: () => import('../views/Message')
    },
    {
      path: '/loginpage',
      name: 'Loginpage',
      component: () => import('../views/Loginpage')
    },
    {
      path: '/answerquestion',
      name: 'AnswerQuestion',
      component: () => import('../views/AnswerQuestion')
    },
    {
      path: '/messageupdate',
      name: 'MessageUpdate',
      component: () => import('../views/MessageUpdate')
    },
    {
      path: '/signinpage',
      name: 'Signinpage',
      component: () => import('../views/Signinpage')
    },
    {
      path: '/addmessage',
      name: 'AddMessage',
      component: () => import('../views/AddMessage')
    },
    {
      path: '/addstudentnumber',
      component: () => import('../views/AddStudentnumber')
    },
    {
      path: '/userupdate',
      component: () => import('../views/UserUpdate')
    },
    {
      path: '/dataview',
      name: 'DataView',
      component: () => import('../views/DataView')
    },
    {
      path: '/homepageswitchmenu',
      component: () => import('../views/HomePageSwitchmenu')
    },
    {
      path: '/batchaddstudent',
      name: 'BatchAddStudent',
      component: () => import('../views/BatchAddStudent')
    }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
