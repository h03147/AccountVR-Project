<template>
    <div class="bigdiv">
        <div class="maindiv">
<!--            <h1 class="hlabel">登录</h1>-->
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                <el-form-item prop="identity">
                    <el-select v-model="ruleForm.identity" placeholder="请选择登录身份" class="elselectidentity"
                               @change="currStationChange">
                        <el-option label="学生" value="student"></el-option>
                        <el-option label="教师" value="teacher"></el-option>
                        <el-option label="访客" value="guest"></el-option>
                    </el-select>
                </el-form-item>

                <el-form-item prop="sno"  v-if="!ch">
                    <el-input v-model="ruleForm.sno" placeholder="studentusername" type="text" clearable></el-input>
                </el-form-item>
                <el-form-item prop="teacher_phone" v-if="ch">
                    <el-input v-model="ruleForm.teacher_phone" placeholder="teacherusername" type="text" clearable></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input v-model="ruleForm.password" placeholder="password" show-password></el-input>
                </el-form-item>

                <el-form-item>
                    <el-button :disabled="(!ruleForm.sno ||!ruleForm.password) && (!ruleForm.teacher_phone ||!ruleForm.password)" type="primary" @click="submitForm('ruleForm')" class="signinbutton"
                               :style="{background: (ruleForm.sno == '' || ruleForm.password == '') && (ruleForm.teacher_phone == '' || ruleForm.password == '') ? 'grey' : '#445f59' }">登录</el-button>
                    <!--                    <el-button type="primary" @click="submitForm('ruleForm')" class="signinbutton">登</el-button>-->
                </el-form-item>
                <el-row class="elrowschoolsong">
                    <el-col>{{Signinpageschoolsong}}</el-col>
                    <el-col>{{Signinpageschoolsong2}}</el-col>
                    <el-col>{{Signinpageschoolsong3}}</el-col>
                    <el-col>{{Signinpageschoolsong4}}</el-col>
                </el-row>
            </el-form>


        </div>
    </div>

</template>

