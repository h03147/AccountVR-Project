<template>
    <div>
        <el-table
                :data="getQuestion"
                :header-cell-style="{background:'#C7E2DC', 'text-align':'center'}"
                :cell-style="{'text-align':'center'}"
                v-if="ideatitystatus == 'teacher'"
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
    import api from '../main'
    export default {
        inject: ['reload'], //依赖注入
        name: "AnswerQuestion",
        data() {
            return {
                getQuestion: [{
                    id: '',
                    request_time: '',
                    student_name: '',
                    question: '',
                    answer: '',
                }],
                ideatitystatus: ''
            }
        },
        created() {
            const _this = this;
            this.ideatitystatus =sessionStorage.getItem("isteacher");
            if(this.ideatitystatus == 'teacher')
            {
                axios.get(api.url + '/message/findAll').then(function (resp) {
                    _this.getQuestion = resp.data;
                });
            }else
            {
                _this.$message.error("非法的接口请求，拦截成功！")
            }

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
                    axios.delete(api.url + '/message/deleteById/' + row.id).then(function (resp) {
                        // console.log(resp.data);
                    });
                    this.$message({
                        type: 'success',
                        message: '删除成功!'
                    });
                    this.reload(); //调用注入的方法达到刷新router-view的目的
                    // window.location.reload();//页面刷新
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