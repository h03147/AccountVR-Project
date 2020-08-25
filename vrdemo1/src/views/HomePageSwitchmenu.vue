<template>
    <div class=''>
        <el-row class="elrowmain1">
            <el-col :span="4" class="elcol1">
                <div class="elcoldiv1" v-for="(item,index) in list"
                     :model="cur"
                     :key="item"
                     :class="{'block':true,'active':cur==index}"
                     @click="currStationChange(index, item)">
                    <div>{{item}}</div>
                </div>
            </el-col>
            <el-col :span="12">
                <div>
                    <p>标题：{{title}}</p>
                    <HR class="hrline" align=center width=300 color=#5D998B SIZE=1></HR>
                    <div>
                        这里显示内容{{current+1}}
                        {{currentcontext}}
                        <div></div>
                    </div>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    import router from "../router";


    export default {
        name: "HomePageSwitchmenu",
        props:{

        },
        data(){
            return{
                list:[
                    "操作手册","实验背景","实验目的","试验方法","实验步骤","成绩评定","学生要求","项目评定"
                ],
                cur:-1,
                gotopage: "",
                current: 0,
                title: 1111,
                currentcontext: "",
                alldivForm: {
                    alldiv1: "M公司成立于2016年，注册资本5000万元。占地面积三万二千六百平方米，建筑面积一万一千七百平方米。公司主要生产汽车刹车片，包括乘用车，商用车以及商用车售后服务件。公司引进世界领先生产设备及工艺，年产能达到可生产1300万块刹车片。实际生产量达到1000万块左右刹车片。主要供货给大众、奔驰、宝马、丰田、福特、斯巴鲁、保时捷等汽车制造企业。",
                    alldiv2: "1.理解标准作业成本法的设计思路；\n" +
                        "2.掌握标准作业成本法的核算、成本考核、成分分析及成本报告；\n" +
                        "3.培养业财融合能力\n" +
                        "4.培养管理会计工具综合应用能力\n",
                }
            }
        },
        methods: {
            currStationChange(index, val) {
                this.cur = index;
                console.log("这是cur的值："+this.cur)
                this.current = index;
                this.title = val;
                if(this.current === 1)
                {
                    this.currentcontext = this.alldivForm.alldiv1;
                }else
                {
                    this.currentcontext = this.alldivForm.alldiv2;
                }
            }
        }
    }

</script>

<style scoped>
    .block{
        width:50px;
        height:50px;
        /*background-color: aqua;*/
        background-image: url("../assets/sybz1.png");
        background-repeat: no-repeat;

    }

    .active{
        /*background-color: brown;*/
        background-image: url("../assets/sybz2.png");
        background-repeat: no-repeat;
        animation: extend-width 0.5s forwards;

    }

    @keyframes extend-width {
        0%{
            width:100px;
        }
        100%{
            width:188px;
        }
    }

    .elrowmain1 {
        width: 1200px;
        margin: 0 auto;
    }
    .elcol1 {
        /*width: 16%!important;*/
    }
    .elcoldiv1 {
        width: 100%;
        margin-bottom: 5%;
        /*background-image: url("../assets/sybz1.png");*/
        /*background-repeat: no-repeat;*/
    }
    .hrline {
        width: 1200px;
        margin-top: 3px;
        font-size: 18px;
        margin-bottom: 30px;
    }
</style>