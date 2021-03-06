import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import echarts from 'echarts'

Vue.config.productionTip = false
Vue.prototype.echarts = echarts

Vue.directive('title', {
  inserted: function (el, binding) {
    document.title = el.dataset.title
  }
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

const url = "http://localhost:80";

const url1 = "http://localhost:8080";

export default {
  url, //后端url
  url1 //前端url
}
