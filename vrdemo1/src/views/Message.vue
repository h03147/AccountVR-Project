<template>
    <div>

        <div class="headdiv1">
            <h1 class="h1data">全部问题</h1>
            <HR class="hrline" align=center width=300 color=#5D998B SIZE=1></HR>
        </div>
        <el-card class="box-card" v-for="item in messages" :key="item.id">
            <div class="firstlinediv">
                <p class="p1">{{item.student_name}}</p>
                <p class="p2">{{item.request_time}}</p>
            </div>
            <div class="secondlinediv">
                <p class="p3">{{item.question}}</p>
            </div>
            <div class="answerdiv">
                <div class="thridlinediv" v-if="item.answer != '未答复'">
                    <p class="p4">{{item.teacher_name}}</p>
                    <p class="p5">回复:{{item.response_time}}</p>
                </div>
                <div class="fourlinediv">
                    <p class="p6">{{item.answer}}</p>
                </div>
            </div>
        </el-card>
    </div>
</template>

<script>
    import api from '../main'
    export default {
        name: "Message",
        data(){
            return {
                messages: [
                    {
                        id: 1,
                        student_name: '张三',
                        teacher_name: '王老师',
                        question: '感谢提问，解答如下',
                        answer: '请问老师，这个章节是不是错了？',
                        request_time: '2020-08-20 11:11:11',
                        response_time: '2020-08-21 12:30:26'
                    }
                ]
            }
        },
        created() {
            const _this = this
            axios.get(api.url + '/message/findAll').then(function (resp) {
                _this.messages = resp.data
            })
        },

    }
</script>

<style scoped>
    .text {
        font-size: 14px;
    }

    .item {
        padding: 18px 0;
    }

    .box-card {
        width: 1200px;
        height: 205px;
        margin: 0 auto;
        margin-top: 8px;
    }

    .h1data {
        /*margin-top: -74px;*/
        margin-left: -1131px;
        font-size: 18px;
        margin-top: 32px;
        color: #445f59;
    }
    .hrline {
        width: 1200px;
        margin-top: 3px;
        font-size: 18px;
        margin-bottom: 30px;
    }
    .p2, .p5 {
        font-size: 12px;
        margin-left: 10px;
        color: #656565;
    }
    .p4 {
        margin-left: 34px;
    }
    .p1, .p3, .p4, .p6 {
        font-size: 14px;
    }
    .p1, .p2, .p3, .p4, .p5, .p6{
        display: inline;
    }
    .answerdiv {
        width: 1110px;
        border: 1px solid rgba(134,178,168,1);
        border-radius: 4px;
        background:rgba(142,244,221,0.1);
        margin: 0 auto;
        margin-top: 16px;
    }
    .p1, .p4 {
        color: #26836E;
    }
    .p3, .p6{
        color: #4D4D4D;
    }
    .firstlinediv {
        height: 30px!important;
        margin-left: -940px;
        margin-top: 0px;
    }
    .thridlinediv {
        height: 30px!important;
        margin-left: -920px;
        margin-top: 0px;
    }

    .secondlinediv, .fourlinediv {
        margin-left: 50px;
        text-align: left;
        margin-bottom: 20px;
    }
    .headdiv1 {
        margin-bottom: 0px!important;
    }


</style>