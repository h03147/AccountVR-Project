<template>
  <div id="app" v-title data-title="大连民族大学">
    <el-container>
      <el-header class="elhead1">
        <el-container>
          <el-aside>
<!--            民族大学logo-->
            <img alt="Vue logo" src="./assets/headerlogo.png">
          </el-aside>
          <!--顶部导航nav-->
          <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect"
                   background-color="#435F59"
                   text-color="#fff"
                   active-text-color="#ffd04b"
                   style="width: 70%">
            <el-menu-item index="1">
              <router-link class="routerlinktoHomepage" to="/" @click.native="getData($event,'1')">首页</router-link>
            </el-menu-item>
            <el-menu-item index="8">
              <router-link class="routerlinktodataview" to="/dataview" @click.native="getData($event,'8')">数据统计</router-link>
            </el-menu-item>
            <el-menu-item index="4" v-if="!answershow">
              <router-link class="routerlinktomessage" to="/message" @click.native="getData($event,'4')">答疑</router-link>
            </el-menu-item>
            <el-menu-item index="5" v-if="answershow">
              <router-link class="routerlinkanswerquestion" to="/answerquestion" @click.native="getData($event,'5')">答疑</router-link>
            </el-menu-item>
            <el-menu-item index="7">
              <router-link class="routerlinkaddstudentnumber" to="/addstudentnumber" v-if="answershow" @click.native="getData($event,'7')">人员录入</router-link>
            </el-menu-item>

            <!-- 登录导航栏-->
            <el-menu-item index="9"  class="menuitemchangeloginstatus">
              <router-link class="routerlinktologinpage" to="/signinpage" v-if="!showname">登录</router-link>
<!--              <span v-if="showname">-->
                <el-submenu index="10" v-if="showname" class="elsubmsg">
              <template slot="title"> {{msg}}</template>
              <el-menu-item index="10-1" >
                <router-link class="routerlinktologinpage" to="/signinpage" @click.native="ClearSession()">退出登录</router-link>
              </el-menu-item>
                </el-submenu>
<!--               </span>-->
            </el-menu-item>
          </el-menu>

        </el-container>
      </el-header>
<!--      <el-container>-->
<!--            <el-main>-->
<!--              <el-row class="elrow1"><p class="plabtitle" style="font-size: 50px; font-family: '黑体';">基于会计制造页虚拟仿真实验</p></el-row>-->
<!--              <el-row class="elrow2"><el-button type="primary">进入实验</el-button></el-row>-->
<!--            </el-main>-->
<!--        </el-container>-->
        <el-container>
          <el-main class="elmainview">
            <router-view v-if="isRouterAlive"></router-view>
          </el-main>
        </el-container>
      <el-footer class="elfontercontext">
        <img alt="Vue logo" src="./assets/bottomimg.png" class="bottomimg">
      </el-footer>
    </el-container>
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'app',
  // components: {
  //   HelloWorld
  // },
    provide() {
        return {
            reload: this.reload
        }
    },
  //导航栏默认激活选项
  data() {
    return {
      activeIndex: '1',
      activeIndex2: '1',
      msg: '',
      isteacher: '',
      showname: false, //判断是否登录
      answershow: false,//根据登录时老师还是学生切换答疑菜单栏
        isRouterAlive: true
    };
  },
  created() {
    this.activeIndex = sessionStorage.getItem('num')
    this.msg =sessionStorage.getItem("token");
    this.isteacher =sessionStorage.getItem("isteacher");
    // console.log("老师来了 名字：" + this.isteacher);
    if(this.isteacher == "teacher")
    {
      this.answershow = true;
    }
    else
    {
      this.answershow = false;
    }
    // console.log(msg);
    if(this.msg)
    {
      this.showname = true;
    }
    else
    {
      this.showname = false;
    }


  },
  methods: {
    handleSelect(key, keyPath) {
      // console.log(key, keyPath);
    },
    ClearSession() {
      //清除所有缓存
      alert(this.msg + "再见");
      // console.log("清除缓存！退出");
      this.msg = '';
      sessionStorage.clear();
      this.showname = false;
      this.answershow = false;
    },
      reload() {
        this.isRouterAlive = false;
        this.$nextTick(function () {
            this.isRouterAlive = true;
        })
      },
      //手动获取index的值
      getData(e,num) {
        // console.log("这是抓的index属性值：" + num);
        sessionStorage.setItem("num", num);
      }
  }
}
</script>

<style>
  html,body,#app{
    height: 100%!important;
    padding: 0;
    margin: 0;
  }

.el-header {
  background-color: #435F59;
  color: #333;
  text-align: left;
  line-height: 60px;
}

.el-footer {
  background-color: #6739A0;
  color: #333;
  text-align: center;
  line-height: 20px;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  /*line-height: 32px;*/
}

.el-aside {
  font-size: 30px;
  margin-left: 233px;
  margin-top: 10px;
  width: 222px!important;
}

.elrow1 {
  margin-top: -80px;
  height: 10px;
}

.elrow2 {
  margin-top: 120px;
}

.el-menu-demo {
  height: 0px;
}

.el-menu-item {
  height: 69px!important;
  line-height: 69px!important;
}

.el-menu--horizontal>.el-submenu .el-submenu__title {
  height: 69px!important;
  line-height: 69px!important;
}

/*router-link激活时的颜色设置--*/
.routerlinktohome, .routerlinkanswerquestion, .routerlinktologinpage, .routerlinktomessage, .routerlinktoabout,
.routerlinktohome, .routerlinktoHomepage, .routerlinkaddmessage, .routerlinkaddstudentnumber, .routerlinktodataview {
    font-size: 0.8vw;
    text-decoration: none;
    color: azure;
    }

.elmainview {
  /*margin-top: -10px;*/
  height: 817px!important;
  margin: 0!important;
  padding: 0!important;
  background-color: #ffffff;
}
  .elhead1 {
    /*margin-bottom: 10px;*/
    height: 70px!important;
  }
  .bottomimg {
    margin-left: -20px;
    /*width: 1920px;*/
  }
  .elfontercontext {
    height: 40px!important;
    margin-top: 10px!important;
  }
  .menuitemchangeloginstatus{
    padding: 0!important;
    margin-left: 44%!important;
  }
  .elsubmsg{
    width: 100%;
    margin-top: 7px!important;
  }



</style>
