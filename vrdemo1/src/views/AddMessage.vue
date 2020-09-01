<template>
    <div>
        <el-form :inline="true" :model="addmessageForm" :rules="rules" ref="addmessageForm" label-width="80px" class="demo-ruleForm">
            <iframe src="/Acc/index.html" width="1200" height="700" frameborder="0" scrolling="auto"style="position:relative;margin: 0 auto;"></iframe>
            <el-form-item class="elformitem1" label="问题描述" prop="question">
                <el-input class="elinput1" type="textarea" v-model="addmessageForm.question"
                          placeholder="Please describe your question(NOT NULL)"
                          maxlength="49"
                          show-word-limit></el-input>
            </el-form-item>
            <el-form-item class="elformitem2">
                <el-button class="elbtn1" size="small" type="primary" @click="submitForm('addmessageForm')">提交问题</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import api from '../main'
    export default {
        data() {
            return {
                addmessageForm: {
                    student_name: '',
                    question: ''
                },
                rules: {
                    question: [
                        { required: true, message: '提问内容不能为空', trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.addmessageForm.student_name = sessionStorage.getItem("token");
                        const _this = this;
                        axios.post(api.url + '/message/addmessage', this.addmessageForm).then(function (resp) {
                            console.log(resp.data);
                            _this.$message.success(resp.data);
                            _this.addmessageForm.question = '';
                        })

                    } else {
                        this.$message.error("add message failed")
                        return false;
                    }
                });
            }
        }
    }
</script>

<style scoped>
    .demo-ruleForm {
        width: 1000px;
        margin: 0 auto;
        /*margin-top: 0%;*/
    }
    .elformitem1 {
        width: 60%;
        float: left;
        margin-left: 11%;
    }

    .elinput1 {
        width: 500px;
    }

    .elformitem2 {
        float: left;
    }

    .elbtn1 {
        background: #239973;
        margin-top: 15%;
    }

</style>