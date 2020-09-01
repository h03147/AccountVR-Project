<template>
  <div class="hello">
<!--    <h1>{{ msg }}</h1>-->
<!--    <p>-->
<!--      For a guide and recipes on how to configure / customize this project,<br>-->
<!--      check out the-->
<!--      <a href="https://cli.vuejs.org" target="_blank" rel="noopener">vue-cli documentation</a>.-->
<!--    </p>-->
<!--    <h3>Installed CLI Plugins</h3>-->
<!--    <ul>-->
<!--      <li><a href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-babel" target="_blank" rel="noopener">babel</a></li>-->
<!--      <li><a href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-router" target="_blank" rel="noopener">router</a></li>-->
<!--      <li><a href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-vuex" target="_blank" rel="noopener">vuex</a></li>-->
<!--    </ul>-->
<!--    <h3>Essential Links</h3>-->
<!--    <ul>-->
<!--      <li><a href="https://vuejs.org" target="_blank" rel="noopener">Core Docs</a></li>-->
<!--      <li><a href="https://forum.vuejs.org" target="_blank" rel="noopener">Forum</a></li>-->
<!--      <li><a href="https://chat.vuejs.org" target="_blank" rel="noopener">Community Chat</a></li>-->
<!--      <li><a href="https://twitter.com/vuejs" target="_blank" rel="noopener">Twitter</a></li>-->
<!--      <li><a href="https://news.vuejs.org" target="_blank" rel="noopener">News</a></li>-->
<!--    </ul>-->
<!--    <h3>Ecosystem</h3>-->
<!--      .imgaddshadow {-->
<!--      box-shadow:10px 0 30px blue inset!important;-->
<!--      -webkit-box-shadow:0 0 30px blue inset!important;-->
<!--      -moz-box-shadow:0 0 30px blue inset!important;-->
<!--      -o-box-shadow:0 0 30px blue inset!important;-->
<!--      }-->
<!--    <ul>-->
<!--      <li><a href="https://router.vuejs.org" target="_blank" rel="noopener">vue-router</a></li>-->
<!--      <li><a href="https://vuex.vuejs.org" target="_blank" rel="noopener">vuex</a></li>-->
<!--      <li><a href="https://github.com/vuejs/vue-devtools#vue-devtools" target="_blank" rel="noopener">vue-devtools</a></li>-->
<!--      <li><a href="https://vue-loader.vuejs.org" target="_blank" rel="noopener">vue-loader</a></li>-->
<!--      <li><a href="https://github.com/vuejs/awesome-vue" target="_blank" rel="noopener">awesome-vue</a></li>-->
<!--    </ul>-->
          <el-container>
                <el-main class="elmain1">
<!--                  <el-row class="elrow1"><p class="plabtitle" style="font-size: 50px; font-family: '黑体';">基于会计制造页虚拟仿真实验</p></el-row>-->
                  <el-row class="elrow2">
                      <template class="tempelcarousel">

                              <el-carousel :interval="3000" arrow="never">
                                  <el-carousel-item v-for="item in 3" :key="item">
                                      <!--                                  <h3>{{ item }}</h3>-->
                                      <div class="imgaddshadow"></div>
                                  </el-carousel-item>
                              </el-carousel>

                      </template>
<!--                      <router-link class="routerlinkaddmessage" to="/addmessage">开始实验</router-link>-->
                      <el-button type="primary" class="elbutton1" @click="startexperiment">开始实验</el-button>
                  </el-row>
                </el-main>
            </el-container>
<!--      <el-tabs tab-position="left" style="height: 200px; width: 1200px; margin: 0 auto;" type="border-card">-->
<!--          <el-tab-pane label="用户管理&nbsp;" name = "first">用户管理</el-tab-pane>-->
<!--          <el-tab-pane label="配置管理" name = "second">配置管理</el-tab-pane>-->
<!--          <el-tab-pane label="角色管理">角色管理</el-tab-pane>-->
<!--          <el-tab-pane label="定时任务补偿">定时任务补偿</el-tab-pane>-->
<!--      </el-tabs>-->
      <el-row class="tac">
