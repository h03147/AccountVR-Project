<template>
    <div>
        <el-table
                :data="getQuestion"
                style="width: 100%">
            <el-table-column
                    prop="id"
                    label="编号"
                    width="180">
            </el-table-column>
            <el-table-column
                    label="提问日期"
                    width="180">
                <template slot-scope="scope">
                    <i class="el-icon-time"></i>
                    <span style="margin-left: 10px">{{ scope.row.request_time }}</span>
                </template>
            </el-table-column>
            <el-table-column
                    prop="student_name"
                    label="学生姓名"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="question"
                    label="提问内容"
                    width="480">
            </el-table-column>
            <el-table-column
                    prop="answer"
                    label="答复内容"
                    width="480">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            @click="handleEdit(scope.row)">回复</el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            @click="handleDelete(scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    export default {
        name: "AnswerQuestion",
        data() {
            return {
                getQuestion: [{
                    id: '1',
                    request_time: '2016-05-02 11:22:16',
                    student_name: '王小虎',
                    question: '上海市普陀区金沙江路 1518 弄',
                    answer: '未答复'
                }]
            }
        },
        created() {
            const _this = this;
            axios.get('http://localhost:8181/message/findAll').then(function (resp) {
                _this.getQuestion = resp.data;
            })
        },
        methods: {
            handleEdit(row) {
                // console.log(index, row);
                // this.$router.push('/messageupdate') //只用跳转直接写
                //如果需要传参数请用下面的写法
                this.$router.push({
                    path: '/messageupdate',
                    //需要传递的参数
                    query: {
                        id: row.id
                    }
                })
            },
            handleDelete(row) {
                const _this = this;
                this.$confirm('此操作将永久删除该留言且不可恢复, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    axios.delete('http://localhost:8181/message/deleteById/' + row.id).then(function (resp) {
                        // console.log(resp.data);
                    });
                    this.$message({
                        type: 'success',
                        message: '删除成功!'
                    });
                    window.location.reload();//页面刷新
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            }
        },

    }
</script>

<style scoped>

</style>