<script>
    import axios from 'axios'
    import api from '../main';
    const $http = axios.create({
        baseURL: api.url,
        timeout: 1000,
        headers: {'X-Custom-Header': 'foobar'}
    });
    export default {
        name: "Signinpage",
        data() {
            return {
                ruleForm: {
                        username: '',
                        identity: '',
                        sno: '',
                        password: '',
                        teacher_phone: ''

                    },
                rules: {
                    identity: [
                        { required: true, message: '请先选择登录身份！', trigger: 'change' },
                        { min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur' }
                    ],
                    sno: [
                        { required: true, message: '用户名不能为空！', trigger: 'blur' },
                        { min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '密码不能为空！', trigger: 'blur' },
                        { min: 6, max: 50, message: '长度在 6 到 50 个字符', trigger: 'blur' }
                    ]

                },
                ch: false,
                // 接收返回的数据
                response_ruleForm: {},
                Signinpageschoolsong: "大黑山高，黄海岸长，美丽的校园闪耀着理想之光。各族师生，意气昂扬，我们用勤劳和智慧点燃希望。立志修身，团结自强，在这片热土上蓬勃成长。",
                Signinpageschoolsong2: "啊，我可爱的民院，你的事业更加辉煌。",
                Signinpageschoolsong3: "春风化雨，书声琅琅，今日的桃李明日成参天栋梁。各族师生，放飞理想，我们用青春和赤诚描绘新篇章。为你自豪，为你增光，五十六族语",
                Signinpageschoolsong4: "言纵声歌唱。啊，我可爱的民院，你的事业更加辉煌。"

            };
        },
        methods: {
             submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid)
                    {
                        axios.get(api.url + "/statistics/addguestnumber").then(response => {
                            console.log("请求了访问量加一");
                        });
                        if(this.ruleForm.identity == 'guest')
                        {
                            this.guestlogin();
                        }
                        else if(this.ruleForm.identity == 'student')
                        {
                            // this.identityjudge();
                            this.studentlogin();
                        }else if(this.ruleForm.identity == 'teacher')
                        {
                            // this.identityjudge();
                            this.teacherlogin();
                        }else
                        {
                            this.$message.error("请检查登录身份是否与账号匹配！");
                        }

                    } else
                    {
                        this.$message.error('数据填写有误，请重新输入！');
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            // 学生登录后台接口请求
            async studentlogin() {
                const  {data:res} = await $http.post("/login", this.ruleForm);
                console.log("后端返回的数据：", res);
                if(res.state)
                {
                    this.$message.success('登录成功');
                    localStorage.setItem("ruleForm", JSON.stringify(res.userDB));
                    sessionStorage.setItem("studentNo", JSON.stringify(res.studentNo));
                    console.log(res.userDB);
                    console.log("这是学生的id"+res.studentNo);
                    this.response_ruleForm = res.userDB;
                    sessionStorage.setItem("token", this.response_ruleForm);
                    location.href = '/';
                }else
                {
                    this.$message.error(res.msg);
                }
            },
            // 教师登录后台接口请求
            async teacherlogin() {
                const  {data:res} = await $http.post("/teacherlogin", this.ruleForm);
                console.log("后端返回的数据：", res);
                if(res.state)
                {
                    this.$message.success('登录成功');
                    localStorage.setItem("ruleForm", JSON.stringify(res.userDB1));
                    sessionStorage.setItem("teacherId", JSON.stringify(res.teacherId));
                    console.log(res.userDB1);
                    console.log("这是老师的id"+res.teacherId);
                    this.response_ruleForm = res.userDB1;
                    sessionStorage.setItem("token", this.response_ruleForm);
                    sessionStorage.setItem("isteacher", "teacher");
                    location.href = '/';
                }else
                {
                    this.$message.error(res.msg);
                }
            },
            //访客登录
            guestlogin() {
                sessionStorage.setItem("isguest", "guest");
                location.href = '/';
            },
            // 要动态监听的方法，通过在组件内添加@change="方法名"属性来实现实时监听这个组件的数据变化
            currStationChange(val) {
                console.log('currStationChange', val);
                if(val === "guest")
                {
                    this.ruleForm.sno = "guest";
                    this.ruleForm.password = "guestpassword"
                }
                else if(val === "teacher")
                {
                    // v-if的判断赋值
                    this.ch = true;
                    // 切换后清除上一个被隐藏组件内的数据
                    this.ruleForm.sno = "";
                    this.ruleForm.password = "";
                }else
                {
                    // v-if的判断赋值
                    this.ch = false;
                    // 切换后清除上一个被隐藏组件内的数据
                    this.ruleForm.teacher_phone = "";
                    this.ruleForm.password = "";
                }

            }
        },
        created() {
            console.log("123456"+this.ruleForm.identity);
        }
    }
</script>

<style scoped>
    .maindiv{
        width: 472px;
        height: 400px;
        /*margin-top: 160px;*/
        margin-left: 774px;
        margin-top: 162px;
        background-image: url("../assets/framesignin.png");
        /*filter:progid:DXImageTransform.Microsoft.Shadow(color=#909090,direction=120,strength=4);*/
        background-repeat:no-repeat;
        background-size: 100%;

        /*-moz-box-shadow: 2px 2px 10px #909090;*/

        /*-webkit-box-shadow: 2px 2px 10px #909090;*/

        /*box-shadow:2px 2px 10px #909090;*/

        border-radius: 10px;

        position: absolute;

    }
    .el-form{
        width: 380px;
        margin-left: -7px;
        margin-top: 129px
    }
    .signinbutton {
        width: 100%;
    }
    .el-input {
        width: 100%;
    }
    .elselectidentity {
        width: 100%;
    }
    .hlabel {
        /*margin-top: -161px;*/
        color: #fff;
        font-size: 22px;
    }
    .bigdiv {
        width: 100%;
        height: 828px;
        margin-top: -1px;
        background-image: url("../assets/backgroundsignin.png");
        position: absolute;
    }
    .demo-ruleForm {
    }
    .elrowschoolsong {
        font-size: 1px;
        width: 815px;
        margin-top: 50px;
        margin-left: -194.5px!important;
        padding: 0;
        opacity: 0.52;
    }
    .el-col {
        height: 20px!important;
    }

</style>