<!--          <el-col v-on:click.native="a=!a" v-bind:class="{changeColor:a}">图片1</el-col>-->
<!--          <el-col>图片2</el-col>-->
<!--          <el-col>图片3</el-col>-->
          <HomePageSwitchmenu></HomePageSwitchmenu>
      </el-row>

  </div>
</template>

<script>
  import {Message} from 'element-ui'
  import HomePageSwitchmenu from "../views/HomePageSwitchmenu";

export default {
    name: 'HelloWorld',

    components: {HomePageSwitchmenu},
    data() {
      return {
          a:false
      }
    },
  props: {
    msg: String
  },
  mounted() {
    window.onload = function getsession() {
       const msg =sessionStorage.getItem("token");
       const isguest = sessionStorage.getItem("isguest")
       if(msg)
       {
         // Message.success("欢迎"+msg+"登入系统");
         Message({
           type: 'success',
           message: "欢迎" + msg + "登入系统",
           showClose: true
         });
       }
       else if(isguest)
       {
           Message.success("访客模式已启动！");
       }else
       {
           Message.error("未登录状态，请您先去登录，谢谢！");
       }
    }
  },
    methods: {
        changeBackground() {
            console.log("点击了图片1")
        },
        // GotoVR(){
        //     location.href = '/Acc/index.html';
        // }
        //开始试验
        startexperiment() {
            const msg =sessionStorage.getItem("token");
            const isguest = sessionStorage.getItem("isguest")
            if(msg || isguest)
            {
                this.$router.push('/addmessage');
            }else
            {
                Message.error("请您先去登录，才能开始试验，谢谢！");
            }
        }

    }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  line-height: 75px;
}
.elmain1 {
    padding: 0;
    height: 500px;
}

.elrow2 {
    margin: 0;
    height: 500px;



}


.el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 550px;
    margin: 0;
}

.el-carousel__item:nth-child(2n) {
    background-image: url("../assets/home1.png");
    height: 500px;
    /*margin-bottom: 200px;*/
}

.el-carousel__item:nth-child(2n+1) {
    background-image: url("../assets/home2.png");
    height: 500px;
}

.el-carousel__item:nth-child(3n) {
    background-image: url("../assets/home3.png");
    height: 500px;
}

.el-carousel, .el-carousel--horizontal {
    position: relative;
    height: 500px!important;
}


.elbutton1 {
    width: 279px;
    border: 0;
    margin-top: -128px;
    margin-left: -139px;
    background-color: rgba(40,161,134,0.76);
    position: absolute;
    z-index: 2;
}
.elbutton1:hover {
    background-color: #445f59;
}

/*css中按钮有四种状态*/

/*1. 普通状态*/
/*2. hover 鼠标悬停状态*/
/*3. active 点击状态*/
/*4. focus 取得焦点状态*/
.elbutton1:focus {
    background-color: rgba(40,161,134,0.76);
}

.changeColor {
    width: 166px;
    height: 55px;
}

.imgaddshadow {
    width: 100%;
    height: 100%;
    box-shadow:200px 0px 390px -80px black inset, /*左边阴影*/
    -200px 0px 390px -80px black inset, /*右边阴影*/
    0 0px 0px blue inset, /*顶部阴影*/
    0 0px 0px green inset; /*底边阴影*/
    -webkit-box-shadow:200px 0px 390px -80px black inset, /*左边阴影*/
    -200px 0px 390px -80px black inset, /*右边阴影*/
    0 0px 0px blue inset, /*顶部阴影*/
    0 0px 0px green inset; /*底边阴影*/
    -moz-box-shadow:200px 0px 390px -80px black inset, /*左边阴影*/
    -200px 0px 390px -80px black inset, /*右边阴影*/
    0 0px 0px blue inset, /*顶部阴影*/
    0 0px 0px green inset; /*底边阴影*/
    -o-box-shadow:200px 0px 390px -80px black inset, /*左边阴影*/
    -200px 0px 390px -80px black inset, /*右边阴影*/
    0 0px 0px blue inset, /*顶部阴影*/
    0 0px 0px green inset; /*底边阴影*/
}

.routerlinkaddmessage {
    color: #E9EEF3;
}






</style>
