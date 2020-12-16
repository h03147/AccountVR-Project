<template>
    <div>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="id" prop="id">
                <el-input v-model="ruleForm.id" disabled></el-input>
            </el-form-item>
            <el-form-item label="姓名" prop="username">
                <el-input v-model="ruleForm.username"></el-input>
            </el-form-item>
            <el-form-item label="学号" prop="sno">
                <el-input v-model="ruleForm.sno"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input type="password" v-model="ruleForm.password"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button class="answerbutton1" type="primary" @click="submitForm('ruleForm')">提交修改</el-button>
                <el-button @click="cancelForm('ruleForm')">取消</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    import api from '../main'
    import crypto123 from 'crypto'
    export default {
        name: "UserUpdate",
        data() {
            return {
                ruleForm: {
                        id: '',
                        username: '',
                        sno: '',
                        password: ''
                },
                rules: {
                    username: [
                        { required: true, message: '本行内容不能为空，请返回重新修改！', trigger: 'blur' },
                        { min: 2, max: 20, message: '长度在 2 到 20 个字符', trigger: 'change' }
                    ],
                    sno: [
                        { required: true, message: '请输入内容', trigger: 'blur' },
                        { min: 3, max: 50, message: '长度在 3 到 50 个字符', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输入内容', trigger: 'blur' },
                        { min: 8, max: 50, message: '长度在 8 到 50 个字符', trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {

                let phoneTest = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,50}$/;  //校验密码8-18位

                if (!phoneTest.test(this.ruleForm.password)) {
                    this.$message.error('请不要设置简单密码，密码须包含数字、字母两种元素，且密码位数为8-50位');
                    return false;
                }else
                {
                    const _this = this;
                    this.$refs[formName].validate((valid) => {
                        // 从session中抓取当前操作老师的名字
                        // this.ruleForm.teacher_name = sessionStorage.getItem("token");
                        // console.log(this.ruleForm);

                        // 密码MD5加密
                        const md5 = crypto123.createHash('md5');
                        md5.update(this.ruleForm.password);
                        let aftermd5password = md5.digest('hex');
                        // this.$message.success('加密后的密码为' + aftermd5password);
                        this.ruleForm.password = aftermd5password;

                        if (valid) {
                            axios.post(api.url + '/updateSingle/', this.ruleForm).then(function (resp) {
                                // console.log(resp);
                                if(resp.data)
                                {
                                    _this.$alert('修改成功！', '消息', {
                                        confirmButtonText: '确定',
                                        callback: action => {
                                            _this.$router.push('/addstudentnumber')
                                        }
                                    });
                                }
                                else
                                {
                                    return false;
                                }

                            })
                        } else {
                            this.$message.error("字段输入非法,请重新输入！");
                            return false;
                        }
                    });
                }
            },
            cancelForm(formName) {
                // this.$refs[formName].resetFields();
                this.$router.push('/addstudentnumber')
            }
        },
        created() {
            const _this = this;
            // console.log(this.$route.query.id)
            //注意发送页面用$router跳转并传参数，接收页用$route接收参数
            // alert(this.$route.query.id);
            axios.get(api.url + '/findById/' + this.$route.query.id).then(function (resp) {
                // console.log(resp.data);
                _this.ruleForm = resp.data;
                // console.log("ruleForm:")
                // console.log(_this.ruleForm);
            })
        }
    }
</script>

<style scoped>
    .demo-ruleForm {
        width: 700px;
        margin: 0 auto;
        margin-top: 10%;
    }
    .answerbutton1 {
        background-color: rgba(40,161,134,0.76);
    }
    .answerbutton1:hover {
        background-color: #445f59;
    }

</style>