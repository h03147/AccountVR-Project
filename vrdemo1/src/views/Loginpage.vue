<template>
    <div>
        <div>
            <div class="content">
                <div class="logo">
                    <h1>欢迎登录</h1>
                </div>
            </div>
        </div>
        <!-- Form Panel    -->
        <div class="content">
            <form method="post" action="#" class="form-validate" id="loginFrom">
                <div class="form-group">
                    <input id="login-username" type="text" required data-msg="请输入用户名"
                           placeholder="用户名" v-model="user.username" value="admin"
                           class="input-material">
                </div>
                <div class="form-group">
                    <input id="login-password" v-model="user.password" type="password" required
                           data-msg="请输入密码"
                           placeholder="密码" class="input-material">{{userDB.username}}
                </div>
                <button id="login" type="button" @click="login" class="btn btn-primary">登录</button>
            </form>
            <br/>
        </div>
    </div>

</template>

<script>
    import axios from 'axios'
    const $http = axios.create({
        baseURL: 'http://localhost:8181',
        timeout: 1000,
        headers: {'X-Custom-Header': 'foobar'}
    });
    export default {

        name: "Loginpage",
        data(){
            return {
                //用户信息，请求提交参数
                user: {},
                userDB: {
                    username: '',
                    password: ''
                },

            }
        },
        mounted() {

        },
        methods: {
            // 用户登录

            async login() {
                const {data: res} = await $http.post("/login", this.user);
                // console.log("后端返回的数据：", res);
                if (res.state) {
                    this.$message.success('登录成功');
                    // 将后端返回的用户信息保存在浏览器的 Local Storage 中（key：value），方便后面业务使用
                    // 这样保存的是一个对象，不方便使用，使用javascript中的 JSON.stringify() 将对象转化为json字符串
                    // localStorage.setItem("user",res.userDB);
                    localStorage.setItem("user", JSON.stringify(res.userDB));
                    // console.log("存入localStorage的user：", localStorage.getItem("user"));
                    // console.log("将json字符串转换成json对象的user：", JSON.parse(localStorage.getItem("user")));
                    // console.log(res.userDB);
                    this.userDB = res.userDB;
                    sessionStorage.setItem("token", this.userDB.username);

                    // location.href = './';
                } else {
                    this.$message.error(res.msg);
                }
            }
        }

    }
</script>

<style scoped>

</style>