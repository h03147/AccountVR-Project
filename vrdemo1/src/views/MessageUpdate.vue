<template>
    <div>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="id" prop="id">
                <el-input v-model="ruleForm.id" disabled></el-input>
            </el-form-item>
            <el-form-item label="提问内容" prop="question">
                <el-input v-model="ruleForm.question" disabled></el-input>
            </el-form-item>
            <el-form-item label="回复内容" prop="answer" class="answeritem">
                <el-input type="textarea" class="answerinput"
                          v-model="ruleForm.answer"
                          maxlength="99"
                          placeholder="请输入回复内容(99个字以内)"
                          show-word-limit></el-input>
            </el-form-item>

            <el-form-item>
                <el-button class="answerbutton1" type="primary" @click="submitForm('ruleForm')">立即回复</el-button>
                <el-button @click="resetForm('ruleForm')">取消</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    import api from '../main'
    export default {
        name: "MessageUpdate",
        data() {
            return {
                ruleForm: {
                    id: '',
                    question: '',
                    answer: '',
                    teacher_name: ''
                },
                rules: {
                    question: [
                        { required: true, message: '本行内容不能为空，请返回重新修改！', trigger: 'blur' },
                        { min: 1, max: 99, message: '长度在 1 到 99 个字符', trigger: 'blur' }
                    ],
                    answer: [
                        { required: true, message: '请输入回复内容', trigger: 'blur' },
                        { min: 3, max: 99, message: '长度在 3 到 995 个字符', trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this;
                this.$refs[formName].validate((valid) => {
                    // 从session中抓取当前操作老师的名字
                    this.ruleForm.teacher_name = sessionStorage.getItem("token");
                    // console.log(this.ruleForm);
                    if (valid) {
                        axios.put(api.url + '/message/update/', this.ruleForm).then(function (resp) {
                            if(resp.data == 'success')
                            {
                                _this.$alert('回复成功！', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/answerquestion')
                                    }
                                });
                            }
                            else
                            {
                                return false;
                            }

                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                // this.$refs[formName].resetFields();
                this.$router.push('/answerquestion')
            }
        },
        created() {
            const _this = this;
            //注意发送页面用$router跳转并传参数，接收页用$route接收参数
            // alert(this.$route.query.id);
            axios.get(api.url + '/message/findById/' + this.$route.query.id).then(function (resp) {
                _this.ruleForm = resp.data
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