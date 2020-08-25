<template>
    <div>
        <el-form :model="addmessageForm" :rules="rules" ref="addmessageForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="问题描述" prop="question">
                <el-input type="textarea" v-model="addmessageForm.question"
                          placeholder="Please describe your question(NOT NULL)"
                          maxlength="9"
                          show-word-limit></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('addmessageForm')">提交问题</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
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
                        axios.post('http://localhost:8181/message/addmessage', this.addmessageForm).then(function (resp) {
                            console.log(resp.data);
                            _this.$message.success(resp.data);
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